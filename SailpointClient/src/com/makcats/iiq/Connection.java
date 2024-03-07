/*package com.makcats.iiq;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.Identity;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class Connection {
	
	public static void main(String[] args) throws GeneralException {
		
		SpringStarter starter = new SpringStarter("iiqBeans");
		starter.start();
		SailPointContext context = SailPointFactory.createContext();
		Identity identity = context.getObject(Identity.class, "spadmin");
		String displayName=identity.getDisplayableName();
		System.out.println("Identity Datails" + identity.getFirstname() +"==========="+ identity.getLastname());
		System.out.println(displayName);
		 starter.close();
	}

} 
*/

package com.makcats.iiq;


import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.Filter;
import sailpoint.object.Identity;
import sailpoint.object.QueryOptions;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Iterator;
import java.util.List;


public class Connection {

    public static SailPointContext context;
      public static void main(String[] args) throws GeneralException {
          SpringStarter starter = new SpringStarter("iiqBeans");
          starter.start();
           getInfo1(getContext());
          starter.close();
     }

     private static SailPointContext getContext()  {
         //IIQ propeties file must be present in java project.
         SailPointContext context = null;
         try {
            context = SailPointFactory.createContext();
           } catch (GeneralException e) {
             throw new RuntimeException(e);
         }
         return context;
     }
     private static  Log getLog(String loggerName){
          Log log = LogFactory.getLog(loggerName);
          return log;
     }


     public static void getInfo1(SailPointContext context) throws GeneralException {
//         Identity identity = context.getObject(Identity.class, "Nichols");
//
//         System.out.println(identity.getLastname());
//         System.out.println(identity.getFirstname());
//         System.out.println(identity.getEmail());
//         System.out.println(identity.getAttribute("empId"));
//         System.out.println(identity.getId());

         //List<Identity> identities = context.getObjects(Identity.class);

         Filter filter= Filter.eq("lastname","Nichols");
         QueryOptions qo= new QueryOptions(filter);
         List<Identity> identityList = context.getObjects(Identity.class, qo);


         Iterator<Identity> iterator = identityList.iterator();
         while(iterator.hasNext()){
             Identity identity = iterator.next();
             System.out.println(identity.getLastname());
         System.out.println(identity.getFirstname());
         System.out.println(identity.getEmail());
         System.out.println(identity.getAttribute("empId"));
         System.out.println(identity.getId());
         }


//         for (Identity id:identities ) {
//
//             if(id.getLastname().equals("Nichols")) {
//                 System.out.println(id.getLastname());
//                 System.out.println(id.getFirstname());
//                 System.out.println(id.getEmail());
//                 System.out.println(id.getAttribute("empId"));
//                 System.out.println(id.getId());
//             }
//
//         }


         //  Nichols



     }


}
