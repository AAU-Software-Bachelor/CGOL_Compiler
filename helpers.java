import java.util.Arrays;

public class helpers {
    private static String tab = "  ";
    private static int tabAmount = 0;
    public static String autoTab(String input) {

        String[] lines = input.split("\n");
        for (int p = 0; p <lines.length; p++) {
            if(lines[p].endsWith("}") && !lines[p].contains("{")) tabAmount--;
            StringBuilder tabs = new StringBuilder();
            for(int i = 0; i < tabAmount; i++) {
                tabs.append(tab);
            }
            if(lines[p].endsWith("{")) tabAmount++;
            lines[p] = tabs + lines[p];
        }
        return String.join("\n", lines);
    }
 }
