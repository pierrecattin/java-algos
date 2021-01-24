package com.pierrecattin.algorithms.utilities;

public class Node {
	private String name;
	
	public Node(String name){
		this.name=name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return(name);
	}
	
	public String toString() {
		return(getName() );
	}
}
