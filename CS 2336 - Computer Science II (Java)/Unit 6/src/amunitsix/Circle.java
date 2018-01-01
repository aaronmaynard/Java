/*
 * Aaron Maynard
 * Exercise 13.9
 */
package amunitsix;

/**
 *
 * @author User
 */
public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    // Constructor
    public Circle() {
    }

    // Overloaded Constructor 1
    public Circle(double radius) {
	this.radius = radius;
    }

    // Overloaded Constructor 2
    public Circle(double radius, String color, boolean filled) {
	this.radius = radius;
	setColor(color);
	setFilled(filled);
    }

    // Return the radius to the consol
    public double getRadius() {
	return radius;
    }

    // Sets a new radius for the circle
    public void setRadius(double radius) {
	this.radius = radius;
    }

    @Override // Returns area of the circle
    public double getArea() {
	return radius * radius * Math.PI;
    }

    // Returns the diameter of the circle
    public double getDiameter() {
	return radius * 2;
    }

    @Override // Returns perimiter of the circle
    public double getPerimeter() {
	return (radius * 2 * Math.PI);
    }

    @Override // If the radii of the circles are the same, return true
    public boolean equals(Object o) {
    	return this.compareTo((Circle)o) == 0;
    }

    @Override // Implimented comparison method
    public int compareTo(Circle o) {
	if (this.radius > o.radius)
            return 1;
	else if (this.radius < o.radius)
            return -1;
	else
            return 0;
    }

    @Override //Impliment the toString method
    public String toString() {
	return super.toString() + "\nDate created: " + getDateCreated() + "\nRadius: " + radius;
    }
}