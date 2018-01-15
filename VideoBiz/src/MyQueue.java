import java.util.LinkedList;
import java.util.List;

/*
 * CSE 17
 * Donna To
 * dkt220
 * [with assistance from tutor name (tutor email)]
 * Program #5		DEADLINE: December 8, 2017
 * Program: WebRentz Movie Rental System - MyQueue
 */

/** This class demonstrates how to implement a queue using
  * composition with a linked list. */
public class MyQueue<E> {
  
  private MyLinkedList<E> list;
  
  /** Create a new queue object. */
  public MyQueue() {
    list = new MyLinkedList<E>();
  }
  
  /** Add element e to the end of the queue. */
  public void enqueue(E e) {
    // we assume the tail of the list is the end of the queue
    list.addLast(e);
  }
  
  /** Remove and return the element at the front of the queue. */
  public E dequeue() {
    // we assume the head of the list is the front of the queue
    return list.removeFirst();
  }
  
  /** Return the number of elements in the queue. */
  public int getSize() {
    return list.size();
  }
  
  /** TODO Returns element at index in the queue, does not alter queue */
  public E peekIndex(int index) {
	  return list.get(index);
  }
  
  /** Test the queue */
  public static void main(String[] args) {
    MyQueue<String> q = new MyQueue<String>();
    q.enqueue("The Clash");
    q.enqueue("Pink Floyd");
    System.out.println("Dequeue: " + q.dequeue());
    q.enqueue("Wilco");
    System.out.println("Dequeue: " + q.dequeue());
    q.enqueue("Cee Lo Green");
    System.out.println("lets see " + q.peekIndex(0));
    while (q.getSize() > 0) {
      System.out.println("Dequeue: " + q.dequeue());
    }
  }
}