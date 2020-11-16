package parser;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.testng.asserts.SoftAssert;
import shop.Cart;

import java.io.File;

import static org.testng.Assert.fail;

class JsonParserTest {
    JsonParser jp;
    File file;

    @BeforeTest
    void setUp() {
        jp = new JsonParser();
        file = new File("src/main/resources/test.json");
    }

    @AfterTest
    void tearDown() {
        file.delete();
    }

    @Test
    void testFileIsCreated() {
        if (!file.exists()) {
            jp.writeToFile(new Cart("test"));
            assertEquals(true, file.exists());
        } else fail("File already exists");
    }

    @Test
    void testReadFromFile() {
        jp.writeToFile(new Cart("test"));
        Cart cart = jp.readFromFile(file);
    }

    @Test
    void testWriteToFileCatchedException() {
        jp.writeToFile(new Cart("test1"));
    }

    @DataProvider(name = "dp")
    public static Object [][] testData () {
        return new Object[][] {{""}, {" "}, {"test"}};
    }

    @Test(expectedExceptions = NoSuchFileException.class, dataProvider = "dp")
    @Parameters (value = "input")
    void testReadFromFileExceptions(String input) {
            jp.readFromFile(new File(input));
    }

    @Test (enabled = false)
    void groupAssertions() {
        SoftAssert assertion = new SoftAssert();
        int[]numbers = {0, 1, 2, 3, 4};
        assertion.assertEquals(numbers[1], 0);
        assertion.assertEquals(numbers[2], 1);
        assertion.assertEquals(numbers[3], 3);
        assertion.assertAll();
    }
}