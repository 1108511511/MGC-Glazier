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
public class Product {   
    private int productID;
    private boolean isLaminate;
    private boolean isLockable;
    private boolean isOutdoor;
    private int length;
    private int width;
    private int thickness;
    private int quantity;
    private float price;
    
    public Product(boolean isLaminate, boolean isLockable, boolean isOutdoor, int length, int width, int thickness, int quantity, float price) {
        this.isLaminate = isLaminate;
        this.isLockable = isLockable;
        this.isOutdoor = isOutdoor;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
        this.quantity = quantity;
        this.price = price;
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
     * @return the isLaminate
     */
    public boolean isIsLaminate() {
        return isLaminate;
    }

    /**
     * @param isLaminate the isLaminate to set
     */
    public void setIsLaminate(boolean isLaminate) {
        this.isLaminate = isLaminate;
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
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
}
