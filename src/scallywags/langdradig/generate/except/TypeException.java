package scallywags.langdradig.generate.except;

import org.antlr.v4.runtime.tree.ParseTree;

import scallywags.langdradig.generate.Type;

@SuppressWarnings("serial")
public class TypeException extends CheckerException {
	private Type expectedType;
	private Type actualType;
	
	public TypeException(ParseTree subTree, Type expected, Type actual) {
		super(String.format("Expected Type %s but got type %s in \"%s\".",
				expected == null ? "null" : expected.toString() , actual == null ? "null" : actual.toString(), subTree.getText()));
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
