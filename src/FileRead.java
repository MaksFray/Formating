
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileRead implements IReader {

    /**
     * 
     * Reading from file
     * @return input
     */
    public String read(Object o) {
        String input = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File((String) o)));
            input = in.readLine();
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        return input;
    }

}
