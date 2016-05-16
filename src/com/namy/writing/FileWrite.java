package com.namy.writing;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileWrite implements IWriter {



    
    private String filename;
    private Writer writer;

    public FileWrite(final String filename) throws WriteException{
        try {
            this.filename = filename;
            writer = new OutputStreamWriter(new FileOutputStream(filename));
        } catch (IOException ex) {
            throw new WriteException(ex);
        }
    }
    

    /**
     * 
     * Write one line in the file
     * @param line - intermediate result of formating 
     */
    @Override
    public void writeLine(String line) throws WriteException{
        try {
            writer.write(line);
            writer.flush();
        } catch (IOException ex) {
             throw new WriteException(ex);
        }
    }
    
    /**
     * Close output stream
     */
    public void close() throws WriteException
    {
        try {
            writer.close();
        }catch (IOException ex) {
            throw new WriteException(ex);
        }
        
    }

}
