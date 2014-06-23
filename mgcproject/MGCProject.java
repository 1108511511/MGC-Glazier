package mgcproject;

import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author 3106909413
 */
public class MGCProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        Product p = new Product("Delicate", true, false, 12, 32, 10, 2);
        Product.writeToDB(p);
        Query.printFromTable(SQLStatements.selectProductListStmt());
               
    }
}

