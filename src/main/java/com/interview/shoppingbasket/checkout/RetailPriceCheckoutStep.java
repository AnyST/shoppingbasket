package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.PricingService;
import com.interview.shoppingbasket.basket.Basket;
import com.interview.shoppingbasket.basket.BasketItem;
import com.interview.shoppingbasket.promotion.Promotion;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RequiredArgsConstructor
public class RetailPriceCheckoutStep implements CheckoutStep {
    private final PricingService pricingService;

    @Override
    public void execute(CheckoutContext context) {
        Basket basket = context.getBasket();
        double retailTotal = 0.0;

        for (final BasketItem item : basket.getItems()) {
            double price = pricingService.getPrice(item.getProductCode());
            item.setProductRetailPrice(price);
            if (!context.getPromotions().isEmpty()) {
                BigDecimal priceWithPromotions = context.getPromotions().stream()
                        .reduce(BigDecimal.valueOf(price), (totalPrice, promotion) -> applyPromotion(promotion, item), BigDecimal::subtract);
                retailTotal += priceWithPromotions.doubleValue();
            } else {
                retailTotal += item.getQuantity() * price;
            }
        }
        context.setRetailPriceTotal(retailTotal);
    }

    private BigDecimal applyPromotion(final Promotion promotion, final BasketItem item) {
        String productCode = item.getProductCode();
        double price = 0;

        if (promotion.getProductCode().equals(productCode)) {
            price = promotion.apply(item.getProductRetailPrice(), item.getQuantity());
        }

        if (!promotion.isQtdUsed()) {
            price *= item.getQuantity();
        }
        return BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_DOWN);
    }
}
