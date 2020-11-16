package shop;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

class VirtualItemTest {
    private VirtualItem vi;

    @BeforeTest
    void setUp() {
        vi = new VirtualItem();
    }
    @AfterTest
    void tearDown() {
    }

    @Test(groups = {"A", "B"})
    void testToString() {
        vi.setName("test");
        vi.setPrice(1);
        vi.setSizeOnDisk(1);
        assertEquals("Class: class shop.VirtualItem; Name: test; Price: 1.0; Size on disk: 1.0", vi.toString());
    }
}