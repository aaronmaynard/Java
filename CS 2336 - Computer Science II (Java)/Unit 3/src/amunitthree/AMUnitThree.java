/*
 * Aaron Maynard
 * Exercise 7.19
 */
package amunitthree;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class AMUnitThree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanIn = new Scanner(System.in);
        System.out.print("Enter size (int) of list: ");
        int size = scanIn.nextInt();
        
        // Create an array to hold the list and fill the array.
        int[] list = new int[size];
        System.out.println("Enter list elements: ");
        for (int counter = 0; counter < list.length; counter++){
            list[counter] = scanIn.nextInt();
        }
        
        // Checks if the list is sorted, and informs user.
        System.out.print("The array list ");
        checkSort(list);
    }

    // Test if the array list is sorted .
    public static void checkSort(int[] list){
        // Only displays if the user has entered only one element into the array.
        String sortType = "only contains one element.";
        // This boolean manages if the system finds a valid sort type.
        boolean sorted = true;
        
        // The first check is to see if there is an ascending sort.
        for (int counter = 0; counter <(list.length - 1); counter++){
            // checks if the preceding list item is less than the next.
            if (list[counter] < list[counter + 1]){
                sortType = "is sorted in ascending order.";
            }
            else{
                // There is an instance of descending order.
                sorted = false;
                break;
            }
        }
        // The first check is to see if there is an descending sort.
        if(sorted == false){
            // Boolean reset
            sorted = true;
            for (int counter = 0; counter <(list.length - 1); counter++){
                // checks if the preceding list item is less than the next.
                if (list[counter] > list[counter + 1]){
                    sortType = "is sorted in descending order.";
                }
                else{
                    // There is an instance of ascending order.
                    sorted = false;
                    break;
                }
            }
        }
        // If both sortType checks have failed, then the array is not sorted.
        if (sorted == false){
            sortType = "is not sorted";
        }
        // Print out findings.
        System.out.println(sortType);
    }
}
