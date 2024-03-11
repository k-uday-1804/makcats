package com.makcats.iiq;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.Identity;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class userCreation {

    public static void main(String args[]) throws GeneralException {
        SpringStarter starter = new SpringStarter("iiqBeans");
        starter.start();

        SailPointContext context = SailPointFactory.createContext();
              
       
        
        Identity newIdentity = createNewUser(context);
        context.saveObject(newIdentity);
        context.commitTransaction();

        System.out.println("New User Created:");
        System.out.println("Name: " + newIdentity.getName());
        System.out.println("Email: " + newIdentity.getEmail());
        System.out.println("Attributes:");
        printAttributes(newIdentity);
        
        context.close();
        starter.close(); 
    }

    private static Identity createNewUser(SailPointContext context) throws GeneralException {
        Identity newIdentity = new Identity();
        newIdentity.setAttribute("empId", "1a2b3c4d5e6f");
        newIdentity.setFirstname("Adithya");
        newIdentity.setLastname("Gopal");
        newIdentity.setName("Adithya.Gopal");
        
        newIdentity.setEmail("adithya.gopal@gmail.com");
        newIdentity.setAttribute("jobtitle", "Azure Data Engineer");
        newIdentity.setAttribute("location", "Europe");
        newIdentity.setAttribute("region", "Grand Rapids");

        
        newIdentity.setAttribute("department", "Executive Management");
      
//
        return newIdentity;
    }

    private static void printAttributes(Identity identity) {
        identity.getAttributes().forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
    }
    
