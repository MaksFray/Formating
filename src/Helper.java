
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Helper implements IHelper {

    HashMap<Character, Integer> m = new HashMap();
    int checkspace;

    public Helper() {
        m.put('{', 4);
        m.put('}', -4);
        m.put(';', 0);
        checkspace = 0;
    }

    /**
     * Return formatted lines
     * @param s 
     */
    @Override
    public String help(String s) {
        int currentlevel = 0;
        List<Character> c = new ArrayList();
        for (char q : s.toCharArray()) {
            c.add(q);
        }
        String out = "";
        StringBuilder b = new StringBuilder();
        String sp = "";
        for (int i = 0; i < c.size(); i++) {

            if (m.containsKey(c.get(i))) {
                checkspace += m.get(c.get(i));
                if (c.get(i) == '}') {
                    currentlevel = checkspace;
                } else {
                    currentlevel = checkspace - m.get(c.get(i)); //приращение функции
                }
            }
        }
        sp = repeat(' ', currentlevel);
        b.append(sp + s + System.getProperty("line.separator"));
        out = b.toString();
        return out;
    }

    public String repeat(char c, int times) {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < times; i++) {
            b.append(c);
        }
        return b.toString();
    }

}
