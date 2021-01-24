package com.pierrecattin.algorithms.part1.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pierrecattin.algorithms.utilities.Graph;
import com.pierrecattin.algorithms.utilities.Node;

public class MinCut {
	public static int singleRandomMinCut(Graph inputGraph) {
		if(inputGraph.nbNodes()<2) {
			return(0);
		} 
		
		MergeableGraph graph = new MergeableGraph(inputGraph);
		Random rand = new Random();
		while(graph.nbNodes()>2) {
			List<Node> nodes = graph.getNodes();
			Node A = nodes.get(rand.nextInt(nodes.size()));
			ArrayList<Node> destinationNodes = new ArrayList<Node>(graph.getEdgesFrom(A));
			if(destinationNodes != null) {
				Node B = destinationNodes.get(rand.nextInt(destinationNodes.size()));
				//System.out.println("Merging "+A+" with "+B);
				graph.mergeNodes(A, B);
				//System.out.println("Nodes in graph: "+graph.getNodes());
			}
		}
		int res = graph.getEdgesFrom(graph.getNodes().get(0)).size();
		//System.out.println("Cuts = "+res);
		return(res );
	}

	public static int minCut(Graph inputGraph) {
		int nbIter = inputGraph.nbNodes()^2;
		int bestMinCut=singleRandomMinCut(inputGraph);
		for(int i=0; i<nbIter-1; i++) {
			int randomMinCut = singleRandomMinCut(inputGraph);
			if(randomMinCut<bestMinCut){
				bestMinCut=randomMinCut;
			}
		}
		return(bestMinCut);
	}
}
