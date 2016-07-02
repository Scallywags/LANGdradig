package scallywags.langdradig.ide.features.finished;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeroen Weener on 22/06/2016.
 * A very naïve syntaxHighlighter
 */
public class SyntaxHighlighter {
    private static final String[] TYPE_KEYWORDS = {"reeks", "reeksen", "getal", "getallen", "stelling", "stellingen"};
    private static final String[] CONCURRENCY_KEYWORDS = {"gedeeld", "gedeelde", "besteed", "uit aan", "kritiek", "wacht op"};
    private static final String[] OPERATOR_KEYWORDS = {"plus", "min", "keer", "gedeeld door", "tot de macht", "modulus", "niet", "verhoog", "verlaag", "hoog"};
    private static final String[] COMPARATOR_KEYWORDS = {"gelijk is aan", "is gelijk aan", "gelijk aan", "ongelijk is aan", "is ongelijk aan", "kleiner is dan", "is kleiner dan", "kleiner dan", "is kleiner", "kleiner is", "groter is dan", "is groter dan", "groter dan", "groter is", "is groter", "ligt", "tussen", "binnen", "buiten"};
    private static final String[] BLOCK_KEYWORDS = {"als", "anders", "zolang", "terwijl", "voor", "doe", "klaar"};
    private static final String[] VALUE_KEYWORDS = {"waar", "onwaar"};
    private static final String[] REST_KEYWORDS = {"wordt", "klopt", "plek", "plaats", "zet", "lengte", "laat", "zien"};

    /*
     *  Highlights the content in the given area.
     */
    public static void highlightSyntax(JTextPane area) {
        StyledDocument doc = area.getStyledDocument();
        Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        doc.setCharacterAttributes(0, doc.getLength(), defaultStyle, true);
        try {
            colorNumbers(area);
            colorKeywords(area);
            colorComments(area);
        } catch (BadLocationException ignore) {
        }
    }

    private static void colorNumbers(JTextPane area) throws BadLocationException {
        StyledDocument doc = area.getStyledDocument();
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.decode("#FF00A6"));     // Pink
        String searchString = doc.getText(0, doc.getLength());
        for (int i = 0; i < searchString.length(); i++) {
            char c = searchString.charAt(i);
            if (c >= '0' && c <= '9') {
                doc.setCharacterAttributes(i, 1, set, true);
            }
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
        for (String keyword : getAllKeywords()) {
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
        if (        Arrays.asList(TYPE_KEYWORDS).contains(keyword)) {           // Type keywords:
            return Color.decode("#FF8800");                                     // Orange

        } else if ( Arrays.asList(CONCURRENCY_KEYWORDS).contains(keyword)) {    // Concurrency keywords:
            return Color.RED;                                                   // Red

        } else if ( Arrays.asList(OPERATOR_KEYWORDS).contains(keyword)) {       // Operator keywords:
            return Color.decode("#0099FF");                                     // Light blue

        } else if ( Arrays.asList(COMPARATOR_KEYWORDS).contains(keyword)) {     // Comparator keywords:
            return Color.decode("#0099FF");                                     // Light blue

        } else if ( Arrays.asList(BLOCK_KEYWORDS).contains(keyword)) {          // Block keywords:
            return Color.decode("#9426C7");                                     // Purple

        } else if ( Arrays.asList(VALUE_KEYWORDS).contains(keyword)) {          // Value keywords:
            return Color.decode("#FF00A6");                                     // Pink

        } else if ( Arrays.asList(REST_KEYWORDS).contains(keyword)) {           // Rest keywords:
            return Color.BLUE;                                                  // Blue

        } else {                                                                // Everything else:
            return Color.BLACK;                                                 // Black
        }
    }

    private static List<String> getAllKeywords() {
        List<String> result = new ArrayList<>();
        result.addAll(Arrays.asList(TYPE_KEYWORDS));
        result.addAll(Arrays.asList(CONCURRENCY_KEYWORDS));
        result.addAll(Arrays.asList(OPERATOR_KEYWORDS));
        result.addAll(Arrays.asList(COMPARATOR_KEYWORDS));
        result.addAll(Arrays.asList(BLOCK_KEYWORDS));
        result.addAll(Arrays.asList(VALUE_KEYWORDS));
        result.addAll(Arrays.asList(REST_KEYWORDS));
        return result;
    }
}
