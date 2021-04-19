package com.pierrecattin.algorithms.part4.week4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.pierrecattin.algorithms.part2.week1.Kosaraju;
import com.pierrecattin.algorithms.utilities.Graph;
import com.pierrecattin.algorithms.utilities.Node;

public class TwoSatSolver {
	private Graph graph;
	HashMap<Integer, Node> nodesMap; 
	private HashSet<Integer> variablesAbs;
	private Clause[] clauses;
	
	TwoSatSolver(Clause[] clauses){
		this.clauses=clauses;
		graph = new Graph(true);
		nodesMap = new HashMap<>();
		variablesAbs = new HashSet<>();
	}
	
	public boolean solve() {
		makeGraph();
		Map<Node, Integer> scc = Kosaraju.kosaraju(graph);
		//System.out.println(scc);
		for(int v:variablesAbs) {
			int componentVar1 = scc.get(nodesMap.get(v));
			int componentVar1Rev = scc.get(nodesMap.get(-v));
			if(componentVar1==componentVar1Rev) {
				return(false);
			}
		}
		return(true);
	}
	
	private void makeGraph() {
		for (Clause clause : clauses) {
			addVariable(clause.getVar1());
			addVariable(clause.getVar2());
			graph.addEdge(nodesMap.get(-clause.getVar1()), nodesMap.get(clause.getVar2()));
			graph.addEdge(nodesMap.get(-clause.getVar2()), nodesMap.get(clause.getVar1()));
		}
		//System.out.println(graph);
	}
	
	private void addVariable(int variableNum) {
		if(!variablesAbs.contains(Math.abs(variableNum))) {
			nodesMap.put(variableNum, new Node(String.valueOf(variableNum)));
			nodesMap.put(-variableNum, new Node(String.valueOf(-variableNum)));
			variablesAbs.add(Math.abs(variableNum));
		}
		
	}

}
