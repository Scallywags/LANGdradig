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

import java.io.IOException;

public class ParseTest {
	
	@Test
	public void testText() {
		testExpression("a KEER b PLUS c KEER d");
        testProgram("");
        testProgram("b is een waarheid.");
        testProgram("b wordt waar.");
        testProgram("a is een geheel getal.");
        testProgram("a wordt 3.");
	}
	
//	@Test
	public void testExamples() {
		try {
			testFile("src/scallywags/langdradig/example/test0.langdradig");
			testFile("src/scallywags/langdradig/example/test1.langdradig");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void testAlsDanAnders() {
		try {
			testFile("src/scallywags/langdradig/example/als-dan-anders_example.langdradig");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void testZolang() {
		try {
			testFile("src/scallywags/langdradig/example/zolang_example.langdradig");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void testOperators() {
		try {
			testFile("src/scallywags/langdradig/example/operator_example.langdradig");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void testBesteedUitKritiek() {
		try {
			testFile("src/scallywags/langdradig/example/besteed_uit_kritiek_example.langdradig");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    private LANGdradigParser test(String text) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new LANGdradigLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        return new LANGdradigParser(tokens);
    }
	
	private void testExpression(String text) {
		LANGdradigParser parser = test(text);
		parser.expression();
	}

    private void testProgram(String text) {
        LANGdradigParser parser = test(text);
        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree(parser));
    }
	
	private void testFile(String path) throws IOException {
		CharStream stream = new ANTLRFileStream(path);
		Lexer lexer = new LANGdradigLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		LANGdradigParser parser = new LANGdradigParser(tokens);
		parser.program();
	}

}
