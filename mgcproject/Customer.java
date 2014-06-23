package mgcproject;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private String customerAbn;
    private String baStreet;
    private String baSuburb;
    private String baState;
    private String postCode;
    private String phoneNu;
    
    Customer(String customerABN, String fName, String lName, String baStreet, String baSuburb, String baState, String postCode, String phoneNu ) {
        super(fName,lName);
        this.customerAbn = customerABN;
        this.baState = baState;
        this.baStreet = baStreet;
        this.baSuburb = baSuburb;
        this.phoneNu = phoneNu;
        this.postCode = postCode;
    }

    /**
     * @return the managerId
     */
    public String getCustomerABN() {
        return customerAbn;
    }

    /**
     * @param CustomerAbn the managerId to set
     */
    public void setCustomerABN(String CustomerAbn) {
        this.customerAbn = CustomerAbn;
    }
    
    public static void writeToDB(Customer c) {
        List<Object> l = c.getFields();
        String abn = (String)l.get(0);
        String firstName = (String)l.get(1);
        String lastName = (String)l.get(2);
        String phone = (String)l.get(3);
        String street = (String)l.get(4);
        String suburb = (String)l.get(5);
        String state = (String)l.get(6);
        String postcode = (String)l.get(7);
        
        Query.writeToTable(SQLStatements.insertCustomerStmt(
                abn, firstName, lastName, phone, street, suburb, state, postcode));
    }
    
    @Override
    public List getFields(){
        List<Object> list = new ArrayList<Object>();
        list.add(customerAbn);
        list.add(super.getFirstName());
        list.add(super.getLastName());
        list.add(phoneNu);
        list.add(baStreet);
        list.add(baSuburb);
        list.add(baState);                
        list.add(postCode);
        return list;
    }
}
