package scallywags.langdradig.ide.frames;

import scallywags.langdradig.generate.Checker;
import scallywags.langdradig.generate.exceptions.CheckerException;
import scallywags.langdradig.ide.TextLineNumber;
import scallywags.langdradig.ide.errors.LANGdradigError;
import scallywags.langdradig.ide.errors.LANGdradigErrorBuilder;

import javax.swing.*;
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

public class Main extends JFrame {
    private static final String EXTENSION = ".langdradig";
    private JPanel contentPane;
    private JButton openButton;
    private JButton saveButton;

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

    private String filePath;

    public Main() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(openButton);

        codeArea.setTabSize(2);

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
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String fileName = file.getName();
            if (fileName.endsWith(EXTENSION)) {
                filePath = file.getAbsolutePath();
                this.setTitle("LANGdradig IDE - " + fileName);
                try {
                    String content = new String(Files.readAllBytes(file.toPath()));
                    codeArea.setText(content);
                    codeArea.setEditable(true);
                } catch (IOException e) {
                    // No permission to read ? Ignore
                    e.printStackTrace();
                }
            } else {
                new ErrorDialog("Bestandstype niet ondersteunt", "Open een bestand met de extensie .langdradig");
            }
        }
    }

    private void onCancel() {
        dispose();
    }

    private void onSave() {
        String content = codeArea.getText();
        highlighter.removeAllHighlights();
        try (PrintWriter writer = new PrintWriter(filePath, "UTF-8")) {
            writer.write(content);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        clearMessages();
        checkContent();
    }

    private void onStart() {
        new ErrorDialog("Not yet implemented", "This feature is not yet implemented.");
    }

    private void checkContent() {
        print("Opslaan...");
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

    public void clearMessages() {
        messagesArea.setText("");
    }

    private void toggleMessages() {
        messagesPanel.setVisible(!messagesPanel.isVisible());
        this.revalidate();
    }

    private void highlight(int lineNumber) {
        String code = codeArea.getText();
        String[] lines = code.split("\n");
        // Line numbers start on 1, indices on 0
        int startPos = code.indexOf(lines[lineNumber - 1]);
        int endPos = startPos + lines[lineNumber - 1].length() - 1;
        try {
            highlightTags.put(lineNumber, highlighter.addHighlight(startPos, endPos, painter));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void removeHighlight(int lineNumber) {
        highlighter.removeHighlight(highlightTags.remove(lineNumber));
    }

    private void printError(LANGdradigError error) {
        print(error.toString());
        highlight(error.getLineNumber());
    }

    private void print(String s) {
        messagesArea.append(s + "\n");
    }

    public static void main(String[] args) {
        Main dialog = new Main();
        dialog.pack();
        dialog.setTitle("LANGdradig IDE");
        dialog.setResizable(true);
        dialog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        dialog.setVisible(true);
    }
}