package tests;

import org.junit.jupiter.api.*;
import pages.RegistrationPage;
import tests.utils.RandomUtils;
import static tests.utils.RandomUtils.*;

public class PracticeFormPOWithTDGTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils RandomUtils = new RandomUtils();
    @Test
    void positiveRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(RandomUtils.firstName)
                .setLastName(RandomUtils.lastName)
                .setUserEmail(RandomUtils.userEmail)
                .setUserGender(RandomUtils.userGender)
                .setUserNumber(RandomUtils.userNumber)
                .setUserDateOfBirth(RandomUtils.userBirthDay, RandomUtils.userBirthMonth, RandomUtils.userBirthYear)
                .setUserSubjects(RandomUtils.userSubjects)
                .setUserHobbies(RandomUtils.userHobbies)
                .upLoadUserPicture(RandomUtils.userPicture)
                .setUserAdress(RandomUtils.userAddress)
                .setUserState(userState)
                .setUserCity(userCity)
                .clickSubmit()
                .checkResultComponent(RandomUtils.firstName + ' ' + RandomUtils.lastName,
                        RandomUtils.userEmail,
                        RandomUtils.userGender,
                        RandomUtils.userNumber,
                        RandomUtils.userBirthDay + ' ' + RandomUtils.userBirthMonth + ','
                                                       + RandomUtils.userBirthYear,
                        RandomUtils.userSubjects,
                        RandomUtils.userHobbies,
                        RandomUtils.userPicture,
                        RandomUtils.userAddress,
                        userState + ' ' + userCity);
    }
    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .setLastName(RandomUtils.lastName)
                .setUserEmail(RandomUtils.userEmail)
                .setUserGender(RandomUtils.userGender)
                .setUserNumber(RandomUtils.userNumber)
                .setUserDateOfBirth(RandomUtils.userBirthDay, RandomUtils.userBirthMonth, RandomUtils.userBirthYear)
                .setUserSubjects(RandomUtils.userSubjects)
                .setUserHobbies(RandomUtils.userHobbies)
                .upLoadUserPicture(RandomUtils.userPicture)
                .setUserAdress(RandomUtils.userAddress)
                .setUserState(userState)
                .setUserCity(userCity)
                .clickSubmit()
                .checkResultNegative();
    }
    @Test
    void requiredFieldsRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(RandomUtils.firstName)
                .setLastName(RandomUtils.lastName)
                .setUserGender(RandomUtils.userGender)
                .setUserNumber(RandomUtils.userNumber)
                .setUserDateOfBirth(RandomUtils.userBirthDay, RandomUtils.userBirthMonth, RandomUtils.userBirthYear)
                .clickSubmit()
                .checkOneResult("Student Name", RandomUtils.firstName + ' ' + RandomUtils.lastName)
                .checkOneResult("Gender", RandomUtils.userGender)
                .checkOneResult("Mobile", RandomUtils.userNumber)
                .checkOneResult("Date of Birth", RandomUtils.userBirthDay + ' ' + RandomUtils.userBirthMonth + ','
                                                                                + RandomUtils.userBirthYear);
    }
}
