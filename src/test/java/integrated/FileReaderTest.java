package integrated;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {

    @Test
    void testTemperature() {
        var day = new FileReader().findSmallestValue(Path.of("src/main/resources/datamunging/weather.dat"), FileType.TEMPERATURE);
        assertEquals("14", day);
    }

    @Test
    void testTeams() {
        var team = new FileReader().findSmallestValue(Path.of("src/main/resources/datamunging/football.dat"), FileType.FOOTBALL);
        assertEquals("Aston_Villa", team);
    }
}
