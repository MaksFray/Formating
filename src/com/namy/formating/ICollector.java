package com.namy.formating;


public interface ICollector {

    public void collect(char symbol) throws FormatException;
    public void checkBallance() throws FormatException;
    public String currentLevel();
}
