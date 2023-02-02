package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;
import com.interview.shoppingbasket.checkout.CheckoutContext;
import com.interview.shoppingbasket.checkout.CheckoutStep;

public class BasketConsolidationCheckoutStep implements CheckoutStep {

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        basket.consolidateItems();
    }
}
