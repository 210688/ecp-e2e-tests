package ru.mos.smart.tests.regressions.app;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.api.ResponseCode;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Owner("SoldatovKS")
@Epic("LCS")
@Feature("Конструктор форм")
public class LcsTests extends ApiBearerTestBase {

    private ResponseCode responseCode = new ResponseCode();

    @Test
    @Layer("api")
    @DisplayName("Проверка работы Возможности")
    @Tag("lcs")
    void checkLcsFormOpportunities() {
        Response response = apiRequestBearer()
                .get("app/lcs/repository/api/MetaObjects/FORM_OPPORTUNITIES")
                .then()
                .extract().response();
        responseCode.checkResponseCode(response.statusCode(), 200);
    }
}
