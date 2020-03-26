package com.neighbours.countrytour.service.implementation;

import com.neighbours.countrytour.dto.Country;
import com.neighbours.countrytour.service.template.CountryService;
import com.neighbours.countrytour.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Country service.
 */
@Service
public class CountryServiceImpl implements CountryService {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Value("${countryMethodURL}")
    private String countryMethodURL;

    @Value("${countriesMethodURL}")
    private String countriesMethodURL;

    @Value("${countryMethodHeaderHostName}")
    private String countryMethodHeaderHostName;

    @Value("${countryMethodHeaderHostValue}")
    private String countryMethodHeaderHostValue;

    @Value("${countryMethodHeaderKeyName}")
    private String countryMethodHeaderKeyName;

    @Value("${countryMethodHeaderKeyValue}")
    private String countryMethodHeaderKeyValue;

    /**
     * Gets country info, by country code or country name.
     *
     * @param country the country
     * @return the country
     */
    @Override
    public Country getCountry(String country) {

        final String uri = countryMethodURL.replace(Constants.ParameterHolders.COUNTRY, country);
        return executeCountryMethod(uri).get(0);
    }

    /**
     * Gets countries info by country names or country codes.
     *
     * @param countries the countries
     * @return the countries by codes
     */
    @Override
    public List<Country> getCountriesByCodes(List<String> countries) {

        final String countriesString = countries.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(";"));
        final String uri = countriesMethodURL.replace(Constants.ParameterHolders.COUNTRIES, countriesString);
        return executeCountryMethod(uri);
    }

    //populates the http headers needed for method execution
    private HttpHeaders populateMethodHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set(countryMethodHeaderHostName, countryMethodHeaderHostValue);
        headers.set(countryMethodHeaderKeyName, countryMethodHeaderKeyValue);
        return headers;
    }

    //executes country info retrieval api method
    private List<Country> executeCountryMethod(String uri) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>("parameters", populateMethodHeaders());
        ResponseEntity<List<Country>> result = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Country>>() {
        });

        logger.info("Countries returned: {}", result.getBody());

        return result.getBody();
    }
}
