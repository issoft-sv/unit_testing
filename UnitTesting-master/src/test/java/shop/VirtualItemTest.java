package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualItemTest {
    private VirtualItem vi;

    @BeforeEach
    void setUp() {
        vi = new VirtualItem();
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        vi.setName("test");
        vi.setPrice(1);
        vi.setSizeOnDisk(1);
        assertEquals("Class: class shop.VirtualItem; Name: test; Price: 1.0; Size on disk: 1.0", vi.toString());
    }
}