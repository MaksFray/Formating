package com.namy.reading;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class FileRead implements IReader {

    String filename;
    Reader in;
    int symbol;

    public FileRead(String filename) {
        this.filename = filename;
        symbol = 0;
    }

    /**
     *
     * Open the reading stream
     */
    @Override
    public void read() {
        try {
            in = new InputStreamReader(new FileInputStream(filename));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * read one symbol
     *
     * @return one symbol
     */
    @Override
    public int readSymbol() throws IOException {
        symbol = in.read();
        return symbol;
    }

    public boolean hasSymbol() {
        boolean check = true;
        int temp = 0;
        temp = symbol;
        check = !(temp == -1); //-1 is the end of file
        return check;
    }

    /**
     * Close input
     */
    public void close() throws IOException {
        in.close();
    }
}
