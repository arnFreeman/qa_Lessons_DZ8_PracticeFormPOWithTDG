package tests.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = getFirstName();
    public String lastName = getLastName();
    public String userEmail = getEmail();
    public String userGender = getGender();
    public String userNumber = getNumber();
    public String userBirthYear = getBirthYear();
    public String userBirthMonth = getBirthMonth();
    public String userBirthDay = getBirthDay();
    public String userSubjects = getSubject();
    public String userHobbies = getHobbie();
    public String userPicture = getPicture();
    public String userAddress = getAddress();
    public static String userState = getState();
    public static String userCity = getCity();

    public String getFirstName() {
        return firstName = faker.name().firstName();
    }

    public String getLastName() {
        return lastName = faker.name().lastName();
    }

    public String getEmail() {
        return userEmail = faker.internet().emailAddress();
    }

    public String getGender() {
        return userGender = faker.options().option("Male", "Female", "Other");
    }

    public String getNumber() {
        return userNumber = faker.phoneNumber().subscriberNumber(10);
    }

    public String getBirthYear() {
        return userBirthYear = String.valueOf(faker.number().numberBetween(1900, 2100));
    }

    public String getBirthMonth() {
        return userBirthMonth = faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String getBirthDay() {
        return userBirthDay = String.valueOf(faker.number().numberBetween(1, 30));
    }

    public String getSubject() {
        return userSubjects = faker.options().option("Accounting", "Arts", "Biology", "Chemistry",
                "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi", "History",
                "Maths", "Physics", "Social Studies");
    }

    public String getHobbie() {
        return userHobbies = faker.options().option("Sports", "Reading", "Music");
    }

    public String getPicture() {
        return userPicture = faker.options().option("1223.jpg", "1224.jpg");
    }

    public String getAddress() {
        return userAddress = faker.address().streetAddress();
    }

    public static String getState() {
        return userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getCity() {
        String randomNCRCity = faker.options().option("Delhi", "Gurgaon", "Noida"),
                randomUttarPradeshCity = faker.options().option("Agra", "Lucknow", "Merrut"),
                randomHaryanaCity = faker.options().option("Karnal", "Panipat"),
                randomRajasthanCity = faker.options().option("Jaipur", "Jaiselmer");

        switch (userState) {
            case "NCR" -> userCity = randomNCRCity;
            case "Uttar Pradesh" -> userCity = randomUttarPradeshCity;
            case "Haryana" -> userCity = randomHaryanaCity;
            default -> userCity = randomRajasthanCity;
        }
        return userCity;
    }
}
