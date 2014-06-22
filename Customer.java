package person;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{
    private int customerAbn;
    private String baStreet;
    private String baSuburb;
    private String baState;
    private int postCode;
    private int phoneNu;
    
    Customer(){
        super();
       
    }
    Customer(int customerABN, String fName, String lName, String baStreet, String baSuburb, String baState, int postCode, int phoneNu ){
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
    public int getCustomerABN() {
        return customerAbn;
    }

    /**
     * @param CustomerAbn the managerId to set
     */
    public void setCustomerABN(int CustomerAbn) {
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