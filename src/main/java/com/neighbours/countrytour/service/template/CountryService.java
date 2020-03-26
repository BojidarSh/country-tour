package com.neighbours.countrytour.service.template;

import com.neighbours.countrytour.dto.Country;

import java.util.List;

//CountryService template
public interface CountryService {

    Country getCountry(String country);

    List<Country> getCountriesByCodes(List<String> countries);
}