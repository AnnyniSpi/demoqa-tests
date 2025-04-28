package examplesGitHub;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ExamplesCodeWithSoftAssertionsTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void findExamplesCodeWithSoftAssertionsTest() {
        open("https://github.com/selenide/selenide");

        $("nav.js-repo-nav").$(byText("Wiki")).click();
        $(".filter-bar").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for='wiki-pages-filter']").$(byText("SoftAssertions")).click();

        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
