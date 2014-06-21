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
    @Override
    public List getFields(){
        List<Object> list = new ArrayList<Object>();
        list = super.getFields();
        list.add(customerAbn);
        list.add(baState);
        list.add(baSuburb);
        list.add(baStreet);
        list.add(phoneNu);
        list.add(postCode);
        return list;
    }
}