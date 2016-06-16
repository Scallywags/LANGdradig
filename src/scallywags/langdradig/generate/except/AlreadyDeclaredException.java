package scallywags.langdradig.generate.except;

import org.antlr.v4.runtime.tree.ParseTree;

@SuppressWarnings("serial")
public class AlreadyDeclaredException extends CheckerException {
    private String identifier;

    public AlreadyDeclaredException(ParseTree tree, String identifier) {
        super(tree, String.format("%s was already declared.", identifier));
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
