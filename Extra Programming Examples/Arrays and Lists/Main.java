import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] things = {"item1", "item2", "item3", "item4" };
        List<String> list1 = new ArrayList<String>();

        // Add array items to list
        for (String x: things) {
            list1.add(x);
        }

        // Print items to screen
        for (int i = 0; i < list1.size(); i++) {
            System.out.printf("%s ", list1.get(i));
        }
    }
}
