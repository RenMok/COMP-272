/**
 * This class implements a singly-linked list, consisting of nodes containing an
 * element of generic type E and a pointer to the next node. This list is
 * designed to swap adjacent nodes and includes methods to add elements, get the
 * value of a node and return the size of the list.
 * 
 * @author Renfred Mok
 *
 */
public class SLList {
    class Node {
        // Each node contains value and a pointer to the next node in the sequence
        int data;
        Node next;

        // Constructor to create new nodes
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Tracks the start and end of the list
    private Node head;
    private Node tail;
    // Used to keep track of the current node while iterating through the list
    Node temp;
    // Tracks the number of nodes in the linked list
    private int n;

    // Adds new nodes to the sequence
    public void add(int x) {
        Node newNode = new Node(x);
        // If the list is empty, the new node becomes the head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
            // Otherwise, new nodes are added to the tail
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        n++;
    }

    // Returns the value in the counter, showing the current size of the list
    public int size() {
        return n;
    }

    // Returns the node at the i-th position
    public Node get(int i) {
        // Checks that the requested node falls within the size range
        if (i < 0 || i > n - 1) {
            throw new IndexOutOfBoundsException();
        }
        // Start iterating at the head
        Node w = head;
        int j = 0;
        while (j < i) {
            w = w.next;
            j++;
        }
        return w;
    }

    // Swaps 2 adjacent nodes, order does not matter
    public void swapAdjacent(int a, int b) {
        // Checks that requested nodes are within the list's range.
        if (a < 0 || a > n || b < 0 || b > n) {
            throw new IllegalArgumentException("Not within list range");
        }
        // Checks that the two integers are adjacent
        if (b > a + 1 || b < a - 1 || b == a) {
            throw new IllegalArgumentException("Elements must be adjacent.");
        }
        // List is empty, do nothing
        if (head == null) {
            return;
        }
        // Start counting positions from 1 rather than 0
        a = a - 1;
        b = b - 1;
        // Holds previous nodes so their pointers can be properly reassigned
        Node prevNodeA = get(a - 1);
        Node prevNodeB = get(b - 1);
        Node nodeA = get(a);
        Node nodeB = get(b);
        // Neither node can be null
        if (get(a) != null && get(b) != null) {
            // If nodeA is not the head, the node before it will point to nodeB
            if (prevNodeA != null)
                prevNodeA.next = nodeB;
            // If nodeA is the head, nodeB takes its place
            else
                head = nodeB;

            // If nodeB is not the head, the node before it will point to nodeA
            if (prevNodeB != null)
                prevNodeB.next = nodeA;
            // if nodeB is the head, nodeA takes its place
            else
                head = nodeA;
            // nodeA and nodeB swap next pointers
            temp = nodeA.next;
            nodeA.next = nodeB.next;
            nodeB.next = temp;
        }

    }
}