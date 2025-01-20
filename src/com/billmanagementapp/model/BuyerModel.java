package com.billmanagementapp.model;

/**
 *
 * @author Sashank Ghimire
 */
public class BuyerModel {
    private int buyerId;
    private String fullName;
    private long contactNo;
    private String gender;
    private String email;
    private String address;
    private double payment; 
    private double duePayment; 

    // Default constructor
    public BuyerModel(int id, String name, long contactNo, String gender, String email, String address, double payment, double duePayment) {
        this.buyerId = id;
        this.fullName = name;
        this.contactNo = contactNo;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.payment = payment; // Initialize payment
        this.duePayment = duePayment; // Initialize due payment
    }

    // Getter and Setter for buyerId
    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    // Getter and Setter for fullName
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter and Setter for contactNo
    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    // Getter and Setter for gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for payment
    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    // Getter and Setter for duePayment
    public double getDuePayment() {
        return duePayment;
    }

    public void setDuePayment(double duePayment) {
        this.duePayment = duePayment;
    }
}