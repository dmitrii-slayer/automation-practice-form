package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testdata.TestData;

import static io.qameta.allure.Allure.step;

@DisplayName("Тесты на форму регистрации automation-practice-form")
public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @DisplayName("Тест регистрации. Позитивный")
    void successfulRegistration() {

        step("Открываем страницу регистрации", () -> {
            registrationPage.openPage();
        });
        step("Заполняем форму", () -> {
            registrationPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.email)
                    .setGender(testData.gender)
                    .setPhone(testData.phone)
                    .setBirthDay(testData.birthDay, testData.birthMonth, testData.birthYear)
                    .setSubject(testData.subject)
                    .setHobbie(testData.hobbie)
                    .uploadPicture(testData.picturePath)
                    .setCurrentAddress(testData.address)
                    .selectState(testData.state)
                    .selectCity(testData.city);
        });
        step("Нажимаем кнопку Submit", () -> {
            registrationPage.submitForm();
        });
        step("Проверяем успешность регистрации", () -> {
            registrationPage.verifyResultModule()
                    .verifyResultValue("Student Name", testData.firstName + " " + testData.lastName)
                    .verifyResultValue("Student Email", testData.email)
                    .verifyResultValue("Gender", testData.gender)
                    .verifyResultValue("Mobile", testData.phone)
                    .verifyResultValue("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                    .verifyResultValue("Subjects", testData.subject)
                    .verifyResultValue("Hobbies", testData.hobbie)
                    .verifyResultValue("Picture", testData.picturePath)
                    .verifyResultValue("Address", testData.address)
                    .verifyResultValue("State and City", testData.state + " " + testData.city);
        });
    }


    @Test
    @DisplayName("Тест регистрации. Негативный")
    void unsuccessfulRegistration() {
        step("Открываем страницу регистрации", () -> {
            registrationPage.openPage();
        });
        step("Заполняем несколько полей", () -> {
            registrationPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName);
        });
        step("Нажимаем кнопку Submit", () -> {
            registrationPage.submitForm();
        });
        step("Проверяем что регистрация не прошла", () -> {
            registrationPage.verifyModuleNotVisible();
        });
    }
}