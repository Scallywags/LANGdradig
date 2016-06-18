package scallywags.langdradig.ide.frames;

import scallywags.langdradig.generate.Checker;
import scallywags.langdradig.generate.exceptions.CheckerException;
import scallywags.langdradig.ide.TextLineNumber;
import scallywags.langdradig.ide.errors.LANGdradigError;
import scallywags.langdradig.ide.errors.LANGdradigErrorBuilder;

import javax.swing.*;
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
// TODO support for control s to save
// TODO support for control r to run
// TODO implement onStart function
// TODO translate certain errors
// TODO verwacht onbekend should be undeclared error
// TODO Fix bug in checker -> b is een waarhseid <- gaat stuk met een nullpointer
// TODO add view with overview of variables and their types - scopes
// TODO tabs for programs
// TODO Floating bubble for few seconds when saving or opening
// TODO Exception

public class Main extends JFrame {
    private static final String EXTENSION = ".langdradig";
    private JPanel contentPane;
    private JButton openButton;
    private JButton saveButton;

    private final JFileChooser fc = new JFileChooser();

    private JTextArea codeArea;
    private Highlighter highlighter;
    private Highlighter.HighlightPainter painter;
    private Map<Integer, Object> highlightTags;

    private JTextArea messagesArea;
    private JButton clearButton;
    private JButton showHideButton;
    private JScrollPane messagesAreaScrollPane;
    private JLabel messagesLabel;
    private JPanel messagesPanel;
    private JButton startButton;
    private JScrollPane codeScrollPane;
    private JButton newButton;

    private JSplitPane splitPane;
    private int dividerLocation;

    private String filePath;

    private boolean madeChanges;

    public Main() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(openButton);

        madeChanges = false;

        codeArea.setTabSize(2);
        setUpKeyListener();

        newButton.addActionListener(e -> onNew());

        openButton.addActionListener(e -> onOpen());

        saveButton.addActionListener(e -> onSave());

        clearButton.addActionListener(e -> clearMessages());

        showHideButton.addActionListener(e -> toggleMessages());

        startButton.addActionListener(e -> onStart());

        TextLineNumber tln = new TextLineNumber(codeArea);
        codeScrollPane.setRowHeaderView(tln);

        highlighter = codeArea.getHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);
        highlightTags = new HashMap<>();

        fc.setFileFilter(new FileNameExtensionFilter("langdradig file", "langdradig"));

        /**
         * Key shortcuts
         *      SAVE:   CTRL + s
         *      OPEN:   CTRL + o
         *      NEW:    CTRL + n
         *      START:  CTRL + r
         */
        codeArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
                    switch (e.getKeyCode()) {
                        case 83:    // 's' key;
                            onSave();
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
                }
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOpen() {
        if (madeChanges) {
            SaveDialog s = new SaveDialog(this);
            switch (s.getDecision()) {
                case OK:
                    onSave();
                    break;
                case CANCEL:
                    return;
                case NO:
                    // Nothing
                    break;
                default:
                    break;
            }
        }
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String fileName = file.getName();
            if (file.exists()) {
                if (fileName.endsWith(EXTENSION)) {
                    filePath = file.getAbsolutePath();
                    this.setTitle("LANGdradig IDE - " + fileName);
                    try {
                        String content = new String(Files.readAllBytes(file.toPath()));
                        codeArea.setText(content);
                        onSave();
                        setUpKeyListener();
                    } catch (IOException e) {
                        // No permission to read ? Ignore
                        e.printStackTrace();
                    }
                } else {
                    new ErrorDialog("Bestandstype niet ondersteunt", "Open een bestand met de extensie .langdradig");
                }
            } else {
                new ErrorDialog("Niet gevonden", "Het geselecteerde betand kan niet worden gevonden.");
            }
        }
    }

    private void onCancel() {
        dispose();
    }

    private void onNew() {
        if (madeChanges) {
            SaveDialog s = new SaveDialog(this);
            switch (s.getDecision()) {
                case OK:
                    onSave();
                    break;
                case CANCEL:
                    return;
                case NO:
                    break;
                default:
                    break;
            }
        }
        reset();
    }

    public void reset() {
        setTitle("LANGdradig IDE - Nieuw Bestand");
        messagesArea.setText("");
        messagesArea.setBackground(Color.WHITE);
        filePath = null;

        madeChanges = false;
        codeArea.setText("");
        setUpKeyListener();
    }

    public void onSave() {
        String content = codeArea.getText();
        highlighter.removeAllHighlights();

        if (filePath == null) {
            fc.setSelectedFile(new File("NieuwBestand.langdradig"));
            int returnValue = fc.showSaveDialog(this);
            if (returnValue != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File f = fc.getSelectedFile();
            filePath = f.getAbsolutePath();
            this.setTitle("LANGdradig IDE - " + f.getName());
        }

        try (PrintWriter writer = new PrintWriter(filePath, "UTF-8")) {
            writer.write(content);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        clearMessages();
        checkContent();

        madeChanges = false;
    }

    private void onStart() {
        new ErrorDialog("Not yet implemented", "This feature is not yet implemented.");
    }

    private void checkContent() {
        Checker checker = new Checker();
        checker.checkString(codeArea.getText());
        if (checker.getCheckerExceptions().isEmpty() && checker.getParserExceptions().isEmpty()) {
            print("Geen errors!");
            messagesArea.setBackground(new Color(180, 255, 150));
        } else {
            List<LANGdradigError> errors = checker.getParserExceptions();
            List<CheckerException> checkerExceptions = checker.getCheckerExceptions();
            checkerExceptions.forEach(e -> errors.add(LANGdradigErrorBuilder.format(codeArea.getText(), e)));
            Collections.sort(errors);
            for (LANGdradigError e : errors) {
                printError(e);
            }
            messagesArea.setBackground(Color.PINK);
        }
    }

    private void setUpKeyListener() {
        codeArea.addKeyListener(new KeyAdapter() {
                                    @Override
                                    public void keyTyped(KeyEvent e) {
                                        if ((e.getModifiers() & ActionEvent.CTRL_MASK) != ActionEvent.CTRL_MASK) {
                                            madeChanges = true;
                                            codeArea.removeKeyListener(this);
                                        }
                                    }
                                }
        );
    }

    public void clearMessages() {
        messagesArea.setText("");
        messagesArea.setBackground(Color.WHITE);
    }

    private void toggleMessages() {
        if (splitPane.getBottomComponent() == null) {
            splitPane.setDividerLocation(dividerLocation);
            splitPane.setBottomComponent(messagesPanel);
        } else {
            dividerLocation = splitPane.getDividerLocation();
            splitPane.setBottomComponent(null);
        }
        this.revalidate();
    }

    private void highlight(int lineNumber) {
        String code = codeArea.getText();
        String[] lines = code.split("\n");

        System.out.println(lineNumber);
        // Line numbers start on 1, indices on 0
        int startPos = code.indexOf(lines[lineNumber - 1]);
        int endPos = startPos + lines[lineNumber - 1].length();
        System.out.println(startPos);
        try {
            highlightTags.put(lineNumber, highlighter.addHighlight(startPos, endPos, painter));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void removeHighlight(int lineNumber) {
        highlighter.removeHighlight(highlightTags.get(lineNumber));
    }

    private void printError(LANGdradigError error) {
        int lineNumber = Math.min(error.getLineNumber(), codeArea.getText().split("\n").length);
        if (lineNumber > 0) {
            highlight(lineNumber);
        }
        error.setLineNumber(lineNumber);
        print(error.toString());
    }

    private void print(String s) {
        messagesArea.append(s + "\n");
    }

    public static void main(String[] args) {
        Main dialog = new Main();
        dialog.pack();
        dialog.setTitle("LANGdradig IDE - Nieuw Bestand");
        dialog.setResizable(true);
        dialog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        dialog.setVisible(true);
    }

    public String getFilePath() {
        return filePath;
    }
}
