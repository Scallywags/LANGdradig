package scallywags.langdradig.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.junit.Assert;

public class LexerTester {
	private final Class<? extends Lexer> lexerType;

	public LexerTester(Class<? extends Lexer> lexerType) {
		this.lexerType = lexerType;
	}

	/**
	 * Tests whether a given text is yields a given sequence of token numbers.
	 * Invokes {@link Assert#fail} if the text cannot be accepted, or the tokens
	 * produced do not form the sequence passed in as a parameter.
	 */
	public void yields(String filepath, Integer... tokens) throws IOException {
		try {
			List<? extends Token> result = scan(filepath);
			Assert.assertEquals(tokens.length, result.size());
			for (int i = 0; i < tokens.length; i++) {
				if (tokens[i] != result.get(i).getType()) {
					Assert.fail(String.format(
							"At index %d, expected type %s but found %s", i,
							tokens[i], result.get(i).getType()));
				}
			}
		} catch (LexerException e) {
			Assert.fail(String.format(
					"'%s' should have been accepted but wasn't", filepath));
		}
	}

	/**
	 * Tests whether a given file is accepted by the lexer.
	 * 
	 * @return if the text is accepted, returns the list of tokens; otherwise
	 *         returns <code>false</code> (however, this will never happen as
	 *         {@link Assert#fail} is invoked, throwing a
	 *         {@link RuntimeException})
	 */
	public List<? extends Token> correct(String filepath) throws IOException {
		try {
			return scan(filepath);
		} catch (LexerException e) {
			Assert.fail(String.format(
					"'%s' should have been accepted but wasn't", filepath));
			return null;
		}
	}

	/** Tests whether a given text is rejected by the lexer. */
	public void wrong(String text) throws IOException {
		try {
			scan(text);
			Assert.fail(String.format(
					"'%s' should have been rejected but wasn't", text));
		} catch (LexerException e) {
			// this is the expected outcome; do nothing
		}
	}

	/**
	 * Tries scanning a given a file.
	 * 
	 * @return the resulting list of tokens, if no lexer errors occurred
	 * @throws LexerException
	 *             if the text was not accepted
	 */
	public List<? extends Token> scan(String path) throws LexerException, IOException {
			List<? extends Token> result = null;
			ANTLRInputStream stream = new ANTLRFileStream(path);
			Lexer lexer = newLexer(stream);
			// redirect error messages to my own stream
			ByteArrayOutputStream err = new ByteArrayOutputStream();
			System.setErr(new PrintStream(err, true));
			result = lexer.getAllTokens();
			// reset the standard error channel
			System.setErr(System.err);
			// test if my own stream is empty (meaning there were no errors)
			if (err.size() > 0) {
				throw new LexerException(err.toString());
			}
			return result;
	}

	/** Constructs a lexer for a given input stream. */
	private Lexer newLexer(CharStream stream) {
		Lexer result = null;
		try {
			Constructor<? extends Lexer> lexer = this.lexerType
					.getConstructor(CharStream.class);
			result = lexer.newInstance(stream);
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| InvocationTargetException e) {
			// should never occur, as all Antlr-generated lexers are
			// well-behaved
			e.printStackTrace();
		}
		return result;
	}

	/** Exception signalling a failed attempt to scan a text. */
	@SuppressWarnings("serial")
	public static class LexerException extends Exception {
		public LexerException(String message) {
			super(message);
		}
	}
}
