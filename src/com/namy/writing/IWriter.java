package com.namy.writing;

import java.io.IOException;

public interface IWriter {

    public void writeLine(String toString) throws WriteException;
    public void close() throws WriteException;
}
