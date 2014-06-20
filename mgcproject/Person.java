/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgcproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1108511511
 */
public class Person {
    private String firstName;
    private String lastName;
    private String setFirstName;
    
    Person(){
        firstName = "Not Set";
        lastName = "Not set";
    }
    
    Person(String fName,String lName)
    {
        firstName = fName;
        lastName = lName;
    }
    
    public void setFirstName(String fname)
    {
        this.firstName = fname;
    }
    
    public String getFirstName()
    {
        return this.firstName;
    
}

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the setFirstName
     */
    public String getSetFirstName() {
        return setFirstName;
    }

    /**
     * @param setFirstName the setFirstName to set
     */
    public void setSetFirstName(String setFirstName) {
        this.setFirstName = setFirstName;}
    
    @Override
    public String toString()
    {
    return "\n\nFirst Name: " + this.firstName + "\n Last Name: " + this.lastName;
    }
    
    public List getFields() {
        List<Object> myList = new ArrayList<Object>() {};
        myList.add(firstName);
        myList.add(lastName);
        return myList;
    }
}