/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package mgcproject;

/******************************************************************
* SQL Statements for accessing and manipulating database.
* Methods are ordered in sections of selecting, updating and inserting data.
* @author Daniel Bassett, Peter Cornell
******************************************************************/ 

public class SQLStatements { 
  
    /******************************************************************
     * SELECT FROM table SQL statements
     * @return statement.
    *******************************************************************/
    public static String selectProductListStmt() {
        String statement = "SELECT * FROM product";
        return statement;
    }
    
    public static String selectProductListStmt(int jobID) {
        String statement = ("SELECT * FROM product WHERE job_job_id = '" 
                + jobID + "'");
        return statement;
    }
    
    public static String selectJobListStmt() {
        String statement = 
            "SELECT job_id, job_status, tax_percent, discount_percent, "
          + "job_qty_used, customer_cust_abn, cust_first_name, cust_last_name "  
          + "FROM job LEFT JOIN customer "
          + "ON job.customer_cust_abn = customer.cust_abn ";
        return statement;
    }
    
    public static String selectPriceStmt(String glassType) {
        String statement = (
                "SELECT price FROM stock "
              + "WHERE glass_type = '" + glassType + "'");
        return statement;
    }  
    
    public static String selectCustomerListStmt() {
        String statement = (
                "SELECT cust_abn, cust_first_name, cust_last_name "
              + "FROM customer");
        return statement;
    }
    
    public static String selectCustomerDetailsStmt(String custABN) {
        String statement = ("SELECT * FROM customer WHERE cust_abn = '" 
                + custABN + "'");
        return statement;
    } 
       
    public static String selectEmployeeListStmt() {
        String statement = ("SELECT * FROM employee");
        return statement;
    }
    
    // Select from DB the employee that match login credentials.
    public static String selectEmployeeLoginStmt(int employeeID, String password) {
        String statement = (
                "SELECT * FROM employee "
              + "WHERE employee_id = '" + employeeID + "' AND "
              + "employee_password = '" + password + "'");
        return statement;
    }
     
    public static String selectMaxEmployeeIdStmt() {
        String statement = ("SELECT MAX(employee_id) AS employee_id FROM employee");
        return statement;
    }
    
    
    /******************************************************************
     * UPDATE table SQL statements
     * @return statement.
    *******************************************************************/
    // Update the price of glass type in DB
    public static String updatePriceStmt(double price, String glassType) {
        String statement = (
                "UPDATE stock SET price = '" + price + "' "
              + "WHERE glass_type = '" + glassType + "'");
        return statement;
    }
    
    public static String updateStockLevelStmt(int stockLevel, String glassType) {
        String statement = (
                "UPDATE stock SET stock_level = '" + stockLevel + "' "
              + "WHERE glass_type = '" + glassType + "'");
        return statement;
    }
    
    // Overwrite the system tax rate with a new one, updating all jobs in DB. 
    // Note: Statement flexible to allow for potential 'completed jobs'.
    public static String updateTaxRateStmt(double taxRate) {
        String statement = (
                "UPDATE job SET tax_percent = '" + taxRate + "' "
              + "WHERE job_status = 'Quote' "
              + "OR job_status = 'Uncommited Quote' "
              + "OR job_status = 'Unapproved Quote' "
              + "OR job_status = 'Approved Job");
        return statement;
    }
    
    // Update label with new discount value and save to job.
    public static String updateDiscountStmt(int jobID, double discount) {
        String statement = (
                "UPDATE job SET discount_percent = '" + discount + "' "
              + "WHERE job_id = '" + jobID + "'");
        return statement;
    }
    
    // Save the new glazier to the DB for that job.
    public static String updateGlazierForJobStmt(int jobID, int employeeID) {
        String statement = (
                "UPDATE job SET employee_employee_id = '" + employeeID + "' "
              + "WHERE job_id = '" + jobID + "'");
        return statement;
    }  
    
    
    /******************************************************************
     * INSERT INTO table SQL statements
     * @return statement.
    *******************************************************************/
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
    
    public static String insertEmployeeStmt(
            int employeeId, String firstName, 
            String lastName, String employeeRole, String password) {
        String statement = "INSERT INTO employee "
                + "VALUES('" + employeeId + "','" + firstName
                + "','" + lastName + "','" + employeeRole + "','" 
                + password + "')";
        return statement;
    }

}
