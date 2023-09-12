package ru.mos.smart.helpers.junit;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.opentest4j.TestAbortedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mos.smart.config.ConfigHelper;

public class RunTestOnPreprodOnlyExtension implements BeforeEachCallback, BeforeAllCallback {

    private final Logger log = LoggerFactory.getLogger("RunTestOnPreprodOnlyExtension");

    @Override
    public void beforeEach(ExtensionContext context) {
        if (!"predprod".equals(ConfigHelper.projectConfig().environment())) {
            String exceptionMessage = "Тест для запуска только на ПП !";
            log.info(exceptionMessage);
            throw new TestAbortedException(exceptionMessage);
        }
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        if (!"predprod".equals(ConfigHelper.projectConfig().environment())) {
            String exceptionMessage = "Тест для запуска только на ПП !";
            log.info(exceptionMessage);
            throw new TestAbortedException(exceptionMessage);
        }
    }
}
