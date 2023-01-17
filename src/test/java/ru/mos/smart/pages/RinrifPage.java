package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import ru.mos.smart.helpers.AllureAttachments;
import ru.mos.smart.helpers.utils.RandomUtils;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Описание реестров RinRif.
 */

public class RinrifPage {

    ElementsCollection tableFieldData = $$(".table-striped");
    ElementsCollection cardHeaders = $$("tabset.tab-container  li");
    ElementsCollection tableHeaders = $$("table th");
    ElementsCollection searchResultTable = $$("table.search-result-table tr");

    @Step("Проверить, что в реестре {registerName} есть данные и присутствуют колонки таблицы {list}")
    public void checkFilter(String registerName, List<String> list) {
        String table = String.join(", ", list);
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(list));
        tableFieldData.shouldHave(sizeGreaterThan(0));
    }

    @Step("Карточка реестра Внесение изменений в разрешения ввод объекта в эксплуатацию")
    public void card() {
        $("#commoninfo").shouldHave(text("Внесение изменений в разрешение на ввод объекта в эксплуатацию"));
        AllureAttachments.attachScreenshot("Карточка реестра");
    }

    @Step("В реестре содержится таблица с колонками Номер акта, Дата акта, Место проведения проверки, Результат проверки, Специалист УН, ЕРКНМ ")
    public void tableActFilter() {
        $(".search-result-table tr").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                "Номер акта",
                "Дата акта",
                "Место проведения проверки",
                "Результат проверки",
                "Специалист УН",
                "ЕРКНМ"
        ));
    }

    @Step("В реестре Все объекты содержится таблица с колонками Источник финансирования, Номер дела, Объект, Застройщик, " +
            "Почтовый адрес, Дата начала строительства, Дата окончания строительства, Состояние, Строительный надзор ")
    public void tableFilterAllObjects() {
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(
                "Источник финансирования",
                "Номер дела",
                "Объект",
                "Застройщик ",
                "Почтовый адрес",
                "Дата начала строительства",
                "Дата окончания строительства",
                "Состояние",
                "Строительный надзор"
        ));
    }

    @Step("Проверить, что в реестре Все объекты сноса присутсвуют колонки таблицы(Дело, Объект, Кадастровый номер ЗУ, Кадастровый номер здания")
    public void filterTableAllObjectsSnos() {
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(
                "Дело",
                "Объект",
                "Кадастровый номер ЗУ",
                "Кадастровый номер здания"
        ));
    }

    @Step("Проверить, что в реестре Все объекты сноса присутсвуют колонки таблицы(Полное наименование организации / Руководитель, ИНН, ОГРН /СНИЛС / Паспорт," +
            "Юр. адрес / Факт. адрес, Почтовый адрес")
    public void filterTableAllOrganizations() {
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(
                "Полное наименование организации / Руководитель",
                "ИНН ",
                "ОГРН /СНИЛС / Паспорт",
                "Юр. адрес / Факт. адрес",
                "Почтовый адрес"
        ));
    }

    @Step("Проверить, что в реестре Все объекты сноса присутсвуют колонки таблицы(Номер, Дата, Объект, Проверяемая организация, Вид проверки" +
            "Основание для проверки, Период проведения, Ответственный, Статус, ЕРКНМ")
    public void checkFilterCardAllInspectionDecisions() {
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(
                "Номер",
                "Дата",
                "Объект",
                "Проверяемая организация",
                "Вид проверки",
                "Основание для проверки",
                "Период проведения",
                "Ответственный",
                "Статус",
                "ЕРКНМ"
        ));
    }

    @Step("Проверить, что в реестре Нарушения присутсвуют колонки таблицы(Номер нарушения, Дата нарушения, Наименование работ, Специалист УН. ФИО")
    public void checkFilterCardViolations() {
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(
                "Номер нарушения",
                "Дата нарушения",
                "Наименование работ",
                "Специалист УН. ФИО"
        ));
    }

    @Step("Проверить, что в реестре Постановления присутствуют колонки таблицы(Основание для возбуждения дела, Организация-нарушитель, Специалист УН. ФИО, Статья КОАП РФ")
    public void checkFilterCardResolutions() {
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(
                "Основание для возбуждения дела",
                "Организация-нарушитель",
                "Специалист УН. ФИО",
                "Статья КОАП РФ"
        ));
    }

    @Step("Проверить, что в реестре Постановления присутствуют колонки таблицы(Статус, Номер уведомления, Дата уведомления, " +
            "Плановая дата, Заявитель,Исполнитель, Данные ПГУ")
    public void checkFilterCardUvedomleniyaOzaversheniiSnosa() {
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(
                "Статус",
                "Номер уведомления",
                "Дата уведомления",
                "Плановая дата",
                "Заявитель",
                "Исполнитель",
                "Данные ПГУ"
        ));
    }

    @Step("Проверить, что в реестре Внесение изменений в разрешения ввод объекта в эксплуатацию присутствуют колонки таблицы(Дело, Заявление, Рег. дата, " +
            "Плановая дата, Объект, Заявитель, Данные ПГУ, Ответный документ, Исполнитель")
    public void checkFilterCardUVneseniyaa() {
        List<String> list2 = Arrays.asList(
                "Дело",
                "Заявление",
                "Рег. дата",
                "Плановая дата",
                "Объект",
                "Заявитель",
                "Данные ПГУ",
                "Ответный документ",
                "Исполнитель"
        );
        //checkFilter(list2);
    }
    //TODO посмотреть на будущее

    @Step("Переход по ссылке {linkName} в карточку")
    public void goToCard() {

        String link = searchResultTable.get(RandomUtils.getRandomInt(3, 6)).$$("td").get(1).$("a").getAttribute("href");
        searchResultTable.shouldHave(sizeGreaterThan(0));
        searchResultTable.get(RandomUtils.getRandomInt(3, 6))
                .$$("td").get(1).$("a").click();
        //File screenshotAs = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        //Allure.addAttachment("Screenshot", FileUtils.getInputStream("resources/screen/MapsTests/"));
        //sleep(30000);
        //Allure.addAttachment("Ссылка на карточку", link);
       /* Screenshot actualImage = new ScreenshotHelper()
                .getActualScreenshot();
        ScreenshotHelper screenshotHelper = new ScreenshotHelper();
        screenshotHelper.cardList(actualImage);*/
        //allureAttachments.attachScreenshot("card");
        /*Allure.parameter("Ссылка на карточку", link);

        Allure.addAttachment("Ссылка на карточку", link);
        System.out.println("-----------------------");
        System.out.println(link);
        System.out.println("-----------------------");*/
    }

    @Step("Ссылка на карточку в реестре {registerName}")
    public void cardList(String registerName) {


    }

    @Step("Проверить заголовки таблицы")
    public void checkTableHeaders(String tableHeader) {
        this.cardHeaders.shouldHave(sizeLessThanOrEqual(5));
        this.cardHeaders.get(0).shouldHave(text(tableHeader)).shouldBe(visible);
    }

    @Step("Перейти в карточку заявления")
    public void gotoCard() {
        $("div.description a").shouldHave((attributeMatching("href", "(.*)/app/rs/card(.*)/common"))).click();
    }
}


