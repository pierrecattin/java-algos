package com.pierrecattin.algorithms.part3.week2;

import java.util.HashMap;
import java.util.Set;

public class UnionFind<T> {
	
	private HashMap<T, T> parents;
	private HashMap<T, Integer> countPerGroup;
	
	public UnionFind(){
		parents = new HashMap<>();
		countPerGroup = new HashMap<>();
	}
	
	public UnionFind(Set<T> elements){
		parents = new HashMap<>();
		countPerGroup = new HashMap<>();		
		for(T e:elements) {
			add(e);
		}
	}
	
	public void add(T e) {
		parents.put(e, e);
		countPerGroup.put(e, 1);
	}
	
	public T find(T x) {
		T currentParent = parents.get(x);
		while(!currentParent.equals(parents.get(currentParent))) {
			currentParent = parents.get(currentParent);
		}
		return(currentParent);
	}
	
	public boolean sameGroup(T x, T y) {
		return(find(x).equals(find(y)));
	}
	
	public void union(T x, T y) {
		T groupX = find(x);
		T groupY = find(y);
		if(!groupX.equals(groupY)) {
			if(countPerGroup.get(groupX)>=countPerGroup.get(groupY)) {
				mergeGroups(groupY, groupX);
			} else {
				mergeGroups(groupX, groupY);
			}
		}
	}
	
	private void mergeGroups(T smallerGroup, T biggerGroup) {
		int sizeSmallerGroup=countPerGroup.get(smallerGroup);
		parents.put(smallerGroup, biggerGroup);
		countPerGroup.remove(smallerGroup);
		countPerGroup.put(biggerGroup, sizeSmallerGroup+countPerGroup.get(biggerGroup));
	}
	
	public String toString() {
		String out = "UnionFind with "+parents.size()+" items:\n";
		for(T x : parents.keySet()) {
			out = out + "\n" + x + ": "+find(x);
		}
		return(out);
	}
}
