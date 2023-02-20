package com.interview.shoppingbasket.promotion;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.BiFunction;


@AllArgsConstructor
public enum Promotion implements BiFunction<Double, Integer, Double> {
    TWO_BY_ONE("productCode", true, (price, qtd) -> {
        if (qtd % 2 == 0) {
            return price * qtd * 0.5;
        } else {
            return price * (qtd - 1) * 0.5 + price;
        }
    }),
    FIFTY_OFF("productCode1", false, (price, qtd) -> price * 0.5),
    TEN_OFF("productCode2", false, (price, qtd) -> price * 0.9),
    ;
    @Getter
    private final String productCode;
    @Getter
    private final boolean qtdUsed;
    private final BiFunction<Double, Integer, Double> fun;


    @Override
    public final Double apply(Double price, Integer qtd) {
        return fun.apply(price, qtd);
    }
}
