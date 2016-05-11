/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fray
 */
public class FormatTest {
    
    public FormatTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of format method, of class Format.
     */
    @Test
    public void testFormatEmpty() {
        String s = "";
        Format instance = new Format(new Helper());
        String expResult = "";
        String result = instance.format(s);
        assertEquals(expResult, result);
    }
    
    @Test(expected = NullPointerException.class)
    public void testFormatNull() {
        String s = null;
        Format instance = new Format(new Helper());
        String expResult = null;
        String result = instance.format(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of prepare method, of class Format.
     */
    @Test(expected = NullPointerException.class)
    public void testPrepareNull() {
        String s = null;
        Format instance = new Format(new Helper());
        String expResult = null;
        String result = instance.prepare(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPrepareEmpty() {
        String s = "";
        Format instance = new Format(new Helper());
        String expResult = "";
        String result = instance.prepare(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPrepareLine() {
        String s = " “[|]’~<!--@/*$%^&#*/()?>,.*'/\\";
        Format instance = new Format(new Helper());
        String expResult = " “[|]’~<!--@/*$%^&#*/()?>,.*'/\\";
        String result = instance.prepare(s);
        assertEquals(expResult, result);
    }
    
}
