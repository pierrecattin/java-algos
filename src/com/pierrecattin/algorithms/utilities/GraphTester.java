package com.pierrecattin.algorithms.utilities;

public class GraphTester {
	public static void main(String[] args) {
		Graph graph=new Graph(true);
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		
		graph.addEdge(a, c);
		graph.addEdge(a, b);
		graph.addEdge(c, b);
		System.out.println(graph);
		
	}
}
