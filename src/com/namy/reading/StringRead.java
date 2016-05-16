
package com.namy.reading;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

public class StringRead implements IReader {
    
    private InputStream input;

    public StringRead(final String data) throws ReadException {
        try {
            input = new StringBufferInputStream(data);
        } catch (Exception e) {
            throw new ReadException(e);
        }
    }

    @Override
    public int readSymbol() throws ReadException {
        try {
            int code = input.read();
            if (code == -1) {
                throw new ReadException(new Exception("End o string"));
            }
            return code;
        } catch (IOException e) {
            throw new ReadException(e);
        }
    }

    @Override
    public void close() throws ReadException{
         try {
            input.close();
        } catch (IOException ex) {
            throw new ReadException(ex);
        }
    }
    
}
