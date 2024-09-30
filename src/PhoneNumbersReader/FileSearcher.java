package PhoneNumbersReader;

import java.io.IOException;
import java.nio.file.*;
import java.util.regex.*;
import java.util.stream.Stream;


public class FileSearcher {

    public static void main(String[] args) {
        String folderPath = "src/PhoneNumber.txt";
        String fileName = "PhoneNumber.txt";

        try {
            Path filePath = findFile(Paths.get(folderPath), fileName);
            if (filePath != null) {
                System.out.println("Fayl topildi: " + filePath);

                readAndPrintNumbers(filePath);
            } else {
                System.out.println("Fayl topilmadi.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Path findFile(Path folder, String fileName) throws IOException {
        try (Stream<Path> files = Files.walk(folder)) {
            return files
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().equals(fileName))
                    .findFirst()
                    .orElse(null);
        }
    }

    public static void readAndPrintNumbers(Path filePath) throws IOException {
        String content = new String(Files.readAllBytes(filePath));
        Pattern pattern = Pattern.compile("\\d{2,}");
        Matcher matcher = pattern.matcher(content);

        System.out.println("Topilgan raqamlar:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
