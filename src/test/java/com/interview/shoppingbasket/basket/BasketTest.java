package com.interview.shoppingbasket.basket;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {
    @Test
    void emptyBasket() {
        Basket basket = new Basket();
        List<BasketItem> basketSize = basket.getItems();

        assertEquals(0, basketSize.size());
    }

    @Test
    void createBasketFullConstructor() {
        Basket basket = new Basket();
        basket.add("productCode", "myProduct", 10);
        List<BasketItem> basketSize = basket.getItems();

        assertEquals(1, basketSize.size());
        assertEquals("productCode", basketSize.get(0).getProductCode());
        assertEquals("myProduct", basketSize.get(0).getProductName());
        assertEquals(10, basketSize.get(0).getQuantity());
    }

    @Test
    void createBasketWithMultipleProducts() {
        Basket basket = new Basket();
        basket.add("productCode", "myProduct", 10);
        basket.add("productCode2", "myProduct2", 10);
        basket.add("productCode3", "myProduct3", 10);

        List<BasketItem> basketSize = basket.getItems();

        assertEquals(3, basketSize.size());
        assertEquals("productCode", basketSize.get(0).getProductCode());
        assertEquals("myProduct", basketSize.get(0).getProductName());
        assertEquals(10, basketSize.get(0).getQuantity());
        assertEquals("productCode2", basketSize.get(1).getProductCode());
        assertEquals("myProduct2", basketSize.get(1).getProductName());
        assertEquals(10, basketSize.get(1).getQuantity());
        assertEquals("productCode3", basketSize.get(2).getProductCode());
        assertEquals("myProduct3", basketSize.get(2).getProductName());
        assertEquals(10, basketSize.get(2).getQuantity());
    }

    @Test
    void consolidateBasketTest() {
        Basket basket = new Basket();
        basket.add("productCode", "myProduct", 10);
        basket.add("productCode2", "myProduct2", 23);
        basket.add("productCode2", "myProduct2", 30);
        basket.add("productCode3", "myProduct3", 40);

        basket.consolidateItems();
        assertEquals(3, basket.getItems().size());
        assertEquals(53, basket.getItems().get(1).getQuantity());
    }
}
