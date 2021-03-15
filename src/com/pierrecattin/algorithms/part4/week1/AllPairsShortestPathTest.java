package com.pierrecattin.algorithms.part4.week1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.GraphWithLength;
import com.pierrecattin.algorithms.utilities.InputReader;
import com.pierrecattin.algorithms.utilities.Node;

public class AllPairsShortestPathTest {

	public static void main(String[] args) {
		runCase("res/g1.txt");
		runCase("res/g2.txt");
		runCase("res/g3.txt");
	}
	
	private static void runCase(String path) {
		System.out.println(path);
		GraphWithLength graph = InputReader.readGraphWithLength(path, true);	
		ArrayList<ArrayList<Integer>> paths = AllPairsShortestPath.FloydWarshall(graph);
		if(paths != null) {
			System.out.println(findMin(paths));	
		} else {
			System.out.println("Negative cycle");
		}
	}
	
	private static int findMin(ArrayList<ArrayList<Integer>> paths) {
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<paths.size(); i++) {
			for(int j=0; j<paths.get(i).size(); j++) {
				int dist = paths.get(i).get(j);
				if(dist<min) {
					min=dist;
				}
			}
		}
		
		return(min);
	}
	
	
	void test() {
		GraphWithLength graph = new GraphWithLength(true);	
		HashMap<String, Node> nodes = new HashMap<>();
		
		String[] nodeNames = {"s", "t", "u", "v", "w"};
		for (String n:nodeNames) {
			nodes.put(n, new Node(n));
			graph.addNode(nodes.get(n));
		}
		
		graph.addEdge(nodes.get("s"), nodes.get("v"), 4);
		graph.addEdge(nodes.get("s"), nodes.get("u"), 2);
		graph.addEdge(nodes.get("u"), nodes.get("w"), 2);
		graph.addEdge(nodes.get("w"), nodes.get("t"), 2);
		graph.addEdge(nodes.get("u"), nodes.get("v"), -1);
		graph.addEdge(nodes.get("v"), nodes.get("t"), 4);
		
		//System.out.println(graph);
		System.out.println(graph.getNodes());
		ArrayList<ArrayList<Integer>> paths = AllPairsShortestPath.FloydWarshall(graph);
		System.out.println(paths);
		}

}
