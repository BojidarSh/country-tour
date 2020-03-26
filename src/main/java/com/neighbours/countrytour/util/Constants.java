package com.neighbours.countrytour.util;

public interface Constants {

    interface Api {
        String PATH = "/api/v1/";
        String METHOD_TOURS = "/tours";
        String REQUEST_ID = "requestId";
        String FLOW_ID = "flowId";
    }

    interface ParameterHolders {
        String COUNTRY = "{country}";
        String COUNTRIES = "{countries}";
        String BASE_CURRENCY = "{baseCurrency}";
        String CURRENCIES = "{currencies}";
    }
}