/*
 * DCCCD - 2017FA Programming Fundamentals III (COSC-2436-71426)
 */
package amunitfour;

/**
 *
 * @author Aaron Travis Maynard
 */
public class AMUnitFour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize value array
        int[] values = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        
        /** methods isEven(), isOdd(), and isPrime() that return true if the
         * value in this object is even, odd, or prime, respectively.
         **/
        System.out.println("Test: isEven");
        for (int counter = 0; counter < values.length; counter++){
            System.out.println("    " + values[counter] + " " + MyInteger.isEven(values[counter]));
        }
        
        System.out.println("\nTest: isOdd");
        for (int counter = 0; counter < values.length; counter++){
            System.out.println("    " + values[counter] + " " + MyInteger.isOdd(values[counter]));
        }
        
        System.out.println("\nTest: isPrime");
        for (int counter = 0; counter < values.length; counter++){
            System.out.println("    " + values[counter] + " " + MyInteger.isPrime(values[counter]));
        }
        
        
        
        
        // Tests for which methods in MyInteger.java is being used.
        System.out.println("\nTest using isEven() method");
	for (int counter = 0; counter < values.length; counter++) {
            MyInteger value = new MyInteger(values[counter]);
            System.out.println(value.getValue() + " " + value.isEven());
	}
        
        System.out.println("\nTest using isOdd() method");
	for (int counter = 0; counter < values.length; counter++) {
            MyInteger value = new MyInteger(values[counter]);
            System.out.println(value.getValue() + " " + value.isOdd());
	}
        
        System.out.println("\nTest using isPrime() method");
	for (int counter = 0; counter < values.length; counter++) {
            MyInteger value = new MyInteger(values[counter]);
            System.out.println(value.getValue() + " " + value.isPrime());
	}
        
        
	System.out.println("\nTest using isEven(MyInteger) method");
        for (int counter = 0; counter < values.length; counter++) {
            MyInteger value = new MyInteger(values[counter]);
            System.out.println(value.getValue() + " " + MyInteger.isEven(value));
	}
	System.out.println("\nTest using isOdd(MyInteger) method");
        for (int counter = 0; counter < values.length; counter++) {
            MyInteger value = new MyInteger(values[counter]);
            System.out.println(value.getValue() + " " + MyInteger.isOdd(value));
	}
	System.out.println("\nTest using isPrime(MyInteger) method");
            for (int counter= 0; counter < values.length; counter++) {
            MyInteger value = new MyInteger(values[counter]);
            System.out.println(value.getValue() + " " + MyInteger.isPrime(value));
	}
        
        /** The methods equals(int) and equals(MyInteger) that return true if
        * the value in this object is equal to the specified value.  A static
        * method parseInt(char[]) that converts an array of numeric characters
        * to an int value. A static method parseInt(String) that converts a
        * string into an int value.
        **/
        int[] values2 = {8, 5, 2, 3, 5, 2};
	MyInteger value = new MyInteger(2);
	System.out.println("\nTest if " + value.getValue() +  " as equals(int) is equal to the specified value:");
	for (int counter = 0; counter < values2.length; counter++) {
            System.out.println(values2[counter] + " " + value.equals(values2[counter]));
	}
	System.out.println("\nTest if " + value.getValue() +  " as equals(MyInteger) is equal to the specified value:");
	for (int counter = 0; counter < values2.length; counter++) {
            MyInteger myInteger = new MyInteger(values2[counter]);	
            System.out.println(values2[counter] + " " + value.equals(myInteger));
        }
        
        System.out.println("\nTest parseInt(char[]) and parseInt(String):");
	// Create a character array
	char[] numChar = {'6', '4', '1'};
	// Create a string
	String numStr = "878";
	System.out.print("\'");
	for (int counter = 0; counter < numChar.length; counter++) {
            System.out.print(numChar[counter] + "");
	}
        // Should equal 1519
	System.out.println("\' + \"" + numStr + "\" = " + (MyInteger.parseInt(numChar) + MyInteger.parseInt(numStr)));
    }
    
}
