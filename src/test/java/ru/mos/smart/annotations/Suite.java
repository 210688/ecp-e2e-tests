package ru.mos.smart.annotations;

import io.qameta.allure.LabelAnnotation;

import java.lang.annotation.*;

import static io.qameta.allure.util.ResultsUtils.STORY_LABEL_NAME;
import static io.qameta.allure.util.ResultsUtils.SUITE_LABEL_NAME;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@LabelAnnotation(name = "suite")
public @interface Suite {

    String value();
}
