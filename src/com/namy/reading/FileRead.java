package com.namy.reading;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileRead implements IReader {

    String filename;
    Reader in;
    int symbol;

    public FileRead(String filename) throws ReadException {
        try {
            this.filename = filename;
            in = new InputStreamReader(new FileInputStream(filename));
        } catch (IOException ex) {
            throw new ReadException(ex);
        }
    }

    /**
     *
     * read one symbol
     *
     * @return one symbol
     * @throws com.namy.reading.ReadException
     */
    @Override
    public int readSymbol() throws ReadException {
        try {
            symbol = in.read();
            if (symbol == -1) {
                throw new ReadException(new Exception("End file"));
            }
            return symbol;
        } catch (IOException ex) {
            throw new ReadException(ex);
        }

    }

    /**
     * Close input
     */
    public void close() throws ReadException {
        try {
            in.close();
        } catch (IOException ex) {
            throw new ReadException(ex);
        }
    }

}
