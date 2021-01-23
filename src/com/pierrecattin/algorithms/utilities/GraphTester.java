package com.pierrecattin.algorithms.utilities;

public class GraphTester {
	public static void main(String[] args) {
		Graph graph=new Graph(5, false);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 2);
		graph.addEdge(2, 0);
		graph.addEdge(3, 4);
		
		graph.removeEdge(2, 2);
		System.out.println(graph);
	}
}
