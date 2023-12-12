import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileInverterTests {
    @Test
    public void givenSuccessfulInvertFileOperation_shouldProduceExpectedReversedContent() throws IOException {
        FileInverter fileInverter = new FileInverter();

        String inputFileName = "text1.txt";
        String outputFileName = inputFileName.substring(0, inputFileName.length() - 4) + "-reversed.txt";
        Path outputPath = Path.of("src/resources/" + outputFileName);

        if (Files.exists(outputPath)) {
            Files.delete(outputPath);
        }

        boolean result = fileInverter.invertFile(inputFileName);

        assertTrue(result);

        String fileContent = Files.readString(outputPath);
        String expectedContent = ".kota ma Ala";
        assertEquals(expectedContent, fileContent);
    }
}
