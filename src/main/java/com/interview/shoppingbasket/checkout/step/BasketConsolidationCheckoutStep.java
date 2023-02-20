package com.interview.shoppingbasket.checkout.step;

import com.interview.shoppingbasket.basket.Basket;
import com.interview.shoppingbasket.checkout.CheckoutContext;
import com.interview.shoppingbasket.checkout.step.CheckoutStep;

public class BasketConsolidationCheckoutStep implements CheckoutStep {

    @Override
    public void execute(final CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        basket.consolidateItems();
    }
}
