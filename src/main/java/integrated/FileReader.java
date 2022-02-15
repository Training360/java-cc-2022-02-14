package integrated;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class FileReader {

    private static final int HEADER_LINES_NO = 2;

    public String findSmallestValue(Path path, FileType fileType) {
        try (var lines = Files.lines(path)) {
            return findSmallest(lines, fileType);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private String findSmallest(Stream<String> lines, FileType fileType) {
        return lines
                .skip(fileType.getHeaderLines())
                .filter(fileType::isValidLine)
                .map(fileType::parse)
                .min(Comparator.comparing(DataItem::getOrderBy))
                .orElseThrow(datamunging.FileReader::throwNoDataFound)
                .getDescription();
    }

    public static boolean dataLine(String s) {
        return !s.contains("mo");
    }

    public static IllegalArgumentException throwNoDataFound() {
        return new IllegalArgumentException("No data line found");
    }
}
