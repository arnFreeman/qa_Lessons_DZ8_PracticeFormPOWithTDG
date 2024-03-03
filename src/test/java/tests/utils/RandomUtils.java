package tests.utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("en-GB"));
    public  String firstName = gnrtFirstName();
    public String lastName = gnrtLastName();
    public String userEmail = gnrtEmail();
    public String userGender = gnrtGender();
    public String userNumber = gnrtNumber();
    public String userBirthYear = gnrtBirthYear();
    public String userBirthMonth = gnrtBirthMonth();
    public String userBirthDay = gnrtBirthDay();
    public String userSubjects = gnrtSubject();
    public String userHobbies = gnrtHobbie();
    public String userPicture = gnrtPicture();
    public String userAddress = gnrtAddress();
    public static String userState = gnrtState();
    public static String userCity = gnrtCity();

    public String gnrtFirstName() {
        return firstName = faker.name().firstName();
    }
    public String gnrtLastName() {
        return lastName = faker.name().lastName();
    }
    public String gnrtEmail() {
        return userEmail = faker.internet().emailAddress();
    }
    public String gnrtGender() {
        return userGender = faker.options().option("Male", "Female", "Other");
    }
    public String gnrtNumber() {
        return userNumber = faker.phoneNumber().subscriberNumber(10);
    }
    public String gnrtBirthYear() {
        return userBirthYear = String.valueOf(faker.number().numberBetween(1900, 2100));
    }
    public String gnrtBirthMonth() {
        return userBirthMonth = faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }
    public String gnrtBirthDay() {
        return userBirthDay = String.valueOf(faker.number().numberBetween(1, 30));
    }
    public String gnrtSubject() {
        return userSubjects = faker.options().option("Accounting", "Arts", "Biology", "Chemistry",
                "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi", "History",
                "Maths", "Physics", "Social Studies");
    }
    public String gnrtHobbie() {
        return userHobbies = faker.options().option("Sports", "Reading", "Music");
    }
    public String gnrtPicture() {
        return userPicture = faker.options().option("1223.jpg", "1224.jng");
    }
   public String gnrtAddress() {
       return userAddress = faker.address().streetAddress();
    }
    public static String gnrtState() {
        return userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }
    public static String gnrtCity() {
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
