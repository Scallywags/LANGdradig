package scallywags.langdradig.ide.errors;

import scallywags.langdradig.generate.Type;
import scallywags.langdradig.generate.exceptions.AlreadyDeclaredException;
import scallywags.langdradig.generate.exceptions.CheckerException;
import scallywags.langdradig.generate.exceptions.TypeException;
import scallywags.langdradig.generate.exceptions.UndeclaredException;

/**
 * Created by Jeroen Weener on 16/06/2016.
 */
public class LANGdradigErrorBuilder {

    public static LANGdradigError format(String msg, int line) {
        if (line == -1) {
            return new LANGdradigError("Fout | " + msg, line);
        } else {
            return new LANGdradigError("Fout op regel " + String.valueOf(line) + "    |    " + format(msg), line);
        }
    }

    private static String format(String msg) {
        return msg.replace("extraneous input", "foutieve input")
                .replace("expecting", "verwacht")
                .replace("no viable alternative at input", "onverwachte term")
                .replace("<EOF>", "eind van het programma")
                .replace("missing", "ontbreekt")
                .replace(" at", " op");
    }

    public static LANGdradigError format(String code, CheckerException e) {
        StringBuilder sb = new StringBuilder();
        int line = -1;
        if (e instanceof AlreadyDeclaredException) {
            String id = ((AlreadyDeclaredException) e).getIdentifier();
            line = findLine(code, id);
            String s = line == -1 ? "" : "op regel " + line;
            sb.append("Fout ").append(s).append("    |    ").append(id).append(" is al gedeclareerd in deze scope");
        } else if (e instanceof UndeclaredException) {
            String id = ((UndeclaredException) e).getIdentifier();
            line = findLine(code, id);
            String s = line == -1 ? "" : "op regel " + line;
            sb.append("Fout ").append(s).append("    |    ").append(id).append(" is niet gedeclareerd in deze scope");
        } else if (e instanceof TypeException) {
            String expected = convert(((TypeException) e).getExpectedType());
            String actual = convert(((TypeException) e).getActualType());
            String rest = e.getText();
            line = findLine(code, rest);
            String s = line == -1 ? "" : "op regel " + line;
            sb.append("Fout ").append(s).append("    |    ").append("Verkeerd type: verwachte ")
                    .append(expected).append(" maar kreeg ").append(actual).append(" in:    ").append(rest).append("");
        } else {
            sb.append("Fout (geen extra informatie beschikbaar");
        }
        return new LANGdradigError(sb.toString(), line);
    }

    private static int findLine(String code, String string) {
        // Remove excessive spaces
        string = string.trim().replaceAll(" +", "");
        String[] lines = code.split("\n");
        String sb = "";
        for (int i = 0; i < lines.length; i++) {
            sb += (" " + lines[i]);
            // Remove excessive spaces
            sb = sb.trim().replaceAll("\t", "").replaceAll(" +", "");
            if (sb.contains(string)) {
                return ++i;
            }
        }
        return -1;
    }

    private static String convert(Type type) {
        if (type == null) {
            return "<onbekend>";
        } else if (type.equals(Type.INTEGER)) {
            return "<geheel getal>";
        } else if (type.equals(Type.BOOLEAN)) {
            return "<waarheid>";
        } else {
            return "<onbekend>";
        }
    }
}
