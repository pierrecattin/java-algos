package com.pierrecattin.algorithms.part3.week3;

import java.util.HashMap;
import java.util.Map.Entry;

import com.pierrecattin.algorithms.utilities.Graph;
import com.pierrecattin.algorithms.utilities.Node;


public class HuffmanEncoding {
	private Graph tree;
	//private HashMap<String, Node> endNodeNames;
	private HashMap<Node, Long> rootNodesWeights;
	private Node root;
	
	HuffmanEncoding(HashMap<String, Integer> symbols) {
		tree = new Graph(true);
		//endNodeNames= new HashMap<>();
		rootNodesWeights = new HashMap<>();
		
		
		for (Entry<String, Integer> symbol:symbols.entrySet()) {
			Node n = new Node(symbol.getKey());
			//endNodeNames.put(symbol.getKey(), n);
			rootNodesWeights.put(n,Long.valueOf(symbol.getValue()));
		}
		
		
		while(rootNodesWeights.size()>1) {
			Node minNode1 = minRootNode();
			long weightsSum=rootNodesWeights.get(minNode1);
			rootNodesWeights.remove(minNode1);
			Node minNode2 = minRootNode();
			weightsSum += rootNodesWeights.get(minNode2); 
			
			rootNodesWeights.remove(minNode2);
			root = new Node(minNode1.getName()+"'");
			
			
			tree.addNode(minNode1);
			tree.addNode(minNode2);
			tree.addNode(root);
			tree.addEdge(root, minNode1);
			tree.addEdge(root, minNode2);
			rootNodesWeights.put(root, weightsSum);	
		}
	}
	
	public Graph getTree() {
		return(tree);
	}
	
	/*public int depth() {
		HashMap<Node, Boolean> visitedNodes = new HashMap<>();
		for(Node n:tree.getNodes()) {
			visitedNodes.put(n,false);
		}
		
		int maxDepth=dfs(visitedNodes, root, 1);
		return(maxDepth);
	}
	
	private int dfs(HashMap<Node, Boolean> visitedNodes, Node source, int sourceDepth) {
		visitedNodes.put(source, true);
		int deepestSubCall=sourceDepth;
		if(tree.getEdgesFrom(source)!=null) {
			for(Node destination:tree.getEdgesFrom(source)) {
				if(!visitedNodes.get(destination)) {
					int subDepth=dfs(visitedNodes, destination, sourceDepth+1);
					if(subDepth>deepestSubCall) {
						deepestSubCall=subDepth;
					}
				}
			}
		}
		System.out.println(deepestSubCall);
		return(deepestSubCall);
	}*/
	
	private Node minRootNode(){
		Node minNode=null;
		Long minWeight=null;
		for(Entry<Node, Long> e : rootNodesWeights.entrySet()) {
			if(minNode==null) {
				minNode=e.getKey();
				minWeight=e.getValue();
			} else if (minWeight<e.getValue()) {
				minNode=e.getKey();
				minWeight=e.getValue();
			}
		}
		return(minNode);
	}

}
 