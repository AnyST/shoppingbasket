package com.interview.shoppingbasket.promotion;

import com.interview.shoppingbasket.basket.BasketItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PromotionTest {
    @ParameterizedTest
    @CsvSource({"10,500", "11,600"})
    void applyTwoByOnePromotion(int qtd, int finalPrice) {
        int price = 100;
        Promotion promotion = Promotion.TWO_BY_ONE;
        BasketItem basketItem = new BasketItem(promotion.getProductCode(), qtd);
        basketItem.setProductRetailPrice(price);

        assertEquals(finalPrice, promotion.apply(basketItem.getProductRetailPrice(), basketItem.getQuantity()));
    }

    @Test
    void applyFiftyOffPromotion() {
        int price = 100;
        Promotion promotion = Promotion.FIFTY_OFF;
        BasketItem basketItem = new BasketItem(promotion.getProductCode(), 7);
        basketItem.setProductRetailPrice(price);

        assertEquals(50, promotion.apply(basketItem.getProductRetailPrice(), basketItem.getQuantity()));
    }

    @Test
    void applyTenOffPromotion() {
        int price = 100;
        Promotion promotion = Promotion.TEN_OFF;
        BasketItem basketItem = new BasketItem(promotion.getProductCode(), 5);
        basketItem.setProductRetailPrice(price);

        assertEquals(90, promotion.apply(basketItem.getProductRetailPrice(), basketItem.getQuantity()));
    }

}
