package com.pierrecattin.algorithms.part2.week2;

import com.pierrecattin.algorithms.utilities.*;

public class DijkstraTest {

	public static void main(String[] args) {
		GraphWithLength graph = InputReader.readGraphWithLength("res/dijkstraData.txt", true);	
		System.out.print(graph);
	}

}
