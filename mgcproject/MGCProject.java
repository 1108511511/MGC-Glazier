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
        try {
            Query.writeToTable("INSERT INTO person VALUES ('Jane', 'Doe', 23);");
            Query.printFromTable("SELECT * FROM person;");            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }  
    }
}
