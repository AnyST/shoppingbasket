package com.interview.shoppingbasket.checkout;

import com.interview.shoppingbasket.basket.Basket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutPipelineTest {

    CheckoutPipeline checkoutPipeline;

    @Mock
    Basket basket;

    @Mock
    CheckoutStep checkoutStep1;

    @Mock
    CheckoutStep checkoutStep2;

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
        // Exercise - implement testing passing through all checkout steps
    }
}
