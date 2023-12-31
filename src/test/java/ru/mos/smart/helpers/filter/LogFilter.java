package ru.mos.smart.helpers.filter;

import io.qameta.allure.restassured.AllureRestAssured;

public class LogFilter {
    private static final AllureRestAssured FILTER = new AllureRestAssured();

    private static class InitLogFilter {
        private static final LogFilter logFilter = new LogFilter();
    }

    private LogFilter() {
    }

    public static LogFilter filters() {
        return InitLogFilter.logFilter;
    }

    public AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("http-request.ftl");
        FILTER.setResponseTemplate("http-response.ftl");
        return FILTER;
    }
}
