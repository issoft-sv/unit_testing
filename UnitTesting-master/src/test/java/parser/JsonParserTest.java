package parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shop.Cart;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {
    JsonParser jp;
    File file;

    @BeforeEach
    void setUp() {
        jp = new JsonParser();
        file = new File("src/main/resources/test.json");
    }

    @AfterEach
    void tearDown() {
        file.delete();
    }

    @Test()
    void testFileIsCreated() {
        if (!file.exists()) {
            jp.writeToFile(new Cart("test"));
            assertEquals(true, file.exists());
        } else fail("File already exists");
    }

    @Test()
    void testReadFromFile() {
        jp.writeToFile(new Cart("test"));
        Cart cart = jp.readFromFile(file);
        file.delete();
    }

    @Test
    void testWriteToFileCatchedException() {
        jp.writeToFile(new Cart("test1"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "test"})
    void testReadFromFileExceptions(String input) {
        assertThrows(NoSuchFileException.class, () -> {
            jp.readFromFile(new File(input));
        });
    }

    @Test  // not real test just for demonstration
    @Disabled
    void groupAssertions() {
        int[]numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[1], 1),
                () -> assertEquals(numbers[2], 2),
                () -> assertEquals(numbers[3], 3)
        );
    }
}