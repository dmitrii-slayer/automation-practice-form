import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FormTests {

    @BeforeAll
    static void configure() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Pupkin");
        $("#userEmail").setValue("egorpupkin@fakemail.com");


//        $(By.name("gender")).selectRadio("male"); // doesn't work
        $("[name=gender][value=Male]").parent().click();
        $("#userNumber").setValue("9876543210");
        $("#currentAddress").setValue("Test address 123 building 0");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1987");
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $("[aria-label='Choose Sunday, June 21st, 1987']").click();


//        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
}