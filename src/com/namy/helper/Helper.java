package com.namy.helper;


import java.util.HashMap;

/**
 * Class with rules
 */
public class Helper implements IHelper {

    HashMap<Character, Integer> m = new HashMap();
    int checkspace;
    int currentlevel;

    public Helper() {
        m.put('{', 4);
        m.put('}', -4);
        m.put(';', 0);
        checkspace = 0;
    }

    /**
     * 
     * check sybmols from map
     */
    @Override
    public void help(char symbol) {
        currentlevel = 0;
        if (m.containsKey(symbol)) {
            checkspace += m.get(symbol);
            if (symbol == '}') {
                currentlevel = checkspace;
            } else {
                currentlevel = checkspace - m.get(symbol); //приращение функции
            }
        }
    }

    @Override
    public String currentLevel() {
        String spaces = "";
        spaces = repeat(' ', currentlevel);
        return spaces.toString();
    }

    @Override
    public boolean hasSymbol(char symbol) {
        boolean check = false;
        check = (m.containsKey(symbol)) ? true : false;
        return check;
    }

    public String repeat(char c, int times) {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < times; i++) {
            b.append(c);
        }
        return b.toString();
    }

}
