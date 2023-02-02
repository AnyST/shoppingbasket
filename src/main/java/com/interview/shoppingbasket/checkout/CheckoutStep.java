package com.interview.shoppingbasket.checkout;

interface CheckoutStep {
    void execute(final CheckoutContext ctx);
}
