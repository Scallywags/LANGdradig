package scallywags.langdradig.ide;

/**
 * Created by Jeroen Weener on 21/06/2016.
 */
public class Formatter {

    public static String format(String content) {
        return formatTabs(content);
    }

    private static String formatTabs(String content) {
        StringBuilder sb = new StringBuilder();
        int indent = 0;
        String[] lines = content.split("\n");
        for (String line : lines) {
            line = line.trim().replace("\t", " ").replace(" +", " ");
            if (shouldRaise(line)) {
                indent--;
            }
            for (int i = 0; i < indent; i++) {
                sb.append("\t");
            }
            sb.append(line);
            sb.append("\n");
            if (shouldIndent(line)) {
                indent++;
            }
        }
        return sb.toString();
    }

    private static boolean shouldIndent(String line) {
        return line.startsWith("doe") || line.startsWith("besteed") || line.startsWith("kritiek");
    }

    private static boolean shouldRaise(String line) {
        return line.startsWith("klaar") || line.startsWith("uit aan");
    }
}
