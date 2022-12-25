package com.simbirsoft.tests.tests;

import com.github.javafaker.Faker;

import java.io.File;
import java.time.Month;
import java.util.Random;

public class TestData {

    public static String gender = getRandomArrayValue(new String[]{"Male", "Female", "Other"});
    public static String hobbies = getRandomArrayValue(new String[]{"Sports", "Reading", "Music"});
    public static File picture = new File("src/test/resources/hello.txt");
    public static String state = "NCR";
    public static String city = "Delhi";
    public static String[] subjects = new String[]{"Maths", "English"};
    private static final Faker faker = new Faker();
    private static final String rawMonth = String.format(String.valueOf(Month.of(faker.number().numberBetween(1, 12))));
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.numerify("89########"),
            currentAddress = faker.address().fullAddress(),
            day = "3",
            month = rawMonth.substring(0, 1).toUpperCase() + rawMonth.substring(1).toLowerCase(),
            year = String.valueOf(faker.number().numberBetween(1930, 2000));

    private static String getRandomArrayValue(String[] array) {
        int randomValue = new Random().nextInt(array.length);
        return array[randomValue];
    }
}
