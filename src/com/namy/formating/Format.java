package com.namy.formating;

import com.namy.helper.IHelper;
import com.namy.reading.IReader;
import com.namy.writing.IWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Format implements IFormat {

    IHelper help;

    public Format(IHelper help) {
        this.help = help;
    }

    /**
     * Apply some rules for data
     *
     * @param s - input data
     */
    @Override
    public void format(final IReader reader, final IWriter writer) {
        StringBuilder builder = new StringBuilder(); //несколько потоков
        try {
            char symbol = 0;
            reader.read();
            writer.write();
            String temp;
            while (reader.hasSymbol()) {
                symbol = (char) reader.readSymbol();
                builder.append(symbol);
                if (help.hasSymbol(symbol)) {
                    help.help(symbol);
                    temp = builder.toString();
                    builder.delete(0, builder.length());
                    builder.append(help.currentLevel() + temp.trim() + System.getProperty("line.separator"));
                    writer.writeLine(builder.toString());
                    builder.delete(0, builder.length());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Format.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Format.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
