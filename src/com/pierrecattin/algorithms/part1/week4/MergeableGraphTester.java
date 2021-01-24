package com.pierrecattin.algorithms.part1.week4;

import com.pierrecattin.algorithms.utilities.Node;

public class MergeableGraphTester {
	public static void main(String[] args) {
		MergeableGraph graph=new MergeableGraph(false);
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		
		graph.addEdge(a, b);
		graph.addEdge(a, c);
		graph.addEdge(c, b);
		graph.addEdge(c, d);
		graph.addEdge(b, d);
		
		System.out.println(graph);
		System.out.println("\n");
		graph.mergeNodes(a, c);
		System.out.println(graph);
		System.out.println("\n");
		
		graph.mergeNodes(b, d);
		System.out.println(graph);
		System.out.println("\n");
		
		
	}
}
