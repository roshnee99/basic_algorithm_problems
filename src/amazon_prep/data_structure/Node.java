package amazon_prep.data_structure;

public class Node {

    public int data;
    public Node next;
    public Node(int d)  { data = d;  next = null; }

    public void printList() {
        Node temp = this;
        while (temp != null) {
            System.out.print(temp.data);
            System.out.print(" ");
            temp = temp.next;
        }
    }
}
