package com.example.mydbfx.Models;

public class Employee {
    private String employeeId, fname, lname, role, salary, sex, dob, contacts, address;

    public Employee(String employeeId, String fname, String lname, String role, String salary, String sex, String dob, String contacts, String address) {
        this.employeeId = employeeId;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
        this.salary = salary;
        this.sex = sex;
        this.dob = dob;
        this.contacts = contacts;
        this.address = address;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contact) {
        this.contacts = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
