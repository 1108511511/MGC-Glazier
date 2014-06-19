/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgcproject;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author 3106909413
 */
public class Product {   
    private int productID;
    private String type;
    private boolean isLockable;
    private boolean isOutdoor;
    private int length;
    private int width;
    private int thickness;
    private int quantity;
    private float unitPrice;
    private float productPrice;
        
    public Product(String type, boolean isLockable, boolean isOutdoor, int length, int width, int thickness, int quantity) {
        this.type = type;
        this.isLockable = isLockable;
        this.isOutdoor = isOutdoor;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
        this.quantity = quantity;
        this.unitPrice = getUnitPriceFromDB(type);
        this.productPrice = calculatePrice();
    }
    
    private float calculatePrice() {
        float thisProductPrice = length * width * thickness * quantity * unitPrice;
        return thisProductPrice;
    }
    
    private float getUnitPriceFromDB(String type) {
        try {
            CachedRowSet crs = new CachedRowSetImpl();
            crs = Query.readFromTable(SQLStatements.selectPriceStmt(type)); 
            crs.next();
            float thisUnitPrice = crs.getFloat("price");
            return thisUnitPrice;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the isLockable
     */
    public boolean isIsLockable() {
        return isLockable;
    }

    /**
     * @param isLockable the isLockable to set
     */
    public void setIsLockable(boolean isLockable) {
        this.isLockable = isLockable;
    }

    /**
     * @return the isOutdoor
     */
    public boolean isIsOutdoor() {
        return isOutdoor;
    }

    /**
     * @param isOutdoor the isOutdoor to set
     */
    public void setIsOutdoor(boolean isOutdoor) {
        this.isOutdoor = isOutdoor;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the thickness
     */
    public int getThickness() {
        return thickness;
    }

    /**
     * @param thickness the thickness to set
     */
    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * @return the unitPrice
     */
    public float getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the price to set
     */
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the prodcutPrice
     */
    public float getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice the price to set
     */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
}
