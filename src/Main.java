import geometric.Square;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        IDirectoryLister directoryLister = new DirectoryLister();
//        directoryLister.printDirectory();

//        IFileHandler fileHandler = new FileHandler();
////        fileHandler.writeUserInputToFile();
//        fileHandler.readFromFile("haha1.txt");

        System.out.println(new Square(2).calculateArea());
        System.out.println(new Square(2).calculateDiameter());
    }
}