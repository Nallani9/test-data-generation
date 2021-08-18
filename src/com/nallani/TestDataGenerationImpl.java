package com.nallani;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestDataGenerationImpl {

    public String generateData_Username(){
        Random rand = new Random();
        Integer b = rand.nextInt(1000);
        String a = generateRandomWord(3);
        System.out.println(a.toLowerCase() + b.toString());
        return a + b.toString();
    }

    public String generateData_PhoneNumber(){
        double a = Math.random();
        System.out.println(String.valueOf(a).substring(2, 12));

        return String.valueOf(a).substring(2, 12);
    }

    public String generateData_Zip(){
        Random rand = new Random();
        Integer a = rand.nextInt(100000);
        System.out.println(a.toString());
        return a.toString();
    }

    public String generateData_Address1(){
        Random rand = new Random();
        Integer a = rand.nextInt(10000);
        String abc  = generateRandomWord(8);
        System.out.println(a.toString()+" "+ generateRandomWord(8) + " Ave");
        return a.toString() + " " + generateRandomWord(8) + " Ave";
    }

    public String generateData_Email(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        System.out.println(saltStr);
        return saltStr+"@gmail.com";
    }

    public String generateRandomWord(int length){
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        System.out.println(generatedString);
        return generatedString;
    }

    public String generatePassword(){
        RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(33, 45)
                .build();
        String generatedString = pwdGenerator.generate(9);

        System.out.println(generatedString);
        return generatedString;
    }

    public String generateDOB() {

        Instant inc = Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt());
        String abc = inc.toString();
        System.out.println(abc.substring(0,10));
        return abc.substring(0,10);
    }
}
