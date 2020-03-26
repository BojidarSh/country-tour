package com.neighbours.countrytour.service.template;

import com.neighbours.countrytour.dto.CurrencyRates;

//CurrencyService template
public interface CurrencyService {

    CurrencyRates getRates(String baseCurrency, String... currencies);
}