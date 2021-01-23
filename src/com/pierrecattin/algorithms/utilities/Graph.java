package com.pierrecattin.algorithms.utilities;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph { 
	private boolean directed;
	private HashMap<Node, LinkedList<Node>> adjacencyMap; // each node has its LinkedList, containing the nodes it's connected to
	
	
	public Graph(boolean directed) {
		this.directed = directed;
		adjacencyMap = new HashMap<>();
		}
	
	public void addEdgeHelper(Node source, Node destination) {
		LinkedList<Node> edgesOfSource = adjacencyMap.get(source);
		if(edgesOfSource != null) {
			edgesOfSource.remove(destination); // remove edge if it exists (no parallel edges support)
		} else {
			// if source has no LinkedList yet, it needs to be created
			edgesOfSource = new LinkedList<>();
		}
		edgesOfSource.add(destination); // add node to LinkedList
		adjacencyMap.put(source, edgesOfSource); // add LinkedList to adjacencyMap
	}
	
	public void addEdge(Node source, Node destination) {
		// Create Nodes if they don't exist
		addNode(source);
		addNode(destination);
		
		addEdgeHelper(source, destination);
		if(!directed) {
			addEdgeHelper(destination, source);
		}
	}
	
	
	public void addNode(Node node) {
		if(!adjacencyMap.containsKey(node)) {
			adjacencyMap.put(node, null);
		}
	}
	
	public boolean hasEdge(Node source, Node destination) {
		if(!adjacencyMap.containsKey(source)) {
			return(false);
		}
		if(!adjacencyMap.containsKey(destination)) {
			return(false);
		}
		return(adjacencyMap.get(source).contains(destination));
	}
	
	
	public String toString() {
		String out ="";
		if(directed) {
			out += "Directed graph";
		} else {
			out += "Undirected graph";
		}
		out += " with " + adjacencyMap.size() + " nodes";
		
		for(Node source : adjacencyMap.keySet()) {
			out += "\n";
			out += "Node "+source + " has edge towards: ";
			if(adjacencyMap.get(source)!=null) {
				for(Node destination : adjacencyMap.get(source)) {
					out += destination+"; ";	
				}
			}
		}
		return(out);
	}
}
