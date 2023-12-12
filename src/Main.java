import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        IDirectoryLister directoryLister = new DirectoryLister();
//        directoryLister.printDirectory();

//        IFileHandler fileHandler = new FileHandler();
////        fileHandler.writeUserInputToFile();
//        fileHandler.readFromFile("haha1.txt");

//        System.out.println(new Square(2).calculateArea());
//        System.out.println(new Square(2).calculateDiameter());

//        FileComparator fileComparator = new FileComparator();
//        String path1 = "C:\\temp\\haha1.txt";
//        String path2 = "C:\\temp\\haha3.txt";
//        String path3 = "C:\\temp\\haha2.txt";
//        String path4 = "C:\\temp\\text1.txt";
//        System.out.println(fileComparator.areTextFilesEqual(path1,path2));
//        System.out.println(fileComparator.areTextFilesEqual(path1,path3));
//        System.out.println(fileComparator.areTextFilesEqual(path1,path4));

        FileInverter fileInverter = new FileInverter();
        fileInverter.invertFile("text1.txt");

    }
}