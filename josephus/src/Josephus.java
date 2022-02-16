/* *****************************************************************************
 *           
 * Title:            Josephus
 * Files:            Josephus.java, Queue.java
 * 
 * Author:           Mickie Newman 
 * 
 * Description:		 Solves the Josephus problem using a Queue
 * 
 * Written:       	 3/5/2020
 * 
 * Credits:          inspired by https://algs4.cs.princeton.edu/13stacks/Josephus.java.html
 **************************************************************************** */

/**
 * In the Josephus problem from antiquity, N people are in dire straits 
 * and agree to the following strategy to reduce the population. They 
 * arrange themselves in a circle (at positions numbered from 0 to N-1) and 
 * proceed around the circle, eliminating every Mth person until only one 
 * person is left. Legend has it that Josephus figured out where to sit 
 * to avoid being eliminated. This program mimics this elimination process
 * and tells Josephus which position he should sit in to avoid being eliminated.
 * 
 * @author Mickie Newman
 *
 */
public class Josephus {

	public static void main(String[] args) {
		// Variables for the elimination process and number of people (feel free to change)
		int m = 2; // Defines the elimination process, which will eliminate ever mth person
        int n = 7; // Defines the total number of people
        
        assert n > 0 : "Error - n must be greater than 0";
        assert m > 0 : "Error - m must be greater than 0";

        // Initialize the queue
        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < n; i++)
            queue.enqueue(i);

        // Go through the elimination procedure, eliminating every mth position until
        // all are removed, keeping track of the last position eliminated
        int positionEliminated = -1;
        System.out.print("Elimination order: ");
        while (!queue.isEmpty()) {
            for (int i = 0; i < m-1; i++)
                queue.enqueue(queue.dequeue());
            positionEliminated = queue.dequeue();
            System.out.print(positionEliminated + " ");
        } 
        System.out.println();
        System.out.println("Josephus should sit in position " + positionEliminated + 
        		" to be the last one left!");
	}
}
