package com.namy.state;

import com.namy.helper.Helper;
import static java.lang.String.valueOf;

public class MiddleLine implements IState {

    @Override
    public void nextState(Helper help) {
        if (help.m.containsKey(help.symbol)) {
            IState s = new EndLine();
            help.setState(s);
        } else {
            help.setState(this);
        }
    }

}
