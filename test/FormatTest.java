/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.namy.formating.Format;
import com.namy.formating.Collector;
import com.namy.formating.FormatException;
import com.namy.reading.FileRead;
import com.namy.reading.ReadException;
import com.namy.reading.StringRead;
import com.namy.writing.FileWrite;
import com.namy.writing.StringWrite;
import com.namy.writing.WriteException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fray
 */
public class FormatTest {

    static private File newfile = new File("testfile.txt").getAbsoluteFile();
    static private File file = new File("testoutfile.txt").getAbsoluteFile();

    public FormatTest() {
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
        newfile.createNewFile();
        file.createNewFile();
        try (FileWriter writer = new FileWriter(newfile)) {
            String text = "try{magic;}";
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
        newfile.delete();
        file.delete();
    }

    /**
     * Test of format method, of class Format.
     */
    @Test(expected = FormatException.class)
    public void testFormatEmpty() throws FormatException, ReadException {

        StringRead read = new StringRead("");
        StringWrite write = new StringWrite();
        Format instance = new Format(new Collector(" ", "4"));
        instance.format(read, write);
    }

    @Test(expected = FormatException.class)
    public void testFormatunballancedbrace() throws FormatException, ReadException {
        StringRead read = new StringRead("{{}");
        StringWrite write = new StringWrite();
        Format instance = new Format(new Collector(" ", "4"));
        instance.format(read, write);
    }

    @Test(expected = FormatException.class)
    public void testFormatwrongbrace() throws FormatException, ReadException {
        StringRead read = new StringRead("{}}}");
        StringWrite write = new StringWrite();
        Format instance = new Format(new Collector(" ", "4"));
        instance.format(read, write);
    }

    @Test(expected = FormatException.class)
    public void testFormat() throws FormatException, ReadException {
        StringRead read = new StringRead("try{magic;}");
        StringWrite write = new StringWrite();
        Format instance = new Format(new Collector(" ", "4"));
        instance.format(read, write);
    }

    /*@Test(expected = FormatException.class,ReadException.class)
    public void testFormatFile() throws FormatException, ReadException, WriteException {
        FileRead read = new FileRead("testfile.txt");
        FileWrite write = new FileWrite("testoutfile.txt");
        Format instance = new Format(new Collector(" ", "4"));
        FileRead test = new FileRead("testoutfile.txt");
        char symbol;
        String s = "mewtry{\n    magic;\n}";
        char[] c = s.toCharArray();
        //instance.format(read, write);
        for (int i = 0; i < c.length; i++) {
            symbol = (char) test.readSymbol();
            assertEquals(symbol,c[i]);
        }
    }*/

}
