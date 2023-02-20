package com.interview.shoppingbasket.basket;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class Basket {
    private final List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem(productCode, quantity);
        basketItem.setProductName(productName);
        items.add(basketItem);
    }

    public void consolidateItems() {
        // Exercise - implement this function
        Map<String, BasketItem> a = items.stream().collect(
                Collectors.toMap(BasketItem::getProductCode,
                                Function.identity(),
                                (bi1, bi2) ->
                                    new BasketItem(bi1.getProductCode(),
                            bi1.getQuantity() + bi2.getQuantity())));


        items.clear();
        items.addAll(a.values());
    }
}
