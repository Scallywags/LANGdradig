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

/*
 *  Tests the LANGdradig parser
 */

public class ParseTest {
    final static boolean DEBUG = true;

    @Test
    public void testOverall() {
        testIncorrectProgram("klaar wordt 3.");                                                                 // Illegal variable name, "klaar" is a keyword
        testCorrectProgram("laar wordt 3.");                                                                    // Legal variable name
        testIncorrectProgram("a wordt 3");                                                                      // Statement does not end with a dot
        testIncorrectProgram("a wordt 3..");                                                                    // Multiple dots
    }

    @Test
    public void testEmptyProgram() {
        testCorrectProgram("");
    }

    @Test
    public void testBinaryOperators() {
        testCorrectProgram("!a && niet b || c en d of e.");
    }

    @Test
    public void testBinaryComparators() {
        testCorrectProgram("a == b != c is gelijk aan d is ongelijk aan e is niet gelijk aan f.");
    }

    @Test
    public void testIntegerOperators() {
        testCorrectProgram("-a + min b - c * d / e % f ^ g plus h min i keer j gedeeld door k modulus l tot de macht m.");
    }

    @Test
    public void testIntegerComparators() {
        testCorrectProgram("a is kleiner dan b groter is dan c is kleiner dan of gelijk aan d.");
        testCorrectProgram("a groter is dan of gelijk is aan b is gelijk aan c is ongelijk aan d is niet gelijk aan e.");
    }

    @Test
    public void testArrayOperators() {
        testCorrectProgram("a wordt de lengte van as.");
        testCorrectProgram("a wordt as op plek 5.");
    }

    @Test
    public void testDeclarations() {
        testCorrectProgram("b is een stelling.");
        testCorrectProgram("b is een gedeelde stelling.");

        testCorrectProgram("a is een getal.");
        testCorrectProgram("a is een gedeeld getal.");

        testCorrectProgram("a is een reeks van 8 getallen.");
        testCorrectProgram("b is een reeks van 16 stellingen.");
        testCorrectProgram("c is een reeks van 0 getallen.");
        testCorrectProgram("d is een reeks van 2 reeksen van 2 stellingen.");

        testCorrectProgram("a is een gedeelde reeks van 32 getallen.");
        testCorrectProgram("b is een gedeelde reeks van 64 stellingen.");
        testCorrectProgram("c is een gedeelde reeks van 2 reeksen van 0 reeksen van 2 getallen.");
    }

    @Test
    public void testAssignments() {
        testCorrectProgram("b wordt waar.");
        testCorrectProgram("b wordt onwaar.");
        testCorrectProgram("a wordt 3.");
        testCorrectProgram("a wordt min 3.");
        testCorrectProgram("a wordt var.");                                                                     // Assignment of a variable

        testCorrectProgram("a wordt array op plek 200.");                                                       // Assign a value in the array to a variable
        testCorrectProgram("as wordt [1,2,3,4,5].");                                                            // Assign integer values to the array
        testCorrectProgram("as wordt [waar, onwaar, niet waar, waar].");                                        // Assign boolean values to the array
        testCorrectProgram("as wordt [].");                                                                     // Assign an empty array to the array
        testCorrectProgram("as wordt [[1,2],[3,4],[5,6]].");                                                    // Assign an array of arrays to the array
        testIncorrectProgram("as wordt 5, 4, 3, 2, 1");                                                         // Assign values to the array without square brackets
        testCorrectProgram("zet 3 op plek 5 van array.");                                                       // Assign a value to a place in array
    }

    @Test
    public void testAlsStatements() {
        testCorrectProgram("als i dan b wordt waar.");                                                          // "Als" statement without else
        testCorrectProgram("als i dan b wordt waar. anders b wordt onwaar.");                                   // "Als" statement with else
        testCorrectProgram("als 9 > i dan doe i is een getal. i wordt i min 1. klaar.");                        // "Als" statement with a block
        testIncorrectProgram("als b dan i is een getal. i wordt i min 1. anders i wordt i plus 1");             // "Als" statement with two separate statements before the "anders"
    }

    @Test
    public void testZolangStatements() {
        testCorrectProgram("zolang b a wordt a keer 8.");                                                       // "Zolang" statement
        testCorrectProgram("zolang b doe a wordt a keer 8. a wordt b. klaar.");                                 // "Zolang" statement with a block
        testIncorrectProgram("zolang b");                                                                       // "Zolang" statement without a body
    }

    @Test
    public void testBlockStatements() {
        testCorrectProgram("doe klaar.");                                                                       // Empty BlockStatement
        testCorrectProgram("doe a wordt 4. b is een getal. klaar.");                                            // BlockStatement
        testIncorrectProgram("doe a wordt 4. b is een getal.");                                                 // BlockStatement without "klaar" keyword
        testCorrectProgram("doe doe doe a wordt 1. klaar. klaar. a wordt 2. b wordt 1. klaar.");                // Three nested blocks
        testIncorrectProgram("doe doe a wordt 1. klaar. klaar. a wordt 2. b wordt 1. klaar.");                  // Incorrect nested blocks; missing a doe
    }

    @Test
    public void testKritiekBlocks() {
        testCorrectProgram("kritiek name doe h wordt h plus 1. klaar.");                                        // "Kritiek" block
        testIncorrectProgram("kritiek doe h wordt h plus 1. klaar.");                                           // "Kritiek" block without declaring a name for the critical section
    }

    @Test
    public void testBesteedUit() {
        testCorrectProgram("besteed uit aan x a wordt 8.");                                                     // "Besteed uit" block with a single statement
        testCorrectProgram("besteed uit aan x doe a wordt 8. b wordt 9. klaar.");                               // "Besteed uit" block with block statement
        testIncorrectProgram("besteed aan x a wordt 8.");                                                       // "Besteed uit" block missing the keyword "uit"
        testIncorrectProgram("besteed uit aan a wordt 8.");                                                     // "Besteed uit" block without declaring a name for the worker
        testIncorrectProgram("besteed uit aan x.");                                                             // "Besteed uit" block without body

        testCorrectProgram("wacht op x.");                                                                      // "Wacht op" statement
        testIncorrectProgram("wacht op.");                                                                      // "Wacht op" statement without stating for which worker it is waiting
    }

    @Test
    public void testComments() {
        testCorrectProgram("# dit is commentaar");                                                              // Just a comment
        testCorrectProgram("#");                                                                                // An empty comment
        testIncorrectProgram("dit is commentaar zonder hekje");                                                 // A comment without a '#'
    }

    @Test
    public void testLaatZien() {
        testCorrectProgram("laat a zien.");                                                                     // Standard "laat zien" statement
        testCorrectProgram("laat 3 tot de macht v zien.");                                                      // "Laat zien" with an expression
        testIncorrectProgram("laat zien.");                                                                     // "Laat zien" statement without a variable
    }

    @Test
    public void testSyntacticSugar() {
        testCorrectProgram("als b klopt dan i wordt 1.");                                                       // Syntactic sugar for b == true
        testCorrectProgram("als b niet klopt dan i wordt 1.");                                                  // Syntactic sugar for b == false

        testCorrectProgram("verhoog a.");                                                                       // "Verhoog" statement
        testCorrectProgram("verlaag a.");                                                                       // "Verlaag" statement

        testCorrectProgram("a ligt tussen b en c.");                                                            // "Ligt tussen" statement
        testCorrectProgram("a ligt binnen b en c.");                                                            // "Ligt binnen" statement
        testCorrectProgram("a ligt buiten b en c.");                                                            // "Ligt buiten" statement
        testIncorrectProgram("8 ligt buiten 9.");                                                               // "Ligt buiten" without a third argument

    }

    /**
     * Tests the flexibility of the grammar.
     * The language syntax is meant to be pretty loose so here we test if multiple syntaxes are accepted
     */
    @Test
    public void testFlexibility() {
        testCorrectProgram("verhoog a.");                                                                       // Increment operator
        testCorrectProgram("hoog a op.");

        testCorrectProgram("a is gelijk aan b.");                                                               // Equals operator
        testCorrectProgram("a gelijk is aan b.");
        testCorrectProgram("a == b.");

        testCorrectProgram("a is ongelijk aan b.");                                                             // Unequals operator
        testCorrectProgram("a ongelijk is aan b.");
        testCorrectProgram("a is niet gelijk aan b.");
        testCorrectProgram("a niet gelijk is aan b.");
        testCorrectProgram("a != b.");

        testCorrectProgram("a is kleiner dan b.");                                                              // Smaller operator
        testCorrectProgram("a kleiner is dan b.");
        testCorrectProgram("a < b.");

        testCorrectProgram("a is groter dan b.");                                                               // Larger operator
        testCorrectProgram("a groter is dan b.");
        testCorrectProgram("a > b.");

        testCorrectProgram("a is kleiner dan of gelijk aan b.");                                                // Smaller or equal operator
        testCorrectProgram("a is kleiner dan of is gelijk aan b.");
        testCorrectProgram("a kleiner is dan of gelijk is aan b.");
        testCorrectProgram("a kleiner is dan of gelijk aan b.");
        testCorrectProgram("a is kleiner of gelijk aan b.");
        testCorrectProgram("a kleiner of gelijk is aan b.");
        testCorrectProgram("a <= b.");

        testCorrectProgram("a is groter dan of gelijk aan b.");                                                 // Larger or equal operator
        testCorrectProgram("a is groter dan of is gelijk aan b.");
        testCorrectProgram("a groter is dan of gelijk is aan b.");
        testCorrectProgram("a groter is dan of gelijk aan b.");
        testCorrectProgram("a is groter of gelijk aan b.");
        testCorrectProgram("a groter of gelijk is aan b.");
        testCorrectProgram("a >= b.");

        testCorrectProgram("-a.");                                                                              // Negation operator for integers
        testCorrectProgram("min a.");

        testCorrectProgram("!a.");                                                                              // Negation operator for booleans
        testCorrectProgram("niet a.");

        testCorrectProgram("a ligt tussen b en c.");                                                            // "Ligt tussen" operator
        testCorrectProgram("a tussen b en c ligt.");

        testCorrectProgram("a ligt binnen b en c.");                                                            // "Ligt binnen" operator
        testCorrectProgram("a binnen b en c ligt.");

        testCorrectProgram("a ligt buiten b en c.");                                                            // "Ligt buiten" operator
        testCorrectProgram("a buiten b en c ligt.");

        testCorrectProgram("besteed uit aan x a wordt 1.");                                                     // "Besteed uit" block
        testCorrectProgram("besteed a wordt 1. uit aan x.");

        testCorrectProgram("besteed uit aan x doe a wordt 1. b wordt waar. klaar.");                            // "Besteed uit" block with a block statement
        testCorrectProgram("besteed doe a wordt 1. b wordt waar. klaar. uit aan x.");

        testCorrectProgram("a wordt 1.");                                                                       // Assignment operator
        testCorrectProgram("a = 1.");

        testCorrectProgram("als a dan doe b is een getal. b wordt 2. klaar.");                                  // If statement with keyword "dan"
        testCorrectProgram("als a doe b is een getal. b wordt 2. klaar.");                                      // If statement without keyword "dan"

        testCorrectProgram("zet a op plek 3 in array.");                                                        // Assign an expression to a place in an array
        testCorrectProgram("zet a op plaats 3 in array.");
        testCorrectProgram("zet a op plek 3 van array.");
        testCorrectProgram("zet a op plaats 3 van array.");
        testCorrectProgram("zet a in array op plek 3.");

        testCorrectProgram("zolang a klopt doe klaar.");                                                        // While loop
        testCorrectProgram("terwijl a klopt doe klaar.");
    }

    private LANGdradigParser test(String text) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new LANGdradigLexer(stream);
        MyErrorListener errListener = new MyErrorListener();
        lexer.removeErrorListeners();
        lexer.addErrorListener(errListener);
        TokenStream tokens = new CommonTokenStream(lexer);

        LANGdradigParser parser = new LANGdradigParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errListener);

        return parser;
    }

    private void testCorrectProgram(String text) {
        LANGdradigParser parser = test(text);
        ParseTree tree = parser.program();
        boolean accepted = ((MyErrorListener) parser.getErrorListeners().get(0)).isAccepted();
        if (!accepted) print(tree.toStringTree(parser));
        assertTrue(accepted);
    }

    private void testIncorrectProgram(String text) {
        LANGdradigParser parser = test(text);
        ParseTree tree = parser.program();
        boolean accepted = ((MyErrorListener) parser.getErrorListeners().get(0)).isAccepted();
        if (accepted) print(tree.toStringTree(parser));
        assertFalse(accepted);
    }

    private void testFile(String path) throws IOException {
        CharStream stream = new ANTLRFileStream(path);
        Lexer lexer = new LANGdradigLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        LANGdradigParser parser = new LANGdradigParser(tokens);
        parser.program();
    }

    private void print(String text) {
        if (DEBUG) {
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
