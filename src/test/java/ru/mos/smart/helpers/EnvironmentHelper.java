
package ru.mos.smart.helpers;

import static java.lang.Boolean.parseBoolean;


public class EnvironmentHelper {
    // WEB CONFIG
    public static final String
            remoteDriverUrl = System.getProperty("remote_driver_url"),
            videoStorageUrl = System.getProperty("video_storage_url");
    public static final boolean
            isHeadless = parseBoolean(System.getProperty("headless", "false")),
            isRemoteDriver = remoteDriverUrl != null,
            isVideoOn = videoStorageUrl != null;

}

