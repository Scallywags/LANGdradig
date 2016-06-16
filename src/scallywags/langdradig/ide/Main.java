package scallywags.langdradig.ide;

import scallywags.langdradig.generate.Checker;
import scallywags.langdradig.generate.except.AlreadyDeclaredException;
import scallywags.langdradig.generate.except.CheckerException;
import scallywags.langdradig.generate.except.TypeException;
import scallywags.langdradig.generate.except.UndeclaredException;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    private static final String EXTENSION = ".langdradig";
    private JPanel contentPane;
    private JButton openButton;
    private JButton saveButton;
    private JTextArea codeArea;
    private JTextArea messagesArea;
    private JButton clearButton;
    private JButton showHideButton;
    private JScrollPane messagesAreaScrollPane;
    private JLabel messagesLabel;
    private JPanel messagesPanel;
    private JButton startButton;

    private String filePath;

    public Main() {
        setContentPane(contentPane);
//        setModal(true);
        getRootPane().setDefaultButton(openButton);

        codeArea.setTabSize(2);

        openButton.addActionListener(e -> onOpen());

        saveButton.addActionListener(e -> onSave());

        clearButton.addActionListener(e -> clearMessages());

        showHideButton.addActionListener(e -> toggleMessages());

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
                    //TODO
                    e.printStackTrace();
                }
            } else {
                //Display dialog with error, file should be of type LANGdradig
            }
        }
    }

    private void onCancel() {
        dispose();
    }

    private void onSave() {
        List<String> lines = new ArrayList<>();
        lines.add(codeArea.getText());

        try {
            Files.write(new File(filePath).toPath(), lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            //Should not happen
            e.printStackTrace();
        }
        clearMessages();
        checkContent();
    }

    private void checkContent() {
        print("Opslaan...");
        Checker checker = new Checker();
        try {
            checker.checkString(codeArea.getText());
        } catch (IOException e) {
            //TODO handle exception
            e.printStackTrace();
        }
        checker.getExceptions().forEach(this::printError);
        if (checker.getExceptions().isEmpty()) {
            print("Geen errors");
        }
    }

    public void clearMessages() {
        messagesArea.setText("");
    }

    private void toggleMessages() {
        messagesPanel.setVisible(!messagesPanel.isVisible());
        this.revalidate();
    }

    private void printError(CheckerException e) {
        if (e instanceof AlreadyDeclaredException) {
            print("Variabele " + ((AlreadyDeclaredException) e).getIdentifier() + " is al gedefinieerd.");
        } else if (e instanceof TypeException) {
            print("Verwachtte " + ((TypeException) e).getExpectedType() + " maar het was "+ ((TypeException) e).getActualType());
        } else if (e instanceof UndeclaredException) {
            print("Variabele " + ((UndeclaredException) e).getIdentifier() + " is nog niet gedefinieerd.");
        } else {
            print("Error. (Geen verdere informatie beschikbaar)");
        }
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}