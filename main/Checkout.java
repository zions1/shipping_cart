package main;

import main.service.OfferServiceFactory;

import java.text.NumberFormat;
import java.util.List;

import static java.util.Collections.frequency;

public class Checkout {

    private static final double APPLE_COST = 0.60;
    private static final double ORANGE_COST = 0.25;
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
        return NumberFormat.getCurrencyInstance().format(calculate(items));
    }

    /**
     * Calculates the total cost of the list of items.
     * @param items The list of items.
     * @return The total cost.
     */
    private double calculate(List<String> items) {
        double total = 0;
        int applesFreq = frequency(items, APPLE);
        total += offerServiceFactory.dedicatedFor(APPLE).apply(applesFreq, APPLE_COST);

        int orangesFreq = frequency(items, ORANGE);
        total += offerServiceFactory.dedicatedFor(ORANGE).apply(orangesFreq, ORANGE_COST);
        return total;
    }

}
