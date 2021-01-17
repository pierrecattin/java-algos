package com.pierrecattin.algorithms.utilities;

import java.util.LinkedList;

public class Graph {
	private int nbNodes; 
	private boolean directed;
	private LinkedList<Integer> edges[]; // each node has its LinkedList, containing the vertices it's connected to
	
	public Graph(int nbNodes, boolean directed) {
		this.nbNodes=nbNodes;
		this.directed = directed;
		
		edges = new LinkedList[nbNodes];
		
		for(int i=0; i<nbNodes; i++) {
			edges[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int source, int destination) {
		edges[source].addFirst(destination);
		
		if(!directed) {
			edges[destination].addFirst(source);
		}
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
			
			for(int j=0; j<edges[i].size(); j++) {
				out += edges[i].get(j)+"; ";	
			}
		}
		return(out);
	}
}
