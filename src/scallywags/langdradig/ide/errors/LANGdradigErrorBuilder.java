package scallywags.langdradig.ide.errors;

import scallywags.langdradig.generate.exceptions.*;
import scallywags.langdradig.ide.Translator;

/**
 * Created by Jeroen Weener on 16/06/2016.
 */
public class LANGdradigErrorBuilder {

    public static LANGdradigError format(String msg, int line) {
        if (line == -1) {
            return new LANGdradigError("Fout | " + msg, line);
        } else {
            return new LANGdradigError("Fout op regel " + String.valueOf(line) + "    |    " + Translator.translateString(msg), line);
        }
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
            String expected = Translator.translateType(((TypeException) e).getExpectedType());
            String actual = Translator.translateType(((TypeException) e).getActualType());
            String rest = e.getText();
            line = findLine(code, rest);
            String s = line == -1 ? "" : "op regel " + line;
            sb.append("Fout ").append(s).append("    |    ").append("Verkeerd type: verwachte ")
                    .append(expected).append(" maar kreeg ").append(actual).append(" in:    ").append(rest);
        } else if (e instanceof NotWaitingForThreadException) {
            String id = ((NotWaitingForThreadException) e).getID();
            String rest = e.getText();
            line = findLine(code, rest);
            String s = line == -1 ? "" : "op regel " + line;
            sb.append("Fout ").append(s).append("    |    ").append("Er wordt door de ouderthread niet gewacht op zijn kind ").append(id).append(" in:    ").append(rest);
        } else {
            sb.append("Fout (geen extra informatie beschikbaar)");
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
}
