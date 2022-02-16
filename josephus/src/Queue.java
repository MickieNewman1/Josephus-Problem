/* *****************************************************************************
 *             
 * Title:            Queue
 * Files:            Queue.java
 * 
 * Author:           Mickie Newman
 * 
 * Description:		 A generic Queue using a linked list implementation
 * 
 * Written:       	  3/5/2020
 * 
 * Credits:          
 **************************************************************************** */

import java.util.NoSuchElementException;

/**
 * A generic Queue implemented via a linked-list following a FIFO policy.
 * 
 * @author Mickie Newman 
 *
 * @param <T> The type of data this queue will hold
 */
public class Queue<T> {

	/**
	 * Internal node class for the linked-list data structure
	 * @author Mickie Newman
	 *
	 */
	private class Node
	{
		T value; // The data the node holds
		Node next; // A pointer to the next node in the list (or null if this is the last node)

		/**
		 * Create a new Node
		 * @param value The value this node should store
		 */
		public Node(T value) {
			this.value = value;
			this.next = null;
		}
	}

	// Instance data
	private Node head, tail; // Keep track of the first and last node in the list
	private int size; // How many nodes are in the list

	/**
	 * Get the number of nodes in the queue
	 * @return the number of nodes in the queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Check if the queue is empty
	 * @return true if the queue is empty (has no nodes), false otherwise
	 */
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		return false;
		
	}

	/**
	 * Add a new node based on a given value to the end of the queue. 
	 * Psuedocode:
	 *     1. If the list is currently empty:
	 *     		A. Create a new Node based on the passed in value
	 *     		B. Set your head and tail pointers to this new node
	 *     2. Else:
	 *     		A. Save the old tail pointer to a temporary variable
	 *     		B. Create a new Node based on the passed in value and set the tail
	 *     		   to be this new node
	 *     		C. Set the .next value of the temporary variable (which is equal to the 
	 *     		   node that used to be the tail node) to point to the new tail node
	 *     3. Increment the size counter
	 * (and/or see the lecture slides or your textbook page 151).
	 * 
	 * @param value The given value, which will be used to create a new node that is added 
	 * 			    to the end of the queue.
	 */
	public void enqueue(T value)
	{
		if(size==0) {
			Node newNode = new Node(value);
			head= newNode;
			tail= newNode;
			
		
		}
		else {
			Node oldTail = tail;
			tail= new Node(value);
			oldTail.next = tail;
		}
		size++;
		
	}

	/**
	 * Removes the first node in the list and returns its value.
	 * Pseudocode:
	 *     1. Create a temporary variable to store the head node
	 *     2. Set the head node to be the next node in the queue
	 *     3. Decrement the size counter
	 *     4. Return the value in the temporary variable that stores the
	 *     	  old head node
	 * (and/or see the lecture slides or page 151 of your textbook)
	 * 
	 * @throws NoSuchElementException if the list is empty
	 * @return The value of the first node in the list
	 */
	public T dequeue()
	{
		if (size == 0) throw new NoSuchElementException("Error - "
				+ "can't dequeue as the queue is empty!");
		Node oldHead = head;
		head = oldHead.next;
		size--;
		return oldHead.value;
		
	}
}
