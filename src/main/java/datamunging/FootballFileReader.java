package datamunging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class FootballFileReader {

    private static final int HEADER_LINES = 1;

    public String findSmallestDifferenceTeam(Path path) {
        try (var lines = Files.lines(path)) {
            return findSmallest(lines);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private String findSmallest(Stream<String> lines) {
        return lines
                .skip(HEADER_LINES)
                .filter(FootballFileReader::lineNotContainsOnlyDashes)
                .map(FootballTeamGoals::parseLine)
                .min(Comparator.comparing(FootballTeamGoals::diffBetweenGoals))
                .orElseThrow(FileReader::throwNoDataFound)
                .getName();
    }

    public static boolean lineNotContainsOnlyDashes(String s) {
        return !s.contains("---");
    }

    public static IllegalArgumentException throwNoDataFound() {
        return new IllegalArgumentException("No data line found");
    }
}
