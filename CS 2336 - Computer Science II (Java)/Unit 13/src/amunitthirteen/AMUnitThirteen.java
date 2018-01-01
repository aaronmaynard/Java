/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amunitthirteen;
/**
 * Complete exercise 27.9 on page 1036
 * public static int hashCodeForString(String s) 
 * @author Aaron Maynard
 */
public class AMUnitThirteen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        String[] list = {"Aaron", "Smith", "tops", "pots", "tod", "dot"};
        
        for (String e : list) {
            System.out.println("\"" + e + "\" contains the hash code: " + hashCodeForString(e));
        }
    }
    
    public static int hashCodeForString(String s){
        // Use the approach from sec 27.3.2 with b value 31
        int b = 31;  //GIVEN
	int hashCode = 0; //store
	for (int i = 0; i < s.length(); i++){ 
            hashCode = b * hashCode + (int)s.charAt(i); 
	}
	return hashCode;
    }    
}
