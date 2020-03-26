package com.neighbours.countrytour.service.implementation;

import com.neighbours.countrytour.dto.CurrencyRates;
import com.neighbours.countrytour.service.template.CurrencyService;
import com.neighbours.countrytour.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The type Currency service.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);

    @Value("${currencyMethodURL}")
    private String currencyMethodURL;

    /**
     * Get the rates of all provided currencies according to the base currency provided.
     *
     * @param baseCurrency
     * @param currencies
     * @return
     */
    @Override
    public CurrencyRates getRates(String baseCurrency, String... currencies) {

        final String currenciesStr = Arrays.asList(currencies).stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(","));

        final String uri = currencyMethodURL
                .replace(Constants.ParameterHolders.BASE_CURRENCY, baseCurrency)
                .replace(Constants.ParameterHolders.CURRENCIES, currenciesStr);
        return executeCurrencyMethod(uri);
    }

    //populates the http headers needed for method execution
    private HttpHeaders populateMethodHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    //executes currency info retrieval api method
    private CurrencyRates executeCurrencyMethod(String uri) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>("parameters", populateMethodHeaders());
        ResponseEntity<CurrencyRates> result = restTemplate.exchange(uri, HttpMethod.GET, entity, CurrencyRates.class);

        logger.info("Currency rates returned: {}", result.getBody());

        return result.getBody();
    }
}
