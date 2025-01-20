package com.billmanagementapp.util;

import javax.swing.JOptionPane;

public class BuyerValidator {

    public static boolean validateFields(String buyerIdText, String fullName, String contactNo, String email, String address, String gender, String paymentText, String duePaymentText) {
        // Validate Buyer ID
        if (buyerIdText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Buyer ID cannot be empty.");
            return false;
        }

        // Validate Full Name
        if (fullName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Full Name cannot be empty.");
            return false;
        }
        if (!isAlpha(fullName)) {
            JOptionPane.showMessageDialog(null, "Full Name cannot contain numbers.");
            return false;
        }

        // Validate Contact No
        if (contactNo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contact No cannot be empty.");
            return false;
        }

        // Validate Email
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email cannot be empty.");
            return false;
        }
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Email must contain '@' symbol.");
            return false;
        }

        // Validate Address
        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Address cannot be empty.");
            return false;
        }

        // Validate Gender
        if (gender == null || gender.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a gender.");
            return false;
        }

        // Validate Buyer ID numeric
        if (!isNumeric(buyerIdText)) {
            JOptionPane.showMessageDialog(null, "Buyer ID must be a numeric value.");
            return false;
        }

        // Validate Contact No length and numeric
        if (!isNumeric(contactNo) || contactNo.length() != 10) {
            JOptionPane.showMessageDialog(null, "Contact No must be a 10-digit number and cannot contain letters.");
            return false;
        }

        // Validate Payment
        if (!isNumeric(paymentText) || Double.parseDouble(paymentText) <= 0) {
            JOptionPane.showMessageDialog(null, "Payment must be a positive number.");
            return false;
        }

        // Validate Due Payment
        if (!isNumeric(duePaymentText) || Double.parseDouble(duePaymentText) < 0) {
            JOptionPane.showMessageDialog(null, "Due Payment must be a non-negative number.");
            return false;
        }

        return true; // All validations passed
    }

    // Helper method to check if a string is numeric
    private static boolean isNumeric(String str) {
        try {
            Double.valueOf(str); // Use Double to allow decimal numbers
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Helper method to check if a string contains only alphabetic characters
    private static boolean isAlpha(String str) {
        return str.matches("[a-zA-Z ]+"); // Allows letters and spaces only
    }

    // Helper method to validate email format
    private static boolean isValidEmail(String email) {
        return email.contains("@"); // Simple check for '@' symbol
    }
}