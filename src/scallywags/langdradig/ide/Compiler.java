package scallywags.langdradig.ide;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import scallywags.langdradig.generate.ASTGenerator;
import scallywags.langdradig.ide.frames.Main;

import javax.swing.*;

public class Compiler {

    private static final Compiler INSTANCE = new Compiler();

    private Compiler() {
    }

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
                System.err.println("Gebruik: <invoerbestand> [(--<flag> <flagwaarde>)]");        //TODO make flag help.
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
        outputDir = "src/scallywags/haskell/"; //UGLY TEMPORARY FIX TODO make this prettier

        astGen.writeAST(outputDir);

        File workingDirectory = new File(outputDir);

        ProcessBuilder pBuilder = new ProcessBuilder("runhaskell", astGen.getProgramName() + ".ast.hs").directory(workingDirectory);
        pBuilder.start();

        return outputDir + astGen.getProgramName() + ".spril.hs";
    }

    // Regular run
    public List<String> run(File workingDirectory, String sprilFile) throws IOException {
        List<String> result = new LinkedList<>();
        ProcessBuilder pBuilder = new ProcessBuilder("runhaskell", sprilFile).directory(workingDirectory);
        Process process = pBuilder.start();

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        String s;
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


    /**
     * ------------------ Special methods for the IDE -------------------
     * ------------------------------------------------------------------
     */

    //TODO unhardcode paths
    public Process compileAndRun(String langdradigInputFile, Main main) throws IOException {
        File program = new File(langdradigInputFile);
        main.print(program.getName() + " compileren...");
        String outputDirName = program.getParent() + "\\gen";
        //Create gen folder
        File outputDir = new File(outputDirName);
        outputDir.mkdir();
        File ast = new File(outputDirName + "\\AST.hs");
        File generator = new File(outputDirName + "\\Generator.hs");
        File hardwareTypes = new File(outputDirName + "\\HardwareTypes.hs");
        File basicFunctions = new File(outputDirName + "\\BasicFunctions.hs");
        File simulation = new File(outputDirName + "\\Simulation.hs");
        File system = new File(outputDirName + "\\System.hs");
        File sprockell = new File(outputDirName + "\\Sprockell.hs");

        if (!ast.exists()) {
            Files.copy(new File("src\\scallywags\\haskell\\AST.hs").toPath(), new File(outputDirName + "\\AST.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        if (!generator.exists()) {
            Files.copy(new File("src\\scallywags\\haskell\\Generator.hs").toPath(), new File(outputDirName + "\\Generator.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        if (!hardwareTypes.exists()) {
            Files.copy(new File("src\\scallywags\\haskell\\HardwareTypes.hs").toPath(), new File(outputDirName + "\\HardwareTypes.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        if (!basicFunctions.exists()) {
            Files.copy(new File("src\\scallywags\\haskell\\BasicFunctions.hs").toPath(), new File(outputDirName + "\\BasicFunctions.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        if (!simulation.exists()) {
            Files.copy(new File("src\\scallywags\\haskell\\Simulation.hs").toPath(), new File(outputDirName + "\\Simulation.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        if (!system.exists()) {
            Files.copy(new File("src\\scallywags\\haskell\\System.hs").toPath(), new File(outputDirName + "\\System.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        if (!sprockell.exists()) {
            Files.copy(new File("src\\scallywags\\haskell\\Sprockell.hs").toPath(), new File(outputDirName + "\\Sprockell.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        ASTGenerator astGen = new ASTGenerator(langdradigInputFile);
        astGen.writeAST(outputDirName);
        ProcessBuilder astBuilder = new ProcessBuilder("runhaskell", astGen.getProgramName() + ".ast.hs").directory(outputDir);
        Process p = astBuilder.start();
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ProcessBuilder sprilBuilder = new ProcessBuilder("runhaskell", astGen.getProgramName() + ".spril.hs").directory(outputDir);
        Process process = sprilBuilder.start();
        main.print(program.getName() + " starten...\n");
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        //Start new thread to keep print stdIn going in parallel
        new Thread(() -> {
            Thread t = new Thread(() -> {
                try {
                    String s;
                    while ((s = stdError.readLine()) != null) {
                        main.print(s);
                    }
                } catch (IOException ignore) {
                } finally {
                    try {
                        stdError.close();
                    } catch (IOException ignore) {
                    }
                }
            });
            t.start();
            try {
                String s;
                 while ((s = stdInput.readLine()) != null) {
                    main.print(s);
                }
            } catch (IOException ignore) {
            } finally {
                try {
                    stdInput.close();
                } catch (IOException ignore) {
                }
            }
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            main.print("\nKlaar.");
            main.onStop();
        }).start();
        return process;
    }

    //Hacky fix to stop programs
    public static Process killGHC() {
        try {
            return Runtime.getRuntime().exec("taskkill /F /IM ghc.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
