package shop;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

class RealItemTest {
    private RealItem ri;

    @BeforeTest
    void setUp() {
        ri = new RealItem();
    }
    @AfterTest
    void tearDown() {
    }

    @Test(groups = {"B"})
    void testToString() {
        ri.setName("test");
        ri.setPrice(1);
        ri.setWeight(1);
        assertEquals("Class: class shop.RealItem; Name: test; Price: 1.0; Weight: 1.0", ri.toString());
    }
}