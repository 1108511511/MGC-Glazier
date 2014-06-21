/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package mgcproject;

/**
*
* @author 3106909413
*/
public class SQLStatements {
    
    public static String getProductList (int jobID) {
        String statement = ("SELECT * FROM product WHERE job_id = " + jobID);
        return statement;
    }
    
    public static String getJobList () {
        String statement = (
            "SELECT job_id, job_status, tax_percent, dsicount_percent "
          + "job_qty_used, customer_cust_abn, cust_first_name, cust_last_name "  
          + "FROM job LEFT JOIN customer "
          + "ON job.customer_cust_abn = customer.cust_abn ");
        return statement;
    }
    
    public static String getCustomerList () {
        String statement = ("SELECT * FROM customer");
        return statement;
    }
       
    public static String getEmployeeList () {
        String statement = ("SELECT * FROM employee");
        return statement;
    }
    
    public static String setPrice (double price, String glassType) {
        String statement = (
                "UPDATE stock SET price = '" + price + "'"
              + "WHERE glass_type ='" + glassType + "';");
        return statement;
    }
    
    public static String setStockLevel (int stockLevel, String glassType) {
        String statement = (
                "UPDATE stock SET stock_level = '" + stockLevel + "'"
              + "WHERE glass_type ='" + glassType + "';");
        return statement;
    }
}
