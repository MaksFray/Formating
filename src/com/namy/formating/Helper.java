package com.namy.formating;

import com.namy.state.EndLine;
import com.namy.state.IState;
import com.namy.state.MiddleLine;
import static java.lang.Integer.valueOf;
import java.util.HashMap;

/**
 * Class for changes char
 */
public class Helper implements IHelper {

    private IState current_state;
    public HashMap<Character, Integer> m = new HashMap();
    public int indentcounter;
    public String indent;
    public int checkspace;
    public int currentlevel;
    public char symbol;
    public StringBuilder f = new StringBuilder(); ;
    public String ret;
    
    
    int plus=0,minus=0;

    public Helper(String indent, String indentcounter) {
        this.indent = indent;
        this.indentcounter = valueOf(indentcounter);
        current_state = new MiddleLine();
        m.put('{', 1);
        m.put('}', -1);
        m.put(';', 0);
        checkspace = 0;
    }

    /**
     *
     * check sybmols from map
     */
    @Override
    public String help(char symbol){
        currentlevel = 0;
        if (m.containsKey(symbol)) {
            if (symbol == '{')
            {
                plus++;
                checkspace=plus-minus;
            }
        }
        currentlevel=checkspace;

        if(symbol=='}' && m.containsKey(symbol)){
            minus++;
            currentlevel=plus-minus;
            checkspace--;
        }

        nextState();
        nextState();
        this.symbol = symbol;
        nextState();
        
        f.append(symbol);
        ret = f.toString();
        f.delete(0, f.length());
        return ret;
    }

    @Override
    public String currentLevel() {
        String spaces = "";
        spaces = repeat(' ', currentlevel*indentcounter);
        return spaces.toString();
    }
    
    

    public String repeat(char c, int times) {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < times; i++) {
            b.append(c);
        }
        return b.toString();
    }

    public void nextState() {
        current_state.nextState(this);
    }

    public void setState(IState s) {
        current_state = s;
    }

    public void setFin(String string) {
        f.append(string);
    }
    
}
