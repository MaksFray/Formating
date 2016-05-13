package com.namy.writing;

import java.io.IOException;

public interface IWriter {

    public void write();

    public void writeLine(String toString);

    public void close() throws IOException;
}
