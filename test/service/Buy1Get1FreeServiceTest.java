package test.service;

import main.service.Buy1Get1FreeService;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class Buy1Get1FreeServiceTest {

    private Buy1Get1FreeService buy1Get1FreeService;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        buy1Get1FreeService = new Buy1Get1FreeService();
    }

    @org.junit.jupiter.api.Test
    void shouldApplyBuy1Get1FreeOffer() {
        assertThat("1 Item ", buy1Get1FreeService.apply(1, 60), is(60));
        assertThat("2 Items", buy1Get1FreeService.apply(2, 60), is(60));
        assertThat("3 Items", buy1Get1FreeService.apply(3, 60), is(120));
    }

}