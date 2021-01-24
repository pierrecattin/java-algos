package com.pierrecattin.algorithms.part1.week4;

import java.util.LinkedList;

import com.pierrecattin.algorithms.utilities.Graph;
import com.pierrecattin.algorithms.utilities.Node;

public class MergeableGraph extends Graph {
	public MergeableGraph(boolean directed) {
		super(directed); 
	}
	
	public MergeableGraph(Graph graph) {
		super(graph); 
	}
	
	public void mergeNodes(Node a, Node b) {
		if(hasNode(a) && hasNode(b)) {
			a.setName(a.getName()+"+"+b.getName()); // concatenate node names
			
			// add edges starting from B to edges starting from A
			LinkedList<Node> edgesFromA = getEdgesFrom(a);
			LinkedList<Node> edgesFromB = getEdgesFrom(b);		
			
			for(Node nodeAccesibleFromB : edgesFromB) {
				if(!nodeAccesibleFromB.equals(a)) { // don't add loops
					edgesFromA.add(nodeAccesibleFromB);
				}
				// no need to remove nodes from B, because we will remove B from adjacencyMap's keyset
			}
			
			
			// transform edges going to B into edges going to A 
				// First identify nodes, but we cannot change adjacencyMap while iterating through it
			LinkedList<Node> nodesWithEdgesToB = new LinkedList<>();
			for(Node source : getAdjacencyMap().keySet()) {
				for(Node destination : getAdjacencyMap().get(source)) {
					if(destination.equals(b)) {
						nodesWithEdgesToB.add(source);
					}
				}
			}
				// Then add edges to A, and remove edges to B
			for(Node nodeWithEdgeToB : nodesWithEdgesToB) {
				if(!nodeWithEdgeToB.equals(a)) {
					getAdjacencyMap().get(nodeWithEdgeToB).add(a);
				}
				getAdjacencyMap().get(nodeWithEdgeToB).remove(b);
			}
			
			//delete Node B
			getAdjacencyMap().remove(b);
			
		}
	}

}
