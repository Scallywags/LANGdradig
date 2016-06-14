package scallywags.langdradig.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import scallywags.langdradig.grammatica.LANGdradigLexer;
import scallywags.langdradig.grammatica.LANGdradigParser;

import java.io.IOException;
import java.util.BitSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParseTest {
    final static boolean print = false;

    @Test
    public void testOverall() {
        assertFalse(testProgram("klaar wordt 3."));                                                                 // Illegal variable name, "klaar" is a keyword
        assertTrue(testProgram("laar wordt 3."));                                                                   // Legal variable name
        assertFalse(testProgram("a wordt 3"));                                                                      // Statement does not end with a dot
        assertFalse(testProgram("a wordt 3.."));                                                                    // Multiple dots
    }

    @Test
    public void testEmptyProgram() {
        assertTrue(testProgram(""));
    }

    @Test
    public void testBinaryOperators() {
        assertTrue(testProgram("!a && niet b || c en d of e."));
    }

    @Test
    public void testBinaryComparators() {
        assertTrue(testProgram("a == b != c is gelijk aan d is ongelijk aan e is niet gelijk aan f."));
    }

    @Test
    public void testIntegerOperators() {
        assertTrue(testProgram("-a + min b - c * d / e % f ^ g plus h min i keer j gedeeld door k modulus l tot de macht m."));
    }

    @Test
    public void testIntegerComparators() {
        assertTrue(testProgram("a is kleiner dan b groter is dan c is kleiner dan of gelijk aan d."));
        assertTrue(testProgram("a groter is dan of gelijk is aan b is gelijk aan c is ongelijk aan d is niet gelijk aan e."));
    }

    @Test
    public void testDeclarations() {
        assertTrue(testProgram("b is een waarheid."));
        assertTrue(testProgram("a is een geheel getal."));
    }

    @Test
    public void testAssignments() {
        assertTrue(testProgram("b wordt waar."));
        assertTrue(testProgram("b wordt onwaar."));
        assertTrue(testProgram("a wordt 3."));
        assertTrue(testProgram("a wordt min 3."));
    }

    @Test
    public void testAlsStatements() {
        assertTrue(testProgram("als i dan b wordt waar."));                                                        // "Als" statement without else
        assertTrue(testProgram("als i dan b wordt waar. anders b wordt onwaar."));                                 // "Als" statement with else
        assertFalse(testProgram("als i b wordt onwaar."));                                                         // "Als" statement without "dan" keyword
        assertTrue(testProgram("als 9 > i dan doe i is een geheel getal. i wordt i min 1. klaar."));               // "Als" statement with a block
        assertFalse(testProgram("als b dan i is een geheel getal. i wordt i min 1. anders i wordt i plus 1"));     // "Als" statement with two separate statements before the "anders"
    }

    @Test
    public void testZolangStatements() {
        assertTrue(testProgram("zolang b a wordt a keer 8."));                                                     // "Zolang" statement
        assertTrue(testProgram("zolang b doe a wordt a keer 8. a wordt b. klaar."));                               // "Zolang" statement with a block
        assertFalse(testProgram("zolang b"));                                                                      // "Zolang" statement without a body
    }

    @Test
    public void testBlockStatements() {
        assertTrue(testProgram("doe klaar."));                                                                     // Empty BlockStatement
        assertTrue(testProgram("doe a wordt 4. b is een geheel getal. klaar."));                                   // BlockStatement
        assertFalse(testProgram("doe a wordt 4. b is een geheel getal."));                                         // BlockStatement without "klaar" keyword
        assertTrue(testProgram("doe doe doe a wordt 1. klaar. klaar. a wordt 2. b wordt 1. klaar."));              // Three nested blocks
        assertFalse(testProgram("doe doe a wordt 1. klaar. klaar. a wordt 2. b wordt 1. klaar."));                 // Incorrect nested blocks; missing a doe
    }

    @Test
    public void testKritiekBlocks() {
        assertTrue(testProgram("kritiek name doe h wordt h plus 1. klaar."));                                      // "Kritiek" block
        assertFalse(testProgram("kritiek doe h wordt h plus 1. klaar."));                                          // "Kritiek" block without declaring a name for the critical section
    }

    @Test
    public void testBesteedUit() {
        assertTrue(testProgram("besteed uit a wordt 8."));                                                         // "Besteed uit" block with a single statement
        assertTrue(testProgram("besteed uit doe a wordt 8. b wordt 9. klaar."));                                   // "Besteed uit" block with block statement
        assertFalse(testProgram("besteed a wordt 8."));                                                            // "Besteed uit" block missing the keyword "uit"
        assertFalse(testProgram("besteed uit"));                                                                   // "Besteed uit" block without body
    }

    @Test
    public void testSyntacticSugar() {
        assertTrue(testProgram("als b klopt dan i wordt 1."));                                                     // Syntactic sugar for b == true
        assertTrue(testProgram("als b niet klopt dan i wordt 1."));                                                // Syntactic sugar for b == false

        assertTrue(testProgram("a ligt tussen b en c."));                                                          // "Ligt tussen" statement
        assertTrue(testProgram("a ligt buiten b en c."));                                                          // "Ligt buiten" statement
        assertFalse(testProgram("8 ligt buiten 9."));                                                              // "Ligt buiten" without a third argument

    }

    /**
     * Tests the flexibility of the grammar.
     * The language syntax is meant to be pretty loose so here we test if multiple syntaxes are accepted
     */
    @Test
    public void testFlexibility() {
        assertTrue(testProgram("a is gelijk aan b.") &&                                                                                          // Equals operator
                   testProgram("a gelijk is aan b.") &&
                   testProgram("a == b."));

        assertTrue(testProgram("a is ongelijk aan b.") &&                                                                                        // Unequals operator
                   testProgram("a ongelijk is aan b.") &&
                   testProgram("a is niet gelijk aan b.") &&
                   testProgram("a niet gelijk is aan b.") &&
                   testProgram("a != b."));

        assertTrue(testProgram("a is kleiner dan b.") &&                                                                                         // Smaller operator
                   testProgram("a kleiner is dan b.") &&
                   testProgram("a < b."));

        assertTrue(testProgram("a is groter dan b.") &&                                                                                          // Larger operator
                   testProgram("a groter is dan b.") &&
                   testProgram("a > b."));

        assertTrue(testProgram("a is kleiner dan of gelijk aan b.") &&                                                                           // Smaller or equal operator
                   testProgram("a is kleiner dan of is gelijk aan b.") &&
                   testProgram("a kleiner is dan of gelijk is aan b.") &&
                   testProgram("a <= b."));

        assertTrue(testProgram("a is groter dan of gelijk aan b.") &&                                                                            // Larger or equal operator
                   testProgram("a is groter dan of is gelijk aan b.") &&
                   testProgram("a groter is dan of gelijk is aan b.") &&
                   testProgram("a >= b."));

        assertTrue(testProgram("-a.") &&                                                                                                         // Negation operator for integers
                   testProgram("min a."));
        assertTrue(testProgram("!a.") &&                                                                                                         // Negation operator for booleans
                   testProgram("niet a."));

        assertTrue(testProgram("a ligt tussen b en c.") &&                                                                                       // "Ligt tussen" operator
                   testProgram("a tussen b en c ligt."));
        assertTrue(testProgram("a ligt buiten b en c.") &&                                                                                       // "Ligt buiten" operator
                   testProgram("a buiten b en c ligt."));
    }

    private LANGdradigParser test(String text) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new LANGdradigLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);

        LANGdradigParser parser = new LANGdradigParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new MyErrorListener());

        return parser;
    }

    private boolean testProgram(String text) {
        LANGdradigParser parser = test(text);
        ParseTree tree = parser.program();
        print(tree.toStringTree(parser));
        return ((MyErrorListener) parser.getErrorListeners().get(0)).isAccepted();
    }

    private void testFile(String path) throws IOException {
        CharStream stream = new ANTLRFileStream(path);
        Lexer lexer = new LANGdradigLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        LANGdradigParser parser = new LANGdradigParser(tokens);
        parser.program();
    }

    private void print(String text) {
        if (print) {
            System.out.println(text);
        }
    }

    class MyErrorListener implements ANTLRErrorListener {
        private boolean accepted;

        public MyErrorListener() {
            this.accepted = true;
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
            accepted = false;
        }

        @Override
        public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
        }

        @Override
        public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
        }

        @Override
        public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
        }

        public boolean isAccepted() {
            return accepted;
        }
    }

}
