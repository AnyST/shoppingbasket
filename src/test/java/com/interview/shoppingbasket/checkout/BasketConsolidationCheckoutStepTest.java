package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class BasketConsolidationCheckoutStepTest {

    @Test
    void basketConsolidationCheckoutStepTest() {
        CheckoutContext checkoutContext = Mockito.mock(CheckoutContext.class);
        Basket basket = Mockito.mock(Basket.class);

        when(checkoutContext.getBasket()).thenReturn(basket);

        BasketConsolidationCheckoutStep basketConsolidationCheckoutStep = new BasketConsolidationCheckoutStep();
        basketConsolidationCheckoutStep.execute(checkoutContext);

        Mockito.verify(checkoutContext).getBasket();
        Mockito.verify(basket).consolidateItems();
    }

}
