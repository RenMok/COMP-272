/**
 * This class is designed to test the functionality of the reverse method in the
 * DLList class.
 * 
 * @author Renfred Mok
 *
 */
public class Question5 {
    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
        DLList<Object> doubleList = new DLList<>();
        for (int i = 0; i < input.length; i++) {
            doubleList.add(i, input[i]);
        }
        System.out.println("There are " + doubleList.size() + " integers in this doubly linked list.");
        System.out.println("Our current list is as follows:");
        for (int i = 0; i < doubleList.size(); i++) {
            System.out.println(doubleList.get(i));
        }
        System.out.println("This list will now be reversed.");
        doubleList.reverse();
        System.out.println("Our new list is as follows:");
        for (int i = 0; i < doubleList.size(); i++) {
            System.out.println(doubleList.get(i));
        }

    }
}