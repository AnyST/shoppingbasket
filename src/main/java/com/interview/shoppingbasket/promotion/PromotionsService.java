package com.interview.shoppingbasket.promotion;

import com.interview.shoppingbasket.basket.Basket;

import java.util.List;

interface PromotionsService {
    List<Promotion> getPromotions(Basket basket);
}
