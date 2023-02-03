package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class CheckoutPipelineTest {


    CheckoutPipeline checkoutPipeline;

    @Mock
    Basket basket;

    @BeforeEach
    void setup() {
        checkoutPipeline = new CheckoutPipeline();
    }

    @Test
    void returnZeroPaymentForEmptyPipeline() {
        PaymentSummary paymentSummary = checkoutPipeline.checkout(basket);

        assertEquals(0.0, paymentSummary.getRetailTotal());
    }

    @Test
    void executeAllPassedCheckoutSteps() {
        CheckoutStep checkoutStep = Mockito.mock(CheckoutStep.class);

        checkoutPipeline.add(checkoutStep);
        checkoutPipeline.checkout(basket);

        verify(checkoutStep).execute(any());
    }
}
