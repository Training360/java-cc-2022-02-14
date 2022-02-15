package datamunging;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballFileReaderTest {

    @Test
    void testFileReader() {
        var team = new FootballFileReader().findSmallestDifferenceTeam(Path.of("src/main/resources/datamunging/football.dat"));
        assertEquals("Aston_Villa", team);
    }
}
