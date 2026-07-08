/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Trung Anh
 */
public class MyQueue {

    NodeQueue head, tail;

    public MyQueue() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }
    // add last linked list
    void enQueue(Node p) {
        NodeQueue node = new NodeQueue(p);
        if (isEmpty()) {
            head = tail = null;
        } else {
            tail.next = node;
            tail = node;
        }
    }
    // delete first linked list 
    Node deQueue() {
        if (isEmpty()) {
            return null;
        }
        Node value = head.value;
        head = head.next;
        return value;
    }
}
