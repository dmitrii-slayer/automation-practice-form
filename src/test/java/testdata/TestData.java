package testdata;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class TestData {
    static Faker faker = new Faker(new Locale("en"));
    static Random random = new Random();


    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress(
            (firstName.toLowerCase() + "." + "'"+ lastName.toLowerCase()).replace("'", ""));
    public String gender = genderRandom();
    public String phone = faker.phoneNumber().subscriberNumber(10);
    public String birthDay = String.format("%02d", faker.number().numberBetween(1, 28));
    public String birthMonth = monthRandom();
    public String birthYear = String.valueOf(faker.number().numberBetween(1970, 2010));
    public String subject = "Math";
    public String hobbie = hobbieRandom();
    public String picturePath = "me.jpg";
    public String address = faker.address().fullAddress();
    public String city = cityRandom();
    public String state = getStateByCity(city);


    public String cityRandom() {
        String[] states = {"Delhi", "Agra", "Karnal", "Gurgaon", "Lucknow", "Panipat", "Jaipur", "Jaiselmer"};
        int i = random.nextInt(states.length);
        return states[i];
    }


    public String getStateByCity(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Delhi", "NCR");
        cityAndState.put("Gurgaon", "NCR");
        cityAndState.put("Agra", "Uttar Pradesh");
        cityAndState.put("Lucknow", "Uttar Pradesh");
        cityAndState.put("Karnal", "Haryana");
        cityAndState.put("Panipat", "Haryana");
        cityAndState.put("Jaipur", "Rajasthan");
        cityAndState.put("Jaiselmer", "Rajasthan");
        return cityAndState.get(value);
    }


    public static String monthRandom() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int i = random.nextInt(month.length);
        return month[i];
    }

    public static String genderRandom() {
        String[] gender = {"Male", "Female", "Other"};
        int i = random.nextInt(gender.length);
        return gender[i];
    }

    public static String hobbieRandom() {
        String[] hobbie = {"Sports", "Reading", "Music"};
        int i = random.nextInt(hobbie.length);
        return hobbie[i];
    }


}