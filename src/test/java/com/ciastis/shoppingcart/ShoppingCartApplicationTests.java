package com.ciastis.shoppingcart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class ShoppingCartApplicationTests {

    @Test
    public void cartEmptyFirst() {
        // Setup
        Cart cart = new Cart();
        int expected = 0;

        // Exercise
        int actual = cart.getItems().size();

        // Assert
        assertEquals("", expected, actual);

    }

    @Test
    public void emptyCartPriceZero() {
        // Setup
        Cart cart = new Cart();
        BigDecimal expected = new BigDecimal(0);

        // Exercise
        BigDecimal actual = cart.getTotal();

        // Assert
        assertEquals("", expected, actual);
    }

    @Test
    public void checkCartTotalPrice() {
        // add item to cart and compare expected with actual
        // create item
        Cart cart = new Cart();
        Item apple = new Item("apple", new BigDecimal(12.5), false);
        cart.addItem(apple, 3);

        BigDecimal expected = new BigDecimal(12.5 * 3);
        BigDecimal actual = cart.getTotal();

        assertEquals("", expected, actual);

    }

    @Test
    public void testGetQuant() {
        // return item name and quantity
        Cart cart = new Cart();
        Item pear = new Item("pear", new BigDecimal(3.0), false);
        cart.addItem(pear, 3);

        Item orange = new Item("orange", new BigDecimal(5.0), false);
        cart.addItem(orange, 33);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("pear - Qty: 3");
        expected.add("orange - Qty: 33");

        List<String> actual = cart.getItemQuantity();

        // Assert
        assertEquals("compare expected list and actual list", expected, actual);

    }
}
