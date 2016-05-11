
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Format implements IFormat{

    IHelper help;

    public Format(IHelper help) {
        this.help = help;
    }

    /**
     * Apply some rules for data
     * @param s - input data
     */
    @Override
    public String format(String s) {
        String out = "";
        s = prepare(s);
        StringBuilder builder = new StringBuilder();
        StringTokenizer tok = new StringTokenizer(s, "\n", false);
        while (tok.hasMoreTokens()) {
            builder.append(help.help(tok.nextToken()));
        }
        out = builder.toString();
        return out;
    }
/**
 * Prepare data for using
 * @param s
 */
    public String prepare(String s) {
        String[] str = {"{", ";", "}"};
        s = s.replaceAll("\n", "");
        for (int i = 0; i < str.length; i++) {
            s = s.replaceAll("[ ]*[" + str[i] + "][ ]*", str[i] + "\n");
        }
        return s;
    }

}
