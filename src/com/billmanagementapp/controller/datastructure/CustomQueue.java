package com.billmanagementapp.controller.datastructure;

import com.billmanagementapp.model.BuyerModel;
import java.util.LinkedList;

/**
 * Custom implementation of a queue data structure for managing BuyerModel
 * objects. This queue is implemented using a LinkedList and supports basic
 * operations like enqueue, dequeue, peek, and size checks.
 */
public class CustomQueue {

    private LinkedList<BuyerModel> buyerQueue; // Internal storage for the queue.
    private int capacity; // Maximum number of elements the queue can hold.

    /**
     * Constructs a CustomQueue with the specified capacity.
     *
     * @param capacity the maximum number of elements the queue can hold.
     * @throws IllegalArgumentException if the specified capacity is negative.
     */
    public CustomQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        buyerQueue = new LinkedList<>();
        this.capacity = capacity;
    }

    /**
     * Removes and returns the first element from the queue.
     *
     * @return the first BuyerModel in the queue, or null if the queue is empty.
     * @throws IllegalStateException if the queue is empty.
     */
    public BuyerModel deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from empty queue.");
        }
        return buyerQueue.removeFirst();
    }

    /**
     * Adds a new element to the end of the queue if it is not full.
     *
     * @param buyerModel the BuyerModel to be added to the queue.
     * @return the current size of the queue after the operation.
     * @throws IllegalStateException if the queue is full.
     */
    public int enQueue(BuyerModel buyerModel) {
        if (isFull()) {
            throw new IllegalStateException("Cannot add to a full queue.");
        }
        buyerQueue.addLast(buyerModel);
        return buyerQueue.size();
    }

    /**
     * Returns the current size of the queue.
     *
     * @return the number of elements in the queue.
     */
    public int size() {
        return buyerQueue.size();
    }

    /**
     * Retrieves, but does not remove, the first element of the queue.
     *
     * @return the first BuyerModel in the queue, or null if the queue is empty.
     * @throws IllegalStateException if the queue is empty.
     */
    public BuyerModel peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek into an empty queue.");
        }
        return buyerQueue.getFirst();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return buyerQueue.isEmpty();
    }

    /**
     * Checks if the queue is full.
     *
     * @return true if the queue has reached its capacity, false otherwise.
     */
    public boolean isFull() {
        return buyerQueue.size() == capacity;
    }
}

