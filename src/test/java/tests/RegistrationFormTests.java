package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testdata.TestData;


public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test()
    void successfulRegistration() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
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
                .selectCity(testData.city)
                .submitForm()
                .verifyResultModule()
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
    }


    @Test()
    void unsuccessfulRegistration() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .submitForm()
                .verifyModuleNotVisible();
    }
}