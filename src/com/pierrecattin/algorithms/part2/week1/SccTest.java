package com.pierrecattin.algorithms.part2.week1;

import java.util.Map;

import com.pierrecattin.algorithms.utilities.*;

public class SccTest {
	public static void main(String[] args) {		
		Graph graph = InputReader.readGraph("res/SCC_figure_8.16.txt", true);
		System.out.println(graph);
		System.out.println();
		
		System.out.println(Kosaraju.kosaraju(graph));
		
	}
}
