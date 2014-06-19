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
    
    Person() {
        firstName = "Not Set";
        lastName = "Not set";
    }
    
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
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

    @Override
    public String toString() {
        return "\n\nFirst Name: " + this.firstName + "\n Last Name: " + this.lastName;
    }
    
    public List getFields() {
        List<Object> myList = new ArrayList<Object>() {};
        myList.add(firstName);
        myList.add(lastName);
        return myList;
    }
}