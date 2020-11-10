package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealItemTest {
    private RealItem ri;

    @BeforeEach
    void setUp() {
        ri = new RealItem();
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        ri.setName("test");
        ri.setPrice(1);
        ri.setWeight(1);
        assertEquals("Class: class shop.RealItem; Name: test; Price: 1.0; Weight: 1.0", ri.toString());
    }
}