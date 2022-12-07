package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    private String firstName = "Egor",
            lastName = "Pupkin",
            userEmail = "egorpupkin@fakemail.com",
            userGender = "Male",
            userPhone = "9876543210",
            userBirthDay = "21",
            userBirthMonth = "June",
            userBirthYear = "1987",
            subjects = "Art",
            hobbies = "Reading",
            imagePath = "me.jpg",
            currentAddress = "Test address 123 building 0",
            userState = "Haryana",
            userCity = "Panipat";

    @Test
    void successfulRegistration() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDay(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(subjects)
                .setHobbie(hobbies)
                .uploadPicture(imagePath)
                .setCurrentAddress(currentAddress)
                .selectState(userState)
                .selectCity(userCity)
                .submitForm()
                .verifyResultModule()
                .verifyResultValue("Student Name", firstName + " " + lastName)
                .verifyResultValue("Student Email", userEmail)
                .verifyResultValue("Gender", userGender)
                .verifyResultValue("Mobile", userPhone)
                .verifyResultValue("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .verifyResultValue("Subjects", subjects)
                .verifyResultValue("Hobbies", hobbies)
                .verifyResultValue("Picture", imagePath)
                .verifyResultValue("Address", currentAddress)
                .verifyResultValue("State and City", userState + " " + userCity);
    }
}