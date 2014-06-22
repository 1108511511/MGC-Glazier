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
    
    @Override
    public List getFields(){
        List<Object> list = new ArrayList<Object>();
        list = super.getFields();
        list.add(employeeRole);
        list.add(employeeId);
        return list;          
    }
    
}
