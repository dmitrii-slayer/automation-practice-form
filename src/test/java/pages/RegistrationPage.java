package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import pages.components.CalendarComponent;
import pages.components.PictureUploader;
import pages.components.RegisterResultsModule;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegisterResultsModule registerResultsModule = new RegisterResultsModule();
    PictureUploader pictureUploader = new PictureUploader();
    private final String RELATIVE_URL = "/automation-practice-form",
            REGISTRATION_FORM_TITLE = "Student Registration Form",
            RESULT_MODULE_TITLE = "Thanks for submitting the form";
    private SelenideElement formTitle = $(".practice-form-wrapper"),
            firstNameElement = $("#firstName"),
            lastNameElement = $("#lastName"),
            emailElement = $("#userEmail"),
            genderElement = $("#genterWrapper"),
            phoneElement = $("#userNumber"),
            birthdayElement = $("#dateOfBirthInput"),
            calendarPanel = $(".react-datepicker__month-container"),
            subjectsElement = $("#subjectsInput"),
            hobbiesElement = $("#hobbiesWrapper"),
            currentAddressElement = $("#currentAddress"),
            stateCityBlock = $("#stateCity-wrapper"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open(RELATIVE_URL);
        formTitle.shouldHave(text(REGISTRATION_FORM_TITLE));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    //методы для формы регистрации
    public RegistrationPage setFirstName(String value) {
        firstNameElement.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameElement.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailElement.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderElement.$(new ByText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneElement.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthdayElement.click();
        calendarPanel.shouldBe(visible);
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsElement.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbie(String value) {
        hobbiesElement.$(new ByText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String imagePath) {
        pictureUploader.uploadPicture(imagePath);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressElement.setValue(value);

        return this;
    }

    public RegistrationPage selectState(String value) {
        stateDropdown.click();
        stateCityBlock.$(new ByText(value)).click();

        return this;
    }

    public RegistrationPage selectCity(String value) {
        cityDropdown.click();
        stateCityBlock.$(new ByText(value)).click();

        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();

        return this;
    }

    public RegistrationPage verifyResultModule() {
        registerResultsModule.verifyModule(RESULT_MODULE_TITLE);

        return this;
    }

    public RegistrationPage verifyResultValue(String key, String value) {
        registerResultsModule.verifyResult(key, value);

        return this;
    }
}