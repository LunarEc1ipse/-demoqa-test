package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    public static String getRandomArrayValue(String[] array) {
        int randomValue = new Random().nextInt(array.length);
        return array[randomValue];
    }

    @BeforeAll
    public static void beforeAll(){
        Configuration.browserSize = "2100x1400";

    }

    @Test
    public void fillFromTest(){

        String gender = getRandomArrayValue(new String[]{"Male", "Female", "Other"});
        String hobbies = getRandomArrayValue(new String[]{"Sports", "Reading", "Music"});
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userEmail = "IvanIvanov@mail.ru";
        String userNumber = "8999777665";
        String[] subjectsInput = new String[]{"Maths", "English"};
        String currentAddress = "Random Address";
        String state = "NCR";
        String city = "Delhi";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(userNumber);
        $(byText(gender)).click();
        $("#subjectsInput").setValue(subjectsInput[0]).pressEnter();
        $("#subjectsInput").setValue(subjectsInput[1]).pressEnter();
        $(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/hello.txt"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1993");
        $x("//div[contains(@aria-label, \"November 3rd, 1993\")]").click();




        $("#submit").click();

        $(".table-responsive")
                .$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("3 November,1993"));
        $(".table-responsive")
                .$(byText("Subjects")).parent().shouldHave(text(subjectsInput[0] + ", "+ subjectsInput[1]));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbies));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("hello.txt"));
        $(".table-responsive")
                .$(byText("State and City")).parent().shouldHave(text(state + " " + city));


    }
}
