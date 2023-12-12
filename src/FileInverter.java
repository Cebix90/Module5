import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileInverter {
    public boolean invertFile(String fileName) throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("resources/" + fileName)) {
            if (inputStream != null) {
                byte[] contentBytes = inputStream.readAllBytes();
                String content = new String(contentBytes);

                List<String> words = Arrays.asList(content.split("\\s+"));

                for (int i = 0; i < words.size(); i++) {
                    String word = words.get(i);

                    if (word.matches(".*\\p{Punct}.*")) {
                        char lastChar = word.charAt(word.length() - 1);
                        words.set(i, lastChar + word.substring(0, word.length() - 1));
                    }
                }

                Collections.reverse(words);

                String invertedContent = String.join(" ", words);

                Path outputPath = Path.of("src/resources/" + getFileNameWithReversedString(fileName));

                try {
                    Files.write(outputPath, invertedContent.getBytes(), StandardOpenOption.CREATE_NEW);
                } catch (FileAlreadyExistsException e) {
                    System.out.println("File already exists: " + getFileNameWithReversedString(fileName));
                    return false;
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file: " + e.getMessage());
                    return false;
                }

                System.out.println("File created successfully: " + getFileNameWithReversedString(fileName));
                return true;
            } else {
                System.out.println("Resource not found: " + fileName);
                return false;
            }
        }
    }

    private String getFileNameWithReversedString(String fileName) {
        return fileName.substring(0, fileName.length() - 4) + "-reversed.txt";
    }
}