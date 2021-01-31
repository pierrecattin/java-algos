package com.pierrecattin.algorithms.part2.week1;

import com.pierrecattin.algorithms.utilities.Graph;
import com.pierrecattin.algorithms.utilities.InputReader;

public class SccTest {
	public static void main(String[] args) {		
		Graph graph = InputReader.readGraph("res/SCC_figure_8.16.txt", true);
		System.out.println(graph);
	}
}
