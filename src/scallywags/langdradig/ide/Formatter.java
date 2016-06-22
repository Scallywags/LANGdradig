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
            line = line.trim().replaceAll("\t", " ").replaceAll(" +", " ");
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
        return sb.toString().replaceAll("\t+\n", "\n");
    }

    private static boolean shouldIndent(String line) {
        return line.startsWith("doe") || line.startsWith("besteed") || line.startsWith("kritiek") || line.startsWith("als") || line.startsWith("zolang");
    }

    private static boolean shouldRaise(String line) {
        return line.startsWith("klaar") || line.startsWith("uit aan");
    }

    private static boolean isBlockWithoutEnd(String line) {
        return line.startsWith("als") || line.startsWith("zolang") || line.startsWith("besteed uit aan");
    }
}
