package com.pierrecattin.algorithms.utilities;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphWithLength { 
	private boolean directed;
	private HashMap<Node, HashMap<Node, Integer>> adjacencyMap; 
	
	
	public GraphWithLength(boolean directed) {
		this.directed = directed;
		adjacencyMap = new HashMap<>();
		}
	
	private void addEdgeHelper(Node source, Node destination, int distance) {
		HashMap<Node, Integer> edgesOfSource = adjacencyMap.get(source);
		if(edgesOfSource == null) {
			edgesOfSource = new HashMap<>();
		}
		edgesOfSource.put(destination, distance); 
		adjacencyMap.put(source, edgesOfSource); 
	}
	
	
	public void addEdge(Node source, Node destination, int distance) {
		addNode(source);
		addNode(destination);
		
		addEdgeHelper(source, destination, distance);
		if(!directed) {
			addEdgeHelper(destination, source, distance);
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
		return(hasNode(source) && hasNode(destination) && adjacencyMap.get(source).containsKey(destination));
	}
	
	public int nbNodes() {
		return(adjacencyMap.size());
	}
	
	public HashMap<Node, Integer> getEdgesFrom(Node node){
		return(adjacencyMap.get(node));
	}
	
	public ArrayList<Node> getNodes(){
		return(new ArrayList<Node>(adjacencyMap.keySet()));
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
				for(Node destination : adjacencyMap.get(source).keySet()) {
					out += destination+" (" + adjacencyMap.get(source).get(destination) +"); ";	
				}
			}
		}
		return(out);
	}
}
