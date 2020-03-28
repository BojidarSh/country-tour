package com.neighbours.countrytour.service.implementation;

import com.neighbours.countrytour.configuration.AppConfig;
import com.neighbours.countrytour.dto.CurrencyRates;
import com.neighbours.countrytour.util.Values;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@DisplayName("Testing CurrencyServiceImpl")
@SpringBootTest
class CurrencyServiceImplTest {

    @Autowired
    private CurrencyServiceImpl currencyService;

    @DisplayName("Testing method getRates(..)")
    @Test
    void getRates() {

        CurrencyRates rates = currencyService.getRates(Values.CurrencyCodes.EUROPEAN_UNION_CURRENCY,
                Values.CurrencyCodes.BULGARIA_CURRENCY, Values.CurrencyCodes.ROMANIA_CURRENCY);

        assertNotNull(rates);
        assertEquals(Values.CurrencyCodes.EUROPEAN_UNION_CURRENCY, rates.getBase());
        assertNotNull(rates.getRates());
        assertEquals(2, rates.getRates().size());

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        double bgnRate = rates.getRates().get(Values.CurrencyCodes.BULGARIA_CURRENCY);
        String actualBgnRateString = decimalFormat.format(bgnRate);
        actualBgnRateString = actualBgnRateString.substring(0, actualBgnRateString.length() - 1);
        assertEquals("1,9", actualBgnRateString);

        double ronRate = rates.getRates().get(Values.CurrencyCodes.ROMANIA_CURRENCY);
        String actualRonRateString = decimalFormat.format(ronRate);
        actualRonRateString = actualRonRateString.substring(0, actualRonRateString.length() - 1);
        assertEquals("4,8", actualRonRateString);
    }
}