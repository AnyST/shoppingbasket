package com.interview.shoppingbasket.checkout.step;


import com.interview.shoppingbasket.checkout.CheckoutContext;

public interface CheckoutStep {
    void execute(final CheckoutContext ctx);
}
