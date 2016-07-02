package scallywags.langdradig.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import scallywags.langdradig.generate.Compiler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jeroen Weener on 02/07/2016.
 */
public class GeneralTest {

    @Before
    public void deleteGenFolder() {
        File f = new File("src\\scallywags\\langdradig\\test\\tests\\gen");
        f.delete();
        f.mkdir();
        String outputDirName = "src\\scallywags\\langdradig\\test\\tests\\gen";
        try {
            Files.copy(new File("src\\scallywags\\haskell\\AST.hs").toPath(), new File(outputDirName + "\\AST.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(new File("src\\scallywags\\haskell\\Generator.hs").toPath(), new File(outputDirName + "\\Generator.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(new File("src\\scallywags\\haskell\\HardwareTypes.hs").toPath(), new File(outputDirName + "\\HardwareTypes.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(new File("src\\scallywags\\haskell\\BasicFunctions.hs").toPath(), new File(outputDirName + "\\BasicFunctions.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(new File("src\\scallywags\\haskell\\Simulation.hs").toPath(), new File(outputDirName + "\\Simulation.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(new File("src\\scallywags\\haskell\\System.hs").toPath(), new File(outputDirName + "\\System.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(new File("src\\scallywags\\haskell\\Sprockell.hs").toPath(), new File(outputDirName + "\\Sprockell.hs").toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    @Test
    public void testStandardValues() {
        checkProgramOutput("declarationExample.langdradig", "0", "onwaar", "[0,0,0,0]", "[onwaar,onwaar,onwaar]");
    }

    @Test
    public void testAssignment() {
        checkProgramOutput("assignmentExample.langdradig", "1337", "waar", "[3,1,4,1,5,9]", "[onwaar,waar,waar]", "[waar,waar,waar]", "[[8,9],[10,11]]");
    }

    @Test
    public void testIf() {
        checkProgramOutput("alsExample0.langdradig", "2");
        checkProgramOutput("alsExample1.langdradig", "1");
    }

    @Test
    public void testWhile() {
        checkProgramOutput("zolangExample.langdradig", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
    }

    @Test
    public void testKritiek() {
        checkProgramOutput("concurrencyExample0.langdradig", "2");
    }

    private List<String> runProgram(String programName) {
        Compiler compiler = Compiler.getInstance();
        try {
            String path = "src\\scallywags\\langdradig\\test\\tests\\";
            String file = compiler.compile(path + programName, new Compiler.FlagValue(Compiler.Flag.OUTPUT_DIR, path + "gen\\"));
            return compiler.run(new File(path + "gen"), new File(file).getAbsolutePath());
        } catch (IOException e) {
            Assert.fail();
        }
        return null;
    }

    private void checkProgramOutput(String programName, String... expected) {
        List<String> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, expected);
        List<String> actual = runProgram(programName);
        Assert.assertEquals(expectedList, actual);
    }
}
