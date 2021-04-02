package com.pierrecattin.algorithms.part3.week4;

import java.util.ArrayList;

public class KnapSack {
	private Integer size;
	private ArrayList<Long> values;
	private ArrayList<Long> weights;
	private Integer nbItems;
	
	public KnapSack(int size, ArrayList<Long> values,ArrayList<Long> weights) {
		assert(values.size()==weights.size());
		this.nbItems=values.size();

		this.size=size;
		this.values=values;
		this.weights=weights;
	}
	
	
	
	
	
	public long solveForValue() {
		Scores scores = new Scores(size, nbItems);
		
		return(scores.getScore(nbItems-1, size));
	}
	
	public String toString() {
		return(size+"\n"+values+"\n\n"+weights);
	}
	
	private class Scores{
		private Long[] scores ;
		private Integer[] capacities;
		private Integer[] lastItems ;
		private Integer nbEntries;
		
		Scores(int size, int nbItems){
			nbEntries=(size+1)*(nbItems+1);
			
			capacities = new Integer[nbEntries];
			lastItems = new Integer[nbEntries];
			scores = new Long[nbEntries];
			
			// initialization and base cases
			int rowNum=0;
			for(int lastItem=-1; lastItem<nbItems; lastItem++) {
				for (int cap=0; cap<=size; cap++) {
					lastItems[rowNum] = lastItem;
					capacities[rowNum] = cap;
					if(lastItem== -1| cap==0) {
						scores[rowNum]=Long.valueOf(0); //base case
					} 
					rowNum++;
				}
			}
		}
		
		public void setSCore(int lastItem, int capacity, long score) {
			int rowNum=getRowNum(lastItem, capacity);
			if(rowNum!=-1) {
				scores[rowNum]=score;
			}
		}
		

		public Long getScore(int lastItem, int capacity) {
			int rowNum=getRowNum(lastItem, capacity);
			if(rowNum==-1) {
				return(Long.valueOf(-1)); 
			} else {
				if(scores[rowNum]==null) {
					return(Long.valueOf(-1)); 
				} else {
					return(scores[rowNum]);
				}
			}
		}

		private int getRowNum(int lastItem, int capacity) {
			for(int i=0;i<=nbEntries;i++) {
				if(lastItems[i] == lastItem && capacities[i] == capacity) {
					return(i);
				}
			}
			return(-1);
		}
	}

}
