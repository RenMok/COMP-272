import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class implements a bag using a singly linked list. It allows multiple
 * copies of the same element and includes methods to add(x), remove(x), find(x)
 * and findAll(x). The methods accept inputs of generic type E.
 * 
 * @author Renfred Mok
 *
 */
public class Bag<E> implements Iterable<E> {

    class Node {
        // Each node contains a value and a pointer to the next node.
        E data;
        Node next;

        // This constructor allows the creation of nodes, directly inputting the data.

        Node(E d) {
            data = d;
            next = null;
        }
    }

    // Head identifies the first node, tail identifies the last node.
    private Node head;
    private Node tail;
    // Multi-purpose temporary node.
    Node temp;
    // Tracks the number of nodes in the linked list.
    private int n;

    // Adds new nodes to the bag.
    public void add(E x) {
        // Creates a new node and inputs the value of x.
        Node newNode = new Node(x);
        // If the list is empty, the new node becomes the head.
        if (head == null) {
            head = newNode;
            tail = newNode;
            // Otherwise adds the new node to the tail.
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        // Increment counter.
        n++;
    }

    // Removes an element from the bag.
    public E remove(E x) {
        // Throws an exception if x does not exist in the bag.
        if (find(x) == null) {
            throw new NoSuchElementException();
        } else {
            // Node used to iterate through the elements.
            Node y = null;
            // Counter for number of iterations.
            int i = 0;
            // Start iterating at the head of the list.
            y = head;
            // Iterates through the list until it reaches an element equal to x (input).
            while (y.data != x) {
                y = y.next;
                i++;
            }
            // Temp holds the element y, which is equal to x.
            temp = y;
            // Counter for iterating.
            int j = 0;
            // Restart iterating at the head of the list until 1 node before y.
            y = head;
            while (j < i - 1) {
                y = y.next;
                j++;
            }
            // Reassign the pointer to skip over the node being removed.
            y.next = y.next.next;
            // Return the value of the removed node.
            return temp.data;
        }
    }

    // Finds an element in the bag, returning its value without altering it.
    public E find(E x) {
        Iterator<E> iterator = iterator();
        // Holds the value of each node to compare to x, starts at the head.
        E y = head.data;
        // Iterates as long as there is a next element in the list.
        while (iterator.hasNext()) {
            // Returns the value of y if it is equal to x.
            if (y == x) {
                return y;
            }
            // Iterates to the next node.
            y = iterator.next();

        }
        // Returns null if an element equal to x is not found in the bag.
        return null;
    }

    // Finds all elements in the bag equal to x, returns a list of them.
    public List<E> findAll(E x) {
        // Variable size array to hold all elements equal to x.
        ArrayList<E> list = new ArrayList<>();
        // Returns an empty list no elements equal to x are in the bag.
        if (find(x) == null) {
            return list;
        } else {
            Iterator<E> iterator = iterator();
            // Start iterator at the head.
            E y = head.data;
            while (iterator.hasNext()) {
                // Adds an element to the list if it is equal to x.
                if (y == x) {
                    list.add(y);
                }
                // Iterates to the next element in the bag.
                y = iterator.next();
            }
            // Returns a list of all elements in the bag equal to x, must contain at least
            // 1.
            return list;
        }
    }

    // Allows the creation of an iterator.
    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    // Allows iteration through elements in the bag.
    class CustomIterator implements Iterator<E> {
        // The current node in the iterator
        Node current;

        // Constructor
        public CustomIterator() {
            // Resets the iterator to start at the head.
            current = head;
        }

        // Checks if the next element exists.
        public boolean hasNext() {
            // Returns false if the next element is null.
            if (current.next == null) {
                return false;
                // All other cases return true.
            } else
                return true;
        }

        // Moves the iterator to next element, returning its value.
        public E next() {
            // Throws an exception if there is no next element.
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            // The iterator moves to the next node.
            current = current.next;
            // Returns the value of the new node in the iterator.
            return current.data;

        }
    }
}