package scallywags.langdradig.test;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import scallywags.langdradig.grammatica.LANGdradigLexer;
import scallywags.langdradig.grammatica.LANGdradigParser;

public class ParseTest {
	
	@Test
	public void testText() throws Exception {
		testExpression("a KEER b PLUS c KEER d");
	}
	
	@Test
	public void testExamples() throws Exception {
		testFile("src/scallywags/langdradig/example/test0.langdradig");
		testFile("src/scallywags/langdradig/example/test1.langdradig");
	}
	
	private void testExpression(String text) {
		CharStream stream = new ANTLRInputStream(text);
		Lexer lexer = new LANGdradigLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		LANGdradigParser parser = new LANGdradigParser(tokens);
		ParseTree tree = parser.expression();
		System.out.println(tree.toStringTree(parser));
	}
	
	private void testFile(String path) throws Exception {
		CharStream stream = new ANTLRFileStream(path);
		Lexer lexer = new LANGdradigLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		LANGdradigParser parser = new LANGdradigParser(tokens);
		ParseTree tree = parser.program();
		System.out.println(tree.toStringTree(parser)); //TODO
	}

}
