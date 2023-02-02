package com.interview.shoppingbasket;

import lombok.Data;

@Data
public class BasketItem {
    private final String productCode;
    private final int quantity;
    private String productName;
    private double productRetailPrice;

}
