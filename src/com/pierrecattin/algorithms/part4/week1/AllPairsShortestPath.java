package com.pierrecattin.algorithms.part4.week1;

import java.util.ArrayList;
import java.util.HashMap;

import com.pierrecattin.algorithms.utilities.GraphWithLength;
import com.pierrecattin.algorithms.utilities.Node;

public class AllPairsShortestPath {
	public static ArrayList<ArrayList<Integer>> FloydWarshall(GraphWithLength graph){
		ArrayList<Node> nodes = graph.getNodes();
		int n = graph.nbNodes();
		
		ArrayList<ArrayList<ArrayList<Integer>>> A = new ArrayList<>(); // subproblems; dimensions = maxNodeNumber, source, destination

		// base case (maxNodeNumber==0)
		A.add(new ArrayList<ArrayList<Integer>>()); 
		for(int sourceNb=0;sourceNb<n; sourceNb++) {
			A.get(0).add(new ArrayList<Integer>());
			for (int destinationNb=0; destinationNb<n; destinationNb++) {
				int dist=0;
				if(sourceNb!=destinationNb) {
					HashMap<Node, Integer> edges = graph.getEdgesFrom(nodes.get(sourceNb));
					if(edges.containsKey(nodes.get(destinationNb))) {
						dist=edges.get(nodes.get(destinationNb));
					} else {
						dist = Integer.MAX_VALUE;
					}
				}
				A.get(0).get(sourceNb).add(dist);
			}
		}
		// solve subproblems with maxNodeNumber>0
		for (int maxNodeNumber=1; maxNodeNumber<n;maxNodeNumber++) {
			//System.out.println("maxNodeNumber="+maxNodeNumber+"/"+(n-1));
			if(maxNodeNumber>1) {
				A.remove(0);				
			}
			A.add(new ArrayList<ArrayList<Integer>>()); 
			for(int sourceNb=0;sourceNb<n; sourceNb++) {
				A.get(1).add(new ArrayList<Integer>());
				for (int destinationNb=0; destinationNb<n; destinationNb++) {
					int case1 = A.get(0).get(sourceNb).get(destinationNb);
					int case2 = A.get(0).get(sourceNb).get(maxNodeNumber) + 
								A.get(0).get(maxNodeNumber).get(destinationNb);
					A.get(1).get(sourceNb).add(Math.min(case1, case2));
				}
			}
		}
		
		// Check negative cycle
		for(int i=0; i<n; i++) {
			if(A.get(1).get(i).get(i)<0) {
				return(null);
			}
		}
		
		// If no negative cycle, return result from last subproblem
		return(A.get(1));
	}
}
