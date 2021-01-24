package com.pierrecattin.algorithms.part1.week4;

import com.pierrecattin.algorithms.utilities.Graph;
import com.pierrecattin.algorithms.utilities.InputReader;

public class minCutTest {
	public static void main(String[] args) {
		InputReader reader = new InputReader();
		Graph graph = reader.readGraph("res/kargerMinCut.txt", false);
		System.out.println(graph);
	}
}
