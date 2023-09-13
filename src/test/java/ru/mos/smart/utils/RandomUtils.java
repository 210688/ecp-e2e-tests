package ru.mos.smart.utils;

import java.util.Random;

public class RandomUtils {

    public static String generateRandomDate() {

        Random random = new Random();
        int year = random.nextInt(23) + 2000;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;

        return String.format("%02d/%02d/%04d", month, day, year);
    }
}
