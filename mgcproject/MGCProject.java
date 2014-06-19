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
        Employee e = new Employee("Pete", "Cornell", "manager", "password");
        System.out.println(e.getEmployeeId());
    }
}
