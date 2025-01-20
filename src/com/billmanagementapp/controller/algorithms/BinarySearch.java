package com.billmanagementapp.controller.algorithms;

import com.billmanagementapp.model.BuyerModel;
import java.util.List;

/**
 * Binary search implementation for searching BuyerModel objects by name.
 */
public class BinarySearch {

    public BuyerModel searchByName(String searchValue, List<BuyerModel> buyerList, int left, int right) {
    // Base Case
    if (right < left) {
        return null; // Not found
    }

    // mid value
    int mid = (left + right) / 2;

    // checks whether searchKey lies on mid point
    if (searchValue.compareToIgnoreCase(buyerList.get(mid).getFullName()) == 0) {
        return buyerList.get(mid); // Found
    } else if (searchValue.compareToIgnoreCase(buyerList.get(mid).getFullName()) < 0) {
        return searchByName(searchValue, buyerList, left, mid - 1); // Search left
    } else {
        return searchByName(searchValue, buyerList, mid + 1, right); // Search right
    }
    }
}