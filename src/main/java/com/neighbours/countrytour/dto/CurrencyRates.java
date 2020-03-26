package com.neighbours.countrytour.dto;

import java.util.Map;
import java.util.StringJoiner;

/**
 * The type CurrencyRates.
 */
public class CurrencyRates {

    private String base;
    private Map<String, Double> rates;

    /**
     * Gets base.
     *
     * @return the base currency.
     */
    public String getBase() {
        return base;
    }

    /**
     * Sets base.
     *
     * @param base the base currency.
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * Gets rates.
     *
     * @return the rates according to base currency.
     */
    public Map<String, Double> getRates() {
        return rates;
    }

    /**
     * Sets rates.
     *
     * @param rates the rates according to base currency.
     */
    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CurrencyRates.class.getSimpleName() + "[", "]")
                .add("base='" + base + "'")
                .add("rates=" + rates)
                .toString();
    }
}
