package com.neighbours.countrytour.response.builder;

import com.neighbours.countrytour.response.ExceptionResponse;

import java.sql.Timestamp;
import java.util.List;

/**
 * The type Exception response.
 */
public class ExceptionResponseBuilder {

    private List<String> errorMessages;
    private String requestedURI;
    private Timestamp timestamp;
    private String requestId;
    private String flowId;

    /**
     * Error messages exception response builder.
     *
     * @param errorMessages the error messages
     * @return the exception response builder
     */
    public ExceptionResponseBuilder errorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
        return this;
    }

    /**
     * Requested uri exception response builder.
     *
     * @param requestedURI the requested uri
     * @return the exception response builder
     */
    public ExceptionResponseBuilder requestedURI(String requestedURI) {
        this.requestedURI = requestedURI;
        return this;
    }

    /**
     * Timestamp exception response builder.
     *
     * @param timestamp the timestamp
     * @return the exception response builder
     */
    public ExceptionResponseBuilder timestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Request id exception response builder.
     *
     * @param requestId the request id
     * @return the exception response builder
     */
    public ExceptionResponseBuilder requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Flow id exception response builder.
     *
     * @param flowId the flow id
     * @return the exception response builder
     */
    public ExceptionResponseBuilder flowId(String flowId) {
        this.flowId = flowId;
        return this;
    }

    /**
     * Build exception response.
     *
     * @return the exception response
     */
    public ExceptionResponse build() {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setErrorMessages(this.errorMessages);
        exceptionResponse.setRequestedURI(this.requestedURI);
        exceptionResponse.setTimestamp(this.timestamp);
        exceptionResponse.setRequestId(this.requestId);
        exceptionResponse.setFlowId(this.flowId);

        return exceptionResponse;
    }
}
