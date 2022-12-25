package com.simbirsoft.tests.tests;

import java.io.File;
import java.util.Random;

public class TestData {

    public static String gender = getRandomArrayValue(new String[]{"Male", "Female", "Other"});
    public static String hobbies = getRandomArrayValue(new String[]{"Sports", "Reading", "Music"});
    public static String firstName = "Ivan";
    public static String lastName = "Ivanov";
    public static String userEmail = "IvanIvanov@mail.ru";
    public static File picture = new File("src/test/resources/hello.txt");

    public static String userNumber = "8999777665";
    public static String[] subjects = new String[]{"Maths", "English"};
    public static String currentAddress = "Random Address";
    public static String state = "NCR";
    public static String city = "Delhi";

    private static String getRandomArrayValue(String[] array) {
        int randomValue = new Random().nextInt(array.length);
        return array[randomValue];
    }
}
