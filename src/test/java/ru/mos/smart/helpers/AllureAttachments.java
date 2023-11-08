

package ru.mos.smart.helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mos.smart.data.enums.Registers;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class AllureAttachments {
    public static final Logger LOGGER = LoggerFactory.getLogger(AllureAttachments.class);

    @Attachment(value = "{attachName}", type = "image/png", fileExtension = "png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain", fileExtension = "json")
    public static void attachPageSource() {
        getWebDriver().getPageSource();
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static void attachAsText(String attachName, String message) {
    }

    public static void BrowserLog() {
        attachAsText(
                "Browser console logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    public static void attachScreenshotRegisters(Registers registerName) {
        AllureAttachments.attachScreenshot("Скриншот карточки" + " " + registerName.value());
    }
}

