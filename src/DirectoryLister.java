import java.io.File;

interface IDirectoryLister {
    void printDirectory(String directoryPath);
}

public class DirectoryLister implements IDirectoryLister {

    @Override
    public void printDirectory(String directoryPath) {
        String[] listOfFiles = new File(directoryPath).list();

        try {
            if (listOfFiles != null && listOfFiles.length > 0) {
                for (String fileName : listOfFiles) {
                    System.out.println(fileName);
                }

                System.out.println("\nNumber of files in this folder = " + listOfFiles.length);
            } else {
                System.out.println("The specified folder is empty.");
            }
        } catch (NullPointerException e) {
            System.out.println("The specified folder is not exist.");
        }
    }
}
