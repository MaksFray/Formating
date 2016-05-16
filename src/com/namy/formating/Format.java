package com.namy.formating;

import com.namy.helper.IHelper;
import com.namy.reading.IReader;
import com.namy.reading.ReadException;
import com.namy.writing.IWriter;
import com.namy.writing.WriteException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Format implements IFormat {


    private IHelper help;

    public Format(IHelper help) {
        this.help = help;
    }

    /**
     * Apply some rules for data
     *
     * @param s - input data
     */
    @Override
    public void format(final IReader reader, final IWriter writer) throws FormatException {
        try {
            char symbol = 0;
            while (true) {
                symbol = (char) reader.readSymbol();
                writer.writeLine(help.help(symbol));
            }
        } catch (ReadException ex) {
            throw new FormatException(ex);
        } catch (WriteException ex) {
            throw new FormatException(ex);
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (ReadException ex) {
               throw new FormatException(ex);
            } catch (WriteException ex) {
               throw new FormatException(ex);
            }

        }
    }

}
