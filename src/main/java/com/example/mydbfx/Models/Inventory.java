package com.example.mydbfx.Models;

public class Inventory {
    private String itemId, qty, price, type, descript, fit, color, supplierId;
    public Inventory(String itemId, String qty, String price, String type, String descript, String fit, String color, String supplierId) {
        this.itemId = itemId;
        this.qty = qty;
        this.price = price;
        this.type = type;
        this.descript = descript;
        this.fit = fit;
        this.color = color;
        this.supplierId = supplierId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
}
