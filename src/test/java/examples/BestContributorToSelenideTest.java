package examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BestContributorToSelenideTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void andreiSolntsevShouldBeFirstContributorTest() {
        open("https://github.com/selenide/selenide");

        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest("h2").sibling(0).$$("li").first().hover();
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }
}
