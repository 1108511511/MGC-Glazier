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
    public static String selectProductListStmt(int jobID) {
        String statement = ("SELECT * FROM product WHERE job_id = " + jobID);
        return statement;
    }
    
    public static String selectJobListStmt() {
        String statement = (
            "SELECT job_id, job_status, tax_percent, discount_percent, "
          + "job_qty_used, customer_cust_abn, cust_first_name, cust_last_name "  
          + "FROM job LEFT JOIN customer "
          + "ON job.customer_cust_abn = customer.cust_abn ");
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
            boolean lockable, String description, boolean setting, 
            String glassType) {
        String statement = (
                "INSERT INTO product "
              + "(product_dimension_height, product_dimension_width,"
              + "product_dimension_thickness, product_flag_lockable, setting,"
              + "stock_glass_type "
              + "VALUES ('" + height + "','" + width + "','" + thickness  + "','"
              + lockable + "','" + description + "','" + setting + "','" 
              + glassType);
        return statement;
    }
    
//    public static String insertNewEmployeeStmt(
//            int employeeId, String firstName, 
//            String lastName, String employeeRole) {
//        
//    }

}
