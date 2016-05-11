
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite implements IWriter {

    private String filename;

    public FileWrite(final String filename) {
        this.filename = filename;
    }
    /**
     * Wrining to file
     * @param s - result execution of Format 
     */

    @Override
    public void write(String s) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            writer.write(s);
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
    }

}
