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
public class Product {   
    private int productID;
    private String type;
    private boolean isLockable;
    private boolean isOutdoor;
    private int length;
    private int width;
    private int thickness;
    private int quantity;
    private String description;
    private int matsUsed;
    private float unitPrice;
    private float productPrice;
        
    public Product(String type, boolean isLockable, boolean isOutdoor, 
            int length, int width, int thickness, int quantity, 
            String description) {
        this.productID = getProductIdFromDB() + 1;
        this.type = type;
        this.isLockable = isLockable;
        this.isOutdoor = isOutdoor;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
        this.description = description;
        this.quantity = quantity;
        this.matsUsed = length * width * thickness;
        deductMatsFromDB();
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
    
    private void deductMatsFromDB() {
        Query.writeToTable(SQLStatements.updateStockLevelStmt(matsUsed, type));
    }
    
    private int getProductIdFromDB() {
        try {
            CachedRowSet crs = new CachedRowSetImpl();
            crs = Query.readFromTable(SQLStatements.selectMaxProductIdStmt()); 
            crs.next();
            int maxId = crs.getInt("product_id");
            return maxId;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
    }
    
    public List getFields(){
        List<Object> list = new ArrayList<Object>();
        list.add(productID);
        list.add(type);
        list.add(isLockable);
        list.add(isOutdoor);
        list.add(length);
        list.add(width);
        list.add(thickness);                
        list.add(quantity);
        list.add(unitPrice);
        list.add(productPrice);
        list.add(getDescription());
        return list;
    }
    
    public static void writeToDB(Product p) {
        List<Object> l = p.getFields();
        int productId = (Integer)l.get(0);
        String type = (String)l.get(1);
        boolean isLockable = (Boolean)l.get(2);
        boolean isOutdoor = (Boolean)l.get(3);
        int length = (Integer)l.get(4);
        int width = (Integer)l.get(5);
        int thickness = (Integer)l.get(6);
        int quantity = (Integer)l.get(7);
        float unitPrice = (Float)l.get(8);
        float productPrice = (Float)l.get(9);
        String description = (String)l.get(10);
        
        Query.writeToTable(SQLStatements.insertProductStmt(
                length, width, thickness, isLockable, description, type, 
                isOutdoor, quantity));
    }

    // for testing output to console
    public String productListString(){
        String productValues = getProductID() + "\t" + getType() + "\t" 
                + isIsLockable() + "\t" + isIsOutdoor() + "\t"
                + getLength() + "\t" + getWidth() + "\t"
                + getThickness();
        return productValues;
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

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
