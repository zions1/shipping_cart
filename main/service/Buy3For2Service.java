package main.service;

public class Buy3For2Service implements OfferService {

    /**
     * Applies buy 3 for 2 offer
     * @param numberOfItems The number of items.
     * @param costOfItem The cost of items.
     * @return The total cost.
     */
    @Override
    public double apply(Integer numberOfItems, Double costOfItem) {
        return numberOfItems != 0 ? (numberOfItems / 3) * 2 * costOfItem + (numberOfItems % 3) * costOfItem : 0;
    }
}
