package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;
import com.interview.shoppingbasket.promotion.Promotion;
import com.interview.shoppingbasket.promotion.PromotionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

class ApplyPromotionCheckoutStepTest {

    PromotionsService promotionsService;
    CheckoutContext checkoutContext;
    Basket basket;

    @BeforeEach
    void setup() {
        promotionsService = Mockito.mock(PromotionsService.class);
        checkoutContext = Mockito.mock(CheckoutContext.class);
        basket = new Basket();

        when(checkoutContext.getBasket()).thenReturn(basket);
    }

    @Test
    void applyPromotionCheckoutStepTest() {
        List<Promotion> promotions = Mockito.spy(new ArrayList<>());

        when(checkoutContext.getBasket()).thenReturn(basket);
        when(checkoutContext.getPromotions()).thenReturn(promotions);

        ApplyPromotionCheckoutStep applyPromotionCheckoutStep = new ApplyPromotionCheckoutStep(promotionsService);
        applyPromotionCheckoutStep.execute(checkoutContext);

        Mockito.verify(checkoutContext).getBasket();
        Mockito.verify(checkoutContext).getBasket();
        Mockito.verify(promotionsService).getPromotions(basket);
        Mockito.verify(promotions).addAll(anyList());
    }
}
