package ru.mos.smart.LogFilter;

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
        FILTER.setRequestTemplate("1request.ftl");
        FILTER.setResponseTemplate("1response.ftl");
        return FILTER;
    }
}
