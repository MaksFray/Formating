
import com.namy.reading.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringReadTest {
    
    public StringReadTest(){
    }

    @BeforeClass
    public static void setUpClass() throws IOException  {
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
    }

    /**
     * Test of read method, of class FileReader.
     */
    @Test
    public void teststringread() throws ReadException {
        IReader read = new StringRead("123");
    }
    
    @Test
    public void teststringreadsymbol() throws ReadException {
        IReader read = new StringRead("z");
        int text = Integer.valueOf('z');
        assertEquals(read.readSymbol(), text);
    }

}
