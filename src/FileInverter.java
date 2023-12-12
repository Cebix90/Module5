import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileInverter {
    public boolean invertFile(String fileName) {
        String separator = File.separator;

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("resources" + separator + fileName)) {
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

                Path outputPath = Path.of("src" + separator + "resources" + separator + fileName.substring(0, fileName.length() - 4) + "-reversed.txt");
                Files.write(outputPath, invertedContent.getBytes(), StandardOpenOption.CREATE);

                return true;
            } else {
                System.out.println("Resource not found: " + fileName);
                return false;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }
}