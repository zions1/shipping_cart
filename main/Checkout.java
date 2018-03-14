package main;

import main.service.OfferServiceFactory;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import static java.util.Collections.frequency;

public class Checkout {

    private static final int APPLE_COST = 60;
    private static final int ORANGE_COST = 25;
    private static final String APPLE = "Apple";
    private static final String ORANGE = "Orange";

    private OfferServiceFactory offerServiceFactory;

    public Checkout(OfferServiceFactory offerServiceFactory) {
        this.offerServiceFactory = offerServiceFactory;
    }

    /**
     * Prints the total cost of the list of items.
     * @param items The list of items.
     * @return The total cost.
     */
    public String printTotalCosts(List<String> items){
        BigDecimal total = new BigDecimal(calculate(items) * 0.01);
        return NumberFormat.getCurrencyInstance().format(total);
    }

    /**
     * Calculates the total cost of the list of items.
     * @param items The list of items.
     * @return The total cost.
     */
    private int calculate(List<String> items) {
        int total = 0;
        int applesFreq = frequency(items, APPLE);
        total += offerServiceFactory.dedicatedFor(APPLE).apply(applesFreq, APPLE_COST);

        int orangesFreq = frequency(items, ORANGE);
        total += offerServiceFactory.dedicatedFor(ORANGE).apply(orangesFreq, ORANGE_COST);
        return total;
    }

}
