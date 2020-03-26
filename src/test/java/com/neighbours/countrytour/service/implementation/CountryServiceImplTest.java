package com.neighbours.countrytour.service.implementation;

import com.neighbours.countrytour.configuration.AppConfig;
import com.neighbours.countrytour.dto.Country;
import com.neighbours.countrytour.service.template.CountryService;
import com.neighbours.countrytour.util.Values;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@DisplayName("Testing CountryServiceImpl")
@SpringBootTest
class CountryServiceImplTest {

    @Autowired
    private CountryService countryService;

    @DisplayName("Testing method getCountry(..)")
    @Test
    void getCountry() {

        Country country = countryService.getCountry("Bulgaria");

        assertNotNull(country);
        assertEquals(Values.CountryNames.BULGARIA, country.getName());
        assertEquals(Values.CountryCodes.ROMANIA_CODE, country.getBorders().get(2));
        assertEquals(Values.CurrencyCodes.BULGARIA_CURRENCY, country.getCurrencies().get(0));
    }

    @DisplayName("Testing method getCountriesByCodes(..)")
    @Test
    void getCountriesByCodes() {

        List<Country> countries = countryService.getCountriesByCodes(Arrays.asList(new String[]{"MKD", "ROU"}));

        assertNotNull(countries);
        assertEquals(2, countries.size());

        Country macedonia = countries.get(0);
        assertNotNull(macedonia);
        assertEquals(Values.CountryNames.MACEDONIA, macedonia.getName());
        assertEquals(Values.CountryCodes.SERBIA_CODE, macedonia.getBorders().get(4));
        assertEquals(Values.CountryCodes.MACEDONIA_CODE, macedonia.getCurrencies().get(0));

        Country romania = countries.get(1);
        assertNotNull(romania);
        assertEquals(Values.CountryNames.ROMANIA, romania.getName());
        assertEquals(Values.CountryCodes.HUNGARY_CODE, romania.getBorders().get(1));
        assertEquals(Values.CountryCodes.ROMANIA_CODE, romania.getCurrencies().get(0));
    }
}