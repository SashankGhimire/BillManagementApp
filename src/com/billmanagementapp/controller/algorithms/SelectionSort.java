package com.billmanagementapp.controller.algorithms;

import com.billmanagementapp.model.BuyerModel;
import java.util.ArrayList;
import java.util.List;

/**
 * SelectionSort class for sorting BuyerModel objects.
 */
public class SelectionSort {
    private List<BuyerModel> buyerSortList;

    public SelectionSort() {
        buyerSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of BuyerModel objects by their Buyer ID in ascending or
     * descending order.
     *
     * @param buyerList the list of BuyerModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<BuyerModel> sortByBuyerId(List<BuyerModel> buyerList, boolean isDesc) {
        this.buyerSortList.clear();
        this.buyerSortList.addAll(buyerList);
        if (buyerSortList == null || buyerSortList.isEmpty()) {
            throw new IllegalArgumentException("Buyer list cannot be null or empty.");
        }

        for (int i = 0; i < buyerSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndexById(buyerSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(buyerSortList, i, extremumIndex);
            }
        }

        return buyerSortList;
    }

    /**
     * Sorts a list of BuyerModel objects by their Full Name in ascending or
     * descending order.
     *
     * @param buyerList the list of BuyerModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<BuyerModel> sortByFullName(List<BuyerModel> buyerList, boolean isDesc) {
        this.buyerSortList.clear();
        this.buyerSortList.addAll(buyerList);
        if (buyerSortList == null || buyerSortList.isEmpty()) {
            throw new IllegalArgumentException("Buyer list cannot be null or empty.");
        }

        for (int i = 0; i < buyerSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndexByName(buyerSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(buyerSortList, i, extremumIndex);
            }
        }

        return buyerSortList;
    }

    private int findExtremumIndexById(List<BuyerModel> buyerSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < buyerSortList.size(); j++) {
            if (shouldSwap(buyerSortList.get(j).getBuyerId(), buyerSortList.get(extremumIndex).getBuyerId(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    private int findExtremumIndexByName(List<BuyerModel> buyerSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < buyerSortList.size(); j++) {
            if (shouldSwap(buyerSortList.get(j).getFullName(), buyerSortList.get(extremumIndex).getFullName(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    private boolean shouldSwap(String current, String extremum, boolean isDesc) {
        return isDesc ? current.compareToIgnoreCase(extremum) > 0 : current.compareToIgnoreCase(extremum) < 0;
    }

    private void swap(List<BuyerModel> buyerSortList, int i, int j) {
        BuyerModel temp = buyerSortList.get(i);
        buyerSortList.set(i, buyerSortList.get(j));
        buyerSortList.set(j, temp);
    }
}