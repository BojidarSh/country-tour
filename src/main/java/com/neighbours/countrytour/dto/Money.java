package com.neighbours.countrytour.dto;

import java.util.StringJoiner;

/**
 * The type Country amount.
 */
public class Money {

    private String currency;

    private double amount;

    public Money(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Money.class.getSimpleName() + "[", "]")
                .add("currency='" + currency + "'")
                .add("amount=" + amount)
                .toString();
    }
}
