/*
 * Aaron Maynard
 * Exercise 13.9
 */
package amunitsix;

/**
* (Enable Circle comparable) Rewrite the Circle class in Listing 13.2 to extend
* GeometricObject and implement the Comparable interface. Override the equals 
* method in the Object class. Two Circle objects are equal if their radii are 
* the same. Draw the UML diagram that involves Circle, GeometricObject, and   
* Comparable. 
 */
public class AMUnitSix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
	// Create circles for camparison, c1, c2, c3
	Circle c1 = new Circle(5, "red", true);
	Circle c2 = new Circle(5, "green", false);
	Circle c3 = new Circle(4, "green", false);

        // Display results
	System.out.println("Radius of Circle 1: " + c1.getRadius());
	System.out.println("Radius of Circle 2: " + c2.getRadius());
	System.out.println("Radius of Circle 3: " + c3.getRadius());
	
        System.out.println("Circle 1 is " + (c2.equals(c3) ? "" : "not ") + "equal to circle 2");
    	System.out.println("Circle 1 is " + (c2.equals(c3) ? "" : "not ") + "equal to circle 3");
    }
}
