package com.pierrecattin.algorithms.part3.week1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.GraphWithLength;
import com.pierrecattin.algorithms.utilities.InputReader;

public class MinimumSpanningTreeTest {

	public static void main(String[] args) {
		GraphWithLength graph = InputReader.readGraphWithLength("res/edges.txt", false);	
		System.out.println(MinimumSpanningTree.prim(graph));
	}
	
	@Test 
	void testPrim() {
		GraphWithLength graph = InputReader.readGraphWithLength("res/edges.txt", false);	
		assertEquals(-3612829, MinimumSpanningTree.prim(graph));
	}

}
