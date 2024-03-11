/*package com.makcats.iiq;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.Identity;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class userOperations {

	public static void main(String args[]) throws GeneralException {
		
		SpringStarter starter = new SpringStarter("iiqBeans");
		starter.start();
		
		SailPointContext context =  SailPointFactory.createContext();
		
		Identity userInfo = context.getObject(Identity.class, "James.Smith");
		String email = userInfo.getEmail();
		String firstName = userInfo.getFirstname();
		
		System.out.println(email+ " "+ firstName);
			
		starter.close();
		
		
	}
}
*/


package com.makcats.iiq;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.Identity;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class userOperations {

    public static void main(String args[]) throws GeneralException {

        SpringStarter starter = new SpringStarter("iiqBeans");
        starter.start();

        SailPointContext context =  SailPointFactory.createContext();

        Identity userInfo = context.getObject(Identity.class, "James.Smith");

        // Storing old values
        String oldEmail = userInfo.getEmail();
        String oldFirstName = userInfo.getFirstname();

        // Setting new values
        userInfo.setEmail("James.Smith@demoexample.com");
        userInfo.setFirstname("James ");
        //

        // Saving the changes
        context.saveObject(userInfo);
        context.commitTransaction();

        // Retrieving updated values
        String newEmail = userInfo.getEmail();
        String newFirstName = userInfo.getFirstname();

        // Printing old and new values
        System.out.println("Old Values:");
        System.out.println("Email: " + oldEmail);
        System.out.println("First Name: " + oldFirstName);

        System.out.println("\nNew Values:");
        System.out.println("Email: " + newEmail);
        System.out.println("First Name: " + newFirstName);
        
        Identity newIdentity= createNewUser(context);
        context.saveObject(newIdentity);
        context.commitTransaction();
        context.close();

        starter.close();
    }

	private static Identity createNewUser(SailPointContext context) {
		Identity newIdentity= new Identity();
		newIdentity.setAttribute("empId", "1a2b3c4d5e6f");
		newIdentity.setFirstname("Uday");
		newIdentity.setLastname("Kudithipudi");
		newIdentity.setName("Uday.Kudithipudi");
		newIdentity.setEmail("uday.cmich@gmail.com");
		newIdentity.setAttribute("manager", "Aaron.Nichols");		
		newIdentity.setAttribute("department", "Executive Management");
		
		
		
		
		return newIdentity;
	}
    
    
   
}

