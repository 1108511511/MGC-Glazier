package mgcproject;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 3106909413
 */
public class MGCProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {          
//        try {
//            Query.printFromTable("SELECT * FROM customer;");            
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }  
        
        // Create new job list
        System.out.println("testing");                      
        
        Job.getJobList();
        Job.printJobList();
        Job.printProductList(1);
        
        JobTable jt = new JobTable();
        jt.setVisible(true);
    }
}
