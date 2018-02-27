package LinkedList;

public class LinkedListNode {
    Integer value = null;
    LinkedListNode next = null;

    public LinkedListNode(Integer value) {
        this.value = value;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public LinkedListNode getNext() {
        return this.next;
    }

    public Integer getValue() {
        return this.value;
    }
}
