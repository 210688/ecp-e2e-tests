/*
package ru.mos.smart.extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static ru.mos.smart.helpers.AttachmentsHelper.*;
import static ru.mos.smart.helpers.AttachmentsHelper.attachVideo;
import static ru.mos.smart.helpers.DriverUtils.getConsoleLogs;
import static ru.mos.smart.helpers.DriverUtils.getSessionId;
import static ru.mos.smart.helpers.EnvironmentHelper.isVideoOn;

public class AllureAttachmentsAfterTestExecutionCallbackk implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) {
            String sessionId = getSessionId();
            addScreenshotAs("Last screenshot");
            attachPageSource();
            addBrowserConsoleLogs("Browser console logs", getConsoleLogs());
            if (isVideoOn) attachVideo(sessionId);
        }
    }
}
*/
