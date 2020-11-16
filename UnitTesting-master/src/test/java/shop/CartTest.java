package shop;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

class CartTest {
    private Cart cart;

    @BeforeTest
    void setUp() {
        cart = new Cart("test");
    }
    @AfterTest
    void tearDown() {
    }

    @Test(groups = {"A"})
    void addRealItem() {
        RealItem ri = new RealItem();
        ri.setPrice(1);
        cart.addRealItem(ri);
        assertEquals(1.2, cart.getTotalPrice());
    }
}