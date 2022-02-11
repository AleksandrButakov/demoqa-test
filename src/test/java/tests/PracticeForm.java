package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserPosition = ("0x0");
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @Test
    void successPracticeFormTest() throws InterruptedException {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("ivan@bk.ru");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("4955552244");

        // working with the calendar
        $("#dateOfBirthInput").click();
        // <option value="1990">1990</option>
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        // <option value="6">July</option>
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__month").$(byText("16")).click();

        $("#subjectsInput").setValue("En").pressEnter();
        $(".practice-form-wrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img.png");
        $("#currentAddress").setValue("Russia");


        executeJavaScript("scroll(0,250)");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Noida")).click();

        $("#submit").click();

        // checking the correctness of the entered value
        $(".table-responsive").shouldHave(
                text("Ivan"),
                text("Petrov"),
                text("ivan@bk.ru"),
                text("Other"),
                text("4955552244"),
                text("16 July,1990"),
                text("En"),
                text("Reading"),
                text("img.png"),
                text("Russia"),
                text("NCR"),
                text("Noida")
        );
    }

}
