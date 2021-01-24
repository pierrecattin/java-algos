package com.pierrecattin.algorithms.part1.week4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.Graph;
import com.pierrecattin.algorithms.utilities.InputReader;
import com.pierrecattin.algorithms.utilities.Node;

public class MinCutTest {
	public static void main(String[] args) {
		InputReader reader = new InputReader();
		Graph graph = reader.readGraph("res/kargerMinCut.txt", false);
		//System.out.println(graph);
		System.out.println(MinCut.minCut(graph));
	}
	
	@Test
	void testMinCut1() {
		Graph graph=new Graph(false);
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		
		graph.addEdge(a, b);
		graph.addEdge(a, c);
		graph.addEdge(c, b);
		graph.addEdge(c, d);
		graph.addEdge(b, d);	
		assertEquals(2, MinCut.minCut(graph));
	}
	
	@Test
	void testMinCut2() {
		Graph graph=new Graph(false);
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		
		graph.addEdge(a, b);
		graph.addEdge(a, c);
		graph.addEdge(a, d);
		
		graph.addEdge(b, c);
		graph.addEdge(b, d);
		graph.addEdge(b, e);
		
		graph.addEdge(c,d);
		
		graph.addEdge(d,g);
		
		graph.addEdge(e,f);
		graph.addEdge(e,g);
		graph.addEdge(e,h);
		
		
		graph.addEdge(f,g);
		graph.addEdge(f,h);
		
		graph.addEdge(g,h);
		
				
		assertEquals(2, MinCut.minCut(graph));
	}


}
