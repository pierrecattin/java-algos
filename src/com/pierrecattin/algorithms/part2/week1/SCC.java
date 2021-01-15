/**
 * 
 */
package com.pierrecattin.algorithms.part2.week1;
import com.pierrecattin.algorithms.utilities.*;

public class SCC {

	public static void main(String[] args) {
		 Graph graph = new Graph(5, false);
	        graph.addEdge(0,1);
	        graph.addEdge(0, 4);
	        graph.addEdge(1, 2);
	        graph.addEdge(1, 3);
	        graph.addEdge(1, 4);
	        graph.addEdge(2, 3);
	        graph.addEdge(3, 4);
	        graph.print();
		
		
	}

}
