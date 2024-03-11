package com.makcats.iiq;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.Identity;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class getUser {

    public static void main(String args[]) throws GeneralException {
        SpringStarter starter = new SpringStarter("iiqBeans");
        starter.start();

        SailPointContext context = SailPointFactory.createContext();
        
        Identity userInfo = context.getObject(Identity.class, "Adithya.Gopal");
        
        if (userInfo != null) {
            String firstName = userInfo.getFirstname();
            String lastName = userInfo.getLastname();
            String email = userInfo.getEmail();
            Identity manager = userInfo.getManager();
            Object department = userInfo.getAttribute("department");
            
            System.out.println(firstName + " " + lastName + " " + email + " " + manager + " " + department);
        } else {
            System.out.println("User not found.");
        }
//        
        context.close();
        starter.close();
        
    }
}
