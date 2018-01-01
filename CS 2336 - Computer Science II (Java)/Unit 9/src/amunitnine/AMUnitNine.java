/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amunitnine;
import java.util.*;
/**
 *
 * @author Aaron Maynard
 */
public class AMUnitNine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Point[] points = new Point[5];
        for (int i = 0; i < points.length; i++){
            points[i] = new Point((int)(Math.random() * 100), (int)(Math.random() * 100));
        }
        Pair pair = Pair.getClosestPair(points);
        System.out.println(pair.getP1());
        System.out.println(pair.getP2());
        System.out.println(pair.getDistance());
    } 
}

/* Comparison Class */
class CompareY implements Comparator<Point>{
    @Override
    public int compare(Point pos1, Point pos2){
        if (pos1.getY() > pos2.getY()){
            return 1;
        } else if (pos1.getY() < pos2.getY()){
            return -1;
        }  else{
            if (pos1.getX() > pos2.getX()){
                return 1;
            } else if (pos1.getX() < pos2.getX()){
                return -1;
            }else {
                return 0;
            }
        }
    }
}

class Point implements Comparable<Point>{
    private double x, y;
    /* Set point x,y */
    public Point(){
        this(0,0);
    }
    /* Initialize */
    public Point(double x, double y){
        super();
        this.x = x;
        this.y = y;
    }
    /* Get x,y "Getter" */
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    /* Set x,y "Setter" */
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    
    
    /* Overide Functions */
    @Override
    public int compareTo(Point o){
        if (x > o.x){
            return 1;
        }else if (x < o.x){
            return -1;
        }else{
            if (y > o.y){
                return 1;
            }else if (y < o.y){
                return -1;
            }else{
                return 0;
            }
        }
    }
    
    @Override
    public String toString(){
        return "x: " + x + ",\ty: " + y;
    }
}

class Pair{
    /* Declare variables */
    private Point p1, p2;
    /* Get points "Getters" */
    public Point getP1(){
        return p1;
    }
    public Point getP2(){
        return p2;
    }
    /* Set points "Setters" */
    public void setP1(Point p1){
        this.p1 = p1;
    }
    public void setP2(Point p2){
        this.p2 = p2;
    }
    /* Pair the points together */
    public Pair(Point p1, Point p2){
        super();
        this.p1 = p1;
        this.p2 = p2;
    }
    /* Get the distance between set 1 and set 2 */
    public double getDistance(){
        return distance(p1, p2);
    }
    
    /* Compute the distance between two points p1 and p2 */
    public static double distance(Point p1, Point p2){
        return distance(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
    
    /** Compute the distance between points (x1, y1) and (x2, y2) */
    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
    
    /** Return the distance of the closest pair of points
    * in pointsOrderedOnX[low..high]. This is a recursive
    * method. pointsOrderedOnX and pointsOrderedOnY are
    * not changed in the subsequent recursive calls.
    */
    public static Pair distance(Point[] pointsOrderedOnX, int low, int high, Point[] pointsOrderedOnY){
        if(low >= high){
            return null;
        }else if (low + 1 == high){
            return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high]);
        }
        int halfSize = (low + high) / 2;
        Pair p1 = distance(pointsOrderedOnX, low, halfSize, pointsOrderedOnY);
        Pair p2 = distance(pointsOrderedOnX, halfSize + 1, high, pointsOrderedOnY);
        double distance = 0;
        Pair p = null;
        
        if (p1 == null && p2 == null){
            distance = Double.MAX_VALUE;
        }else if (p1 == null){
            distance = p2.getDistance();
            p = p2;
        }else if (p2 == null){
            distance = p1.getDistance();
            p = p1;
        }else{
            distance = Math.min(p1.getDistance(), p2.getDistance());
            p = ((p1.getDistance() <= p2.getDistance())? p1 : p2);
        }
        
        ArrayList<Point> left = new ArrayList<>();
        ArrayList<Point> right = new ArrayList<>();
        for (Point pointsOrderedOnY1 : pointsOrderedOnY) {
            if ((pointsOrderedOnY1.getX() <= pointsOrderedOnX[halfSize].getX()) && (pointsOrderedOnY1.getX() >= pointsOrderedOnX[halfSize].getX() - distance)) {
                left.add(pointsOrderedOnY1);
            } else {
                right.add(pointsOrderedOnY1);
            }
        }
        
        double d3 = distance;
        int r = 0;
        for (int i = 0; i < left.size(); i++) {
            while (r < right.size() && left.get(i).getY() > right.get(r).getY() + distance){
                r++;
            }
            int r1 = r;
            while (r1 < right.size() && right.get(r1).getY() <= left.get(i).getY() + distance){
                if (d3 > distance(left.get(i), right.get(r1))){
                    d3 = distance(left.get(i), right.get(r1));
                    p.p1 = left.get(i);
                    p.p2 = right.get(r1);
                }
                r1++;
            }
        }
        return p;
    }

    /* Return the distance of the closest pair of points */
    public static Pair getClosestPair(Point[] points){
        Arrays.sort(points);
        Point[] pointsOrderedOnY = points.clone();
        Arrays.sort(pointsOrderedOnY, new CompareY());
        return distance(points, 0, points.length - 1, pointsOrderedOnY);
    }
    /* Return the distance of the closest pair of points */
    public static Pair getClosestPair(double[][] points){
        Point[] points2 = new Point[points.length];
        for (int i = 0; i < points.length; i++){
            points2[i] = new Point(points[i][0], points[i][1]);
        }
        return getClosestPair(points2);
    }
}