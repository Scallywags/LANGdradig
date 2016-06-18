package scallywags.langdradig.ide.frames;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class SaveDialog extends JDialog {

    public enum Decision {CANCEL, NO, OK};

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel messageLabel;
    private JButton buttonNo;

    private Decision d;

    public Decision getDecision() {
        return d;
    }

    public SaveDialog(Main main) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        setTitle("Opslaan?");

        String path = main.getFilePath();
        messageLabel.setText("Wilt u " + (path == null ? "het huidige bestand" : new File(path).getName())  + " opslaan?");

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        buttonNo.addActionListener(e -> onNo());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    private void onOK() {
        dispose();
        d = Decision.OK;
    }

    private void onCancel() {
        dispose();
        d = Decision.CANCEL;
    }

    private void onNo() {
        dispose();
        d = Decision.NO;
    }
}
