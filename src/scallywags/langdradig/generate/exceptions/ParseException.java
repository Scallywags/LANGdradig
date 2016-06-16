package scallywags.langdradig.generate.exceptions;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by Jeroen Weener on 15/06/2016.
 */
public class ParseException extends CheckerException {

    public ParseException(ParseTree tree, String message) {
        super(tree, message);
    }
}
