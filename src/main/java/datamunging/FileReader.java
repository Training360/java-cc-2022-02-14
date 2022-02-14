package datamunging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class FileReader {

    private static final int HEADER_LINES_NO = 2;

    public int findSmallestTemperatureSpread(Path path) {
        try (var lines = Files.lines(path)) {
            return findSmallest(lines);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private int findSmallest(Stream<String> lines) {
        return lines
                .skip(HEADER_LINES_NO)
                .filter(FileReader::dataLine)
                .map(DataItem::of)
                .min(Comparator.comparing(DataItem::diff))
                .orElseThrow(FileReader::throwNoDataFound)
                .getDay();
    }

    public static boolean dataLine(String s) {
        return !s.contains("mo");
    }

    public static IllegalArgumentException throwNoDataFound() {
        return new IllegalArgumentException("No data line found");
    }

}
