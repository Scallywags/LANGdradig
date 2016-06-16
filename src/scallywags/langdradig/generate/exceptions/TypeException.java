package scallywags.langdradig.generate.exceptions;

import org.antlr.v4.runtime.tree.ParseTree;

import scallywags.langdradig.generate.Type;

@SuppressWarnings("serial")
public class TypeException extends CheckerException {
    private Type expectedType;
    private Type actualType;

    public TypeException(ParseTree subTree, Type expected, Type actual) {
        super(subTree, String.format("Expected %s but it was %s in \"%s\".",
                expected == null ? "null" : expected.toString(), actual == null ? "null" : actual.toString(), subTree));
        expectedType = expected;
        actualType = actual;
    }

    public Type getExpectedType() {
        return expectedType;
    }

    public Type getActualType() {
        return actualType;
    }

}
