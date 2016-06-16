package scallywags.langdradig.generate.except;

import org.antlr.v4.runtime.tree.ParseTree;

@SuppressWarnings("serial")
public class CheckerException extends RuntimeException {
    private String text;

    public CheckerException(ParseTree subTree, String message) {
        super(message);
        text = printTree(subTree);
    }

    public String getText() {
        return text;
    }

    /**
     * Not totally correct, sometimes print multiple spaces
     *
     * @param tree the tree that was constructed from a sentence in our program
     * @return A string representation of the original line that the tree was constructed from
     */
    private static String printTree(ParseTree tree) {
        StringBuilder sb = new StringBuilder();
        if (tree.getChildCount() == 0) {
            return tree.getText();
        } else {
            for (int i = 0; i < tree.getChildCount(); i++) {
                sb.append(printTree(tree.getChild(i))).append(" ");
            }
        }
        return sb.toString();
    }

}
