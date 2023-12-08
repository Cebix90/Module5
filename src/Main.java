import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        DirectoryLister directoryLister = new DirectoryLister();
//        directoryLister.printDirectory();

        FileHandler fileHandler = new FileHandler();
        fileHandler.writeUserInputToFile();
    }
}