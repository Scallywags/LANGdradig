package scallywags.langdradig.ide.features.finished;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.undo.UndoManager;
import java.awt.*;

/**
 * Created by Jeroen Weener on 22/06/2016.
 * <p>
 * A very naïve syntaxHighlighter
 */
public class SyntaxHighlighter {
    private static final String[] keywords = {"als", "anders", "zolang", "reeksen", "reeks", "getallen", "getal", "stellingen", "stelling", "besteed", "uit aan", "kritiek", "wacht op", "doe", "klaar"};

    public static void highlightSyntax(JTextPane area) {
        StyledDocument doc = area.getStyledDocument();
        Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        doc.setCharacterAttributes(0, doc.getLength(), defaultStyle, true);
        try {
            colorKeywords(area);
            colorComments(area);
        } catch (BadLocationException ignore) {
        }
    }

    private static void colorComments(JTextPane area) throws BadLocationException {
        StyledDocument doc = area.getStyledDocument();
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.GRAY);
        String searchString = doc.getText(0, doc.getLength());
        int start = searchString.indexOf('#');
        int acc = start;
        while (start != -1) {
            searchString = searchString.substring(start + 1);
            int end = searchString.indexOf('\n');
            end = end == -1 ? searchString.length() : end;
            doc.setCharacterAttributes(acc, end + 1, set, true);
            start = searchString.indexOf('#');
            acc += start + 1;
        }
    }

    private static void colorKeywords(JTextPane area) throws BadLocationException {
        StyledDocument doc = area.getStyledDocument();
        for (String keyword : keywords) {
            SimpleAttributeSet set = new SimpleAttributeSet();
            StyleConstants.setForeground(set, getKeywordColor(keyword));
            String searchString = doc.getText(0, doc.getLength()).toLowerCase();
            int start = searchString.indexOf(keyword);
            int acc = start;
            while (start != -1) {
                doc.setCharacterAttributes(acc, keyword.length(), set, true);
                searchString = searchString.substring(start + 1);
                start = searchString.indexOf(keyword);
                acc += start + 1;
            }
        }
    }

    private static Color getKeywordColor(String keyword) {
        // Branch statements are blue
        if (keyword.equals("als") || keyword.equals("anders") || keyword.equals("zolang")) {
            return Color.BLUE;

            // Type syntax is orange
        } else if (keyword.equals("getallen")   || keyword.equals("getal") || keyword.equals("stellingen") || keyword.equals("stelling")
                || keyword.equals("reeksen")    || keyword.equals("reeks")) {
            return Color.decode("#FF8800");

            // Concurrency syntax is red
        } else if (keyword.equals("besteed") || keyword.equals("uit aan") || keyword.equals("kritiek")
                || keyword.equals("wacht op")) {
            return Color.RED;

        } else {
            // The rest of the keywords are just black
            return Color.BLACK;
        }
    }
}
