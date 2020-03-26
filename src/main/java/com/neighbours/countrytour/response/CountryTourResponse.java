package com.neighbours.countrytour.response;

import com.neighbours.countrytour.dto.Money;

import java.util.Map;
import java.util.StringJoiner;

/**
 * The type Country tour response.
 */
public class CountryTourResponse {

    private String startingCountry;

    private int neighboursCount;

    private int toursCount;

    private Map<String, Money> neighbours;

    private Money leftover;

    private String requestId;

    private String flowId;

    /**
     * Gets starting country.
     *
     * @return the starting country
     */
    public String getStartingCountry() {
        return startingCountry;
    }

    /**
     * Sets starting country.
     *
     * @param startingCountry the starting country
     */
    public void setStartingCountry(String startingCountry) {
        this.startingCountry = startingCountry;
    }

    /**
     * Gets nighbours count.
     *
     * @return the neighbours count
     */
    public int getNeighboursCount() {
        return neighboursCount;
    }

    /**
     * Sets neighbours count.
     *
     * @param neighboursCount the nighbours count
     */
    public void setNeighboursCount(int neighboursCount) {
        this.neighboursCount = neighboursCount;
    }

    /**
     * Gets tours count.
     *
     * @return the tours count
     */
    public int getToursCount() {
        return toursCount;
    }

    /**
     * Sets tours count.
     *
     * @param toursCount the tours count
     */
    public void setToursCount(int toursCount) {
        this.toursCount = toursCount;
    }

    /**
     * Gets neighbours.
     *
     * @return the neighbours
     */
    public Map<String, Money> getNeighbours() {
        return neighbours;
    }

    /**
     * Sets neighbours.
     *
     * @param neighbours the neighbours
     */
    public void setNeighbours(Map<String, Money> neighbours) {
        this.neighbours = neighbours;
    }

    /**
     * Gets leftover.
     *
     * @return the leftover
     */
    public Money getLeftover() {
        return leftover;
    }

    /**
     * Sets leftover.
     *
     * @param leftover the leftover
     */
    public void setLeftover(Money leftover) {
        this.leftover = leftover;
    }

    /**
     * Gets request id.
     *
     * @return the request id
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets request id.
     *
     * @param requestId the request id
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * Gets flow id.
     *
     * @return the flow id
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     * Sets flow id.
     *
     * @param flowId the flow id
     */
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CountryTourResponse.class.getSimpleName() + "[", "]")
                .add("startingCountry='" + startingCountry + "'")
                .add("neighboursCount=" + neighboursCount)
                .add("toursCount=" + toursCount)
                .add("neighbours=" + neighbours)
                .add("leftover=" + leftover)
                .add("requestId='" + requestId + "'")
                .add("flowId='" + flowId + "'")
                .toString();
    }
}