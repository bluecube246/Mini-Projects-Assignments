package com.example.bluec.delivery_homework2;

/**
 * Created by bluec on 2018-02-14.
 */

public class DeliveryListNode {
    private Delivery data;
    private DeliveryListNode next;
    private DeliveryListNode prev;

    public DeliveryListNode(Delivery intData) {
        if (intData == null)
            throw new IllegalArgumentException();
        // What does wrap the indicated Delivery mean?
        this.data = intData; // Does it mean this?
        this.prev = null;
        this.next = null;
    }

    public Delivery getData() {
        return data;
    }

    public void setData(Delivery data) {
        this.data = data;
    }

    public DeliveryListNode getNext() {
        return next;
    }

    public void setNext(DeliveryListNode next) {
        this.next = next;
    }

    public DeliveryListNode getPrev() {
        return prev;
    }

    public void setPrev(DeliveryListNode prev) {
        this.prev = prev;
    }
}
