/**
 * 
 */
package com.pierrecattin.algorithms.part2.week1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.pierrecattin.algorithms.utilities.*;

public class Kosaraju {

	public static Map<Node, Integer> kosaraju(Graph graph) {
		Graph graphRev = revertedGraph(graph);
		Map<Node, Integer> topologicalOrdering = TopoSort.topologicalOrdering(graphRev);
		
		Map<Node, Integer> SCCMapping = new HashMap<Node, Integer>();
		Set<Node> exploredNodes = new HashSet<Node>();
		int numSCC = 0;
		for(Node v:topologicalOrdering.keySet()) {
			if(!exploredNodes.contains(v)) {
				numSCC = numSCC + 1;
				DFSSCC(graph, v, SCCMapping, exploredNodes, numSCC);
			}
		}
		
		return(SCCMapping);
	}
	
	public static void DFSSCC(Graph graph, Node s, 	Map<Node, Integer> SCCMapping, Set<Node> exploredNodes, int numSCC) {
		exploredNodes.add(s);
		SCCMapping.put(s, numSCC);
		if(graph.getEdgesFrom(s) != null) {
			for (Node v : graph.getEdgesFrom(s)) {
				if(!exploredNodes.contains(v)) {
					DFSSCC(graph, v, SCCMapping, exploredNodes, numSCC);
				}
			}	
		}
	}

	
	public static Graph revertedGraph(Graph graph) {
		// Creates a copy of graph with revered edges, using the original set of Nodes (Nodes are not copied)
		Graph revertedGraph = new Graph(true);
		
		for(Node sourceNode:graph.getNodes()) {
			if(graph.getEdgesFrom(sourceNode)!=null) {
				for (Node destinationNode:graph.getEdgesFrom(sourceNode)) {
					revertedGraph.addEdge(destinationNode, sourceNode);
				}
			}
		}
		
		return(revertedGraph);
	}
	
}
