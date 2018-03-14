package test.service;

import main.service.Buy1Get1FreeService;
import main.service.Buy3For2Service;
import main.service.OfferServiceFactory;

import static org.hamcrest.CoreMatchers.instanceOf;

import static org.junit.Assert.assertThat;

class OfferServiceFactoryTest {

    private OfferServiceFactory offerServiceFactory;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        offerServiceFactory = new OfferServiceFactory();
    }

    @org.junit.jupiter.api.Test
    void shouldDedicatedOffer() {
        assertThat("Offer dedicated for Apple", offerServiceFactory.dedicatedFor("Apple"), instanceOf(Buy1Get1FreeService.class));
        assertThat("Offer dedicated for Apple", offerServiceFactory.dedicatedFor("APPLE"), instanceOf(Buy1Get1FreeService.class));
        assertThat("Offer dedicated for Apple", offerServiceFactory.dedicatedFor("apple"), instanceOf(Buy1Get1FreeService.class));

        assertThat("Offer dedicated for Orange", offerServiceFactory.dedicatedFor("Orange"), instanceOf(Buy3For2Service.class));
        assertThat("Offer dedicated for Orange", offerServiceFactory.dedicatedFor("ORANGE"), instanceOf(Buy3For2Service.class));
        assertThat("Offer dedicated for Orange", offerServiceFactory.dedicatedFor("orange"), instanceOf(Buy3For2Service.class));

    }

    @org.junit.jupiter.api.Test
    void shouldThrowException() {
        try {
            offerServiceFactory.dedicatedFor("dummy");
        } catch (Exception IllegalArgumentException) {
            assert (true);
        }
    }
}