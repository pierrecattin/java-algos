package com.pierrecattin.algorithms.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph { 
	private boolean directed;
	private HashMap<Node, LinkedList<Node>> adjacencyMap; // each node is associated to a LinkedList, containing the nodes it's connected to
	
	
	public Graph(boolean directed) {
		this.directed = directed;
		adjacencyMap = new HashMap<>();
		}
	
	public Graph(Graph other) {
		this.directed = other.directed;
		// Create deep copy of adjacencyMap (create copies of Nodes)
	
		// Create mapping from nodes of original to nodes of copies
		HashMap<Node, Node> nodesMapping = new HashMap<>();
		for(Node sourceNode: other.adjacencyMap.keySet()) {
			nodesMapping.put(sourceNode, new Node(sourceNode));
		}
		
		// Populate adjacency map of copy
		this.adjacencyMap = new HashMap<>();	
		for(Node sourceNode: other.adjacencyMap.keySet()) {
			this.adjacencyMap.put(nodesMapping.get(sourceNode), new LinkedList<Node>());
			for(Node destinationNode : other.adjacencyMap.get(sourceNode)) {
				this.adjacencyMap.get(nodesMapping.get(sourceNode)).add(nodesMapping.get(destinationNode));
			}
		}
	}
	
	private void addEdgeHelper(Node source, Node destination) {
		LinkedList<Node> edgesOfSource = adjacencyMap.get(source);
		if(edgesOfSource == null) {
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
	
	private void removeEdgeHelper(Node source, Node destination) {
		LinkedList<Node> edgesOfSource = adjacencyMap.get(source);
		if(edgesOfSource != null) {
			if(adjacencyMap.get(source).contains(destination)) {
				adjacencyMap.get(source).remove(destination);
			}
		}
	}
	
	
	public void removeEdge(Node source, Node destination) {
		if(hasNode(source) && hasNode(destination)) {
			removeEdgeHelper(source, destination);
			if(!directed) {
				removeEdgeHelper(destination, source);
			}
		}
	}
	
	public void addNode(Node node) {
		if(!adjacencyMap.containsKey(node)) {
			adjacencyMap.put(node, null);
		}
	}
	public boolean hasNode(Node node) {
		return(adjacencyMap.containsKey(node));
	}
	
	public boolean hasEdge(Node source, Node destination) {
		return(hasNode(source) && hasNode(destination) && adjacencyMap.get(source).contains(destination));
	}
	
	public int nbNodes() {
		return(adjacencyMap.size());
	}
	
	public LinkedList<Node> getEdgesFrom(Node node){
		return(adjacencyMap.get(node));
	}
	
	public ArrayList<Node> getNodes(){
		return(new ArrayList<Node>(adjacencyMap.keySet()));
	}
	
	protected HashMap<Node, LinkedList<Node>> getAdjacencyMap(){
		return(adjacencyMap);
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
