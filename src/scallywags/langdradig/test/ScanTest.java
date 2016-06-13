package scallywags.langdradig.test;

import org.junit.Test;

import scallywags.langdradig.grammatica.LANGdradigLexer;

public class ScanTest {
	
	private LexerTester tester = new LexerTester(LANGdradigLexer.class);
	
	@Test
	public void testIf()throws Exception {
		tester.correct("/src/scallywags/langdradig/example/test0.langdradig");
	}
	

}
