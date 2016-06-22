package scallywags.langdradig.ide.features.unfinished;

/**
 * Created by Jeroen Weener on 21/06/2016.
 */
public class Formatter {
    private static final boolean ON = false;

    public static String format(String content) {
        if (!ON) return content;
        return createArtificialEndNodes(content);
    }

    private static String createArtificialEndNodes(String content) {
        StringBuilder sb = new StringBuilder();
        String[] lines = content.split("\n");
        int pointer = 0;
        while (pointer < lines.length) {
            String line = lines[pointer];
            sb.append(line).append("\n");
            if (blockOpening(line)) {
                String nextLine = lines[pointer + 1];
                if (!blockOpening(nextLine)) {
                    sb.append(nextLine).append("\n");
                    sb.append("%end%").append("\n");
                    pointer++;
                } else {

                }
            }
            pointer++;
        }
        return sb.toString();
    }

    private static String formatTabs(String content) {
        StringBuilder sb = new StringBuilder();
        int indent = 0;
        String[] lines = content.split("\n");
        for (String line : lines) {
            line = line.trim().replaceAll("\t", " ").replaceAll(" +", " ");
            if (blockClosing(line)) {
                indent--;
            }
            for (int i = 0; i < indent; i++) {
                sb.append("\t");
            }
            sb.append(line);
            sb.append("\n");
            if (blockOpening(line)) {
                indent++;
            }
        }
        return sb.toString().replaceAll("\t+\n", "\n");
    }

    private static boolean blockOpening(String line) {
        return line.startsWith("doe") || line.startsWith("besteed") || line.startsWith("kritiek") || line.startsWith("als") || line.startsWith("zolang");
    }

    private static boolean blockClosing(String line) {
        return line.startsWith("klaar") || line.startsWith("uit aan");
    }
}
