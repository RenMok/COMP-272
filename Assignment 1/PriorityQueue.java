/**
 * This class implements a priority queue using a singly linked list. This list
 * accepts input of type double and sorts elements in ascending order as each
 * new element is added. Elements can only be removed from the front of the list
 * (ie. lowest values first). A method to return the size of the list is also
 * included.
 * 
 * @author Renfred Mok
 *
 */
public class PriorityQueue {
    class Node {
        // Each node contains value and a pointer to the next node in the sequence.
        double data;
        Node next;

        // Constructor for creating new nodes.
        Node(double d) {
            data = d;
            next = null;
        }
    }

    // Tracks the start and end of the list.
    private Node head;
    private Node tail;
    // Used to keep track of the current node while iterating through the list.
    Node temp;
    // Tracks the number of nodes in the list.
    private int n;

    // Adds new nodes to the sequence
    public void add(double x) {
        // Creates a new node
        Node newNode = new Node(x);
        // If the list is empty, the node is both the head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
            // New node becomes the new head if it is the smallest
        } else if (head.data > x) {
            newNode.next = head;
            head = newNode;
        } else {
            // Iterate starting at the head
            temp = head;
            // Iterates until a larger value is found or the tail is reached
            while (temp.next != null && temp.next.data < x) {
                temp = temp.next;
            }
            // Reassigns the tail if the new node is added at the end
            if (temp.next == null) {
                tail.next = newNode;
                tail = newNode;
            } else {
                // Assigns the new node's next pointer
                newNode.next = temp.next;
                // Reassigns the previous node's pointer to the new node
                temp.next = newNode;
            }
        }
        // Increment counter
        n++;
    }

    // This method removes the head of the sequence
    public double deleteMin() {
        // Stores the value of the current head
        temp = head;
        // Removes the head by reassigning the head to the next node
        head = head.next;
        // Decrement the counter
        n--;
        // Returns the value of the deleted node
        return temp.data;
    }

    // Returns the value in the counter, showing the current size of the list
    public int size() {
        return n;
    }
}
