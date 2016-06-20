package scallywags.langdradig;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import scallywags.langdradig.generate.ASTGenerator;

public class Compiler {

	private static final Compiler INSTANCE = new Compiler();

	private Compiler() {}

	public static Compiler getInstance() {
		return INSTANCE;
	}

	public static void main(String[] args) {
		FlagValue flag1 = null, flag2 = null;
		switch (args.length) {
		case 5:
			String flagString = stripPrefix(args[3]);
			Flag symbol = Flag.getByChar(flagString.charAt(0));
			flag2 = new FlagValue(symbol, args[4]);
		case 3:
			flagString = stripPrefix(args[1]);
			symbol = Flag.getByChar(flagString.charAt(0));
			flag1 = new FlagValue(symbol, args[2]);
		case 1:
			break;
		default:
			System.err.println("Gebruik: <invoerbestand> [(--<flag> <flagwaarde>)]"); 		//TODO make flag help.
			return;
		}
		String inputFile = args[0];
		try {
			if (flag1 == null) {
				INSTANCE.compile(inputFile);
			} else {
				if (flag2 == null) {
					INSTANCE.compile(inputFile, flag1);
				} else {
					INSTANCE.compile(inputFile, flag1, flag2);
				}
			}
		} catch (IOException e) {
			//TODO give proper error message.
			e.printStackTrace();
		}
	}

	private static String stripPrefix(String s) {
		return s.replace("--", "").replace("-", "").replace("/", "");
	}

	public String compile(String langdradigInputFile, FlagValue... flags) throws IOException {
		ASTGenerator astGen = new ASTGenerator(langdradigInputFile);
		int cores = 1;
		String outputDir = astGen.getSourceFile().getParent();

		for (FlagValue flag : flags) {
			if (flag.getSymbol() == Flag.CORES) {
				cores = Integer.parseInt(flag.getValue());
			}
			if (flag.getSymbol() == Flag.OUTPUT_DIR) {
				outputDir = flag.getValue();
			}
		}

		astGen.setNumSprockells(cores);
		astGen.writeAST(outputDir);
		
		File workingDirectory = new File(outputDir);
		
		ProcessBuilder pBuilder = new ProcessBuilder("echo", "writeSpril", "|", "ghci", astGen.getProgramName() + ".ast.hs").directory(workingDirectory);
		pBuilder.start();
	
		return astGen.getProgramName() + ".spril.hs";
	}
	
	public List<String> run(File workingDirectory, String sprilFile) throws IOException {
		List<String> result = new LinkedList<>();
		ProcessBuilder pBuilder = new ProcessBuilder("echo", "run", "|", "ghci", sprilFile).directory(workingDirectory);
		Process process = pBuilder.start();
		
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		
		String s = null;
		while ((s = stdInput.readLine()) != null) {
		    result.add(s);
		}
		
		while ((s = stdError.readLine()) != null) {
		    result.add(s);
		}
		return result;
	}

	public static class FlagValue {
		private Flag symbol;
		private String value;
		public FlagValue(Flag symbol, String value) {
			this.symbol = symbol;
			this.value = value;
		}
		public Flag getSymbol() {
			return symbol;
		}
		public String getValue() {
			return value;
		}
	}

	public enum Flag {
		CORES('c'), OUTPUT_DIR('o');

		private char c;

		private Flag(char c) {
			this.c = c;
		}

		public char getChar() {
			return c;
		}

		private static Map<Character, Flag> byChar = new HashMap<>();
		static {
			for (Flag flag : Flag.values()) {
				byChar.put(flag.getChar(), flag);
			}
		}

		public static Flag getByChar(char c) {
			return byChar.get(c);
		}
	}

}
