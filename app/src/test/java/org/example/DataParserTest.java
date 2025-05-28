package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataParserTest {
    // Tests whether the exception works in the parseEachLine()
    @Test
    void TestparseEachLineException() {
        DataParser parser = new DataParser();
        String line = "1234234590|Tower3|150|200|no|no|no";

        assertThrows(Exception.class, () -> {
            parser.parseEachLine(line);
        });
    }

    // Tests whether if proper line is parsed then required Datarecord is returned
    @Test
    void TestparseEachLineWithoutException() throws Exception {
        DataRecord expectedRecord = new DataRecord("1234234590", "Tower3", 150, 200, false);
        DataParser parser = new DataParser();
        String line = "1234234590|Tower3|150|200|no";
        assertEquals(expectedRecord, parser.parseEachLine(line));
    }

}
