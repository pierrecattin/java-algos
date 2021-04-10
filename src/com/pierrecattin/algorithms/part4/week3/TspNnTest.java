package com.pierrecattin.algorithms.part4.week3;

public class TspNnTest {

	public static void main(String[] args) {
		City[] cities = CitiesReader.read("res/nn.txt");
		TspNnSolver solver = new TspNnSolver(cities);
		System.out.println(solver.solve());
	}
}
