package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart("test");
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void addRealItem() {
        RealItem ri = new RealItem();
        ri.setPrice(1);
        cart.addRealItem(ri);
        assertEquals(1.2, cart.getTotalPrice());
    }
}