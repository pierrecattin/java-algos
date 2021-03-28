package com.pierrecattin.algorithms.part3.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.pierrecattin.algorithms.utilities.BinaryTree;
import com.pierrecattin.algorithms.utilities.Node;


public class HuffmanEncoder {
	private BinaryTree tree;
	private HashMap<Node, Long> rootNodesWeights;
	private HashMap<String, Node> symbolToNodes;
	
	HuffmanEncoder(HashMap<String, Integer> symbols) {
		tree = new BinaryTree();
		rootNodesWeights = new HashMap<>();
		symbolToNodes = new HashMap<>();
		
		for (Entry<String, Integer> symbol:symbols.entrySet()) {
			Node n = new Node(symbol.getKey());
			rootNodesWeights.put(n,Long.valueOf(symbol.getValue()));
			symbolToNodes.put(symbol.getKey(), n);
		}
		
		
		while(rootNodesWeights.size()>1) {
			Node minNode1 = minRootNode();
			long weightsSum=rootNodesWeights.get(minNode1);
			rootNodesWeights.remove(minNode1);
			Node minNode2 = minRootNode();
			weightsSum += rootNodesWeights.get(minNode2); 
			
			rootNodesWeights.remove(minNode2);
			Node localRoot = new Node(minNode1.getName()+"'");
			
			
			tree.addEdge(localRoot , minNode1, true);
			tree.addEdge(localRoot , minNode2, false);
			rootNodesWeights.put(localRoot , weightsSum);	
		}
	}
	
	public BinaryTree getTree() {
		return(tree);
	}
	
	public ArrayList<Boolean> encode(String symbol) {
		Node curChild = symbolToNodes.get(symbol);
		if(curChild==null) {
			return(null);
		}
		ArrayList<Boolean>  encoding= new ArrayList<>();
		Node curParent = tree.getParent(curChild);
		while(curParent != null) {
			if(tree.isLeftChild(curChild)) {
				encoding.add(0, true); 
			} else {
				encoding.add(0, false);
			}
			curChild=curParent;
			curParent=tree.getParent(curParent);
			
		}
		return(encoding);
	}
	
	public String decode(ArrayList<Boolean> encoding) {
		Node currentNode=tree.getRoot();
		for(boolean bit:encoding) {
			currentNode=tree.getChild(currentNode, bit); // true means left child
			if(currentNode==null) {
				return(null);
			}
		}
		if(!tree.isTerminal(currentNode)) {
			return(null);
		}
		return(currentNode.getName());	
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
			} else if (minWeight>e.getValue()) {
				minNode=e.getKey();
				minWeight=e.getValue();
			}
		}
		return(minNode);
	}

}
 