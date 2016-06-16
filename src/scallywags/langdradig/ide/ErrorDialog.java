package scallywags.langdradig.ide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel messageLabel;

    public ErrorDialog(String title, String message) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        pack();
        setSize(new Dimension(500, 200));
        setLocationRelativeTo(null);
        setTitle(title);
        messageLabel.setText(message);

        setVisible(true);
    }

    private void onOK() {
        dispose();
    }
}
