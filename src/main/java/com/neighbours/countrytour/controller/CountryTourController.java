package com.neighbours.countrytour.controller;

import com.neighbours.countrytour.response.CountryTourResponse;
import com.neighbours.countrytour.service.template.CountryTourService;
import com.neighbours.countrytour.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@RestController
@RequestMapping(Constants.Api.PATH)
@Validated
public class CountryTourController {

    private final CountryTourService countryTourService;

    public CountryTourController(CountryTourService countryTourService) {
        this.countryTourService = countryTourService;
    }


    @GetMapping(Constants.Api.METHOD_TOURS)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    CountryTourResponse tours(@Valid @Size(max = 50) @RequestParam(defaultValue = "Bulgaria") String country,
                             @Valid @Max(5000) @RequestParam(defaultValue = "200") int budgetPerCountry,
                             @Valid @Max(50000) @RequestParam(defaultValue = "2000") int totalBudget,
                             @Valid @Size(max = 3) @RequestParam(defaultValue = "EUR") String currency,
                             @Valid @Size(max = 10) @RequestParam String requestId,
                             @Valid @Size(max = 36) @RequestParam String flowId) {

        return countryTourService.calculateTours(country, budgetPerCountry, totalBudget, currency, requestId, flowId);
    }
}
