package com.namy.formating;

import static java.lang.Integer.valueOf;

/**
 * Class for changes char
 */
public class Collector implements ICollector {

    private LevelCounter counter = new LevelCounter(this);
    private final int indentcounter;
    private final String indent;
    private int checkspace;
    private StringBuilder f = new StringBuilder();
    private int plus = 0, minus = 0;

    public Collector(String indent, String indentcounter) {
        
        this.indent = indent;
        this.indentcounter = valueOf(indentcounter);
        
        checkspace = 0;
    }

    /**
     *
     * check sybmols
     */
    @Override
    public void collect(char symbol) throws FormatException {
        counter.count(symbol);
        checkSpaces();
    }

    @Override
    public String currentLevel() {
        String spaces = "";
        spaces = repeat(' ', checkspace * indentcounter);
        return spaces.toString();
    }

    public String repeat(char c, int times) {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < times; i++) {
            b.append(c);
        }
        return b.toString();
    }

    public void setPlus() {
        plus++;
        checkspace = plus - minus;
    }

    public void setMinus() {
        minus++;
        checkspace--;
    }

    public void checkSpaces() throws FormatException {
        try {
            if (checkspace<0) {
                throw new FormatException(new Exception("Too much close brace"));
            }
        } catch (Exception ex) {
            throw new FormatException(ex);
        }
    }
    
    @Override
    public void checkBallance() throws FormatException {
        try {
            if (!(plus-minus==0)) {
                throw new FormatException(new Exception("Wrong ballance between brace"));
            }
        } catch (Exception ex) {
            throw new FormatException(ex);
        }
    }
 
}
