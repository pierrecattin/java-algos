package com.pierrecattin.algorithms.part3.week4;

import java.util.ArrayList;
import java.util.HashMap;

public class KnapSack {
	private Integer capacity;
	private ArrayList<Integer> values;
	private ArrayList<Integer> sizes;
	private Integer nbItems;
	
	public KnapSack(int capacity, ArrayList<Integer> values,ArrayList<Integer> sizes) {
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
				long best;
				if(sizes.get(lastItem)>cap) {
					// if current item is larger than capacity
					best=scores.getScore(lastItem-1, cap);
				} else {
					best = Math.max(
							scores.getScore(lastItem-1, cap),
							scores.getScore(lastItem-1, cap-sizes.get(lastItem))+Long.valueOf(values.get(lastItem))
							);	
				}
				scores.setSCore(lastItem, cap, best);
			}
		}
		
		return(scores.getScore(nbItems-1, capacity));
	}
	
	public String toString() {
		return(capacity+"\n"+values+"\n\n"+sizes);
	}
	
	private class Scores{
		private HashMap<Integer, HashMap<Integer, Long>> scoresMap;
		Scores(int capacity, int nbItems){	
			scoresMap = new HashMap<>();
			
			// initialization and base cases
			for(int lastItem=-1; lastItem<nbItems; lastItem++) {
				scoresMap.put(lastItem, new HashMap<>());
				scoresMap.get(lastItem).put(0, Long.valueOf(0)); //base case
			}
			
			for(int cap=0; cap<=capacity; cap++) {
				scoresMap.get(-1).put(cap, Long.valueOf(0)); //base case
			}
		}
		
		public void setSCore(int lastItem, int cap, long score) {			
			scoresMap.get(lastItem).put(cap, score);
		}
		

		public Long getScore(int lastItem, int cap) {
			if(!scoresMap.containsKey(lastItem)) {
				return(Long.valueOf(-1)); 
			}
			
			if(!scoresMap.get(lastItem).containsKey(cap)) {
				return(Long.valueOf(-1)); 
			}

			return(scoresMap.get(lastItem).get(cap));
		}
	}

}
