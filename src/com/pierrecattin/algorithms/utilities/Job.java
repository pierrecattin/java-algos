package com.pierrecattin.algorithms.utilities;

public class Job {
	private int weight;
	private int length;
	
	public Job(int weight, int length){
		this.weight=weight;
		this.length=length;
	}
	
	public int getWeight() {
		return(weight);
	}	
	public int getLength() {
		return(length);
	}	
	
	public String toString() {
		return("weight="+weight+"; length="+length);
	}
}
