package com.pierrecattin.algorithms.part4.week1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.GraphWithLength;
import com.pierrecattin.algorithms.utilities.InputReader;

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
	
	@Test 
	void test() {
		GraphWithLength graph = InputReader.readGraphWithLength("res/edges.txt", false);	
		assertEquals(0, 0);
	}

}
