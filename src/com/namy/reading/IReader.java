package com.namy.reading;


public interface IReader{

    public int readSymbol() throws ReadException;

    public void close() throws ReadException;

}
