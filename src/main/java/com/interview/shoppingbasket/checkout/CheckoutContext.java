package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;
import com.interview.shoppingbasket.promotion.Promotion;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
class CheckoutContext {
    private final List<Promotion> promotions = new ArrayList<>();
    private final Basket basket;
    private double retailPriceTotal = 0.0;

    public PaymentSummary paymentSummary() {
        return new PaymentSummary(retailPriceTotal);
    }
}
