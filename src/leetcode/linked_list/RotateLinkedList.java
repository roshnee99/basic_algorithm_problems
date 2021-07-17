package leetcode.linked_list;

import leetcode.data_structure.Node;

public class RotateLinkedList {

    /**
     * Rotate on the element specified, if 4, we mean the 4th element of the list (index starting at 1)
     * Basically you keep putting the first element at the end of the list until you're done rotating
     * @param head list to rotate
     * @param elementToRotate the number element to rotate
     * @return the rotated list
     */
    public static Node rotateList(Node head, int elementToRotate) {
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        Node current = head;
        for (int i = 1; i <= elementToRotate; i++) {
            Node newLast = current;
            current = current.next;
            newLast.next = null;
            last.next = newLast;
            last = newLast;
        }
        return current;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eighth = new Node(8);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
        Node rotated = rotateList(head, 4);
        rotated.printList();
    }

}
