package scallywags.langdradig.ide.features.finished;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.undo.UndoManager;
import java.awt.*;

/**
 * Created by Jeroen Weener on 22/06/2016.
 *
 * A very naïve syntaxHighlighter
 */
public class SyntaxHighlighter {
    private static final String[] keywords = {"als", "anders", "zolang", "getal", "stelling", "besteed", "uit", "aan", "kritiek", "wacht op", "gedeeld", "gedeelde", "doe", "klaar"};

    public static void highlightSyntax(JTextPane area) {
        StyledDocument doc = area.getStyledDocument();
        Style defaultStyle = StyleContext.
                getDefaultStyleContext().
                getStyle(StyleContext.DEFAULT_STYLE);
        doc.setCharacterAttributes(0, doc.getLength(), defaultStyle, true);
        try {
            colorComments(area);
            colorKeywords(area);
        } catch (BadLocationException ignore){}
    }

    private static void colorComments(JTextPane area) throws BadLocationException {
        StyledDocument doc = area.getStyledDocument();
        String content = doc.getText(0, doc.getLength());
        String[] intermediate = content.split("#");
        String[] comments = new String[intermediate.length];
        for (int i = 1; i < intermediate.length; i++) {
            comments[i] = intermediate[i].split("\n")[0];
        }
    }

    private static void colorKeywords(JTextPane area) throws BadLocationException {
            StyledDocument doc = area.getStyledDocument();
            for (String keyword : keywords) {
                SimpleAttributeSet set = new SimpleAttributeSet();
                StyleConstants.setForeground(set, getKeywordColor(keyword));
                String searchString = doc.getText(0, doc.getLength());
                int start = searchString.indexOf(keyword);
                int acc = start;
                while (start != -1) {
                    doc.setCharacterAttributes(acc, keyword.length(), set, true);
                    searchString = searchString.substring(start + 1);
                    start = searchString.indexOf(keyword);
                    acc += start + 1;
                }
            }
            area.setCharacterAttributes(new SimpleAttributeSet(), true);
    }

    private static Color getKeywordColor(String keyword) {
        // Branch statements are blue
        if (keyword.equals("als") || keyword.equals("anders") || keyword.equals("zolang")) {
            return Color.BLUE;

            // Type syntax is orange
        } else if (keyword.equals("getal") || keyword.equals("stelling")) {
            return Color.decode("#FF8800");

            // Concurrency syntax is red
        } else if (keyword.equals("besteed") || keyword.equals("uit") || keyword.equals("aan") || keyword.equals("kritiek") ||
                keyword.equals("wacht op") || keyword.equals("gedeeld") || keyword.equals("gedeelde")) {
            return Color.RED;

        } else {
            // The rest of the keywords are just black
            return Color.BLACK;
        }
    }
}
