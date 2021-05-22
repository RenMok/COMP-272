import java.util.List;

/**
 * This class is designed to test the Bag class.
 * 
 * @author Renfred Mok
 *
 */
public class Question3 {
    public static void main(String[] args) {
        Bag<Object> newBag = new Bag<>();
        Object[] input = { 1, "a", 63, "jump", "flan", "tore", 5, 8, 5, 5, "a", 5 };
        for (int i = 0; i < input.length; i++) {
            newBag.add(input[i]);
        }
        try {
            System.out.println(newBag.find("jump") + " was found in the list.");
            System.out.println(newBag.remove("jump") + " was removed from the list.");
            if (newBag.find("jump") == null) {
                System.out.println("jump cannot be found in this list");
            } else {
                System.out.println(newBag.find("jump"));
            }
            List<Object> list = newBag.findAll(5);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));

            }
        } catch (Exception e) {
            System.out.print("Error!");
        }
    }
}