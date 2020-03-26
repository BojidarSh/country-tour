package com.neighbours.countrytour.service.implementation;

import com.neighbours.countrytour.dto.Country;
import com.neighbours.countrytour.dto.CurrencyRates;
import com.neighbours.countrytour.dto.Money;
import com.neighbours.countrytour.response.CountryTourResponse;
import com.neighbours.countrytour.response.builder.CountryTourResponseBuilder;
import com.neighbours.countrytour.service.template.CountryService;
import com.neighbours.countrytour.service.template.CountryTourService;
import com.neighbours.countrytour.service.template.CurrencyService;
import com.neighbours.countrytour.service.template.TourBudgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountryTourServiceImpl implements CountryTourService {

    Logger logger = LoggerFactory.getLogger(CountryTourServiceImpl.class);

    private final CountryService countryService;
    private final CurrencyService currencyService;
    private final TourBudgetService tourBudgetService;

    public CountryTourServiceImpl(CountryService countryService, CurrencyService currencyService, TourBudgetService tourBudgetService) {
        this.countryService = countryService;
        this.currencyService = currencyService;
        this.tourBudgetService = tourBudgetService;
    }

    @Override
    public CountryTourResponse calculateTours(String country, int budgetPerCountry, int totalBudget, String currency, String requestId, String flowId) {

        Country baseCountry = countryService.getCountry(country);
        logger.info("Base country found {}.", baseCountry);

        int neighbourCountriesCount = baseCountry.getBorders().size();
        int fullToursCount = tourBudgetService.getFullToursCount(budgetPerCountry, totalBudget, neighbourCountriesCount);
        int leftover = tourBudgetService.getLeftover(budgetPerCountry, totalBudget, neighbourCountriesCount, fullToursCount);

        List<Country> neighbours = countryService.getCountriesByCodes(baseCountry.getBorders());

        Map<String, Money> neighboursResult = new HashMap<>();
        neighbours.forEach(neighbourCountry -> {

            String neighbourCurrencyCode = currency;
            if (neighbourCountry.getCurrencies() != null && neighbourCountry.getCurrencies().size() > 0) {
                neighbourCurrencyCode = neighbourCountry.getCurrencies().get(0);
            }

            double neededMoneyPerCountry = Double.valueOf(budgetPerCountry);
            try {
                CurrencyRates currencyRates = currencyService.getRates(currency, neighbourCurrencyCode);
                logger.info("Neighbour {}, currency rates found: {}", neighbourCountry, currencyRates);

                neededMoneyPerCountry = budgetPerCountry * currencyRates.getRates().get(neighbourCurrencyCode) * fullToursCount;
            } catch (HttpClientErrorException httpClientErrorException) {
                neighbourCurrencyCode = currency;
                logger.error("Exception: {}", httpClientErrorException.getMessage());
            }

            Money neighbourMoney = new Money(neighbourCurrencyCode, Math.round(neededMoneyPerCountry * 100.0) / 100.0);
            neighboursResult.put(neighbourCountry.getName(), neighbourMoney);
        });

        return new CountryTourResponseBuilder()
                .leftover(new Money(currency, Math.round(leftover * 100.0) / 100.0))
                .neighbours(neighboursResult)
                .neighboursCount(neighbourCountriesCount)
                .startingCountry(baseCountry.getName())
                .toursCount(fullToursCount)
                .requestId(requestId)
                .flowId(flowId)
                .build();
    }
}
