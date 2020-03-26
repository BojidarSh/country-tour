package com.neighbours.countrytour.response.builder;

import com.neighbours.countrytour.dto.Money;
import com.neighbours.countrytour.response.CountryTourResponse;

import java.util.Map;

/**
 * The type Country tour response builder.
 */
public class CountryTourResponseBuilder {

    private String startingCountry;

    private int neighboursCount;

    private int toursCount;

    private Map<String, Money> neighbours;

    private Money leftover;

    private String requestId;

    private String flowId;

    /**
     * Starting country country tour response builder.
     *
     * @param startingCountry the starting country
     * @return the country tour response builder
     */
    public CountryTourResponseBuilder startingCountry(String startingCountry) {
        this.startingCountry = startingCountry;
        return this;
    }

    /**
     * Neighbours count country tour response builder.
     *
     * @param neighboursCount the neighbours count
     * @return the country tour response builder
     */
    public CountryTourResponseBuilder neighboursCount(int neighboursCount) {
        this.neighboursCount = neighboursCount;
        return this;
    }

    /**
     * Tours count country tour response builder.
     *
     * @param toursCount the tours count
     * @return the country tour response builder
     */
    public CountryTourResponseBuilder toursCount(int toursCount) {
        this.toursCount = toursCount;
        return this;
    }

    /**
     * Neighbours country tour response builder.
     *
     * @param neighbours the neighbours
     * @return the country tour response builder
     */
    public CountryTourResponseBuilder neighbours(Map<String, Money> neighbours) {
        this.neighbours = neighbours;
        return this;
    }

    /**
     * Leftover country tour response builder.
     *
     * @param leftover the leftover
     * @return the country tour response builder
     */
    public CountryTourResponseBuilder leftover(Money leftover) {
        this.leftover = leftover;
        return this;
    }

    /**
     * Request id country tour response builder.
     *
     * @param requestId the request id
     * @return the country tour response builder
     */
    public CountryTourResponseBuilder requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Flow id country tour response builder.
     *
     * @param flowId the flow id
     * @return the country tour response builder
     */
    public CountryTourResponseBuilder flowId(String flowId) {
        this.flowId = flowId;
        return this;
    }

    /**
     * Build country tour response.
     *
     * @return the country tour response
     */
    public CountryTourResponse build() {

        CountryTourResponse countryTourResponse = new CountryTourResponse();
        countryTourResponse.setStartingCountry(this.startingCountry);
        countryTourResponse.setNeighboursCount(this.neighboursCount);
        countryTourResponse.setToursCount(this.toursCount);
        countryTourResponse.setNeighbours(this.neighbours);
        countryTourResponse.setLeftover(this.leftover);
        countryTourResponse.setRequestId(this.requestId);
        countryTourResponse.setFlowId(this.flowId);

        return countryTourResponse;
    }
}
