package scallywags.langdradig.ide.frames;

import scallywags.langdradig.generate.Checker;
import scallywags.langdradig.generate.exceptions.CheckerException;
import scallywags.langdradig.ide.TextLineNumber;
import scallywags.langdradig.ide.errors.LANGdradigError;
import scallywags.langdradig.ide.errors.LANGdradigErrorBuilder;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.filechooser.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

/**
 * Created by Jeroen Weener on 15/06/2016.
 */
// TODO implement onStart function
// TODO translate certain errors
// TODO verwacht onbekend should be undeclared error
// TODO add view with overview of variables and their types - scopes
// TODO Exception
// TODO requestfocus in codearea?
// TODO fix "'" char error in parser
// TODO add deelbaar door
// TODO font scaling
// TODO JOptionPane
// TODO saving file with existing name dialog
// TODO saving file as file that is already open should merge tabs
// TODO closing unsaved tab should prompt for save


public class Main extends JFrame {
    private static final String EXTENSION = ".langdradig";

    private JPanel contentPane;
    private JButton openButton;
    private JButton saveButton;

    private final JFileChooser fc = new JFileChooser();

    private Highlighter.HighlightPainter painter;
    private Map<Integer, Object> highlightTags;

    private JTextArea messagesArea;
    private JButton clearButton;
    private JButton showHideButton;
    private JScrollPane messagesAreaScrollPane;
    private JPanel messagesPanel;
    private JButton startButton;
    private JButton newButton;

    private JSplitPane splitPane;
    private JTabbedPane programPane;
    private JLabel notificationLabel;
    private JPanel notificationPanel;
    private JScrollPane notificationScrollPane;
    private int dividerLocation;

    private List<String> filePaths;
    private Timer notificationTimer;
    private Timer contentCheckTimer;
    private int changesCounter;

    public Main() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(openButton);

        newButton.addActionListener(e -> onNew());

        openButton.addActionListener(e -> onOpen());

        saveButton.addActionListener(e -> onSave());

        clearButton.addActionListener(e -> clearMessages());

        showHideButton.addActionListener(e -> toggleMessages());

        startButton.addActionListener(e -> onStart());

        filePaths = new ArrayList<>();

        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);
        highlightTags = new HashMap<>();

        fc.setFileFilter(new FileNameExtensionFilter("langdradig file", "langdradig"));

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        splitPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                splitPane.setDividerLocation(.8);
            }
        });

        openFile(null);
        changesCounter = 0;

        contentCheckTimer = new Timer(1000, f -> {
            System.out.println("checkContent()");
            checkContent();
        });
        contentCheckTimer.setRepeats(false);

        pack();
        setTitle("LANGdradig IDE");
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        // There is a bug in JSplitPane preventing componentShown() from being called if we don't do this
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
                    new ErrorDialog("Bestandstype niet ondersteunt", "Dit bestandstype wordt niet ondersteunt. Open een bestand met de extensie .langdradig");
                }
            } else {
                new ErrorDialog("Niet gevonden", "Het geselecteerde betand kan niet worden gevonden.");
            }
        }
    }

    private void onCancel() {
        if (changesCounter > 0) {
            SaveDialog s = new SaveDialog();
            switch (s.getDecision()) {
                case OK:
                    for (int i = 0; i < programPane.getTabCount(); i++) {
                        programPane.setSelectedIndex(i);
                        onSave();
                    }
                    dispose();
                    break;
                case CANCEL:
                    break;
                case NO:
                    dispose();
                    break;
                default:
                    break;
            }
        } else {
            dispose();
        }
    }

    private void onNew() {
        openFile(null);
    }

    public void onSave() {
        String content = getCode();
        String filePath = getFilePath();

        if (filePath == null) {
            fc.setSelectedFile(new File("NieuwBestand.langdradig"));
            int returnValue = fc.showSaveDialog(this);
            if (returnValue != JFileChooser.APPROVE_OPTION) {
                return;
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
    }

    private void onStart() {
//        popup("Running " + new File(filePath).getName());
        new ErrorDialog("Not yet implemented", "This feature is not yet implemented.");
    }

    private void checkContent() {
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

    public Highlighter getHighlighter() {
        return ((JTextArea) ((JViewport) ((JScrollPane) programPane.getSelectedComponent()).getComponent(0)).getComponent(0)).getHighlighter();
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
        area.addKeyListener(new KeyAdapter() {
            private boolean changed;

            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
                    /**
                     * Key shortcuts
                     *      SAVE:   CTRL + s
                     *      OPEN:   CTRL + o
                     *      NEW:    CTRL + n
                     *      START:  CTRL + r
                     */
                    switch (e.getKeyCode()) {
                        case 83:    // 's' key;
                            onSave();
                            changed = false;
                            changesCounter--;
                            break;
                        case 79:    // 'o' key
                            onOpen();
                            break;
                        case 78:    // 'n' key
                            onNew();
                            break;
                        case 82:    // 'r' key
                            onStart();
                            break;
                        default:
                            break;
                    }
                } else if (!e.isActionKey() && !e.isAltDown() && !e.isShiftDown()) {
                    if (!changed) {
                        JLabel label = ((JLabel) ((JPanel) programPane.getTabComponentAt(programPane.getSelectedIndex())).getComponent(0));
                        label.setText(label.getText() + "*");
                        changed = true;
                        changesCounter++;
                    }
                    contentCheckTimer.stop();
                    contentCheckTimer.start();
                }
            }
        });
        JScrollPane scroll = new JScrollPane(area);
        scroll.setRowHeaderView(new TextLineNumber(area));

        programPane.addTab(fileName, scroll);
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
                int index = programPane.indexOfComponent(scroll);
                removeTab(index);
            }
        });
        tabPanel.add(closeButton);

        programPane.setTabComponentAt(programPane.getSelectedIndex(), tabPanel);

        if (file != null) {
            filePaths.add(file.getAbsolutePath());
        } else {
            filePaths.add(null);
        }
        popup(fileName + " geopend");
        checkContent();
    }

    private void removeTab(int index) {
        filePaths.remove(index);
        programPane.removeTabAt(index);
    }

    public String getCode() {
        return ((JTextArea) ((JViewport) ((JScrollPane) programPane.getSelectedComponent()).getComponent(0)).getComponent(0)).getText();
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
