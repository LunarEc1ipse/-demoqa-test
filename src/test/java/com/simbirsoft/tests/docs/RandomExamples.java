package com.simbirsoft.tests.docs;



import static com.simbirsoft.tests.utils.RandomUtils.*;

public class RandomExamples {
    public static void main(String[] args) {
        System.out.println(getRandomString(50));
        String randomMessage =  getRandomMessage(100,500);
        System.out.println(randomMessage);
        System.out.println(getRandomInt(100000,564356345) + "");
        String randomPhone = getRandomPhone();
        System.out.println(randomPhone);

        String randomPhoneWithPrefix = getRandomPhone("+7");
        System.out.println(randomPhoneWithPrefix);

        String difficultRandomPhoneWithPrefix = getDifficultRandomPhone("+8");
        System.out.println(difficultRandomPhoneWithPrefix);
        String randomEmail = getRandomEmail();
        System.out.println(randomEmail);
    }

}
