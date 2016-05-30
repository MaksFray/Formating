
import com.namy.reading.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileReadTest {
    static private File newfile= new File("testfile.txt").getAbsoluteFile();
    
    public FileReadTest(){
    }

    @BeforeClass
    public static void setUpClass() throws IOException  {
        newfile.createNewFile();
        try(FileWriter writer = new FileWriter(newfile))
        {
            String text = "z";
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
        newfile.delete();
    }

    /**
     * Test of read method, of class FileReader.
     */
    @Test(expected = ReadException.class)
    public void testfilenotfound() throws ReadException {
        IReader read = new FileRead("magic");
    }
    
    @Test
    public void testfileread() throws ReadException {
        IReader read = new FileRead("testfile.txt");
    }
    
    @Test
    public void testfilereadsymbol() throws ReadException {
        IReader read = new FileRead("testfile.txt");
        int text = Integer.valueOf('z');
        assertEquals(read.readSymbol(), text);
    }

}
