package parser;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shop.Cart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        if (file.exists()) {
            file.delete();
        }
    }

    @Test() // to verify file is created in case when we have no another file or directory with such name
    void testFileIsCreated() {
        if (!file.exists()) {
            jp.writeToFile(new Cart("test"));
            assertEquals(true, file.exists());
        } else fail("File already exists");
    }

    @Test // to verify file is not created in case when we catch IOException
    void testExceptionFileIsNotCreated() {
        jp.writeToFile(new Cart("test1"));
        assertEquals(false, file.exists());
    }

    @Test // to verify we get NullPointerException in case when we try to write null in the file
    void testWriteToFileNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            jp.writeToFile(null);
        });
    }

    @Test() // to verify we can successfully get cart object (not null) from the file prepared by the writeToFile method
    void testReadFromFile() {
        jp.writeToFile(new Cart("test"));
        Cart cart = jp.readFromFile(file);
        assertNotNull(cart);
    }

    @Test() // to verify we get NullPointerException in case when we try to read from null
    void testReadFromFileNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            jp.writeToFile(new Cart("test"));
            Cart cart = jp.readFromFile(null);
        });
    }

    @Test() // to verify we get NoSuchFileException in case when the file doesn't exist
    void testReadFromFileNoSuchFileException() {
        assertThrows(NoSuchFileException.class, () -> {
            Cart cart = jp.readFromFile(file);
        });
    }

    @Test() // to verify we get null in case when we try deserialize json created from null
    void testReadFromWrongFile() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("src/main/resources/test.json")) {
            writer.write(gson.toJson(null));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Cart cart = jp.readFromFile(file);
        assertNull(cart);
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