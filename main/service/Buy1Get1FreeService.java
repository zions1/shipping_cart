package main.service;

public class Buy1Get1FreeService implements OfferService {

    /**
     * Applies buy 1 get 1 free offer
     * @param numberOfItems The number of items.
     * @param costOfItem The cost of items.
     * @return The total cost.
     */
    @Override
    public double apply(Integer numberOfItems, Double costOfItem) {
        return numberOfItems != 0 ? (numberOfItems / 2) * costOfItem + (numberOfItems % 2) * costOfItem : 0;
    }

}
