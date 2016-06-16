package scallywags.langdradig.ide;

import scallywags.langdradig.generate.Type;
import scallywags.langdradig.generate.except.AlreadyDeclaredException;
import scallywags.langdradig.generate.except.CheckerException;
import scallywags.langdradig.generate.except.TypeException;
import scallywags.langdradig.generate.except.UndeclaredException;

/**
 * Created by Jeroen Weener on 16/06/2016.
 */
public class LANGdradigErrorBuilder {

    public static LANGdradigError format(String msg, int line) {
        return new LANGdradigError("Fout op regel " + String.valueOf(line) + "    |    " + format(msg), line);
    }

    private static String format(String msg) {
        return msg.replace("extraneous input", "foutieve input")
                .replace("expecting", "verwacht")
                .replace("no viable alternative at input", "onverwachte term");
    }

    public static LANGdradigError format(String code, CheckerException e) {
        StringBuilder sb = new StringBuilder();
        int line = -1;
        if (e instanceof AlreadyDeclaredException) {
            String id = ((AlreadyDeclaredException) e).getIdentifier();
            line = findLine(code, id);
            sb.append("Fout op regel ").append(String.valueOf(line)).append("    |    ").append(id).append(" is al gedeclareerd");
        } else if (e instanceof UndeclaredException) {
            String id = ((UndeclaredException) e).getIdentifier();
            line = findLine(code, id);
            sb.append("Fout op regel ").append(String.valueOf(line)).append("    |    ").append(id).append(" is niet gedeclareerd");
        } else if (e instanceof TypeException) {
            String expected = convert(((TypeException) e).getExpectedType());
            String actual = convert(((TypeException) e).getActualType());
            String rest = e.getText();
            line = findLine(code, rest);
            sb.append("Fout op regel ").append(String.valueOf(line)).append("    |    ").append("Verkeerd type: verwachte ")
                    .append(expected).append(" maar kreeg ").append(actual).append(" in:    ").append(rest).append("");
        } else {
            sb.append("Fout (meer informatie niet beschikbaar");
        }
        return new LANGdradigError(sb.toString(), line);
    }

    private static int findLine(String code, String string) {
        String[] lines = code.split("\n");
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains(string)) {
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
