package com.simbirsoft.tests.tests;

import com.simbirsoft.tests.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.simbirsoft.tests.tests.TestData.*;

public class AutomationPracticeFormWithPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void fillFromTest() {

//        Faker faker = new Faker();
//        String firstName = faker.name().firstName(),
//                lastName = faker.name().lastName(),
//                userEmail = faker.internet().emailAddress();
        //Заполнение формы
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.typeUserNumber(userNumber);
        registrationPage.selectGender(gender);
        registrationPage.typeSubject(subjects);
        registrationPage.selectHobbies(hobbies);
        registrationPage.uploadPicture(picture);
        registrationPage.typeAddress(currentAddress);
        registrationPage.stateAndCity.SelectState(state);
        registrationPage.stateAndCity.SelectCity(city);
        registrationPage.calendar.setDate("3", "November", "1993");
        registrationPage.clickSubmit();
        //Проверка заполнения формы
        registrationPage.checkResultsUserName("Student Name", firstName + " " + lastName);
        registrationPage.checkResultsStudentEmail(userEmail);
        registrationPage.checkResultsStudentNumber(userNumber);
        registrationPage.checkResultsGender(gender);
        registrationPage.checkResultsDateOfBirth("3", "November", "1993");
        registrationPage.checkResultsSubjects(subjects);
        registrationPage.checkResultsHobbies(hobbies);
        registrationPage.checkResultsAddress(currentAddress);
        registrationPage.checkResultsPicture(picture);
        registrationPage.checkResultsStateAndCity(state, city);
    }
}
