package datamunging;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {

    @Test
    void testFileReader() {
        int result = new FileReader().findSmallestTemperatureSpread(Path.of("src/main/resources/datamunging/weather.dat"));
        assertEquals(14, result);
    }
}
