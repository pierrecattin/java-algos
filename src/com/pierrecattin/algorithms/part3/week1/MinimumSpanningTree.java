package com.pierrecattin.algorithms.part3.week1;

import java.util.ArrayList;

import com.pierrecattin.algorithms.utilities.*;
public class MinimumSpanningTree {
	public static int prim(GraphWithLength graph) {
		
		
		int totalCost=0;
		ArrayList<Node> visitedNodes = new ArrayList<>();
		
		// Choose arbitrary first node
		Node nodeToVisit=graph.getNodes().get(0);
		visitedNodes.add(nodeToVisit);
		while(visitedNodes.size()<graph.nbNodes()) {
			int bestCost=Integer.MAX_VALUE;
			Node bestDestinationNode=null;
			for(Node source:visitedNodes) {
				for(Node destination:graph.getEdgesFrom(source).keySet()) {
					if(!visitedNodes.contains(destination)) {
						if(graph.getEdgesFrom(source).get(destination)<bestCost) {
							bestCost = graph.getEdgesFrom(source).get(destination);
							bestDestinationNode=destination;
						}
					}
				}
			}
			totalCost += bestCost;
			visitedNodes.add(bestDestinationNode);
		}
		return(totalCost);
	}

}
