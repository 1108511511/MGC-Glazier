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
public class Job {
    private int jobID;
    private String jobStatus;
    private double taxPercent;
    private double discountPercent;
    private int quantityUsed;
    private String customerABN;
    private String custFirstName;
    private String custLastName;

    // constructor
    public Job(int jobID, String jobStatus, double taxPercent, 
            double discountPercent, int quantityUsed, String customerABN,
            String custFirstName, String custLastName) {
        this.jobID = jobID;
        this.jobStatus = jobStatus;
        this.taxPercent = taxPercent;
        this.discountPercent = discountPercent;
        this.quantityUsed = quantityUsed;
        this.customerABN = customerABN;
        this.custFirstName = custFirstName;
        this.custLastName = custLastName;
    }

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
