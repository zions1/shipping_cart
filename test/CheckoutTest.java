package test;

import main.Checkout;
import main.service.OfferServiceFactory;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class CheckoutTest {

    private Checkout checkout;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        checkout = new Checkout(new OfferServiceFactory());
    }

    @org.junit.jupiter.api.Test
    void shouldPrintTotalCostsAfterBuyOneGetOneFreeOffer() {
        assertThat("1 Apple ", checkout.printTotalCosts(asList("Apple")), is("£0.60"));
        assertThat("2 Apples", checkout.printTotalCosts(asList("Apple", "Apple")), is("£0.60"));
        assertThat("3 Apples", checkout.printTotalCosts(asList("Apple", "Apple", "Apple")), is("£1.20"));
        assertThat("4 Apples", checkout.printTotalCosts(asList("Apple", "Apple", "Apple", "Apple")), is("£1.20"));
    }

    @org.junit.jupiter.api.Test
    void shouldPrintTotalCostsAfterBuyThreeForTwoOffer() {
        assertThat("1 Orange ", checkout.printTotalCosts(asList("Orange")), is("£0.25"));
        assertThat("2 Oranges", checkout.printTotalCosts(asList("Orange", "Orange")), is("£0.50"));
        assertThat("3 Oranges", checkout.printTotalCosts(asList("Orange", "Orange", "Orange")), is("£0.50"));
        assertThat("4 Oranges", checkout.printTotalCosts(asList("Orange", "Orange", "Orange", "Orange")), is("£0.75"));
    }
}