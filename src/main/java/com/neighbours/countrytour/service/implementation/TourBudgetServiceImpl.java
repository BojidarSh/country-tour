package com.neighbours.countrytour.service.implementation;

import com.neighbours.countrytour.service.template.TourBudgetService;
import org.springframework.stereotype.Service;

@Service
public class TourBudgetServiceImpl implements TourBudgetService {

    /**
     * Calculates the exact count of full tours the user will be able to make based on the total budget and on the budget per country.
     *
     * @param budgetPerCountry
     * @param totalBudget
     * @param neighbourCountriesCount
     * @return
     */
    @Override
    public int getFullToursCount(int budgetPerCountry, int totalBudget, int neighbourCountriesCount) {

        //calculates the budged for full tour in all countries
        int fullTourBudget = calculateFullTourBudget(budgetPerCountry, neighbourCountriesCount);

        //calculates the exact count of full tours the user will be able to make
        return totalBudget / fullTourBudget;
    }

    /**
     * Calculates the leftover based on the full tour count.
     *
     * @param budgetPerCountry
     * @param totalBudget
     * @param neighbourCountriesCount
     * @param fullToursCount
     * @return
     */
    @Override
    public int getLeftover(int budgetPerCountry, int totalBudget, int neighbourCountriesCount, int fullToursCount) {

        //calculates the budged for full tour in all countries
        int fullTourBudget = calculateFullTourBudget(budgetPerCountry, neighbourCountriesCount);

        //calculates the total budget needed for all full tours
        int totalBudgetNeeded = fullToursCount * fullTourBudget;

        //calculates the leftover
        return totalBudget - totalBudgetNeeded;
    }

    /**
     * Calculates the budged for full tour in all countries
     *
     * @param budgetPerCountry
     * @param neighbourCountriesCount
     * @return
     */
    private int calculateFullTourBudget(int budgetPerCountry, int neighbourCountriesCount) {

        return budgetPerCountry * neighbourCountriesCount;
    }
}
