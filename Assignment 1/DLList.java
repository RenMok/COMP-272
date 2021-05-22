/**
 * This class implements a doubly linked list. The list consists of nodes which
 * include a data value of generic type E and pointers to the previous and next
 * nodes, allowing the list to be search from front-to-back and vice versa. This
 * implementation includes methods to get, add, and remove nodes, as well as set
 * their held value. There are also methods to swap nodes, reverse the order of
 * the list and return the size of the list.
 * 
 * @author Renfred Mok
 *
 */
public class DLList<E> {
    class Node {
        // Each node contains value and a pointer to the next and previous nodes in the
        // sequence.
        E data;
        Node next;
        Node prev;

        // Creates a new node with data of generic type E.
        Node(E d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    // Tracks the number of nodes in the linked list.
    private int n;
    // Completes the circle of the list, functions as the head AND tail.
    Node dummy;

    DLList() {
        // Starts the list off with a dummy node when a new list is created.
        dummy = new Node(null);
        dummy.next = dummy;
        dummy.prev = dummy;
        n = 0;

    }

    // Receives an integer and return its corresponding node. This method can only
    // be
    // accessed using other methods to avoid direct tampering with nodes.
    private Node getNode(int i) {
        // Variable used to iterate through the list.
        Node temp = null;
        // Searches front to back if i is in the front half, start after dummy node.
        if (i < n / 2) {
            temp = dummy.next;
            // Keeps iterating until the i-th node is reached.
            for (int j = 0; j < i; j++)
                temp = temp.next;
        } else {
            // Searches back to front, starting at the dummy node.
            temp = dummy;
            for (int j = n; j > i; j--)
                temp = temp.prev;
        }
        // Returns the i-th node.
        return temp;
    }

    // Reassigns the data in an existing node.
    public E set(int i, E x) {
        if (i < 0 || i > n - 1)
            throw new IndexOutOfBoundsException();
        Node temp = getNode(i);
        // Hold the current value of the node to return after it is replaced.
        E y = temp.data;
        temp.data = x;
        return y;
    }

    // Gets the data value in node at position i.
    public E get(int i) {
        if (i < 0 || i > n - 1)
            throw new IndexOutOfBoundsException();
        return getNode(i).data;

    }

    // Called from the add(i,x) method, creates a new node and reassigns the
    // adjacent pointers. Increments counter.
    private Node addBefore(Node i, E x) {
        var newNode = new Node(x);
        newNode.prev = i.prev;
        newNode.next = i;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        n++;
        return newNode;
    }

    // Checks that the position integer is valid, calls getNode and addBefore
    // methods to implement the new node.
    public void add(int i, E x) {
        if (i < 0 || i > n)
            throw new IndexOutOfBoundsException();
        addBefore(getNode(i), x);
    }

    // Reassigns pointers to skip over the node at desired position. Decrement
    // counter.
    private void remove(Node w) {
        w.prev.next = w.next;
        w.next.prev = w.prev;
        n--;
    }

    // Accepts an integer, checks that it is within the list size range, calls
    // remove(Node w) using getNode for input. Returns the data value of the removed
    // node.
    public E remove(int i) {
        if (i < 0 || i > n - 1)
            throw new IndexOutOfBoundsException();
        var w = getNode(i);
        remove(w);
        return w.data;
    }

    // Swaps adjacent nodes only, reassigns pointers only, data is not directly
    // reassigned
    public void swapAdjacent(int a, int b) {
        // Checks that requested nodes are within the list's range.
        if (a < 0 || a > n || b < 0 || b > n) {
            throw new IllegalArgumentException("Not within list range");
        }
        // Checks that the two integers are adjacent
        if (b > a + 1 || b < a - 1 || b == a) {
            throw new IllegalArgumentException("Elements must be adjacent.");
        }
        // Start counting positions from 1 rather than 0
        a = a - 1;
        b = b - 1;
        var node1 = getNode(a);
        var node2 = getNode(b);
        node1.next = node2.next;
        node2.prev = node1.prev;
        node1.next.prev = node1;
        node2.prev.next = node2;
        node2.next = node1;
        node1.prev = node2;
    }

    // Returns the value in the counter, showing the current size of the list
    public int size() {
        return n;
    }

    // Reverses the order of elements in the list by reassigning pointers
    public void reverse() {
        var current = getNode(0);
        Node temp;
        // Iterates through each node switching the next and prev pointers
        for (int i = 0; i < n; i++) {
            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        }
        // Swaps the pointers for the dummy node
        temp = dummy.next;
        dummy.next = dummy.prev;
        dummy.prev = temp;
    }
}