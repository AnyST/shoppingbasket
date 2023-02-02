package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;
import lombok.Data;

@Data
class CheckoutContext {
    private final Basket basket;
    private double retailPriceTotal = 0.0;

    public void setRetailPriceTotal(double retailPriceTotal) {
        this.retailPriceTotal = retailPriceTotal;
    }

    public PaymentSummary paymentSummary() {
        return new PaymentSummary(retailPriceTotal);
    }

    public Basket getBasket() {
        return basket;
    }
}
