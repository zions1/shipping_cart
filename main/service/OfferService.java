package main.service;

public interface OfferService {

    /**
     * Applies special offer offer
     * @param numberOfItems The number of items.
     * @param costOfItem The cost of items.
     * @return The total cost.
     */
    double apply(Integer numberOfItems, Double costOfItem);
}
