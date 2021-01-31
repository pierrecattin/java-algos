package com.pierrecattin.algorithms.part2.week1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.pierrecattin.algorithms.utilities.*;
public class TopoSort {
	public static Map<Node, Integer> topologicalOrdering(Graph graph){
		 Map<Node, Integer> ordering = new HashMap<Node, Integer>();
		 Set<Node> exploredNodes = new HashSet<Node>();
		int curLabel = graph.nbNodes();
		for(Node v : graph.getNodes()) {
			if(!exploredNodes.contains(v)) {
				curLabel = DFSTopo(graph, v, exploredNodes, ordering, curLabel);
			}
		}
		return(ordering);
	}
	
	public static int DFSTopo(Graph graph, Node s,  Set<Node> exploredNodes,  Map<Node, Integer> ordering, int curLabel) {
		exploredNodes.add(s);
		for(Node v : graph.getEdgesFrom(s)) {
			if(!exploredNodes.contains(v)) {
				curLabel=DFSTopo(graph, v, exploredNodes, ordering, curLabel);
			}
		}
		ordering.put(s, curLabel);
		return(curLabel  - 1);
	}

}
