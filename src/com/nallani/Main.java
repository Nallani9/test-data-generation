package com.nallani;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nallani.model.Address;
import com.nallani.model.FullName;
import com.nallani.model.Registation;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        TestDataGenerationImpl test = new TestDataGenerationImpl();
        FullName fullName = new FullName();
        Address address = new Address();
        ObjectMapper mapper = new ObjectMapper();
        Registation registation = new Registation();

        for (int i = 0; i <= 1; i++) {

            System.out.print("The loop number is...... ");
            System.out.print(i);
            System.out.println("");
           // TestDataGenerationImpl test = new TestDataGenerationImpl();

           // FullName fullName = new FullName();
            fullName.setFirstName(test.generateRandomWord(9));
            fullName.setLastName(test.generateRandomWord(7));

          //  Address address = new Address();
            address.setLine1(test.generateData_Address1());
            address.setCity("Richmond");
            address.setState("Va");
            address.setPostalCode(test.generateData_Zip());

           // Registation registation = new Registation();
            registation.setUsername(test.generateData_Username());
            registation.setPassword(test.generatePassword());
            registation.setFullName(fullName);
            registation.setAddress(address);
            registation.setEmail(test.generateData_Email());
            registation.setPhone(test.generateData_PhoneNumber());
            registation.setDateOfBirth(test.generateDOB());

          //  ObjectMapper mapper = new ObjectMapper();
            String testData = mapper.writeValueAsString(registation);

            CreateFile createFile = new CreateFile();
            try {
                createFile.createFileAndWrite(testData);

            } catch (Exception e) {
                System.out.println("Unable to write data to file");
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("Counting to 10000000 takes " +(end - start) + "ms");
    }

}
