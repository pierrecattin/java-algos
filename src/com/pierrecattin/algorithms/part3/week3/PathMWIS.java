package com.pierrecattin.algorithms.part3.week3;

import java.util.ArrayList;

public class PathMWIS {
	public static ArrayList<Long> mwisScores(ArrayList<Long> nodes){
		ArrayList<Long> scores = new ArrayList<>();
		scores.add(Long.valueOf(0));
		scores.add(nodes.get(0));
		
		for(int maxNbNodes=2; maxNbNodes<=nodes.size(); maxNbNodes++) {
			long previousScore = scores.get(maxNbNodes-1);
			long scoreWithCurrentNode = scores.get(maxNbNodes-2) + nodes.get(maxNbNodes-1);
			if(previousScore>=scoreWithCurrentNode) {
				scores.add(previousScore);
			} else {
				scores.add(scoreWithCurrentNode);
			}
		}
		return(scores);
	}
	
	public static ArrayList<Integer> mwisReconstruction(ArrayList<Long> nodes, ArrayList<Long> scores){
		ArrayList<Integer> selectedNodes= new ArrayList<>();
		int i = nodes.size()-1; 
		while(i>=1) {
			if(scores.get(i)>=scores.get(i-1)+nodes.get(i)) {
				i--;
			} else {
				selectedNodes.add(i);
				i-=2;
			}
		}
		if(i==0) {
			selectedNodes.add(i);
		}
		
		return(selectedNodes);
	}
}
