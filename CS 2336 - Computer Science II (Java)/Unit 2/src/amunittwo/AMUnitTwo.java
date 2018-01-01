/*
 * Aaron Maynard
 * 
 * (Financial application: compute the future investment value) Write a method that
 * computes future investment value at a given interest rate for a specified number
 * of years. The future investment is determined using the formula in Programming
 * Exercise 2.21.
 */

package amunittwo;
import java.util.Scanner;

/**
 *
 * @author Aaron Maynard
 */
public class AMUnitTwo {
	/**
	* @param args the command line arguments
	*/
	public static void main(String[] args) {
		// TODO code application logic here
		// Declare variables
		double investmentAmount, monthlyInterestRate;
		int years = 5;

        	Scanner input = new Scanner(System.in);
        	// Promt the user to enter data:
		System.out.print("Future Investment Value Calculator\nEnter the amount of finance invested: ");
		investmentAmount = input.nextDouble();
		System.out.print("Enter the annual interest rate (as percentage; ex 5% = 5): ");
		monthlyInterestRate = (input.nextDouble() / 1200);




		// Financial Table
		System.out.println("Years   |   Future Value");
		for (int year = 1; year <= years; year++) {
			System.out.print("Year: " + year + "       ");
			System.out.println(futureInvestmentValue(investmentAmount, monthlyInterestRate, years));
		}
	}

	/** Method given by textbook
     * @param investmentAmount
     * @param monthlyInterestRate
     * @param years
     * @return  */
	public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
		return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
	}
}