import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

interface IFileHandler {
    boolean writeUserInputToFile();

    void readFromFile(String fileName);
}

public class FileHandler implements IFileHandler {
    private static final String DIRECTORY_PATH = "C:\\temp\\";

    @Override
    public boolean writeUserInputToFile() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter file's name:");
            String fileName = scanner.nextLine();

            if (fileName.isEmpty() || fileName.contains(File.separator)) {
                System.out.println("Invalid file name.");
                return false;
            }

//            String filePath = DIRECTORY_PATH + fileName + ".txt";
            Path path = Paths.get(DIRECTORY_PATH + fileName + ".txt");

            if (Files.exists(path)) {
                System.out.println("File already exists in the directory.");
                return false;
            }

            System.out.println("Enter text:");
            String inputLine = scanner.nextLine().trim();

            String[] words = inputLine.split("\\s+");

            StringBuilder contentBuilder = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                contentBuilder.append(words[i]).append(" ");
                if ((i + 1) % 4 == 0) {
                    contentBuilder.append("\n");
                }
            }

            String content = contentBuilder.toString().trim();

            Files.writeString(path, content);

            System.out.println("Content is successfully wrote to the file.");
            return true;

        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
        }

        return false;
    }

    @Override
    public void readFromFile(String fileName) {
        Path filePath = Paths.get("C:\\temp\\", fileName);

        try {
            List<String> fileLines = Files.readAllLines(filePath);
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
