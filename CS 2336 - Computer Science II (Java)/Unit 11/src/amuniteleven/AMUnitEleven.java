/*
 * EXERCISE 24.3 
(Implement a doubly linked list) The MyLinkedList class used in Listing 24.6
is a one-way directional linked list that enables one-way traversal of the list.
Modify the Node class to add the new data field name previous to refer to the
previous node in the list, as follows:
public class Node<E> {
E element;
Node<E> next;
Node<E> previous;
public Node(E e) {
element = e;
}
}
Implement a new class named TwoWayLinkedList that uses a doubly
linked list to store elements. The MyLinkedList class in the text
extends MyAbstractList. Define TwoWayLinkedList to extend the
java.util.AbstractSequentialList class. You need to implement all the
methods defined in MyLinkedList as well as the methods listIterator()
and listIterator(int index). Both return an instance of java.util.
ListIterator<E>. The former sets the cursor to the head of the list and the
latter to the element at the specified index
 */
package amuniteleven;
import java.util.*;
//Class
public class AMUnitEleven
{
   public static void main(String[] args)
   {
       //Create new instance
       MyTwoWayLinkedList<Integer> myTwoWayList = new MyTwoWayLinkedList<>();
      
       //Function calls
       myTwoWayList.add(1,1);
       myTwoWayList.add(2,2);
       myTwoWayList.add(3,3);
       myTwoWayList.add(4,4);
       myTwoWayList.add(5,5);
       myTwoWayList.add(6,6);
       
       
       ListIterator<Integer> myTwoWayListIterator = myTwoWayList.iterator();
       myTwoWayListIterator.next();
       myTwoWayListIterator.next();
       myTwoWayListIterator.next();

       System.out.println();
      
       while (myTwoWayListIterator.hasPrevious())
              
           //Print output
           System.out.print(myTwoWayListIterator.previous() + " ");
   }
}