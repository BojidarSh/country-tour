package com.neighbours.countrytour.service.template;

//TourBudgetService template
public interface TourBudgetService {

    int getFullToursCount(int budgetPerCountry, int totalBudget, int neighbourCountriesCount);

    int getLeftover(int budgetPerCountry, int totalBudget, int neighbourCountriesCount, int fullToursCount);
}
