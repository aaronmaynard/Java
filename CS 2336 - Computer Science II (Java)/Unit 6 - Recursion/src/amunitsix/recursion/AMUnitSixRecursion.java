/*
 * Aaron Maynard
 * Exercise Recursion
 */
package amunitsix.recursion;
import java.util.*;
/**
 *
 * @author User
 */
public class AMUnitSixRecursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Create variable
        int value = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number (int) for recirsive production;\nto exit, type ''999''.\n");
        
        // repeatedly prompts  user for a number until user enters quitting value
        while (value != 999){
            value = scan.nextInt();
            if(value != -999){
                // Recursion value used in output statement because new variable is not neccessary afterwards
                System.out.println(value + " x 3 = " + recursion.recursive(value));
            }
        }
    }
}

class recursion{
    public static int recursive(int value){
        if(value == 0){
            return 0;
        }else if (value > 0){
            return (3 + recursive(value - 1));
        }else
            return (-3 + recursive(value + 1));
    }
}