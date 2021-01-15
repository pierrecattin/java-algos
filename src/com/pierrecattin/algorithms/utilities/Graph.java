package com.pierrecattin.algorithms.utilities;

import java.util.LinkedList;

public class Graph {
	int nbVertex; 
	boolean directed;
	private LinkedList<Integer> list[];
	
	public Graph(int nbVertex, boolean directed) {
		this.nbVertex=nbVertex;
		this.directed = directed;
		
		list = new LinkedList[nbVertex];
		
		for(int i=0; i<nbVertex; i++) {
			list[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int source, int destination) {
		list[source].addFirst(destination);
		
		if(directed) {
			list[destination].addFirst(source);
		}
	}
	
	public void print() {
		for (int i=0; i<nbVertex; i++) {
			System.out.println("Vertex "+i+" is connected to:");
			
			for(int j=0; j<list[i].size(); j++) {
				System.out.println(list[i].get(j)+" ");	
			}
		}
		System.out.println("\n");
	}

}
