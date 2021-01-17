package com.pierrecattin.algorithms.utilities;

import java.util.ArrayList;

public class Graph {
	private int nbNodes; 
	private boolean directed;
	private ArrayList<ArrayList<Integer>> edges; // each node has its ArrayList, containing the vertices it's connected to
	
	public Graph(int nbNodes, boolean directed) {
		this.nbNodes = nbNodes;
		this.directed = directed;
		this.edges = new ArrayList();
		for(int i=0; i<nbNodes; i++) {
			edges.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int source, int destination) {
		edges.get(source).add(destination);
		
		if(!directed) {
			edges.get(destination).add(source);
		}
	}
	
	public void removeEdge(int source, int destination) {
	}
	
	
	public String toString() {
		String out ="";
		if(directed) {
			out += "Directed graph";
		} else {
			out += "Undirected graph";
		}
		out += " with " + nbNodes + " nodes";
		for (int i=0; i<nbNodes; i++) {
			out += "\n";
			out += "Node "+i + " is connected to: ";
			
			for(int j=0; j<edges.get(i).size(); j++) {
				out += edges.get(i).get(j)+"; ";	
			}
		}
		return(out);
	}
}
