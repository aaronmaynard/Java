/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amprojectzero;
/**
 * @author Aaron Maynard
 */

public class CreditCard {
    /**
     * Create the CreditCard class according to the UML diagram. It should
     * have data fields that include an owner of type Person, a balance of
     * type Money, and a creditLimit of type Money. 
     */
    private Person owner;
    private Money balance;
    private Money creditLimit;
    
    /*
    It should have a constructor that has two parameters, a reference to a
    Person object to initialize the owner and a reference to a Money object
    to initialize the creditLimit. The balance can be initialized to a Money
    object with a value of zero. Remember you are passing in objects
    (passed by reference), so you are passing the memory address of an
    object. If you want your CreditCard to have its own creditLimit and
    balance, you should create a new object of each using the copy 
    onstructor in the Money class. 
    */
    public CreditCard(Person name, Money limit){
        this.owner = name;
        this.creditLimit = limit;
        this.balance = new Money(0);
    }
    
    /**
     * It should have accessor methods to get the balance and the creditLimit.
     * Since these are Money objects (passed by reference), we don’t want to
     * create a security issue by passing out addresses to components in our
     * CreditCard class, so we must return a new object with the same values.
     * Again, use the copy constructor to create a new object of type Money
     * that can be returned.  
     * @return 
     */
    public String getBalance()
    {
        Money reference = new Money(this.balance);
        return reference.toString();
    }
    
    public String getCreditLimit()
    {
        Money reference = new Money(this.creditLimit);
        return reference.toString();
    }
    
    /**
     * It should have an accessor method to get the information about the
     * owner, but in the form of a String that can be printed out. This can
     * be done by calling the toString method for the owner
     * (an instance of the Person class). 
     * @return 
     */
    public String getPersonals(){
        return this.owner.toString();
    }
    
    /**
     * It should have a method that will charge to the CreditCard by adding
     * the amount passed in the parameter to the balance, but only if it will
     * not exceed the creditLimit. If the creditLimit will be exceeded, the
     * amount should not be added, and an error message can be printed to
     * the console. 
     * @param money
     */
    public void charge(Money money){
        int balance = (money.add(this.balance)).compareTo(this.creditLimit);
        if(balance == -1)
        {
            this.balance=this.balance.add(money);
        }else System.out.println("Exceeds credit limit");
    }
    
    /**
     * It should have a method that will make a payment on the CreditCard by
     * subtracting the amount passed in the parameter from the balance. 
     * @param money
     */
    public void payment(Money money)
    {
        this.balance = this.balance.subtract(money);
    } 
}
