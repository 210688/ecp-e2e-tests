package ru.mos.smart.helpers.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import ru.mos.smart.api.Authorization;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BlockUsersFromCsv {

    public static void main(String[] args) throws IOException {
        RestAssured.baseURI = ""; //Окружение
        String login = ""; //Логин
        String password = ""; //Пароль

        Authorization authorization = new Authorization();
        Map<String, String> cookies = authorization.getAuthCookie(login, password);
        List<String> usersList = getUsersList("src/test/resources/files_for_tests/list_users_blocking.csv");

        try (FileWriter writer = new FileWriter("src/test/resources/files_for_tests/block-list.log", false)) {
            for (String user : usersList) {
                String response = blockUser(cookies, user) + "\n";
                writer.write(response);
                System.out.println(response);
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static List<String[]> parseCsv(String filePath) throws IOException {
        List<String[]> result = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        for (String fileLine : fileLines) {
            result.add(fileLine.split(","));
        }

        return result;
    }

    private static List<String> getUsersList(String filePath) throws IOException {
        List<String[]> csv = parseCsv(filePath);
        List<String> result = new ArrayList<>();
        for (String[] line : csv) {
            if (line[0].contains("@"))
                continue;
            if (line.length >= 3) {
                if (line[2].equals("True")) {
                    continue;
                }
            }
            result.add(line[0]);
        }

        return result;
    }

    private static String blockUser(Map<String, String> cookies, String user) {
        ExtractableResponse<Response> response = given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/mdm/api/v1/openldap/user/" + user)
                .then()
                .extract();

        if (response.statusCode() != 200)
            return "Пользователь " + user + " Не найден!";

        String str = "{\"dn\":\"" + response.jsonPath().getString("dn") + "\" , \"lockCode\":\"BLOCK_DIT\"}";
        response = given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(str)
                .when()
                .post("/mdm/api/v1/openldap/blockAccount")
                .then()
                .extract();

        if (response.statusCode() != 200)
            return "Ошибка блокировки пользователя " + user;

        return format("Пользователь %s Заблокирован!", user);
    }
}
