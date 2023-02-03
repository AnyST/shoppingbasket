package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;
import com.interview.shoppingbasket.promotion.Promotion;
import com.interview.shoppingbasket.promotion.PromotionsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplyPromotionCheckoutStepTest {

    @Test
    void applyPromotionCheckoutStepTest() {

        CheckoutContext checkoutContext = Mockito.mock(CheckoutContext.class);
        Basket basket = Mockito.mock(Basket.class);
        PromotionsService promotionsService = Mockito.mock(PromotionsService.class);
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
