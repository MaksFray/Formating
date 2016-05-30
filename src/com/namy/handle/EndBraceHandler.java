package com.namy.handle;

import com.namy.formating.ICollector;

public class EndBraceHandler implements IHandler {
    private ICollector collect;
    
    public EndBraceHandler(ICollector collect)
    {
        this.collect=collect;
    }

    @Override
    public String handle(){
        String s = System.getProperty("line.separator")+collect.currentLevel();
        return s;
    }

   
}
