package com.pierrecattin.algorithms.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTree { 
	private HashMap<Node, Pair<Node, Node>> children; 
	private HashMap<Node, Node> parents; 
	private Node root;


	public BinaryTree() {
		children = new HashMap<>();
		parents = new HashMap<>();
	}


	public void addEdge(Node parent, Node child, boolean left) {
		// Create Nodes if they don't exist
		addNode(parent);
		addNode(child);

		Pair<Node, Node> curChildren = children.get(parent);
		if(curChildren == null) {
			curChildren = new Pair<Node, Node>();
		}
		if(left) {
			curChildren.setLeft(child);
		} else {
			curChildren.setRight(child);
		}

		children.put(parent, curChildren);
		parents.put(child, parent);

		if(parents.get(parent)==null) {
			root=parent;
		}
	}

	private void addNode(Node node) {
		if(!children.containsKey(node)) {
			children.put(node, null);
			parents.put(node, null);
		}
	}
	public boolean hasNode(Node node) {
		return(children.containsKey(node));
	}


	public int nbNodes() {
		return(children.size());
	}


	public Node getChild(Node node, boolean left){
		Pair<Node, Node> curChildren=children.get(node);
		if(curChildren==null) {
			return(null);
		}
		if(left) {
			return(curChildren.getLeft());
		} else {
			return(curChildren.getRight());
		}
	}

	public Node getParent(Node node){
		return(parents.get(node));
	}

	public Node getRoot(){
		return(root);
	}

	public boolean isLeftChild(Node n) {
		Node parent = parents.get(n);
		if(parent==null) {
			return(false);
		}

		if(getChild(parent, true).equals(n)) {
			return(true);
		} else {
			return(false);
		}
	}
	
	public boolean isTerminal(Node n) {
		return(getChild(n, true)==null & getChild(n, false)==null);
	}

	public ArrayList<Node> getNodes(){
		return(new ArrayList<Node>(children.keySet()));
	}


	public String toString() {
		String out ="";
		out += "BinaryTree with " + children.size() + " nodes";

		for(Node source : children.keySet()) {
			out += "\n";
			out += "Node "+source + " is parent of: ";
			if(children.get(source)!=null) {
				out += children.get(source);	
			}
		}
		return(out);
	}
}
