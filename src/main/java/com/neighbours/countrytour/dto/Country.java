package com.neighbours.countrytour.dto;

import java.util.List;
import java.util.StringJoiner;

/**
 * The type Country.
 */
public class Country {

    private String name;
    private List<String> borders;
    private List<String> currencies;

    /**
     * Gets name.
     *
     * @return the name of the country.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name of the country.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets borders.
     *
     * @return the border countries of the country.
     */
    public List<String> getBorders() {
        return borders;
    }

    /**
     * Sets borders.
     *
     * @param borders the border countries of the country.
     */
    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    /**
     * Gets currencies.
     *
     * @return the currencies of the country.
     */
    public List<String> getCurrencies() {
        return currencies;
    }

    /**
     * Sets currencies.
     *
     * @param currencies the currencies of the country.
     */
    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Country.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("borders=" + borders)
                .add("currencies=" + currencies)
                .toString();
    }
}