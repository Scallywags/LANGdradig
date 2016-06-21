package scallywags.langdradig.ide;

/**
 * Created by Jeroen Weener on 21/06/2016.
 */
public class Formatter {

    public static String format(String content) {
        return formatTabs(content.trim().replaceAll(" +", " "));
    }

    private static String formatTabs(String content) {
        StringBuilder sb = new StringBuilder();
        int indent = 0;
        String[] lines = content.split("\n");
        for (String line : lines) {
            indent += indentation(line);
            for (int i = 0; i < indent; i++) {
                sb.append("\t");
            }
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    private static int indentation(String line) {
        if (line.startsWith("doe") || line.startsWith("besteed") || line.startsWith("kritiek")) {
            return 1;
        } else if (line.startsWith("klaar")) {
            return -1;
        } else {
            return 0;
        }
    }
}
