package LinkedList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;

public class LinkedList {
    LinkedListNode head;
    LinkedListNode current;

    public LinkedList() {
        this.head = null;
        this.current = null;
    }

    public void insert(Integer value) {
        if(head == null) {
            head = new LinkedListNode(value);
            current = head;
        }
        else {
            LinkedListNode node = new LinkedListNode(value);
            current.setNext(node);
            current = node;
        }
    }

    public ArrayList<Integer> printLinkedList() {
        return printLinkedList(this.head);
    }

    public ArrayList<Integer> printLinkedList(LinkedListNode head) {
        ArrayList<Integer> traversal = new ArrayList<>();
        LinkedListNode node = head;
        while(node != null) {
            traversal.add(node.getValue());
            node = node.next;
        }
        return traversal;
    }

    /**
     * reference : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
     *
     *
     * given a linkedList, and an integer n, remove nth element from the rear.
     *
     *          1--> 2 --> 3 --> 4
     *
     *          n == 2
     *
     *          new list :
     *              1 --> 2 --> 4
     *
     * Idea is
     * 1. add n+1 enteries in a queue
     * 2. keep on removing and adding next node to queue till we reach the end of the list
     * 3. now 2nd element in the queue is the element to be deleted.
     *
     *
     */

    public LinkedListNode removeNthElementFromLast(int n) {
        LinkedListNode node = head;
        Queue<LinkedListNode> queue = new java.util.LinkedList<>();
        int k = n;
        while(k >= 0 && node!= null) {
            queue.add(node);
            node = node.getNext();
            k--;
            // add n+1 nodes first
        }

        if(node == null && k == 0) {
            // this is a special case where n = length of the linked list, in that case first element
            // has to be removed.
            //node will be null in case of n = length - 1, but in that case k will be -1
            this.head = head.next;
        }
        else {
            while(node != null) {
                queue.remove();
                queue.add(node);
                node = node.getNext();
            }
            node = queue.remove();
            node.next = node.next.next;
        }
        return head;
    }

}
