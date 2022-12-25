package com.simbirsoft.tests.pages;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.tests.pages.components.CalendarComponent;
import com.simbirsoft.tests.pages.components.StateAndCityComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private final SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submitButton = $("#submit");
    public CalendarComponent calendar = new CalendarComponent();
    public StateAndCityComponent stateAndCity = new StateAndCityComponent();

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void typeEmail(String userEmail) {
        emailInput.setValue(userEmail);
    }

    public void typeUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
    }

    public void selectGender(String gender) {
        $(byText(gender)).click();
    }

    public void selectHobbies(String hobbies) {
        $(byText(hobbies)).click();
    }

    public void typeSubject(String[] subjects) {
        subjectsInput.setValue(subjects[0]).pressEnter();
        subjectsInput.setValue(subjects[1]).pressEnter();
    }

    public void uploadPicture(File picture) {
        uploadPicture.uploadFile(picture);
    }

    public void typeAddress(String address) {
        addressInput.setValue(address);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void checkResultsUserName(String key, String value) {
        $(".table-responsive")
                .$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkResultsStudentEmail(String userEmail) {
        $(".table-responsive").
                $(byText("Student Email")).parent().shouldHave(text(userEmail));
    }

    public void checkResultsGender(String gender) {
        $(".table-responsive")
                .$(byText("Gender")).parent().shouldHave(text(gender));
    }

    public void checkResultsStudentNumber(String userNumber) {
        $(".table-responsive")
                .$(byText("Mobile")).parent().shouldHave(text(userNumber));
    }

    public void checkResultsDateOfBirth(String day, String month, String year) {
        $(".table-responsive")
                .$(byText("Date of Birth")).parent()
                .shouldHave(text(day + " " + month + "," + year));
    }

    public void checkResultsSubjects(String[] subjects) {
        $(".table-responsive")
                .$(byText("Subjects")).parent().shouldHave(text(subjects[0] + ", " + subjects[1]));
    }

    public void checkResultsHobbies(String hobbies) {
        $(".table-responsive")
                .$(byText("Hobbies")).parent().shouldHave(text(hobbies));
    }

    public void checkResultsAddress(String address) {
        $(".table-responsive")
                .$(byText("Address")).parent().shouldHave(text(address));
    }

    public void checkResultsPicture(File picture) {
        $(".table-responsive")
                .$(byText("Picture")).parent().shouldHave(text(picture.getName()));
    }

    public void checkResultsStateAndCity(String state, String city) {
        $(".table-responsive")
                .$(byText("State and City")).parent().shouldHave(text(state + " " + city));
    }
}
