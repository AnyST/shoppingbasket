package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPipeline {

    private final List<CheckoutStep> steps = new ArrayList<>();

    public PaymentSummary checkout(final Basket basket) {
        CheckoutContext checkoutContext = new CheckoutContext(basket);
        for (CheckoutStep checkoutStep : steps) {
            checkoutStep.execute(checkoutContext);
        }
        return checkoutContext.paymentSummary();
    }

    public void add(final CheckoutStep step) {
        steps.add(step);
    }
}
