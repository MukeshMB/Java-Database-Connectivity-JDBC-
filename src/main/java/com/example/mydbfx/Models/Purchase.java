package com.example.mydbfx.Models;

public class Purchase {
    private String purchaseId, date, customerName, itemName, price, employeeName;

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Purchase(String purchaseId, String date, String customerName, String itemName, String price, String employeeName) {
        this.purchaseId = purchaseId;
        this.date = date;
        this.customerName = customerName;
        this.itemName = itemName;
        this.price = price;
        this.employeeName = employeeName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}