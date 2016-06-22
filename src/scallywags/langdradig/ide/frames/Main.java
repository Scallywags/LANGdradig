package scallywags.langdradig.ide.frames;

import scallywags.langdradig.Translator;
import scallywags.langdradig.generate.Checker;
import scallywags.langdradig.generate.Variable;
import scallywags.langdradig.generate.exceptions.CheckerException;
import scallywags.langdradig.ide.*;
import scallywags.langdradig.ide.Formatter;
import scallywags.langdradig.ide.errors.LANGdradigError;
import scallywags.langdradig.ide.errors.LANGdradigErrorBuilder;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.filechooser.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

import scallywags.langdradig.Compiler;

/**
 * Created by Jeroen Weener on 15/06/2016.
 */
// TODO Exception
// TODO fix "'" char error in parser
// TODO add deelbaar door
// TODO saving file with existing name dialog
// TODO saving file as file that is already open should merge tabs
// TODO support Ctrl + Z and Ctrl + Y
// TODO support Ctrl + F
// TODO only run when no errors
// TODO implement stop button for running program
// TODO limit programs running to 1
// TODO auto formatting
// TODO more threads than sprockels, what to do ?
// TODO run breaks
// TODO autofinish doe klaar block
// TODO add warnings (join child threads)

public class Main extends JFrame {
    private static final String EXTENSION = ".langdradig";
    private static final Font font = new Font("Verdana", Font.PLAIN, 16);
    private final JFileChooser fc = new JFileChooser();

    private enum Status {YES, NO, CANCEL}

    private Highlighter.HighlightPainter painter;
    private Map<Integer, Object> highlightTags;

    private int revisionPointer;
    private ArrayList<String> revisions;

    private JPanel contentPane;
    private JButton openButton;
    private JButton saveButton;
    private JButton startButton;
    private JButton newButton;
    private JButton clearButton;
    private JButton showHideButton;
    private JTextArea messagesArea;
    private JScrollPane messagesAreaScrollPane;
    private JPanel messagesPanel;

    private JSplitPane splitPane;
    private JTabbedPane programPane;
    private Map<JTextArea, Boolean> changes;
    private JLabel notificationLabel;
    private JPanel notificationPanel;
    private JTextArea variableView;
    private JSplitPane programmingViews;
    private JScrollPane notificationScrollPane;
    private int dividerLocation;

    private List<String> filePaths;
    private Timer notificationTimer;
    private Timer contentCheckTimer;

    private Thread executingThread;

    public Main() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(openButton);

        revisionPointer = -1;
        revisions = new ArrayList<>();

        newButton.addActionListener(e -> onNew());
        newButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
                    /**
                     * Key shortcuts
                     *      OPEN:   CTRL + o
                     *      NEW:    CTRL + n
                     */
                    switch (e.getKeyCode()) {
                        case 79:    // 'o' key
                            onOpen();
                            break;
                        case 78:    // 'n' key
                            onNew();
                            break;
                        default:
                            break;
                    }
                }
            }
        });

        openButton.addActionListener(e -> onOpen());

        saveButton.addActionListener(e -> onSave());

        clearButton.addActionListener(e -> clearMessages());

        showHideButton.addActionListener(e -> toggleMessages());

        startButton.addActionListener(e -> onStart());

        DefaultCaret caret = (DefaultCaret) messagesArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        messagesArea.setFont(font);
        variableView.setFont(font);
        programmingViews.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                programmingViews.setDividerLocation(.8);
            }

            @Override
            public void componentResized(ComponentEvent e) {
                programmingViews.setDividerLocation(.8);
            }
        });

        programPane.addChangeListener(changeEvent -> {
            if (programPane.getTabCount() > 0) {
                checkContent();
            }
        });
        changes = new HashMap<>();

        filePaths = new ArrayList<>();

        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);
        highlightTags = new HashMap<>();

        fc.setFileFilter(new FileNameExtensionFilter("langdradig file", "langdradig"));

        // call onClose() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onClose();
            }
        });

        // call onClose() on ESCAPE
        contentPane.registerKeyboardAction(e -> onClose(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        splitPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                splitPane.setDividerLocation(.8);
            }

            @Override
            public void componentResized(ComponentEvent e) {
                splitPane.setDividerLocation(.8);
            }
        });
        contentCheckTimer = new Timer(800, f -> checkContent());
        contentCheckTimer.setRepeats(false);

        pack();
        setTitle("LANGdradig IDE");
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        // There is a bug in JSplitPane preventing componentShown() from being called if we don't do this
        programmingViews.setVisible(false);
        programmingViews.setVisible(true);
        splitPane.setVisible(false);
        splitPane.setVisible(true);
    }

    private void onOpen() {
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String fileName = file.getName();
            if (file.exists()) {
                if (fileName.endsWith(EXTENSION)) {
                    openFile(file);
                } else {
                    JOptionPane.showMessageDialog(this, "Dit bestandstype wordt niet ondersteunt. Open een bestand met de extensdie .langdradig", "Bestandstype niet ondersteunt", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Het geselecteerd bestand kan niet worden gevonden", "Bestand niet gevonden", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void onClose() {
        if (changes()) {
            Status s = promptSave("Opslaan?", "Wilt u uw gewijzigde bestanden opslaan?");
            switch (s) {
                case YES:
                    for (int i = 0; i < programPane.getTabCount(); i++) {
                        programPane.setSelectedIndex(i);
                        int result = onSave();
                        if (result == -1) {
                            return;
                        }
                    }
                    break;
                case NO:
                    break;
                case CANCEL:
                default:
                    return;
            }
        }
        dispose();
    }

    private void onNew() {
        openFile(null);
    }

    public int onSave() {
        if (changes.get(getCodeArea())) {
            String content = getCode();
            String filePath = getFilePath();
            return save(content, filePath);
        } else {
            return 0;
        }
    }

    public int onSave(int tabIndex) {
        if (changes.get(getCodeArea(tabIndex))) {
            String content = getCode(tabIndex);
            String filePath = getFilePath(tabIndex);
            return save(content, filePath);
        } else {
            return 0;
        }
    }

    private int save(String content, String filePath) {
        if (filePath == null) {
            fc.setSelectedFile(new File("NieuwBestand.langdradig"));
            int returnValue = fc.showSaveDialog(this);
            if (returnValue != JFileChooser.APPROVE_OPTION) {
                return -1;
            }
            File f = fc.getSelectedFile();
            filePath = f.getAbsolutePath();
            filePaths.set(programPane.getSelectedIndex(), filePath);
        }
        try (PrintWriter writer = new PrintWriter(filePath, "UTF-8")) {
            writer.write(content);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String name = new File(filePath).getName();
        ((JLabel) ((JPanel) programPane.getTabComponentAt(programPane.getSelectedIndex())).getComponent(0)).setText(name);
        popup(name + " opgeslagen");
        checkContent();
        return 0;
    }


    private void onStart() {
        onSave();
        JOptionPane.showMessageDialog(this, "TODO: BE UNABLE TO RUN A PROGRAM WITH ERRORS", "TODO", JOptionPane.ERROR_MESSAGE);
        if (executingThread != null) {
            popup("Er is al een ander programma bezig!");
            return;
        }
        clearMessages();
        Compiler c = Compiler.getInstance();
        try {
            String filePath = getFilePath();
            if (filePath == null) {
                //TODO
                return;
            }
            String compileOutput = c.compile(getFilePath());
            print(compileOutput);
            File sprilFile = new File(compileOutput);
            executingThread = new Thread(() -> {
                try {
                    List<String> runOutput = c.run(sprilFile.getParentFile(), sprilFile.getAbsolutePath());
                    runOutput.forEach(this::print);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    executingThread = null;
                }
            });
            executingThread.start();
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
        popup("Uitvoeren " + new File(getFilePath()).getName());
    }

    private void checkContent() {
        revisions.add(getCode());
        revisionPointer++;
        clearMessages();
        getHighlighter().removeAllHighlights();
        Checker checker = new Checker();
        checker.checkString(getCode());
        if (checker.getCheckerExceptions().isEmpty() && checker.getParserExceptions().isEmpty()) {
            print("Geen errors!");
            messagesArea.setBackground(new Color(180, 255, 150));
        } else {
            List<LANGdradigError> errors = checker.getParserExceptions();
            List<CheckerException> checkerExceptions = checker.getCheckerExceptions();
            checkerExceptions.forEach(e -> errors.add(LANGdradigErrorBuilder.format(getCode(), e)));
            Collections.sort(errors);
            for (LANGdradigError e : errors) {
                print(programPane.getTitleAt(programPane.getSelectedIndex()));
                printError(e);
                print("");
            }
            messagesArea.setBackground(Color.PINK);
        }

        printVariables(checker.getVariables());
    }

    private void printVariables(List<Variable> variables) {
        StringBuilder sb = new StringBuilder();
        for (Variable v : variables) {
            for (int i = 0; i < v.getScope(); i++) {
                sb.append("\t");
            }
            sb.append(v.getVariable()).append(" - ").append(Translator.translateType(v.getType())).append("\n");
        }
        variableView.setText(sb.toString());
    }

    public void clearMessages() {
        messagesArea.setText("");
        messagesArea.setBackground(Color.WHITE);
    }

    private void toggleMessages() {
        if (splitPane.getBottomComponent() == null) {
            splitPane.setDividerLocation(dividerLocation);
            splitPane.setBottomComponent(messagesAreaScrollPane);
        } else {
            dividerLocation = splitPane.getDividerLocation();
            splitPane.setBottomComponent(null);
        }
        this.revalidate();
    }

    private void setupKeyListener(JTextArea c) {
        changes.put(c, false);
        c.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown()) {
                    /**
                     * Key shortcuts
                     *      SAVE:       CTRL + S
                     *      OPEN:       CTRL + O
                     *      NEW:        CTRL + N
                     *      START:      CTRL + R
                     *      FORMAT:     CTRL + L
                     *      CLOSE TAB:  CTRL + W
                     *      UNDO:       CTRL + Z
                     */
                    switch (e.getKeyCode()) {
                        case 83:    // 'S' key;
                            int result = onSave();
                            if (result == 0) {
                                changes.put(c, false);
                            }
                            break;
                        case 79:    // 'O' key
                            onOpen();
                            break;
                        case 78:    // 'N' key
                            onNew();
                            break;
                        case 82:    // 'R' key
                            onStart();
                            break;
                        case 76:    // 'L' key
                            //TODO fix formatting
//                            format();
                            break;
                        case 87:    // 'W' key
                            removeTab(programPane.getSelectedIndex());
                            break;
                        case 90:    // 'Z' key
                            undo();
                        default:
                            break;
                    }
                } else if (!e.isActionKey() && !e.isAltDown() && !e.isShiftDown()) {
                    if (!changes.get(c)) {
                        JLabel label = ((JLabel) ((JPanel) programPane.getTabComponentAt(programPane.getSelectedIndex())).getComponent(0));
                        label.setText(label.getText() + "*");
                        changes.put(c, true);
                    }
                    contentCheckTimer.stop();
                    contentCheckTimer.start();
                }
            }
        });
    }

    private void highlight(int lineNumber) {
        String code = getCode();
        String[] lines = code.split("\n");

        // Line numbers start on 1, indices on 0
        int startPos = code.indexOf(lines[lineNumber - 1]);
        int endPos = startPos + lines[lineNumber - 1].length();
        try {
            highlightTags.put(lineNumber, getHighlighter().addHighlight(startPos, endPos, painter));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void removeHighlight(int lineNumber) {
        getHighlighter().removeHighlight(highlightTags.get(lineNumber));
    }

    private void printError(LANGdradigError error) {
        int lineNumber = Math.min(error.getLineNumber(), getCode().split("\n").length);
        if (lineNumber > 0) {
            highlight(lineNumber);
        }
        error.setLineNumber(lineNumber);
        print(error.toString());
    }

    private void print(String s) {
        messagesArea.append(s + "\n");
    }

    public String getFilePath() {
        return filePaths.get(programPane.getSelectedIndex());
    }

    public String getFilePath(int index) {
        return filePaths.get(index);
    }

    public Highlighter getHighlighter() {
        return getCodeArea().getHighlighter();
    }

    public void popup(String message) {
        String oldMessage = notificationLabel.getText();
        String newMessage = oldMessage.equals("") ? message : oldMessage + ", " + message;
        notificationLabel.setText(newMessage);
        notificationPanel.setVisible(true);

        if (notificationTimer == null) {
            notificationTimer = new Timer(3000, e -> {
                notificationPanel.setVisible(false);
                notificationLabel.setText("");
                notificationTimer = null;
            });
            notificationTimer.setRepeats(false);
        } else {
            notificationTimer.stop();
            notificationTimer.setInitialDelay(3000);
        }
        notificationTimer.start();
    }

    public void openFile(File file) {
        JTextArea area = new JTextArea();
        area.setFont(font);
        String fileName;
        if (file == null) {
            fileName = "NieuwBestand";
        } else {
            // Check if file is already opened
            for (int i = 0; i < filePaths.size(); i++) {
                String filePath = filePaths.get(i);
                if (file.getAbsolutePath().equals(filePath)) {
                    programPane.setSelectedIndex(i);
                    return;
                }
            }
            fileName = file.getName();
            try {
                String content = new String(Files.readAllBytes(file.toPath()));
                area.setText(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        area.setTabSize(2);
        setupKeyListener(area);
        JScrollPane codeScroll = new JScrollPane(area);
        codeScroll.setRowHeaderView(new TextLineNumber(area));
        programPane.addTab(fileName, codeScroll);
        programPane.setSelectedIndex(programPane.getTabCount() - 1);
        JPanel tabPanel = new JPanel();
        tabPanel.setOpaque(false);
        tabPanel.add(new JLabel(fileName));
        JButton closeButton = new JButton("X");
        closeButton.setContentAreaFilled(false);
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setForeground(Color.BLACK);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                removeTab(programPane.indexOfComponent(codeScroll));
            }
        });
        tabPanel.add(closeButton);

        programPane.setTabComponentAt(programPane.getSelectedIndex(), tabPanel);
        area.requestFocus();

        if (file != null) {
            filePaths.add(file.getAbsolutePath());
        } else {
            filePaths.add(null);
        }
        popup(fileName + " geopend");
        checkContent();
    }

    private void removeTab(int index) {
        JTextArea area = getCodeArea(index);
        if (changes.get(area)) {
            Status status = promptSave("Opslaan?", "Dit bestand bevat onopgeslagen wijzigen, wilt u deze opslaan?");
            switch (status) {
                case YES:
                    int result = onSave(index);
                    if (result == -1) {
                        return;
                    }
                case NO:
                    break;
                case CANCEL:
                    return;
                default:
                    return;
            }
        }
        changes.remove(area);
        filePaths.remove(index);
        programPane.removeTabAt(index);
        if (programPane.getTabCount() == 0) {
            variableView.setText("");
        }
    }

    private Status promptSave(String title, String message) {
        int result = JOptionPane.showOptionDialog(this, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"Ja", "Nee", "Annuleren"}, null);
        switch (result) {
            case JOptionPane.OK_OPTION:
                return Status.YES;
            case JOptionPane.NO_OPTION:
                return Status.NO;
            case JOptionPane.CANCEL_OPTION:
            case JOptionPane.CLOSED_OPTION:
            default:
                return Status.CANCEL;
        }
    }

    public JTextArea getCodeArea() {
        return (JTextArea) ((JViewport) ((JScrollPane) programPane.getSelectedComponent()).getComponent(0)).getComponent(0);
    }

    public JTextArea getCodeArea(int index) {
        return (JTextArea) ((JViewport) ((JScrollPane) programPane.getComponentAt(index)).getComponent(0)).getComponent(0);
    }

    public String getCode(int index) {
        return getCodeArea(index).getText();
    }

    public String getCode() {
        return getCodeArea().getText();
    }

    private boolean changes() {
        return changes.values().stream().anyMatch(b -> b);
    }

    private void format() {
        JTextArea area = getCodeArea();
        String newContent = Formatter.format(getCode());
        if (!newContent.equals(getCode())) {
            area.setText(newContent);
            if (!changes.get(area)) {
                JLabel label = ((JLabel) ((JPanel) programPane.getTabComponentAt(programPane.getSelectedIndex())).getComponent(0));
                label.setText(label.getText() + "*");
            }
            changes.put(area, true);
            checkContent();
        }
    }

    private void undo() {
        revisionPointer--;
        getCodeArea().setText(revisions.get(revisionPointer));
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
        new Main();
    }
}
