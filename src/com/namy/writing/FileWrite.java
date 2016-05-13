package com.namy.writing;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWrite implements IWriter {

    private String filename;
    private Writer writer;

    public FileWrite(final String filename) {
        this.filename = filename;
    }
    /**
     * Open the writing stream
     */
    @Override
    public void write() {
        try {
            writer = new OutputStreamWriter(new FileOutputStream(filename));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * Write one line in the file
     * @param line - intermediate result of formating 
     */
    @Override
    public void writeLine(String line) {
        try {
            writer.write(line);
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(FileWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Close output stream
     */
    public void close() throws IOException
    {
        writer.close();
    }

}
