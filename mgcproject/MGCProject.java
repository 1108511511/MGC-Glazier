package mgcproject;

import java.sql.SQLException;

/**
 *
 * @author 3106909413
 */
public class MGCProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {          
        Product p = new Product("Tough", true, true, 12, 23, 3, 1);
        System.out.println(p.getUnitPrice());
        System.out.println(p.getProductPrice());
    }
}
