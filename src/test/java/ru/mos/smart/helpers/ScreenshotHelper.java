package ru.mos.smart.helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import static ru.mos.smart.helpers.utils.FileUtils.getInputStream;
import static ru.mos.smart.helpers.utils.FileUtils.savePng;

public class ScreenshotHelper {
    public Screenshot getActualScreenshot() {
        Screenshot getActual = new AShot().takeScreenshot(WebDriverRunner.getWebDriver());
        String pathToResources = "src/test/resources/screen/MapsTests/";
        savePng(getActual.getImage(), pathToResources + "actual.png");
        return getActual;
    }

    public Screenshot getExpectedScreenshot() {
    Screenshot getExpected = new AShot().takeScreenshot(WebDriverRunner.getWebDriver());
        String pathToResources = "src/test/resources/screen/MapsTests/";
        savePng(getExpected.getImage(), pathToResources + "actual.png");
        return getExpected;
    }

    @Step("Карточка реестра {registerName}")
    public void cardList(Screenshot actualImage) {
        String testPath = "src/test/resources/screen/MapsTests/";
        Allure.addAttachment("Скриншот карточки", getInputStream(testPath + "actual.png"));
    }


    @Step("Compare screenshots")
    public ImageDiff compareScreenshots(Screenshot actualImage, Screenshot expectedImage, int diffSizeTrigger) {
        String testPath = "src/test/resources/screen/MapsTests/";
        Allure.addAttachment("Actual", getInputStream(testPath + "actual.png"));
        Allure.addAttachment("Expected", getInputStream(testPath + "expected.png"));

        ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage).withDiffSizeTrigger(diffSizeTrigger);

        if (diff.hasDiff()) {
            Allure.addAttachment("Difference", getInputStream(testPath + "difference.png"));

            savePng(diff.getMarkedImage(), testPath + "difference.png");
        }
        return diff;
    }
}
