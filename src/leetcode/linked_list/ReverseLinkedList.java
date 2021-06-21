package leetcode.linked_list;

import leetcode.data_structure.Node;

public class ReverseLinkedList {

    /**
     * Traverse a LinkedList and print elements in reversed order
     * Goal is to go to the end of the list and create a second list with the previouses stored
     * I wonder basically we can create a recursive call
     * - while head == null, you're done
     * - while
     */
    public static Node reverseLinkedList(Node head) {
        Node previous = head;
        Node current = head.next;
        // ensure previous is the new head of list
        previous.next = null;
        return recursiveHelper(previous, current);
    }

    private static Node recursiveHelper(Node previous, Node current) {
        if (current == null) {
            return null;
        }
        // if no next node, we're at the end, return the current node with the next index updated
        if (current.next == null) {
            current.next = previous;
            return current;
        }
        // current linked list
        Node next = current.next;
        // updating current.next to previous element
        current.next = previous;
        return recursiveHelper(current, next);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        Node reversed = ReverseLinkedList.reverseLinkedList(head);
        reversed.printList();
    }
}
