package com.namy.state;

import com.namy.helper.Helper;

public class EndLine implements IState {

    @Override
    public void nextState(Helper help) {
        IState s = new StartLine();
        help.setState(s);
        help.setFin(System.getProperty("line.separator"));
    }

}
