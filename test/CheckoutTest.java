package test;

import main.Checkout;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class CheckoutTest {

    private Checkout checkout;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        checkout = new Checkout();
    }

    @org.junit.jupiter.api.Test
    void shouldPrintTotalCosts() {

        assertThat("1 Apple", checkout.printTotalCosts(asList("Apple")), is("£0.60"));
        assertThat("1 Orange", checkout.printTotalCosts(asList("Orange")), is("£0.25"));
        assertThat("3 Apples, 1 Orange", checkout.printTotalCosts(asList("Apple", "Apple", "Orange", "Apple")), is("£2.05"));
    }
}