package com.pierrecattin.algorithms.part2.week2;

import java.util.HashMap;
import java.util.HashSet;

import com.pierrecattin.algorithms.utilities.GraphWithLength;
import com.pierrecattin.algorithms.utilities.Node;

public class Dijkstra {
	public static HashMap<Node, Integer> shortestPath(GraphWithLength graph, Node s){
		HashMap<Node, Integer> distances = new HashMap<>();
		for (Node destination:graph.getNodes()) {
			if(destination.equals(s)) {
				distances.put(destination, 0);
			} else {
				distances.put(destination, Integer.MAX_VALUE);
			}
		}
		
		HashSet<Node> exploredNodes = new HashSet<>();
		exploredNodes.add(s);
		
		boolean nodesRemaining = true;
		while(nodesRemaining){
			NodeDistance nextNode = findNextNode(graph, exploredNodes, distances);
			if(nextNode.node==null) {
				nodesRemaining = false;
			} else {
				exploredNodes.add(nextNode.node);
				distances.put(nextNode.node, nextNode.distance);
			}
			
		}
		
		return(distances);
	}
	
	
	private static NodeDistance findNextNode(GraphWithLength graph, HashSet<Node> exploredNodes, HashMap<Node, Integer> distances){
		NodeDistance bestNode = new NodeDistance();
		bestNode.distance = Integer.MAX_VALUE;
		for (Node source : exploredNodes) {
			HashMap<Node, Integer> distToDestination = graph.getEdgesFrom(source);
			for(Node destination : distToDestination.keySet()) {
				if(!exploredNodes.contains(destination)) {
					int distanceFromSingleSource = distances.get(source)+distToDestination.get(destination);
					if(distanceFromSingleSource < bestNode.distance ) {
						bestNode.node = destination;
						bestNode.distance = distanceFromSingleSource;
					}
				}
			}
		}
		return(bestNode);
	}

}
