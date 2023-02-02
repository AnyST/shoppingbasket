package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.PricingService;
import com.interview.shoppingbasket.basket.Basket;
import com.interview.shoppingbasket.basket.BasketItem;
import com.interview.shoppingbasket.promotion.Promotion;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RetailPriceCheckoutStep implements CheckoutStep {
    private final PricingService pricingService;
    private double retailTotal;

    @Override
    public void execute(CheckoutContext context) {
        Basket basket = context.getBasket();
        retailTotal = 0.0;

        for (final BasketItem bi : basket.getItems()) {
            int quantity = bi.getQuantity();
            double price = pricingService.getPrice(bi.getProductCode());
            bi.setProductRetailPrice(price);
            retailTotal += quantity*price;
        }
        context.setRetailPriceTotal(retailTotal);
    }

    public double applyPromotion(Promotion promotion, BasketItem item, double price) {
        /*
         * Implement applyPromotion method
         */
        return retailTotal;
    }
}
