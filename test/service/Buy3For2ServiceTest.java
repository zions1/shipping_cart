package test.service;

import main.service.Buy3For2Service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class Buy3For2ServiceTest {

    private Buy3For2Service buy3For2Service;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        buy3For2Service = new Buy3For2Service();
    }

    @org.junit.jupiter.api.Test
    void shouldApplyBuy3For2Offer() {
        assertThat("1 Item ", buy3For2Service.apply(1, 0.25), is(0.25));
        assertThat("2 Items", buy3For2Service.apply(2, 0.25), is(0.50));
        assertThat("3 Items", buy3For2Service.apply(3, 0.25), is(0.50));
        assertThat("4 Items", buy3For2Service.apply(4, 0.25), is(0.75));
    }

}