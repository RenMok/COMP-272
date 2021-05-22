/**
 * This class is for testing the priorityQueue class. The output should be a
 * list of integers removed from the list in ascending order.
 * 
 * @author Renfred Mok
 *
 */
public class Question1A {
    public static void main(String[] args) {
        // Create a new instance of class SLList.
        PriorityQueue priorityQueue = new PriorityQueue();
        // Create an array of input values
        int[] input = { 5, 7, 12, 346, 853, 125, 85, 2, 57, 12, 9, 2, 57, 9, 4, 1, 69, 13, 7, 8 };
        // Iterate through each integer in the array.
        for (int i = 0; i < input.length; i++) {
            // Call the add(x) method for each integer in the array.
            priorityQueue.add(input[i]);
        }
        // Adding more values for testing, because why not.
        priorityQueue.add(3);
        priorityQueue.add(9);
        priorityQueue.add(346);
        priorityQueue.add(53);
        priorityQueue.add(27);
        priorityQueue.add(17);
        priorityQueue.add(2);
        priorityQueue.add(87);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(2);
        // Prints out the size of the list to show the size() method functionality.
        System.out.println("There are " + priorityQueue.size() + " elements in this list");
        // Iterate through the entire list, deleting each node.
        while (priorityQueue.size() != 0) {
            // Print out the value of each node that is deleted.
            System.out.println(priorityQueue.deleteMin() + " was deleted from the list");
        }
        System.out.println("There are " + priorityQueue.size() + " elements in this list");

    }
}