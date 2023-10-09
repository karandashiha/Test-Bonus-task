package org.example.app.service;

import org.example.app.utils.Rounder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {
    private BonusService bonusService;

    @BeforeEach
    void setUp() {
        bonusService = new BonusService();
    }

    @Test
    void testCalcBonusWithExpectedResult() {
        double sales = 1000.0;
        double expectedBonus = sales * BonusService.BONUS_RATE / 100;

        String result = bonusService.getRes(sales);

        assertEquals(Rounder.roundValue(expectedBonus), result);
    }

    @Test
    void testCalcBonusWithUnexpectedResult() {
        double sales = -1000.0;

        String result = bonusService.getRes(sales);

        assertEquals("Incorrect value!", result);
    }

}