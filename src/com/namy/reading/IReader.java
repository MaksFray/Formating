package com.namy.reading;

import java.io.IOException;

public interface IReader {

    public void read();

    public int readSymbol() throws IOException;

    public void close() throws IOException;

    public boolean hasSymbol();
}
