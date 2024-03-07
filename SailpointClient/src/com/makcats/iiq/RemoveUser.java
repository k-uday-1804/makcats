package com.makcats.iiq;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.Identity;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class RemoveUser {
	public static void main(String args[]) throws GeneralException {
		SpringStarter starter = new SpringStarter("iiqBeans");
        starter.start();

        SailPointContext context = SailPointFactory.createContext();
        
        Identity identityToRemove = getIdentityToRemoveByName(context,"Adithya.Gopal");
        
        if(identityToRemove!=null) {
        	context.removeObject(identityToRemove);
        	context.commitTransaction();
        	System.out.println("Identity deleted succesfully.");
        }else {
        	System.out.println("Identity not found");
        }
       
        
        context.close();
        starter.close();
	}

	private static Identity getIdentityToRemoveByName(SailPointContext context, String name) throws GeneralException {
		return context.getObjectByName(Identity.class, name);
	}

}
