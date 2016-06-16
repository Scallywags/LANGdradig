package scallywags.langdradig.generate.except;

import org.antlr.v4.runtime.tree.ParseTree;

@SuppressWarnings("serial")
public class UndeclaredException extends CheckerException {
    private String identifier;

    public UndeclaredException(ParseTree tree, String identifier) {
        super(tree, String.format("%s was not declared.", identifier));
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

}
