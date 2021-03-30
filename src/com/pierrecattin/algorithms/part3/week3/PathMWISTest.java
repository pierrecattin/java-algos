package com.pierrecattin.algorithms.part3.week3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.InputReader;

public class PathMWISTest {

	public static void main(String[] args) {
		ArrayList<Long> nodes =InputReader.readLongList("res/mwis.txt");
		ArrayList<Long> scores = PathMWIS.mwisScores(nodes);
		ArrayList<Integer> selectedNodes = PathMWIS.mwisReconstruction(nodes,scores);
		
		Integer[] testNodes = {1, 2, 3, 4, 17, 117, 517, 997};
		String solution="";
		for(int n:testNodes ) {
			if(selectedNodes.contains(n-1)) {
				solution +="1";
			} else {
				solution +="0";
			}
		}
		System.out.println(solution);
		System.out.println(selectedNodes);
	}
	

	@Test
	void mwisTest() {
		long[] input = {3,2,1,6,4,5};
		ArrayList<Long> nodes = new ArrayList<>();
		for(long n:input) {
			nodes.add(n);
		}
		
		ArrayList<Long> scores = PathMWIS.mwisScores(nodes);
		ArrayList<Integer> selectedNodes = PathMWIS.mwisReconstruction(nodes,scores);
		/*System.out.println(nodes);
		System.out.println(scores);
		System.out.println(selectedNodes);*/
		
		assertEquals(5, selectedNodes.get(0));
		assertEquals(3, selectedNodes.get(1));
		assertEquals(0, selectedNodes.get(2));
	}

}
