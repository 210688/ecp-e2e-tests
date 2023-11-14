package ru.mos.smart.helpers.annotations;

import io.qameta.allure.LabelAnnotation;

import java.lang.annotation.*;

    @Documented
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.TYPE})
    @LabelAnnotation(name = "action")
    public @interface Action {

        String value();
    }
