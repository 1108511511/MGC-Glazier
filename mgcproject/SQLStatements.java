/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package mgcproject;

/**
*
* @author Daniel Bassett
*/
public class SQLStatements { 
 
    // SELECT FROM TABLE
    public static String selectProductListStmt() {
        String statement = "SELECT * FROM product";
        return statement;
    }
    
//    public static String selectProductListStmt(int jobID) {
//        String statement = ("SELECT * FROM product WHERE job_id = " + jobID);
//        return statement;
//    }
    
    public static String selectJobListStmt() {
        String statement = 
            "SELECT job_id, job_status, tax_percent, discount_percent, "
          + "job_qty_used, customer_cust_abn, cust_first_name, cust_last_name "  
          + "FROM job LEFT JOIN customer "
          + "ON job.customer_cust_abn = customer.cust_abn ";
        return statement;
    }
    
    public static String selectCustomerListStmt() {
        String statement = (
                "SELECT cust_abn, cust_first_name, cust_last_name "
              + "FROM customer");
        return statement;
    }
    
    public static String selectCustomerDetailsStmt(String custABN) {
        String statement = ("SELECT * FROM customer WHERE cust_abn = " 
                + custABN);
        return statement;
    } 
       
    public static String selectEmployeeListStmt() {
        String statement = ("SELECT * FROM employee");
        return statement;
    }
    
    public static String selectPriceStmt(String glassType) {
        String statement = (
                "SELECT price FROM stock "
              + "WHERE glass_type = '" + glassType + "'");
        return statement;
    }       
    
    public static String selectMaxEmployeeIdStmt() {
        String statement = ("SELECT MAX(employee_id) AS employee_id FROM employee");
        return statement;
    }
    
    // UPDATE TABLE
    public static String updatePriceStmt(double price, String glassType) {
        String statement = (
                "UPDATE stock SET price = '" + price + "'"
              + "WHERE glass_type ='" + glassType + "'");
        return statement;
    }
    
    public static String updateStockLevelStmt(int stockLevel, String glassType) {
        String statement = (
                "UPDATE stock SET stock_level = '" + stockLevel + "'"
              + "WHERE glass_type ='" + glassType + "'");
        return statement;
    }       
    
    
    // INSERT INTO TABLE
    public static String insertProductStmt (
            int height, int width, int thickness,
            boolean lockable, String description, 
            String glassType, boolean outdoor, int quantity) {
        int isLockable = 0;
        int isOutdoor = 0;
        if(lockable) {isLockable = 1;}
        if(outdoor) {isOutdoor = 1;}
        String statement = 
                "INSERT INTO product "
              + "(product_dimension_height, product_dimension_width,"
              + "product_dimension_thickness, product_flag_lockable, "
              + "product_description, stock_glass_type, product_setting, quantity) "
              + "VALUES('" + height + "','" + width + "','" + thickness  + "','"
              + isLockable + "','" + description + "','" + glassType + "','" 
              + isOutdoor + "','" + quantity + "')";
        return statement;
    }
    
    public static String insertEmployeeStmt(
            int employeeId, String firstName, 
            String lastName, String employeeRole, String password) {
        String statement = "INSERT INTO employee "
                + "VALUES('" + employeeId + "','" + firstName
                + "','" + lastName + "','" + employeeRole + "','" 
                + password + "')";
        return statement;
    }
    
    public static String insertCustomerStmt(
            String abn, String firstName, String lastName, String phone, 
            String street, String suburb, String state, String postcode) {
        String statement = "INSERT INTO customer(cust_abn, cust_first_name, "
                + "cust_last_name, cust_primary_phone_number, "
                + "cust_billing_addr_street, cust_billing_addr_suburb,"
                + "cust_billing_addr_state, cust_billing_addr_postcode) "
                + "VALUES('" + abn + "','" + firstName
                + "','" + lastName + "','" + phone + "','" 
                + street + "','" + suburb + "','" + state 
                + "','" + postcode + "')";
        return statement;
    }

}
