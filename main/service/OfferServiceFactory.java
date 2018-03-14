package main.service;

public class OfferServiceFactory {

    /**
     * Dedicates the suitable offer to item.
     * @param name The name of the item.
     * @return The suitable offer.
     */
    public OfferService dedicatedFor(String name) {
        switch (name.toLowerCase()) {
            case ("apple"):
                return new Buy1Get1FreeService();
            case ("orange"):
                return new Buy3For2Service();
            default:
                throw new IllegalArgumentException("Item not listed: " + name);
        }
    }
}
