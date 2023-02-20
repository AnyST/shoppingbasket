package com.interview.shoppingbasket.checkout.step;

import com.interview.shoppingbasket.basket.Basket;
import com.interview.shoppingbasket.checkout.CheckoutContext;
import com.interview.shoppingbasket.checkout.step.CheckoutStep;
import com.interview.shoppingbasket.promotion.Promotion;
import com.interview.shoppingbasket.promotion.PromotionsService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ApplyPromotionCheckoutStep implements CheckoutStep {

    private final PromotionsService promotionsService;

    @Override
    public void execute(final CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        List<Promotion> promotions = promotionsService.getPromotions(basket);
        checkoutContext.getPromotions().addAll(promotions);
    }
}
