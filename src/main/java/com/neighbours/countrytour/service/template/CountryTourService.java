package com.neighbours.countrytour.service.template;

import com.neighbours.countrytour.response.CountryTourResponse;

public interface CountryTourService {

    CountryTourResponse calculateTours(String country, int budgetPerCountry, int totalBudget, String currency, String requestId, String flowId);
}