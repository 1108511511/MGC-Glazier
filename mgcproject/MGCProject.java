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
        Employee e = new Employee("Rustin", "Cole", "SalesPerson", "flatcircle");
        Employee.writeToDB(e);
        Query.printFromTable(SQLStatements.selectEmployeeListStmt());
    }
}
