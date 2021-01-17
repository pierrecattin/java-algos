package com.pierrecattin.algorithms.utilities;

import java.util.LinkedList;

public class Graph {
	private int nbVertex; 
	private boolean directed;
	private LinkedList<Integer> edges[]; // each vertex has its LinkedList, containing the vertices it's connected to
	
	public Graph(int nbVertex, boolean directed) {
		this.nbVertex=nbVertex;
		this.directed = directed;
		
		edges = new LinkedList[nbVertex];
		
		for(int i=0; i<nbVertex; i++) {
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
		out += " with " + nbVertex + " vertices";
		for (int i=0; i<nbVertex; i++) {
			out += "\n";
			out += "Vertex "+i + " is connected to: ";
			
			for(int j=0; j<edges[i].size(); j++) {
				out += edges[i].get(j)+"; ";	
			}
		}
		return(out);
	}
}
