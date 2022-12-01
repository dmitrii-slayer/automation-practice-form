import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FormTests {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {

        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Pupkin");
        $("#userEmail").setValue("egorpupkin@fakemail.com");
//        $(By.name("gender")).selectRadio("male"); // doesn't work
        $("[name=gender][value=Male]").parent().click();
        $("#userNumber").setValue("9876543210");
        // select date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__day--021").click();
//        $("[aria-label='Choose Sunday, June 21st, 1987']").click();
        // select subjects
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        // select hobbies
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        // upload picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/me.jpg"));
//        $("#uploadPicture").sendKeys();
        $("#currentAddress").setValue("Test address 123 building 0");
        // select state and city
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Panipat")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        // to do - проверять пары ("Student Email", "egorpupkin@fakemail.com")
        // чтобы не было чего-то вроде ("Student Email", "21 June,1987")
        $(".table-responsive").shouldHave(
                text("Egor Pupkin"),
                text("egorpupkin@fakemail.com"),
                text("Male"),
                text("9876543210"),
                text("21 June,1987"),
                text("Maths, Arts, Hindi"),
                text("Reading, Music"),
                text("me.jpg"),
                text("Test address 123 building 0"),
                text("Haryana Panipat"));
    }
}