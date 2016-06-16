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

    public static String format(int line, String msg) {
        return "Fout op regel " + String.valueOf(line) + " | " + format(msg);
    }

    private static String format(String msg) {
        return msg.replace("extraneous input", "foutieve input")
                .replace("expecting", "verwacht")
                .replace("no viable alternative at input", "onverwachte term");
    }

    public static String format(CheckerException e) {
        StringBuilder sb = new StringBuilder();
        if (e instanceof AlreadyDeclaredException) {
            String id = ((AlreadyDeclaredException) e).getIdentifier();
            int line = findLine(id);
            sb.append("Fout op regel ").append(String.valueOf(line)).append(" | ").append(id).append(" is al gedeclareerd");
        } else if (e instanceof UndeclaredException) {
            String id = ((UndeclaredException) e).getIdentifier();
            int line = findLine(id);
            sb.append("Fout op regel ").append(String.valueOf(line)).append(" | ").append(id).append(" is niet gedeclareerd");
        } else if (e instanceof TypeException) {
            String expected = convert(((TypeException) e).getExpectedType());
            String actual = convert(((TypeException) e).getActualType());
            String rest = e.getText();
            int line = findLine(rest);
            sb.append("Fout op regel ").append(String.valueOf(line)).append(" | ").append("Verkeerd type: verwachte ")
                    .append(expected).append(" maar kreeg ").append(actual).append(" in ").append(rest);
        } else {
            sb.append("Fout (meer informatie niet beschikbaar");
        }
        return sb.toString();
    }

    private static int findLine(String id) {
        return -1;
    }

    private static String convert(Type type) {
        if (type == null) {
            return "<onbekend>";
        }
        switch (type) {
            case INTEGER:
                return "<geheel getal>";
            case BOOLEAN:
                return "<waarheid>";
            default:
                return "<onbekend>";
        }
    }
}
