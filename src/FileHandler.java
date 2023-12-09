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
    @Override
    public boolean writeUserInputToFile() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter file's name:");
            String fileName = scanner.nextLine();

            if (fileName.isEmpty() || fileName.contains(File.separator)) {
                System.out.println("Invalid file name.");
                return false;
            }

            String path = "C:\\temp\\" + fileName + ".txt";

            File newFile = new File(path);
            if (newFile.createNewFile()) {
                System.out.println("File " + newFile.getName() + " is created successfully.");

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

                try (FileWriter fileWriter = new FileWriter(path)) {
                    fileWriter.write(content);
                }

                System.out.println("Content is successfully wrote to the file.");
                return true;
            } else {
                System.out.println("File is already exist in the directory.");
            }
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
