/**
 * This class is for testing the Stack class. The output should display all
 * elements input to the list, then they should all be removed in reverse order.
 * 
 * @author Renfred Mok
 *
 */
public class Question1B {
    public static void main(String[] args) {
        try {
            // Create an array of input values.
            int[] input = { 5, 7, 12, 346, 853, 125, 85, 2, 57, 12, 9, 2, 57, 9, 4, 1, 69, 13, 7, 8 };
            // Iterate through each integer in the array.
            for (int i = 0; i < input.length; i++) {
                // Call the push(x) method for each integer in the array, then print its value.
                Stack.push(input[i]);
                System.out.println(input[i] + " was added to the list");
            }
            // Print out the counter to confirm the push operations were successful.
            System.out.println("There are " + Stack.n + " elements in this list");
            // Continuously calls the pop method until the queue is empty.
            while (Stack.n != 0) {
                System.out.println(Stack.pop() + " was deleted from the list");
            }
            // Print out the counter to confirm all pop operations were successful.
            System.out.println("There are " + Stack.n + " elements in this list");
        } catch (Exception illegalStatException) {
            System.out.println("Error! Check that the list is not empty!");
        }
    }
}
