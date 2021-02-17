package com.pierrecattin.algorithms.part2.week3;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
	private ArrayList<Integer> array;
	private Type type;
	public static enum Type{
		MIN,
		MAX
	}
	
	public Heap(Type type) {
		array = new ArrayList<>();
		this.type = type;
	}
	
	public void insert(int x) {
		array.add(x);	
		int currentIndex = array.size()-1;
		int parent = positionParent(currentIndex);
		while(parent != -1 &&  compare(x,array.get(parent))) {
			Collections.swap(array, currentIndex, parent);
			currentIndex=parent;
			parent = positionParent(currentIndex);
		}
	}
	
	public int extractExtrema() {
		int extrema = getExtrema();
		Collections.swap(array, 0, array.size()-1);
		array.remove(array.size()-1);	
		
		int currentPos = 0;	
		while(violation(currentPos)) {
			int leftChildPos = positionLeftChild(currentPos);
			int rightChildPos = positionRightChild(currentPos);
			boolean swapWithLeft=true;
			if(leftChildPos==-1) {
				swapWithLeft = false;
			} else if (rightChildPos != -1 && compare(array.get(rightChildPos),array.get(leftChildPos))) {
				swapWithLeft = false;
			}
			
			if(swapWithLeft) {
				Collections.swap(array, currentPos, leftChildPos);
				currentPos = leftChildPos;
			} else {
				Collections.swap(array, currentPos, rightChildPos);
				currentPos = rightChildPos;
			}
		}
		
		return(extrema);
	}
	
	private boolean compare(int a, int b) {
		if(type==Type.MAX) {
			return(a>b);
		} else {
			return(a<b);
		}
	}
	
	private boolean violation(int position) {
		int leftChildPos = positionLeftChild(position);
		int rightChildPos = positionRightChild(position);
		
		boolean violationLeft = leftChildPos != -1 && compare(array.get(leftChildPos),array.get(position));
		boolean violationRight = rightChildPos != -1 && compare(array.get(rightChildPos),array.get(position));
		
		return(violationLeft || violationRight);
	}
	
	public int getExtrema() {
		return(array.get(0));
	}
	
	public String toString() {
		return(array.toString());
	}
	
	private int positionParent(int position) {
		int parent=-1;
		if(position>=1) {
			parent = (position-1)/2;
		}
		//System.out.println("positionParent: position="+position+" parent="+parent);
		return(parent);
	}
	
	private int positionLeftChild(int position) {
		int child=-1;
		if(2*position<=array.size()-1) {
			child = 2*position+1;
		}
		return(child);
	}
	
	private int positionRightChild(int position) {
		int child=-1;
		if(2*position+1<=array.size()-1) {
			child = 2*position+2;
		}
		return(child);
	}
}
