/**
 * 
 */
package com.pierrecattin.algorithms.part2.week1;
import com.pierrecattin.algorithms.utilities.*;

public class Kosaraju {

	public static void kosaraju(Graph graph) {		
		
	}
	
	public static Graph revertedGraph(Graph graph) {
		// Creates a copy of graph with revered edges, using the original set of Nodes (Nodes are not copied)
		Graph revertedGraph = new Graph(true);
		
		for(Node sourceNode:graph.getNodes()) {
			for (Node destinationNode:graph.getEdgesFrom(sourceNode)) {
				revertedGraph.addEdge(destinationNode, sourceNode);
			}
		}
		
		return(revertedGraph);
	}
}
