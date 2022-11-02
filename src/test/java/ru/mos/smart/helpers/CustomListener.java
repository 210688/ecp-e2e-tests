package ru.mos.smart.helpers;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomListener implements TestWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomListener.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        LOGGER.info("==============");
        LOGGER.info("Test {} - failed", context.getTestMethod().get().getName());
        LOGGER.info("==============");
        AllureAttachments.attachScreenshot("failed screenshot");
        AllureAttachments.attachPageSource();
        Selenide.closeWebDriver();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        Selenide.closeWebDriver();
    }
}

