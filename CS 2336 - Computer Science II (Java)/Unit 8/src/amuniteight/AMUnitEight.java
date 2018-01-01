/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amuniteight;
import java.util.*;
/**
 *
 * @author Aaron Maynard
 */
public class AMUnitEight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a Scanner for the user to enter State
        Scanner input = new Scanner(System.in);
        // We need to create a map of the 50 states and their capitals
        // Map<State Cap>
        Map<String, String> stateMap = getCapital();
        
        // Prompt user to enter state for stateMap
        System.out.print("Enter a State of the US: ");
        String state = input.nextLine();
        
        //Display the capital for the entered state
        if(stateMap.get(state) != null){
            System.out.println("The capital of " + state + " is " + stateMap.get(state));
        }else{
            System.out.println("The state that you have entered is either not part of the US or does not exist.");
        }
    }
    
    public static Map<String, String> getCapital(){
        Map<String, String> hashMap = new HashMap<>();
        String[][] data = {
            // Enter States for data
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Indiana", "Indianapolis"},
            {"Iowa Des", "Moines"},
            {"Kansas", "Topeka"},
            {"Kentucky","Frankfort"}, 
            {"Louisiana", "Baton Rouge"},
            {"Maine", "Augusta"}, 
            {"Maryland", "Annapolis"},
            {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"},
            {"Minnesota", "Saint Paul"}, 
            {"Mississippi", "Jackson"},
            {"Missouri", "Jefferson City"}, 
            {"Montana", "Helena"},
            {"Nebraska", "Lincoln"}, 
            {"Nevada	", "Carson City"},
            {"New Hampshire", "Concord"}, 
            {"New Jersey", "Trenton"},
            {"New Mexico", "Santa Fe"}, 
            {"New York", "Albany"},
            {"North Carolina", "Raleigh"}, 
            {"North Dakota", "Bismarck"},
            {"Ohio", "Columbus"},
            {"Oklahoma", "Oklahoma City"},
            {"Oregon", "Salem"}, 
            {"Pennsylvania", "Harrisburg"},
            {"Rhode Island", "Providence"}, 
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"}, 
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"}, 
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"}, 
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"}, 
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"}, 
            {"Wyoming", "Cheyenne"}
        };
        
        for (int counter = 0; counter < data.length; counter++){
            hashMap.put(data[counter][0], data[counter][1]);
        }
        
        return hashMap;
    }
}
