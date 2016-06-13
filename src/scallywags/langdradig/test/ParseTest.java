package scallywags.langdradig.test;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import scallywags.langdradig.grammatica.LANGdradigLexer;
import scallywags.langdradig.grammatica.LANGdradigParser;

public class ParseTest {
	
	@Test
	public void test0()throws Exception {
		ANTLRInputStream stream = new ANTLRFileStream("src/scallywags/langdradig/example/test0.langdradig");
		Lexer lexer = new LANGdradigLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		LANGdradigParser parser = new LANGdradigParser(tokens);
		ParseTree tree = parser.program();
		System.out.println(tree.toStringTree(parser));
	}	

}
