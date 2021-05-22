/**
 * This class is designed to test the node swapping methods of the SLList and
 * DLList classes. Output should print a list of 18 consecutive integers and
 * then the list after nodes have been swapped.
 * 
 * @author Renfred Mok
 *
 */
public class Question2 {
    public static void main(String[] args) {
        // Array for data input.
        int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
        // New singly-linked list.
        SLList singleList = new SLList();
        for (int i = 0; i < input.length; i++) {
            // Add each integer from the array to the list.
            singleList.add(input[i]);
        }
        // Print the full list.
        System.out.println("There are " + singleList.size() + " integers in this singly linked list.");
        System.out.println("Our current list is as follows:");
        for (int i = 0; i < singleList.size(); i++) {
            System.out.println(singleList.get(i).data);
        }
        // Swap elements and then reprint list.
        System.out.println("The 13th and 14th elements in the list will now be swapped.");
        singleList.swapAdjacent(14, 13);
        System.out.println("Our new list is as follows:");
        for (int i = 0; i < singleList.size(); i++) {
            System.out.println(singleList.get(i).data);
        }
        // New doubly-linked list.
        DLList<Object> doubleList = new DLList<>();
        // Add each integer from the array to the list.
        for (int i = 0; i < input.length; i++) {
            doubleList.add(i, input[i]);
        }
        // Print the full list.
        System.out.println("There are " + doubleList.size() + " integers in this doubly linked list.");
        System.out.println("Our current list is as follows:");
        for (int i = 0; i < doubleList.size(); i++) {
            System.out.println(doubleList.get(i));
        }
        // Swap elements and reprint the list.
        System.out.println("The 7th and 8th elements in the list will now be swapped.");
        doubleList.swapAdjacent(7, 8);
        System.out.println("Our new list is as follows:");
        for (int i = 0; i < doubleList.size(); i++) {
            System.out.println(doubleList.get(i));
        }

    }
}
