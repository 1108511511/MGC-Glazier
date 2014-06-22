/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgcproject;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;


/**
 *
 * @author 1108511511
 */
public class Employee extends Person {
    private int employeeId;
    private String employeeRole;
    private String password;

    
    Employee() {
        super();
        employeeId = 0;
    }

    
    Employee(String firstName, String lastName, String employeeRole, String password) {
        super(firstName,lastName);
        this.employeeId = getEmployeeIdFromDB() + 1;
        this.employeeRole = employeeRole;
        this.password = password;
    }
    
    private int getEmployeeIdFromDB() {
        try {
            CachedRowSet crs = new CachedRowSetImpl();
            crs = Query.readFromTable(SQLStatements.selectMaxEmployeeIdStmt()); 
            crs.next();
            int maxId = crs.getInt("employee_id");
            return maxId;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
    }

    /**
     * @return the employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public static void writeToDB(Employee e) {
        List<Object> l = e.getFields();
        int employeeId = (Integer)l.get(0);
        String firstName = (String)l.get(1);
        String lastName = (String)l.get(2);
        String role = (String)l.get(3);
        String password = (String)l.get(4);
        
        Query.writeToTable(SQLStatements.insertEmployeeStmt(employeeId, firstName, lastName, role, password));
    }
    
    @Override
    public List getFields(){
        List<Object> list = new ArrayList<Object>();
        list.add(employeeId);
        list.add(super.getFirstName());
        list.add(super.getLastName());
        list.add(employeeRole);
        list.add(password);
        return list;          
    }
    
}
