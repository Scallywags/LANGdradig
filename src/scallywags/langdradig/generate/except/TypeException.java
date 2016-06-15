package scallywags.langdradig.generate.except;

import org.antlr.v4.runtime.tree.ParseTree;

import scallywags.langdradig.generate.Type;

@SuppressWarnings("serial")
public class TypeException extends CheckerException {
	
	public TypeException(ParseTree subTree, Type expected, Type actual) {
		super(String.format("Expected Type %s but got type %s in \"%s\".",
				expected.toString(), actual.toString(), subTree.getText()));
	}

}
