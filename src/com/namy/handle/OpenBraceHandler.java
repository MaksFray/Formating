package com.namy.handle;

import com.namy.formating.ICollector;

public class OpenBraceHandler implements IHandler {

    private ICollector collect;
    
    public OpenBraceHandler(ICollector collect)
    {
        this.collect=collect;
    }

    @Override
    public String handle() {
       String s = System.getProperty("line.separator")+collect.currentLevel();
        return s;
    }

}
