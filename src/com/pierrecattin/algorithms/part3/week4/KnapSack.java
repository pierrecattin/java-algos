package com.pierrecattin.algorithms.part3.week4;

import java.util.ArrayList;

public class KnapSack {
	private Integer capacity;
	private ArrayList<Long> values;
	private ArrayList<Long> sizes;
	private Integer nbItems;
	
	public KnapSack(int capacity, ArrayList<Long> values,ArrayList<Long> sizes) {
		assert(values.size()==sizes.size());
		this.nbItems=values.size();

		this.capacity=capacity;
		this.values=values;
		this.sizes=sizes;
	}
	
	
	
	
	
	public long solveForValue() {
		Scores scores = new Scores(capacity, nbItems);
		
		for(int lastItem=0; lastItem<nbItems; lastItem++) {
			for (int cap=1; cap<=capacity; cap++) {
				if(sizes.get(lastItem)>cap) {
					
				}
				
			}
		}
		
		return(scores.getScore(nbItems-1, capacity));
	}
	
	public String toString() {
		return(capacity+"\n"+values+"\n\n"+sizes);
	}
	
	private class Scores{
		private Long[] scores ;
		private Integer[] capacities;
		private Integer[] lastItems ;
		private Integer nbEntries;
		
		Scores(int capacity, int nbItems){
			nbEntries=(capacity+1)*(nbItems+1);
			
			capacities = new Integer[nbEntries];
			lastItems = new Integer[nbEntries];
			scores = new Long[nbEntries];
			
			// initialization and base cases
			int rowNum=0;
			for(int lastItem=-1; lastItem<nbItems; lastItem++) {
				for (int cap=0; cap<=capacity; cap++) {
					lastItems[rowNum] = lastItem;
					capacities[rowNum] = cap;
					if(lastItem== -1| cap==0) {
						scores[rowNum]=Long.valueOf(0); //base case
					} 
					rowNum++;
				}
			}
		}
		
		public void setSCore(int lastItem, int cap, long score) {
			int rowNum=getRowNum(lastItem, cap);
			if(rowNum!=-1) {
				scores[rowNum]=score;
			}
		}
		

		public Long getScore(int lastItem, int cap) {
			int rowNum=getRowNum(lastItem, cap);
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

		private int getRowNum(int lastItem, int cap) {
			for(int i=0;i<=nbEntries;i++) {
				if(lastItems[i] == lastItem && capacities[i] == cap) {
					return(i);
				}
			}
			return(-1);
		}
	}

}
