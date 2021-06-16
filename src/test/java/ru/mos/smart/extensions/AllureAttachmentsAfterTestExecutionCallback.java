package ru.mos.smart.extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static ru.mos.smart.helpers.AttachmentsHelper.*;
import static ru.mos.smart.helpers.AttachmentsHelper.attachVideo;
import static ru.mos.smart.helpers.DriverHelper.getConsoleLogs;
import static ru.mos.smart.helpers.DriverHelper.getSessionId;
import static ru.mos.smart.helpers.EnvironmentHelper.isVideoOn;

public class AllureAttachmentsAfterTestExecutionCallback implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) {
            String sessionId = getSessionId();
            System.out.println(sessionId);
            attachScreenshot("Last screenshot");
            attachPageSource();
            attachAsText("Browser console logs", getConsoleLogs());
            if (isVideoOn) attachVideo(sessionId);
        }
    }
}
