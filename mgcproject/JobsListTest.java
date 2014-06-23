
package mgcproject;

/**
 *
 * @author 3106909413
 */
public class JobsListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                  
        
        System.out.println("testing");                      
        
        // Create new job list
        Job.getJobList();
        Job.printJobList();
        
        Job.getProductListPerJob();
        Job.printProductList(1);

    }
}

