/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgcproject;

/**
 *
 * @author 1108511511
 */
public class Employee extends Person{
    private int employeeId;
    private enum employeeRole{GLAZIER, SALES, MANAGER};
    
    Employee(){
        super();
        employeeId = 0;
    }
    Employee(int employID, String fName, String lName, enum employeeRole{} ){
    super(fName,lName);
    this.employeeId = employID;
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
