package amazon_prep.linked_list;

import amazon_prep.data_structure.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindMiddleElement {

    /**
     * To get the middle of the list, can use two pointers
     * So by the time the fast one reaches the end, we know that the current is in the middle
     * Basically have fast traverse by .next.next while slow is just .next
     * @param head
     * @return
     */
    public static int getMiddle(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer.data;
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
        System.out.println(FindMiddleElement.getMiddle(head));
    }
}
