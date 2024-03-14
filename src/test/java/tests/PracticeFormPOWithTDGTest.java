package tests;

import org.junit.jupiter.api.*;
import pages.RegistrationPage;
import tests.utils.RandomUtils;
import static tests.utils.RandomUtils.*;

public class PracticeFormPOWithTDGTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    @Test
    void positiveRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserEmail(randomUtils.userEmail)
                .setUserGender(randomUtils.userGender)
                .setUserNumber(randomUtils.userNumber)
                .setUserDateOfBirth(randomUtils.userBirthDay, randomUtils.userBirthMonth, randomUtils.userBirthYear)
                .setUserSubjects(randomUtils.userSubjects)
                .setUserHobbies(randomUtils.userHobbies)
                .upLoadUserPicture(randomUtils.userPicture)
                .setUserAdress(randomUtils.userAddress)
                .setUserState(userState)
                .setUserCity(userCity)
                .clickSubmit()
                .checkResultComponent(randomUtils.firstName + ' ' + randomUtils.lastName,
                        randomUtils.userEmail,
                        randomUtils.userGender,
                        randomUtils.userNumber,
                        randomUtils.userBirthDay + ' ' + randomUtils.userBirthMonth + ','
                                                       + randomUtils.userBirthYear,
                        randomUtils.userSubjects,
                        randomUtils.userHobbies,
                        randomUtils.userPicture,
                        randomUtils.userAddress,
                        userState + ' ' + userCity);
    }
    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .setLastName(randomUtils.lastName)
                .setUserEmail(randomUtils.userEmail)
                .setUserGender(randomUtils.userGender)
                .setUserNumber(randomUtils.userNumber)
                .setUserDateOfBirth(randomUtils.userBirthDay, randomUtils.userBirthMonth, randomUtils.userBirthYear)
                .setUserSubjects(randomUtils.userSubjects)
                .setUserHobbies(randomUtils.userHobbies)
                .upLoadUserPicture(randomUtils.userPicture)
                .setUserAdress(randomUtils.userAddress)
                .setUserState(userState)
                .setUserCity(userCity)
                .clickSubmit()
                .checkResultNegative();
    }
    @Test
    void requiredFieldsRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserGender(randomUtils.userGender)
                .setUserNumber(randomUtils.userNumber)
                .setUserDateOfBirth(randomUtils.userBirthDay, randomUtils.userBirthMonth, randomUtils.userBirthYear)
                .clickSubmit()
                .checkOneResult("Student Name", randomUtils.firstName + ' ' + randomUtils.lastName)
                .checkOneResult("Gender", randomUtils.userGender)
                .checkOneResult("Mobile", randomUtils.userNumber)
                .checkOneResult("Date of Birth", randomUtils.userBirthDay + ' ' + randomUtils.userBirthMonth + ','
                                                                                + randomUtils.userBirthYear);
    }
}
