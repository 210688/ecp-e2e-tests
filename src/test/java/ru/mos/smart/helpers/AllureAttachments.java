
package ru.mos.smart.helpers;

import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AllureAttachments {
    public static final Logger LOGGER = LoggerFactory.getLogger(AllureAttachments.class);

    @Attachment(value = "{attachName}", type = "text/plain")
    private static String addMessage(String attachName, String text) {
        return text;
    }

    public static void addBrowserConsoleLogs() {
        addMessage("Browser console logs", DriverUtils.getConsoleLogs());
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] addScreenshotAs(String attachName) {
        return DriverUtils.getScreenshotAsBytes(); //((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/html") //plain
    public static byte[] addPageSource() {
        return DriverUtils.getPageSourceAsBytes(); //((TakesPageSource) getWebDriver()).getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

   /* public static void addVideo(String sessionId) {
        URL videoUrl = DriverHelper.getVideoUrl(sessionId);
        if (videoUrl != null) {
            InputStream videoInputStream = null;
            sleep(5000);

            for (int i = 0; i < 10; i++) {
                try {
                    videoInputStream = videoUrl.openStream();
                    break;
                } catch (FileNotFoundException e) {
                    sleep(5000);
                } catch (IOException e) {
                    LOGGER.warn("[ALLURE VIDEO ATTACHMENT ERROR] Cant attach video allure , {}", videoUrl);
                    e.printStackTrace();
                }
            }*/
    //Allure.addAttachment("Video", "video/mp4", videoInputStream, "mp4");
}
