package com.neighbours.countrytour.response;

import java.sql.Timestamp;
import java.util.List;
import java.util.StringJoiner;

/**
 * The type Exception response.
 */
public class ExceptionResponse {

    private List<String> errorMessages;
    private String requestedURI;
    private Timestamp timestamp;
    private String requestId;
    private String flowId;

    /**
     * Gets error messages.
     *
     * @return the error messages
     */
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * Sets error messages.
     *
     * @param errorMessages the error messages
     */
    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    /**
     * Gets requested uri.
     *
     * @return the requested uri
     */
    public String getRequestedURI() {
        return requestedURI;
    }

    /**
     * Sets requested uri.
     *
     * @param requestedURI the requested uri
     */
    public void setRequestedURI(final String requestedURI) {
        this.requestedURI = requestedURI;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
        return new StringJoiner(", ", ExceptionResponse.class.getSimpleName() + "[", "]")
                .add("errorMessages=" + errorMessages)
                .add("requestedURI='" + requestedURI + "'")
                .add("timestamp=" + timestamp)
                .add("requestId='" + requestId + "'")
                .add("flowId='" + flowId + "'")
                .toString();
    }
}
