package ru.mos.smart.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DebugTagsTests {
    @Test
    @Tag("prod") @Tag("ugd1")
    void test1() {
        System.out.println("test1 - prod");
    }

    @Test
    @Tag("prod") @Tag("predprod") @Tag("ugd1")
    void test2() {
        System.out.println("test2 - prod, predprod");
    }

    @Test
    @Tag("predprod") @Tag("ugd1")
    void test3() {
        System.out.println("test3 - predprod");
    }

    @Test
    @Tag("predprod") @Tag("ugd2")
    void test4() {
        System.out.println("test3 - predprod, ugd2");
    }
}
