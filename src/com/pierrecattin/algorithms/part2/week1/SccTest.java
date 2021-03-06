package com.pierrecattin.algorithms.part2.week1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.*;

public class SccTest {
	public static void main(String[] args) {		
		Graph graph = InputReader.readGraph("res/SCC.txt", true);	
		//System.out.println(graph.nbNodes());
		//System.out.println(graph.getNodes().get(1));
		//System.out.println(graph.getEdgesFrom(graph.getNodes().get(1)));
		Map <Node, Integer> SCC = Kosaraju.kosaraju(graph);
		System.out.println("Completed");
		//System.out.println(SCC);
		Map<Integer, Integer> componentSize = componentSize(SCC);
		for(Integer component:componentSize.keySet()) {
			System.out.println(componentSize.get(component));	
		}
		//434821,968,459,313,211

	}
	
	@Test
	void TestSCC() {	
		Graph graph = InputReader.readGraph("res/SCC_figure_8.16.txt", true);	
		Map <Node, Integer> SCC = Kosaraju.kosaraju(graph);
		Map<Integer, Integer> componentSize = componentSize(SCC);
		//System.out.println(SCC);
		//System.out.println(componentSize);
		Map<Integer, Integer> expecteds = new HashMap<>();
		expecteds.put(1, 3);
		// Component names 2 and 3 could be reversed, the answer would still be correct
		if(componentSize.get(2)==1) {
			expecteds.put(2, 1);
			expecteds.put(3, 4);
		} else {
			expecteds.put(3, 1);
			expecteds.put(2, 4);
		}
		
		expecteds.put(4, 3);
		for(Integer component:expecteds.keySet()) {
			//System.out.println("Component="+component+"  Expected="+expecteds.get(component)+"   actual="+componentSize.get(component));
			assertEquals(expecteds.get(component), componentSize.get(component));
		}	
	}
	
	
	public static Map<Integer, Integer> componentSize(Map <Node, Integer>SCCMap){
		Map<Integer, Integer> componentSize = new LinkedHashMap<>(); // maps SCC to number of nodes in SCC
		for(Map.Entry<Node, Integer> entry : SCCMap.entrySet()) {
			int newNodesCount = 1;
			if(componentSize.containsKey(entry.getValue()))	{ // if SCC is already tracked
				newNodesCount = componentSize.get(entry.getValue()) + 1;
			} 
			componentSize.put(entry.getValue(), newNodesCount);
		}
		
		Map<Integer, Integer> sortedComponentSize = componentSize.entrySet()
				  .stream()
				  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				  .collect(Collectors.toMap(
				    Map.Entry::getKey, 
				    Map.Entry::getValue, 
				    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		return(sortedComponentSize);
	}
}
