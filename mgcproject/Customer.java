package mgcproject;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;

public class Customer extends Person {
    private String customerAbn;
    private String baStreet;
    private String baSuburb;
    private String baState;
    private String postCode;
    private String phoneNu;
    private String phoneNu2nd;
    private String shpStreet, shpSuburb, shpState, shpPostCode;
    
    Customer() {
        super();
    }
    
    Customer(String customerABN, String fName, String lName, String baStreet, 
            String baSuburb, String baState, String postCode, String phoneNu,
            String phoneNu2nd, String shpStreet, String shpSuburb, 
            String shpState, String shpPostCode) {
        super(fName,lName);
        this.customerAbn = customerABN;
        this.baState = baState;
        this.baStreet = baStreet;
        this.baSuburb = baSuburb;
        this.phoneNu = phoneNu;
        this.phoneNu2nd = phoneNu2nd;
        this.postCode = postCode;
        this.shpStreet = shpStreet;
        this.shpSuburb = shpSuburb;
        this.shpState = shpState;
        this.shpPostCode = shpPostCode;
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
    
    public static Customer getCustomerFromDB(int abn) {
        Customer newCust = new Customer();
        try {
            CachedRowSet crs = new CachedRowSetImpl();
            crs = Query.readFromTable(SQLStatements.selectCustomerDetailsStmt(abn));
            while (crs.next()) {
                String customerABN = crs.getString("cust_abn"); 
                String fName = crs.getString("cust_first_name");  
                String lName = crs.getString("cust_last_name");  
                String baStreet = crs.getString("cust_primary_phone_number"); 
                String baSuburb = crs.getString("cust_secondary_phone_number"); 
                String baState = crs.getString("cust_billing_addr_street"); 
                String postCode = crs.getString("cust_billing_addr_suburb"); 
                String phoneNu = crs.getString("cust_billing_addr_state");
                String phoneNu2nd = crs.getString("cust_billing_addr_postcode"); 
                String shpStreet = crs.getString("cust_delivery_addr_street"); 
                String shpSuburb = crs.getString("cust_delivery_addr_suburb"); 
                String shpState = crs.getString("cust_delivery_addr_state"); 
                String shpPostCode = crs.getString("cust_delivery_addr_postcode");
                newCust = new Customer(customerABN, fName, lName, baStreet,
                        baSuburb, baState, postCode, phoneNu, phoneNu2nd, 
                        shpStreet, shpSuburb, shpState, shpPostCode);
                
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return newCust;
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
        
        //TODO update writeToTable parametes and SQL string to take customer delivery address
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
        list.add(phoneNu2nd);
        list.add(baStreet);
        list.add(baSuburb);
        list.add(baState);                
        list.add(postCode);
        list.add(shpStreet);
        list.add(shpSuburb);
        list.add(shpState);
        list.add(shpPostCode);
        return list;
    }
}
