

import com.namy.helper.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HelperTest {
    
    public HelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

/*
    @Test(expected = NullPointerException.class)
    public void testHelpNull() {
        String s = null;
        IHelper instance = new Helper();
        String expResult = null;
        String result = instance.help(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of repeat method, of class Helper.
     */
    @Test
    public void testRepeatEmptyResult() {
        char c = 'm';
        int times = 0;
        Helper instance = new Helper();
        String expResult = "";
        String result = instance.repeat(c, times);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRepeatCount() {
        char c = 'm';
        int times = 5;
        Helper instance = new Helper();
        String expResult = "mmmmm";
        String result = instance.repeat(c, times);
        assertEquals(expResult, result);
    }
    
}
