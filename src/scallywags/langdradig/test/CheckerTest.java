package scallywags.langdradig.test;

import org.junit.Before;
import org.junit.Test;
import scallywags.langdradig.generate.Checker;
import scallywags.langdradig.generate.Type;
import scallywags.langdradig.generate.except.AlreadyDeclaredException;
import scallywags.langdradig.generate.except.CheckerException;
import scallywags.langdradig.generate.except.TypeException;
import scallywags.langdradig.generate.except.UndeclaredException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jeroen Weener on 15/06/2016.
 */
public class CheckerTest {
    private static final String BASE = "src\\scallywags\\langdradig\\example\\";
    private static final String EXT = ".langdradig";

    private Checker checker;

    @Before
    public void setup() {
        checker = new Checker();
    }

    @Test
    public void test() {
        readFile("als-dan-anders_example");
        assertEquals(new ArrayList<>(), checker.getExceptions());
    }

    @Test
    public void testDeclarations() {
        readFile("declaration_example");
        List<CheckerException> exceptions = checker.getExceptions();

        for (CheckerException e : exceptions) {
            System.out.println(e.getMessage());
        }

        int size = 3;
        assertEquals(size, exceptions.size());
//
//        boolean[] foundExceptions = {false, false, false};
//        for (CheckerException e : exceptions) {
//            if (!foundExceptions[0]) {
//                if (e instanceof TypeException) {
//                    if (((TypeException) e).getActualType() == null) {
//                        foundExceptions[0] = true;
//                    }
//                }
//            } else if (!foundExceptions[1]) {
//                if (e instanceof UndeclaredException) {
//                    if ("undeclaredVariable".equals(((UndeclaredException) e).getIdentifier())) {
//                        foundExceptions[1] = true;
//                    }
//                }
//            } else if (!foundExceptions[2]) {
//                if (e instanceof AlreadyDeclaredException) {
//                    if ("declaredVariable".equals(((AlreadyDeclaredException) e).getIdentifier())) {
//                        foundExceptions[2] = true;
//                    }
//                }
//            }
//        }
//        assertEquals(true, foundExceptions[0]);
//        assertEquals(true, foundExceptions[1]);
//        assertEquals(true, foundExceptions[2]);
    }

    private void readFile(String source) {
        try {
            checker.checkFile(BASE + source + EXT);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            fail();
        }
    }
}
