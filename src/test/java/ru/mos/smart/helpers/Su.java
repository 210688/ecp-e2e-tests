package ru.mos.smart.helpers;

import io.qameta.allure.LabelAnnotation;

import java.lang.annotation.*;

import static io.qameta.allure.util.ResultsUtils.STORY_LABEL_NAME;
import static io.qameta.allure.util.ResultsUtils.SUITE_LABEL_NAME;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@LabelAnnotation(name = SUITE_LABEL_NAME)
public @interface Su {

    String value();

}
