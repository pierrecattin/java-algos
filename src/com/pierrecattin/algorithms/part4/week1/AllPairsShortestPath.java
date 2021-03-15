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
					if(edges==null || !edges.containsKey(nodes.get(destinationNb))) {
						dist = Integer.MAX_VALUE;
					} else {
						dist=edges.get(nodes.get(destinationNb));
					}
				}
				A.get(0).get(sourceNb).add(dist);
			}
		}
		//print2dArray(A.get(0));
		//System.out.println("            ");
		
		// solve subproblems with maxNodeNumber>0
		for (int maxNodeNumber=1; maxNodeNumber<n;maxNodeNumber++) {
			//System.out.println("maxNodeNumber="+maxNodeNumber+"/"+(n-1));
			if(maxNodeNumber>1) {
				A.remove(0);				
			}
			A.add(new ArrayList<ArrayList<Integer>>()); 
			for(int sourceNb=0;sourceNb<n; sourceNb++) {
				A.get(1).add(new ArrayList<Integer>());
				//System.out.println("Source="+sourceNb);
				for (int destinationNb=0; destinationNb<n; destinationNb++) {
					//System.out.println("Destination="+destinationNb);
					int case1 = A.get(0).get(sourceNb).get(destinationNb);
					int case2 = sumWithoutOverflow(	A.get(0).get(sourceNb).get(maxNodeNumber), 
													A.get(0).get(maxNodeNumber).get(destinationNb));
					//System.out.println("case1="+case1);
					//System.out.println("case2="+case2);
					A.get(1).get(sourceNb).add(Math.min(case1, case2));
				}
			}
			//print2dArray(A.get(0));
			//System.out.println("->");
			//print2dArray(A.get(1));
			//System.out.println("       ");
			//System.out.println("       ");
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
	
	private static int sumWithoutOverflow(int a, int b) {
		if(a>=0) {
			if(b>= Integer.MAX_VALUE-a) {
				return(Integer.MAX_VALUE);
			}
		}
		if(a<0) {
			if(b < -a - Integer.MAX_VALUE) {
				return(-Integer.MAX_VALUE);
			}
		}
		
		return(a+b);
	}
	
	
	public static void print2dArray(ArrayList<ArrayList<Integer>> A) {
		for(int i=0; i<A.size(); i++) {
			System.out.println(A.get(i));
		}
	}
	
}
