package com.namy.formating;

import com.namy.handle.*;
import com.namy.state.EndLine;
import com.namy.state.IState;
import com.namy.state.MiddleLine;
import java.util.HashMap;

public class StateMachine {

    IState current_state;
    IHandler current_command;
    IHandler nextcommand;
    HashMap<Character, IState> innermap;
    HashMap<Character, IState> check;
    HashMap<IState, HashMap<Character, IState>> outermap = new HashMap<IState, HashMap<Character, IState>>();
    final IState mid = new MiddleLine();
    final IHandler handle = new MidHandler();
    HashMap<Character, IHandler> innercommand;
    HashMap<IState, HashMap<Character, IHandler>> outercommand = new HashMap<IState, HashMap<Character, IHandler>>();

    public StateMachine(ICollector collect) {
        nextcommand = new MidHandler();
        IState end = new EndLine();
        IHandler obrace = new OpenBraceHandler(collect);
        IHandler ebrace = new EndBraceHandler(collect);
        IHandler semicolon = new SemicolonHandler(collect);

        innermap = new HashMap();
        check = new HashMap();

        innercommand = new HashMap();
        innermap.put('{', end);
        innermap.put('}', end);
        innermap.put(';', end);
        check.put('{', end);
        check.put('}', end);
        check.put(';', end);
        outermap.put(mid, innermap);
        innercommand.put('{', obrace);
        innercommand.put('}', ebrace);
        innercommand.put(';', semicolon);
        outercommand.put(end, innercommand);
    }

    public IState checkState(IState state, char c){
        current_state = outermap.getOrDefault(state, check).getOrDefault(c, mid);
        if (!check.containsKey(c)) {
            innermap.put(c, mid);
        }
        outermap.put(current_state, innermap);
        return current_state;
    }

    public IHandler checkCommand(IState state, char c){
        nextcommand = outercommand.getOrDefault(state, innercommand).getOrDefault(c, handle);
        return nextcommand;
    }

}
