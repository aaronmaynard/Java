/*
 * Aaron Maynard
 * Exercise 13.9
 */
package amunitsix;

/**
 *
 * @author User
 */
public abstract class GeometricObject {
    private String color = "while";
    private boolean filled;
    private java.util.Date dateCreated;

    // Create a Geometric Object
    protected GeometricObject() {
	dateCreated = new java.util.Date();
    }

    // Create a Geometric Object with color
    protected GeometricObject(String color, boolean filled) {
	dateCreated = new java.util.Date();
    	this.color = color;
	this.filled = filled;
    }

    // Return color to the consol
    public String getColor() {
    	return color;
    }

    // Sets a new color to the circle
    public void setColor(String color) {
	this.color = color;
    }

    // Returns a filled color circle
    public boolean isFilled() {
	return filled;
    }

    // New filled circle
    public void setFilled(boolean filled) {
    	this.filled = filled;
    }

    // Gets date created
    public java.util.Date getDateCreated() {
    	return dateCreated;
    }

    @Override
    public String toString() {
    	return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    // Get Area
    public abstract double getArea();

    // Get Perimiter
    public abstract double getPerimeter();

}