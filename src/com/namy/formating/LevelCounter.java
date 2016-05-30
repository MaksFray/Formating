
package com.namy.formating;

public class LevelCounter {
    Collector help;
    public LevelCounter ( Collector help)
    {
        this.help=help;
    }
    public void count(char symbol)
    {
        if (symbol == '{') {
            help.setPlus();
        }

        if (symbol == '}') {
            help.setMinus();
        }
    }
}
