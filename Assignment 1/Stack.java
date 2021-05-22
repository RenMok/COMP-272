import java.util.LinkedList;
import java.util.Queue;
/**
 * This class implements a stack (last-in-first-out) using two first-in-first-out queues.
 * Pop() removes the most recently added element. 
 * @author Renfred Mok
 *
 */
public final class Stack {
    private Stack(){
        // Hides the implicit public constructor
    }
    // Counts the items in the main queue
static int n = 0;
// 2 queues are created, q1 is the main queue, q2 is used to temporarily store values
static Queue<Integer> q1 = new LinkedList<>();
static Queue<Integer> q2 = new LinkedList<>();
// Adds new elements to the front of the list
    public static void push(int x) {
   // Adds x to q1 if q1 is empty
if (q1.isEmpty()){
    q1.add(x);
} 
else {
    // Removes each element from q1, adding it to q2, until q1 is empty
    while (!q1.isEmpty()){
q2.add(q1.remove());
    }
    // x is added to the front of q1
    q1.add(x);
}
// All the previously removed elements are placed back in the queue and q2 is emptied
while (!q2.isEmpty()) {
    q1.add(q2.remove());
}
// Increment counter
n++;
    }
    // Removes elements from the front of the list
public static int pop(){
    // Prevents the counter from going negative when the list is empty
    if (n == 0){
        throw new IllegalStateException();
    }
    // Decrement counter
    n--;
    // remove the first element from q1 and return its value
    return q1.remove();
}
}
    