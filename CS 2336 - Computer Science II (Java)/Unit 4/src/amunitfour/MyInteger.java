/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amunitfour;

/**
 *
 * @author User
 */
public class MyInteger {
    int value;
    
    // Constructor
    MyInteger(int value){
        this.value = value;
    }
    
    // Return value to main 
    public int getValue(){
        return value;
    }
    
    /** methods isEven(), isOdd(), and isPrime() that return true if the
    * value in this object is even, odd, or prime, respectively.
    **/
    
    // isEven statements
    public boolean isEven(){
        return isEven(value);
    }
    public static boolean isEven(int value){
        return value % 2 == 0;
    }
    public static boolean isEven(MyInteger myInteger) {
	return myInteger.isEven();
    }
    
    // isOdd statements
    public boolean isOdd(){
        return isOdd(value);
    }
    public static boolean isOdd(int value){
        return value % 2 != 0;
    }
    public static boolean isOdd(MyInteger myInteger) {
	return myInteger.isOdd();
    }
    
    // isPrime statements
    public boolean isPrime(){
        return isPrime(value);
    }
    public static boolean isPrime(int value){
        for (int i = 2; 2*i < value; i++){
            if (value%i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPrime(MyInteger myInteger) {
	return myInteger.isPrime();
    }
    
    /** The methods equals(int) and equals(MyInteger) that return true if
    * the value in this object is equal to the specified value.
    **/
    // Equals methods
    public boolean equals(int value) {
	return this.value == value;
    }
    public boolean equals(MyInteger myInteger) {
	return myInteger.value == this.value;
    }
    
    /** A static
    * method parseInt(char[]) that converts an array of numeric characters
    * to an int value. A static method parseInt(String) that converts a
    * string into an int value.
    **/
    // parsing methods
    public static int parseInt(char[] chars) {
	int value = 0;
	for (int i = 0, j = (int)Math.pow(10, chars.length - 1); 
		  i < chars.length; i++, j /= 10) {
		value += (chars[i]- 48) * j;
	}
	return value;
    }
    public static int parseInt(String str) {
	int value = 0;
	for (int i = 0, j = (int)Math.pow(10, str.length() - 1); 
		  i < str.length(); i++, j /= 10) {
		value += (str.charAt(i) - 48) * j;
	}
	return value;
    }
}
