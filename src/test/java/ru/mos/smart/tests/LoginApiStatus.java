package ru.mos.smart.tests;
import io.restassured.RestAssured;
import org.junit.Test;


public class LoginApiStatus {


    @Test
    public void loginstatus()
    {

        int code=RestAssured.given()
                .auth().preemptive()
                .basic("soldatovks","0oR67")
                .when()
                .get("http://smart-predprod.mos.ru/auth/user/")
                .getStatusCode();

        System.out.println("Response Code from is "+code);
    }
}

//https://smart-predprod.mos.ru/auth/user