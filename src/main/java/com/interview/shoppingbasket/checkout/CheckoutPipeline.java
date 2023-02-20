package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;
import com.interview.shoppingbasket.checkout.step.CheckoutStep;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPipeline {

    private final List<CheckoutStep> steps = new ArrayList<>();

    public PaymentSummary checkout(final Basket basket) {
        final CheckoutContext checkoutContext = new CheckoutContext(basket);
        steps.forEach( e -> e.execute(checkoutContext));
        return checkoutContext.paymentSummary();
    }

    public void add(final CheckoutStep step) {
        steps.add(step);
    }
}
