package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.checkout.step.RetailPriceCheckoutStep;
import com.interview.shoppingbasket.service.PricingService;
import com.interview.shoppingbasket.basket.Basket;
import com.interview.shoppingbasket.promotion.Promotion;
import com.interview.shoppingbasket.promotion.PromotionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RetailPriceCheckoutStepTest {

    PricingService pricingService;
    PromotionsService promotionsService;
    CheckoutContext checkoutContext;
    Basket basket;

    @BeforeEach
    void setup() {
        pricingService = Mockito.mock(PricingService.class);
        promotionsService = Mockito.mock(PromotionsService.class);
        basket = new Basket();
        checkoutContext = Mockito.spy(new CheckoutContext(basket));
    }

    @Test
    void setPriceZeroForEmptyBasket() {

        RetailPriceCheckoutStep retailPriceCheckoutStep = new RetailPriceCheckoutStep(pricingService);

        retailPriceCheckoutStep.execute(checkoutContext);

        Mockito.verify(checkoutContext).setRetailPriceTotal(0.0);
    }

    @Test
    void setPriceOfProductToBasketItem() {

        basket.add("product1", "myproduct1", 10);
        basket.add("product2", "myproduct2", 10);

        when(pricingService.getPrice("product1")).thenReturn(3.99);
        when(pricingService.getPrice("product2")).thenReturn(2.0);
        RetailPriceCheckoutStep retailPriceCheckoutStep = new RetailPriceCheckoutStep(pricingService);

        retailPriceCheckoutStep.execute(checkoutContext);
        Mockito.verify(checkoutContext).setRetailPriceTotal(3.99 * 10 + 2 * 10);

    }

    @Test
    void testWithPromotionApplied() {
        double price = 2.0;
        int qtd = 10;

        Promotion promotion = Promotion.TEN_OFF;
        basket.add(promotion.getProductCode(), "myproduct1", qtd);
        when(checkoutContext.getPromotions()).thenReturn(Collections.singletonList(promotion));
        when(pricingService.getPrice(promotion.getProductCode())).thenReturn(price);

        RetailPriceCheckoutStep retailPriceCheckoutStep = new RetailPriceCheckoutStep(pricingService);
        retailPriceCheckoutStep.execute(checkoutContext);

        Mockito.verify(checkoutContext).setRetailPriceTotal((price * qtd) - (price * qtd * 0.1));
    }
}
