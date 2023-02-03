package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;

public class BasketConsolidationCheckoutStep implements CheckoutStep {

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        basket.consolidateItems();
    }
}
