package com.pierrecattin.algorithms.part3.week4;

import java.util.ArrayList;

public class KnapSack {
	private Long size;
	private ArrayList<Long> values;
	private ArrayList<Long> weights;
	
	public KnapSack(Long size, ArrayList<Long> values,ArrayList<Long> weights) {
		this.size=size;
		this.values=values;
		this.weights=weights;
	}
	public String toString() {
		return(size+"\n"+values+"\n\n"+weights);
	}
}
