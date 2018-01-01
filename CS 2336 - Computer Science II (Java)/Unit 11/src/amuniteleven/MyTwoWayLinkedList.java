/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amuniteleven;
import java.util.*;
/**
 *
 * @author User
 * @param <E>
 */
public class MyTwoWayLinkedList<E> extends AbstractSequentialList<E>{
   //Declare  variables
   private myNode<E> head, tail;
   private int myListSize;
   //Constructor
   public MyTwoWayLinkedList(){
   }
  
   //Method definition
   public E getFirst(){
       if (myListSize == 0){
           return null;
       }else{
           return head.element;
       }
   }
  
   //Method definition
   public E getLast(){
       if (myListSize == 0){
           return null;
       }else{
           return tail.element;
       }
   }
   
   //Method definition
   public void addFirst(E data){
       //Create node
       myNode<E> myListNode = new myNode<>(data);
      
       myListNode.next = head;
      
       head = myListNode;
      
       myListSize++;
      
       if (tail == null){
           tail = head;
       }
       if (head != tail){
           head.next.previousNode = head;
       }
   }
  
   //Method definition
   public void addLast(E data){
       //Create node
       myNode<E> myListNode = new myNode<>(data);
       myNode<E> temp = tail;
      
       if (tail == null){
           head = tail = myListNode;
       }else{
           tail.next = myListNode;
           tail = tail.next;
       }
      
       //Increment size
       myListSize++;
      
       tail.previousNode = temp;
   }
  
   //Method definition
   @Override
   public void add(int indexA, E data){
       if (indexA == 0){
           addFirst(data);
       }else if (indexA >= myListSize){
           addLast(data);
       }else{
           myNode<E> present = head;
          
           for (int idx1 = 1; idx1 < indexA; idx1++){
               present = present.next;
           }
          
           myNode<E> temp = present.next;
          
           present.next = new myNode<>(data);
          
           (present.next).next = temp;
          
           //Increment size
           myListSize++;
          
           temp.previousNode = present.next;
          
           present.next.previousNode = present;
       }
   }
      
   //Method definition
   public E removeFirst(){
       if (myListSize == 0){
           return null;
       }else{
           //Create node
           myNode<E> temp = head;
          
           head = head.next;
          
           //Decrement size
           myListSize--;
          
           if (head == null){
               tail = null;
           }
          
           return temp.element;
       }
   }
  
   //Method definition
   public E removeLast(){
       if (myListSize == 0){
           return null;
       }
      
       //Condition check
       if (myListSize == 1){
           myNode<E> temp = head;
          
           head = tail = null;
          
           myListSize = 0;
          
           return temp.element;
       }else{
           myNode<E> present = head;
          
           for (int idx1 = 0; idx1 < myListSize - 2; idx1++)
           {
               present = present.next;
           }
          
           myNode<E> temp = tail;
          
           tail = present;
          
           tail.next = null;
          
           //Decrement size
           myListSize--;
          
           return temp.element;
       }
   }
  
   //Method definition
   @Override
   public E remove(int indexA)   {
       if (indexA < 0 || indexA >= myListSize){
           return null;
       }else if (indexA == 0){
           return removeFirst();
       }else if (indexA == myListSize - 1){
           return removeLast();
       }else{
           myNode<E> previousNode = head;
          
           for (int idx1 = 1; idx1 < indexA; idx1++)
           {
               previousNode = previousNode.next;
           }
          
           myNode<E> present = previousNode.next;
          
           previousNode.next = present.next;
          
           present.next.previousNode = previousNode;
          
           //Decrement size
           myListSize--;
          
           return present.element;
       }
   }
  
   //Method definition
   @Override
   public String toString(){
       //Create instance
       StringBuilder sbObject = new StringBuilder("[");
      
       myNode<E> present = head;
      
       for (int idx1 = 0; idx1 < myListSize; idx1++){  
           //Function call          
           sbObject.append(present.element);
          
           present = present.next;
          
           if (present != null){
               //Function call  
               sbObject.append(", ");
           }else{
               //Function call  
               sbObject.append("]");
           }
       }
      
       return sbObject.toString();
   }
  
   //Method definition
   @Override
   public void clear(){
       head = tail = null;
   }
  
   //Method definition
   @Override
   public boolean contains(Object data){
       myNode<E> present = head;
      
       while(present!=null){
           //Condition check
           if(data.equals(present.element)){
               return true;
           }
           present=present.next;
       }
      
       return false;
   }
  
   //Method definition
   @Override
   public E get(int indexA){      
       myNode<E> present = head;
      
       if(indexA>myListSize){
           return null;
       }
      
       for (int idx1 = 0; idx1 < indexA; idx1++){
           present=present.next;
       }
      
       return present.element;
   }
  
   //Method definition
   @Override
   public int indexOf(Object data){
       myNode<E> present = head;
       int indData=0;
      
       while(present!=null)
       {          
           if(present.element.equals(data)){
               return indData;
           }
          
           present=present.next;
          
           //Increment
           indData++;
       }
      
       return indData;
   }
  
   //Method definition
   @Override
   public int lastIndexOf(Object data){
       myNode<E> present = tail;
       int indData=myListSize-1;
      
       while(present!=null && (data.equals(present.element))){
           present=present.previousNode;
          
           //Decrement
           indData--;
       }
      
       if(present==null){
           return -1;
       }
      
       return indData;
   }
  
   //Method definition
   @Override
   public E set(int indexA, E data)
   {
       if(indexA>myListSize ){
           return null;
       }
      
       myNode<E> present = head;
      
       while(indexA>0){
           present=present.next;
          
           //Decrement
           indexA--;
       }
      
       E temp1=present.element;
      
       present.element=data;
      
       return temp1;
   }
  
   //Method definition
   @Override
   public java.util.ListIterator<E> iterator(){
       return new myTwoWayListIterator<>();
   }
  
   private class myTwoWayListIterator<E> implements java.util.ListIterator<E>{
       private myNode<E> present = (myNode<E>)head;
       int indData = 0;
      
       //Constructor
       public myTwoWayListIterator(){}
      
       //Constructor
       public myTwoWayListIterator(int indexA)
       {
           if (indexA < 0 || indexA > myListSize){
               throw new IndexOutOfBoundsException("Index: " + indexA + ", Size: "+ myListSize);
           }
          
           for (int idx1 = 0; idx1 < indexA; idx1++){
               present = present.next;
           }
       }
      
       //Method definition
       @Override
       public boolean hasNext(){
           return (present != null);
       }
      
       //Method definition
       @Override
       public E next(){
           E data = present.element;
          
           present = present.next;
          
           //Increment
           indData++;
          
           return data;
       }
      
       //Method definition
       @Override
       public void remove(){
           myNode<E> temp1=present.previousNode;
           myNode<E> temp2=present.next;
           temp1.next=temp2;
           temp2.previousNode=temp1;
           present=temp1;
          
           //Decrement
           indData--;
       }
      
       //Method definition
       @Override
       public void add(E data){
           myNode<E> temp1=present.previousNode;
           myNode<E> temp2=new myNode(data);
           myNode<E> temp3=present;
           temp1.next=temp2;
           temp2.next=temp3;
           temp3.previousNode=temp2;
           temp2.previousNode=temp1;
           indData++;
       }
      
       //Method definition
       @Override
       public boolean hasPrevious(){
           return present != head;
       }
      
       //Method definition
       @Override
       public int nextIndex(){      
           return indData;
       }
      
       //Method definition
       @Override
       public E previous(){
           E data = present.element;
           present = present.previousNode;
          
           return data;
       }
      
       //Method definition
       @Override
       public int previousIndex(){
           return indData-1;
       }
      
       //Method definition
       @Override
       public void set(E data){
           present.element = data;
       }
   }
  
   //Class
   public class myNode<E>{
       E element;
       myNode<E> next;
       myNode<E> previousNode;
      
       //Constructor
       public myNode(E data){
           element = data;
       }
   }
  
   //Method definition
   @Override
   public int size(){
       return myListSize;
   }
  
   //Method definition
   @Override
   public ListIterator<E> listIterator(int indexA){
       return new myTwoWayListIterator<>(indexA);
   }
}