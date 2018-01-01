/*
 * Aaron Maynard
 * 
 * (Compute the perimeter of a triangle) Write a program that reads three edges for
 * a triangle and computes the perimeter if the input is valid. Otherwise, display that
 * the input is invalid. The input is valid if the sum of every pair of two edges is
 * greater than the remaining edge.
 */
package amunitone;
import java.util.Scanner;

/**
 *
 * @author Aaron Maynard
 */
public class AMUnitOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        // Promt the user to enter 3 sides
        System.out.println("Enter the length of side 1 of the triangle: ");
        double s1 = input.nextDouble(); //side 1
        System.out.println("Enter the length of side 2 of the triangle: ");
        double s2 = input.nextDouble(); //side 2
        System.out.println("Enter the length of side 3 of the triangle: ");
        double s3 = input.nextDouble(); //side 3
        
        // Test if the input is valid        
        if (isValid(s1, s2, s3) == true){
            // Is valid
            double p = s1 + s2 + s3;
            System.out.println("The perimeter of the triangle is: " + p);
        }
        else{
            // Is not valid
            System.out.println("The input is INVALID");
        }
    }
    
    static boolean isValid(double s1, double s2, double s3){
        boolean valid = false;
        if ((s1 + s2) > s3)
            valid = true;
        else
            return false;
        if ((s2 + s3) > s1)
            valid = true;
        else
            return false;
        if ((s3 + s1) > s2)
            valid = true;
        else
            return false;
        return valid;
    }    
}
