package com.namy.reading;

import java.io.Closeable;
import java.io.IOException;

public interface IReader{

    public int readSymbol() throws ReadException;

    public void close() throws ReadException;

}
