/*
 * Modify Listing 20.9 EvaluateExpression.java to add
 * operators ^ for exponent and % for modulus. For example, 3^2 is 9 and 3%2
 * is 1. The ^ operator has the highest precedence and the % operator has the
 * same precedence as the * & / operators. Your program should prompt the user
 * to enter an expression.
 */
package amunitseven;
import java.util.*;
/**
 *
 * @author Aaron Maynard
 */
public class AMUnitSeven {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Create a scanner object to retrieve input
        Scanner input = new Scanner(System.in);
        
        // Prompt the user for an expression followed by a try-catch statement
        System.out.println("Enter an expressoin to evaluate");
        String expression = input.nextLine();
        
        // Try-Catch 
        try{
            System.out.println(expression + " = " + evaluateExpression(expression));
        }catch(Exception e){
            // If the expression cannot be evaluated, explain why here
            System.out.println("Error : " + e);
        }
    }
    
    // Function to evaluate the expression
    public static double evaluateExpression(String expression){
        // Declare variables
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>(); // Accidentally had this as Stack<Double> because I copied from operandStack... that took a while ot figure out. :) 
        
        // Make sure that each set in the function is seperated between operator
        expression = seperator(expression);
        
        // I learned that this must go after the seperator function
        String[] tokens = expression.split(" ");
        // Scan the expression for operators to carry through stacker
        // Will be copy-and-pasting first else if, then editing for time
        for(String token: tokens){
            if (token.length() == 0){
                // Do nothing
            }else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                // We have found an operator we need to deal with it
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '^' || operatorStack.peek() == '%')){
                    stacker(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '%' )) {
                    stacker(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }else if (token.charAt(0) == '^') {
                while (!operatorStack.isEmpty() && operatorStack.peek() == '^') {
                    stacker(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            }else if (token.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    stacker(operandStack, operatorStack);
                }
                operatorStack.pop();
            }else {
                operandStack.push(new Double(token));
            }
        }
        
        // Now we need to scan the stack and quickly process the ones that remain
        while (!operatorStack.isEmpty()) {
            stacker(operandStack, operatorStack);
        }
        
        return operandStack.pop();
    }
    
    // Function that seperates the sets in the function
    public static String seperator(String expression){
        String seperatedSets = "";
        
        // Go through each character in the string expression, if operator space
        for(int counter = 0 ; counter < expression.length(); counter++){
            // Checks if special operator char ()+-*/^%
            if(expression.charAt(counter) == '(' || expression.charAt(counter) == ')' || expression.charAt(counter) == '+' || expression.charAt(counter) == '-' || expression.charAt(counter) == '*' || expression.charAt(counter) == '/' || expression.charAt(counter) == '^' || expression.charAt(counter) == '%'){
                seperatedSets += " " + expression.charAt(counter) + " ";
            }else{
                seperatedSets += expression.charAt(counter);
            }
        }
        return seperatedSets;
    }
    
    // Function that pushes and pops the stacks
    public static void stacker(Stack<Double> operandStack, Stack<Character> operatorStack){
        // Declare variables
        char operatorChar = operatorStack.pop();
        double firstOperation = operandStack.pop();
        double secondOperation = operandStack.pop();
        
        switch (operatorChar) {
            case '+':
                operandStack.push(secondOperation + firstOperation);
                break;
            case '-':
                operandStack.push(secondOperation - firstOperation);
                break;
            case '*':
                operandStack.push(secondOperation * firstOperation);
                break;
            case '/':
                operandStack.push(secondOperation / firstOperation);
                break;
            case '^':
                operandStack.push((double)Math.pow(secondOperation, firstOperation));
                break;
            case '%':
                operandStack.push(secondOperation % firstOperation);
                break;
            default:
                break;
        }
    }
}