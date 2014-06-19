/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgcproject;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author 3106909413
 */
public class Job {
    // fields
    private int jobID;
    private String jobStatus;
    private double taxPercent;
    private double discountPercent;
    private int quantityUsed;
    private String customerABN;
    private String custFirstName;
    private String custLastName;
    private static ArrayList<Job> jobsList = new ArrayList<>();
    private static ArrayList<Product> productList = new ArrayList<>();

    // constructors
    public Job() {
    }
    
    public Job(int jobID, String jobStatus, double taxPercent, 
            double discountPercent, int quantityUsed, String customerABN,
            String custFirstName, String custLastName, 
            ArrayList<Product> productList, Customer customer) {
        this.jobID = jobID;
        this.jobStatus = jobStatus;
        this.taxPercent = taxPercent;
        this.discountPercent = discountPercent;
        this.quantityUsed = quantityUsed;
        this.customerABN = customerABN;
        this.productList = productList;
        this.customer = customer;
    }

    
    // methods
    public static ArrayList cacheJobList() {                                     
        try {
        CachedRowSet crs = new CachedRowSetImpl();
        crs = Query.readFromTable(SQLStatements.selectJobListStmt());
            while (crs.next())
            {
                int jobID = crs.getInt("job_id");
                String jobStatus = crs.getString("job_status");
                double taxPercent = crs.getDouble("tax_percent");
                double discountPercent = crs.getDouble("discount_percent");
                int quantityUsed = crs.getInt("job_qty_used");
                String customerABN = crs.getString("customer_cust_abn");
                String custFirstName = crs.getString("cust_first_name");
                String custLastName = crs.getString("cust_last_name");
                Job newJob = new Job(jobID, jobStatus, taxPercent,
                discountPercent, quantityUsed, customerABN, custFirstName,
                custLastName, productList);
                jobsList.add(newJob);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return jobsList;
    }
    
    /** 
     * testing cacheJobList
     * <p>
     * to test in main method, use Job.cacheJobList(); and then 
     * Job.printCacheJobList();
     */
    public static void printCacheJobList() {
        System.out.println(jobsList.size());
        System.out.println("start of printCacheJobList");
        for(int i = 0; i < jobsList.size(); i++) {
            System.out.println(jobsList.get(i).toString());
        }
        System.out.println("end of printCacheJobList for loop");
    }
    
    @Override
    public String toString(){
        String jobValues = getJobID() + "\t" + getJobStatus() + "\t" 
                + getTaxPercent() + "\t" + getDiscountPercent() + "\t"
                + getQuantityUsed() + "\t" + getCustomerABN() + "\t"
                + getCustFirstName() + "\t" + getCustLastName();
        return jobValues;
    }
    // end of testing cacheJoblist

    
    /**
     * @return the jobID
     */
    public int getJobID() {
        return jobID;
    }

    /**
     * @param jobID the jobID to set
     */
    public void setJobID(int jobID) {
        this.jobID = jobID;
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
    public double getTaxPercent() {
        return taxPercent;
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
     * @return the quantityUsed
     */
    public int getQuantityUsed() {
        return quantityUsed;
    }

    /**
     * @param quantityUsed the quantityUsed to set
     */
    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    /**
     * @return the customerABN
     */
    public String getCustomerABN() {
        return customerABN;
    }

    /**
     * @param customerABN the customerABN to set
     */
    public void setCustomerABN(String customerABN) {
        this.customerABN = customerABN;
    }

    /**
     * @return the custFirstName
     */
    public String getCustFirstName() {
        return custFirstName;
    }

    /**
     * @param custFirstName the custFirstName to set
     */
    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    /**
     * @return the custLastName
     */
    public String getCustLastName() {
        return custLastName;
    }

    /**
     * @param custLastName the custLastName to set
     */
    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }
    
}
