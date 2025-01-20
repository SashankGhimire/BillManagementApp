package com.billmanagementapp.controller.algorithms;

import com.billmanagementapp.model.BuyerModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Insertion sort implementation for sorting BuyerModel objects by email.
 */
public class InsertionSort {

    public List<BuyerModel> sortByEmail(List<BuyerModel> unsortedData, boolean isDesc) {
        // Create a copy of the unsorted data to sort
        List<BuyerModel> dataToSort = new ArrayList<>(unsortedData);

        // Insertion sort algorithm
        for (int i = 1; i < dataToSort.size(); i++) {
            BuyerModel keyBuyer = dataToSort.get(i);
            int j = i - 1;

            // Compare and insert the keyBuyer in the correct position
            while (j >= 0 && compareEmails(dataToSort.get(j), keyBuyer, isDesc)) {
                dataToSort.set(j + 1, dataToSort.get(j));
                j--;
            }
            dataToSort.set(j + 1, keyBuyer);
        }
        return dataToSort;
    }

    private boolean compareEmails(BuyerModel buyer1, BuyerModel buyer2, boolean isDesc) {
        int comparisonResult = buyer1.getEmail().compareToIgnoreCase(buyer2.getEmail());
        return isDesc ? comparisonResult > 0 : comparisonResult < 0;
    }
}