package com.namy.state;

import com.namy.formating.Helper;

public class StartLine implements IState {

    @Override
    public void nextState(Helper help) {
        IState s = new MiddleLine();
        help.setState(s);
        help.setFin(help.currentLevel());
    }
    

    
}
