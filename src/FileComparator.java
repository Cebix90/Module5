import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileComparator {
    public boolean areTextFilesEqual(String filePath1, String filePath2){
        Path firstFilePath = Paths.get(filePath1);
        Path secondFilePath = Paths.get(filePath2);

        if(isPathExists(firstFilePath) && isPathExists(secondFilePath)){
            try {
                List<String> fileLines1 = getFileLines(firstFilePath);
                List<String> fileLines2 = getFileLines(secondFilePath);

                return fileLines1.equals(fileLines2);
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
            }
        } else {
            System.out.println("One or both of the file paths do not exist.");
        }

        return false;
    }

    private static boolean isPathExists(Path filePath) {
        return Files.exists(filePath);
    }

    private List<String> getFileLines(Path firstFilePath) throws IOException {
        return Files.readAllLines(firstFilePath);
    }
}
