package scallywags.langdradig.ide.features.unfinished;

import scallywags.langdradig.generate.Variable;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.util.List;

/**
 * Created by Jeroen Weener on 22/06/2016.
 */
public class SyntaxHighlighter {
    private static final boolean ON = false;

    public static void highlightVariables(JTextArea area, List<Variable> variables) {
        if (!ON) return;
        //TODO
    }

    public static void colorKeywords(JTextPane area, String content) {
        try {
            SimpleAttributeSet set = new SimpleAttributeSet();
            StyleConstants.setItalic(set, true);
            StyleConstants.setForeground(set, Color.YELLOW);
            String searchString = content;
            Document doc = area.getStyledDocument();
            int start;
            int acc = 0;
            do {
                start = searchString.indexOf("als");
                acc = start + searchString.indexOf("als");
                doc.insertString(start, "SLA", set);
                doc.remove(start + 3, 3);
                searchString = searchString.substring(acc);
                System.out.println("TEST");
            } while (start != -1);
            area.setCharacterAttributes(new SimpleAttributeSet(), true);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
