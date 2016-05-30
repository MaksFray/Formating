/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.namy.writing.FileWrite;
import com.namy.writing.IWriter;
import com.namy.writing.WriteException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fray
 */
public class FileWriteTest {
    
    public FileWriteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of write method, of class FileWriter.
     */
    
    @Test(expected = NullPointerException.class)
    public void testWrite() throws WriteException {
        String s = "";
        IWriter instance = new FileWrite("");
    }
}
