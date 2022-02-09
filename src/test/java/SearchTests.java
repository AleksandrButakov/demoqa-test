import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    @Test
    void selenideSearchTest() {
        open("https://www.google.com");
        $("[name=q]").setValue("selenide").pressEnter();
        Configuration.timeout=20000;
        $("[id=search]").shouldHave(text("selenide.org"));

    }

}
