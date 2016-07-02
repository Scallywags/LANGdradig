package scallywags.langdradig.ide.features.unfinished;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Utilities;

/**
 * Created by Jeroen Weener on 22/06/2016.
 *
 * Helper class to autocomplete in the IDE
 */
public class AutoCompleter {
    private static final boolean ON = true;

    /*
     *  Auto completes "doe klaar" and "besteed uit" blocks
     */
    public static void complete(JTextPane c, DocumentEvent e) {
        if (!ON) return;
        try {
            int start = Utilities.getWordStart(c, c.getCaretPosition());
            int end = Utilities.getWordEnd(c, c.getCaretPosition());
            String text = c.getDocument().getText(start, end - start);
            Document doc = e.getDocument();
            switch (text) {
                case "doe":
                    SwingUtilities.invokeLater(() -> {
                        try {
                            int offset = c.getCaretPosition();
                            doc.insertString(offset, "\n\t\nklaar.", null);
                            c.setCaretPosition(offset + 2);
                        } catch (BadLocationException ignore) {
                        }
                    });
                    break;
                case "besteed":
                    SwingUtilities.invokeLater(() -> {
                        try {
                            int offset = c.getCaretPosition();
                            doc.insertString(offset, "\n\t\nuit aan *.\nwacht op *.", null);
                            c.setCaretPosition(offset + 2);
                        } catch (BadLocationException ignore) {
                        }
                    });
                default:
                    break;
            }
        } catch (BadLocationException ignore) {}
    }
}
