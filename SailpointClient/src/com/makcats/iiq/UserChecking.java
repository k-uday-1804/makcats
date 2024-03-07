package com.makcats.iiq;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.Identity;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class UserChecking {

    public static void main(String args[]) throws GeneralException {
        SpringStarter starter = new SpringStarter("iiqBeans");
        starter.start();

        SailPointContext context = SailPointFactory.createContext();

        // Initialize variables
        String firstName = "Adithya";
        String lastName = "Gopal";
        String username = generateUniqueUsername(context, firstName, lastName);
        
        Identity userInfo = context.getObject(Identity.class, username);
        
        if (userInfo == null) {
            // User does not exist, create new user
            userInfo = new Identity();
            userInfo.setFirstname(firstName);
            userInfo.setLastname(lastName);
            userInfo.setName(username);
            // Set other attributes as needed
            
            // Save the user
            context.saveObject(userInfo);
            context.commitTransaction();
            
            System.out.println("User Created:");
            System.out.println("Name: " + userInfo.getName());
            System.out.println("Email: " + userInfo.getEmail());
        } else {
            // User exists, handle accordingly
            System.out.println("User with username " + username + " already exists.");
        }

        context.close();
        starter.close();
    }

    private static String generateUniqueUsername(SailPointContext context, String firstName, String lastName) throws GeneralException {
        String username = firstName + "." + lastName;
        int count = 1;
        while (context.getObject(Identity.class, username) != null) {
            username = firstName + count + "." + lastName;
            count++;
        }
        return username;
    }
}
