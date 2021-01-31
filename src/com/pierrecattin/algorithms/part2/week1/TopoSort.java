package com.pierrecattin.algorithms.part2.week1;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.pierrecattin.algorithms.utilities.*;
public class TopoSort {
	public static Map<Node, Integer> topologicalOrdering(Graph graph){
		 Map<Node, Integer> ordering = new LinkedHashMap<Node, Integer>();
		 Set<Node> exploredNodes = new HashSet<Node>();
		int curLabel = graph.nbNodes();
		for(Node v : graph.getNodes()) {
			if(!exploredNodes.contains(v)) {
				curLabel = DFSTopo(graph, v, exploredNodes, ordering, curLabel);
			}
		}
		Map<Node, Integer> sortedOrdering = ordering.entrySet()
				  .stream()
				  .sorted(Map.Entry.comparingByValue())
				  .collect(Collectors.toMap(
				    Map.Entry::getKey, 
				    Map.Entry::getValue, 
				    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		return(sortedOrdering);
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
