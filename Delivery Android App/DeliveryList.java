package com.example.bluec.delivery_homework2;

/**
 * Created by bluec on 2018-02-14.
 */

public class DeliveryList {
    private DeliveryListNode head;
    private DeliveryListNode tail;
    private DeliveryListNode cursor;
    private int count;

    public DeliveryList() {
        head = null;
        tail = null;
        cursor = null;
    }

    public int numDeliveries() {
        return count; // Need to fix how to run O(1)? //is this the right way to do it?
    }

    public Delivery getCursor() {
        return cursor.getData();
    }

    public void resetCursorToHead() {
        cursor = head;
    }

    public void resetCursorToTail() {
        cursor = tail;
    }

    public void cursorForward() throws EndOfListException {
        if (cursor == tail)
            throw new EndOfListException("Can not advance. Cursor is tail");
        cursor = cursor.getNext();
    }

    public void cursorBackward() throws EndOfListException {
        if (cursor == head)
            throw new EndOfListException("Can not go back. Cursor is head");
        cursor = cursor.getPrev();
    }

    public void insertAfterCursor(Delivery newDelivery) {
        if (newDelivery == null)
            throw new IllegalArgumentException("The Delivery Object cannot be appended since it is null");
        System.out.println("insertAfterCursor method activated");
        DeliveryListNode newNode = new DeliveryListNode(newDelivery);
        if (cursor == null) {
            head = newNode;
            tail = newNode;
            cursor = newNode;
        } // The possibility that there are no elements in the array.

        else if (cursor.getNext() == null) {
            // cursor.setNext(newNode);
            // newNode.setPrev(cursor);
            // tail = newNode; // set new tail
            appendToTail(newDelivery);
            System.out.println("Order inserted");// If cursor == tail

        }

        else {
            newNode.setNext(cursor.getNext()); // This sets the next of the new node to the element after the cursor
            cursor.setNext(newNode); // This sets the next of the cursor to the new node
            newNode.setPrev(cursor);
            newNode.getNext().setPrev(newNode);
            // In conclusion the new node gets put in between the cursor and the value after
            // the cursor
            count++;
            if (cursor.getNext() == null)
                tail = cursor;

        }
        System.out.println("Order inserted");
    }

    public void appendToTail(Delivery newDelivery) {
        if (newDelivery == null)
            throw new IllegalArgumentException("Cannot append to tail since Delivery is null");
        DeliveryListNode newNode = new DeliveryListNode(newDelivery);
        tail.setNext(newNode); // connect tail to new node
        newNode.setPrev(tail);// connect new node to tail
        tail = newNode; // set new tail
    }

    public Delivery removeCursor() {
        if (cursor == null)
            throw new IllegalArgumentException("The cursor is null");

        Delivery returns = cursor.getData();// Is this necessary?
        // What if cursor = tail

        if(cursor.getNext() == null && cursor.getPrev() == null) {//if cursor is the only element
            head = null;
            tail = null;
            cursor = null;
        }

        else if (cursor.getNext() == null) {// If cursor == tail
            System.out.println("if");
            cursor = cursor.getPrev();
            cursor.getNext().setPrev(null);
            cursor.setNext(null);
            tail = cursor;
        }

        else if (cursor.getPrev() == null) {// If cursor == head
            System.out.println("else if");
            cursor = cursor.getNext();
            cursor.getPrev().setNext(null);
            cursor.setPrev(null);
            head = cursor;
        }

        else {
            System.out.println("else");
            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());
            cursor = cursor.getNext();
        }

        return returns;
    }

    public DeliveryListNode getHead() {
        return head;
    }

    public void setHead(DeliveryListNode head) {
        this.head = head;
    }

    public DeliveryListNode getTail() {
        return tail;
    }

    public void setTail(DeliveryListNode tail) {
        this.tail = tail;
    }

    public void setCursor(DeliveryListNode cursor) {
        this.cursor = cursor;

    }
}
