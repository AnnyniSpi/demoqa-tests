import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void fillFormTest() {
        open("/text-box");

        $("[id='userName']").setValue("Alex Murlatov");
        $("#userName").setValue("Alex Murlatov");
        $("#userEmail").setValue("alex333@gmail.com");
        $("#currentAddress").setValue("Some Address 1");
        $("#permanentAddress").setValue("Another address 2");
        $("#submit").click();

        $("#output").shouldHave(text("Alex Murlatov"), text("alex333@gmail.com"), text("Some Address 1"), text("Another address 2"));

    }

}
