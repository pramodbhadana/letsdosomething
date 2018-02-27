package LinkedList;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

}
