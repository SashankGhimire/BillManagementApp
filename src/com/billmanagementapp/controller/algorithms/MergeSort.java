package com.billmanagementapp.controller.algorithms;

import com.billmanagementapp.model.BuyerModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Merge sort implementation for sorting BuyerModel objects by name.
 */
public class MergeSort {

    public List<BuyerModel> sortByName(List<BuyerModel> unsortedData, boolean isDesc) {
        // Create a copy of the unsorted data to sort
        List<BuyerModel> dataToSort = new ArrayList<>(unsortedData);
        // Call the merge sort method
        mergeSort(dataToSort, 0, dataToSort.size() - 1, isDesc);
        return dataToSort;
    }

    private void mergeSort(List<BuyerModel> data, int left, int right, boolean isDesc) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort the first half
            mergeSort(data, left, mid, isDesc);
            // Sort the second half
            mergeSort(data, mid + 1, right, isDesc);
            // Merge the sorted halves
            merge(data, left, mid, right, isDesc);
        }
    }

    private void merge(List<BuyerModel> data, int left, int mid, int right, boolean isDesc) {
        // Create temporary arrays for left and right subarrays
        List<BuyerModel> leftArray = new ArrayList<>(data.subList(left, mid + 1));
        List<BuyerModel> rightArray = new ArrayList<>(data.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;

        // Merge the temporary arrays back into the original array
        while (i < leftArray.size() && j < rightArray.size()) {
            int comparisonResult = leftArray.get(i).getFullName().compareToIgnoreCase(rightArray.get(j).getFullName());
            if (isDesc) {
                if (comparisonResult > 0) {
                    data.set(k++, leftArray.get(i++));
                } else {
                    data.set(k++, rightArray.get(j++));
                }
            } else {
                if (comparisonResult < 0) {
                    data.set(k++, leftArray.get(i++));
                } else {
                    data.set(k++, rightArray.get(j++));
                }
            }
        }

        // Copy remaining elements of leftArray, if any
        while (i < leftArray.size()) {
            data.set(k++, leftArray.get(i++));
        }

        // Copy remaining elements of rightArray, if any
        while (j < rightArray.size()) {
            data.set(k++, rightArray.get(j++));
        }
    }
}