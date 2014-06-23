/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgcproject;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author 3106909413
 */
public class Job {
    // fields
    private int jobId;
    private String jobStatus;
    private double taxPercent;
    private double discountPercent;
    private static ArrayList<Job> jobsList = new ArrayList<Job>();
    private ArrayList<Product> productList = new ArrayList<Product>();
    private Customer customer;
    private Employee employee;

    // constructors
    public Job(String jobStatus, double discountPercent, 
            ArrayList<Product> productList, 
            Customer customer) {
        this.jobId = getJobIdFromDB() + 1;
        this.jobStatus = jobStatus;
        this.taxPercent = getGlobalTaxRate();
        this.discountPercent = discountPercent;
        this.productList = productList;
        this.customer = customer;
        this.employee = null;
    }
    
    // methods
    private int getJobIdFromDB() {
        try {
            CachedRowSet crs = new CachedRowSetImpl();
            crs = Query.readFromTable(SQLStatements.selectMaxJobIdStmt()); 
            crs.next();
            int maxId = crs.getInt("job_id");
            return maxId;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
    }
     /*   
    public static ArrayList getJobList() {                                     
        try {
        CachedRowSet crs = new CachedRowSetImpl();
        crs = Query.readFromTable(SQLStatements.selectJobListStmt());
            while (crs.next())
            {
                int jobId = crs.getInt("job_id");
                String jobStatus = crs.getString("job_status");
                double taxPercent = crs.getDouble("tax_percent");
                double discountPercent = crs.getDouble("discount_percent");                
                ArrayList<Product> productList = getProductListPerJob(jobId);
                Customer customer = Customer.getCustomerFromDB(jobId);
                Job newJob = new Job(jobStatus, discountPercent, 
                        productList, customer);
                newJob.setJobId(jobId);
                jobsList.add(newJob);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return jobsList;
    }
    */
    
    public static ArrayList getProductListPerJob(int jobId) {
        ArrayList<Product> p = new ArrayList();
        try { 
            CachedRowSet crs = new CachedRowSetImpl();
            crs = Query.readFromTable(SQLStatements.selectProductListStmt(jobId));
            while (crs.next()) {
                int productID = crs.getInt("product_id");
                int height = crs.getInt("product_dimension_height");
                int width = crs.getInt("product_dimension_width");
                int thickness = crs.getInt("product_dimension_thickness");
                boolean lockable = crs.getBoolean("product_flag_lockable");
                String description = crs.getString("product_description");
                String type = crs.getString("stock_glass_type");
                boolean setting = crs.getBoolean("product_setting");
                int quantity = crs.getInt("product_quantity");
                Product newProducts = new Product(type, lockable, setting, height, width, thickness, quantity, description);
                p.add(newProducts);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
   
    
    /** 
     * testing cacheJobList
     * <p>
     * to test in main method, use Job.getJobList(); and then 
     * Job.printJobList();
     */
    public static void printJobList() {
        System.out.println(jobsList.size());
        System.out.println("start of printJobList");
        for(int i = 0; i < jobsList.size(); i++) {
            System.out.println(jobsList.get(i).jobsListString());
        }
        System.out.println("end of printJobList for loop");
    }
    
    public void printProductList() {
        System.out.println(productList.size());
        System.out.println("start of printProductList");
        for(int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).productListString());
        }
        System.out.println("end of printProductList for loop");
    }
    
    public String jobsListString(){
        String jobValues = getJobId() + "\t" + getJobStatus() + "\t" 
                + getGlobalTaxRate() + "\t" + getDiscountPercent() + "\t"
                + productList;
        return jobValues;
    }
    
    public static void writeToDB(Job j) {
        List<Object> l = j.getFields();
        int jobId = (Integer)l.get(0);
        String jobStatus = (String)l.get(1);
        double taxPercent = (Double)l.get(2);
        double discountPercent = (Double)l.get(3);
        String custAbn = (String)l.get(4);
        int employeeId;
        if(j.getEmployee() != null) {
            employeeId = (Integer)l.get(5);
        } else {
            employeeId = -1;
        }
        Query.writeToTable(SQLStatements.insertJobStmt(
                jobId, jobStatus, taxPercent, discountPercent, 
                custAbn, employeeId));
    }
    
   public List getFields(){
        List<Object> list = new ArrayList<Object>();
        list.add(jobId);
        list.add(jobStatus);
        list.add(taxPercent);
        list.add(discountPercent);
        list.add(this.customer.getCustomerABN());
        if(this.getEmployee() != null) {
            list.add(employee);
        }
        return list;
    }
    
    // end of testing cacheJoblist
    
    /**
     * @return the jobId
     */
    public int getJobId() {
        return jobId;
    }

    /**
     * @param jobID the jobId to set
     */
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    
    /**
     * @return the jobStatus
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * @param jobStatus the jobStatus to set
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * @return the taxPercent
     */
    public static double getGlobalTaxRate() {
        try {
            CachedRowSet crs = new CachedRowSetImpl();
            crs = Query.readFromTable(SQLStatements.selectTaxRateStmt()); 
            crs.next();
            double taxPercent = crs.getDouble("tax_rate");
            return taxPercent;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
    }
    
    public static void setGlobalTaxRate(float rate) {
        Query.writeToTable(SQLStatements.updateTaxRateStmt(rate));
    }

    /**
     * @param taxPercent the taxPercent to set
     */
    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    /**
     * @return the discountPercent
     */
    public double getDiscountPercent() {
        return discountPercent;
    }

    /**
     * @param discountPercent the discountPercent to set
     */
    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the quantityUsed
     */
        
}
