package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;
import com.interview.shoppingbasket.promotion.Promotion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class CheckoutContext {
    private final Basket basket;
    private double retailPriceTotal = 0.0;
    private final List<Promotion> promotions = new ArrayList<>();

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
