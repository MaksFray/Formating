
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileReadTest {
    
    public FileReadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of read method, of class FileReader.
     */
    @Test(expected = NullPointerException.class)
    public void testRead() {
        Object o = null;
        IReader read = new FileRead();
        read.read(o);
    }
    public void testfilenotfound(){
        Object o = " “[|]’~<!--@/*$%^&#*/()?>,.*'/\\";
        FileRead read = new FileRead();
        read.read(o);
    }
    
}
