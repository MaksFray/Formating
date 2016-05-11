
public class Main {
    
    public static void main(String[] args) {
        IReader read = new FileRead();
        IHelper help = new Helper();
        Format format = new Format(help);
        IWriter write = new FileWrite("result.txt");
        write.write(format.format(read.read("test.txt")));
        
    }
    
}
