package com.pierrecattin.algorithms.part4.week4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class TwoSatTest {
	public static void main(String[] args) {	
		// run with -Xss1024m
		String[] inputsFiles = {
				"2sat1.txt",
				"2sat2.txt",
				"2sat3.txt",
				"2sat4.txt",
				"2sat5.txt",
				"2sat6.txt"};
		
		Clause[] clauses;
		TwoSatSolver solver;
		for(String f:inputsFiles) {
			clauses=TwoSatInputReader.read("res/" + f);
			solver = new TwoSatSolver(clauses);
			System.out.println(f+": "+solver.solve());
		}
	}
	@Test
	void TestTwoSat() {	
		Clause[] clauses = {
				new Clause(1,-2),
				new Clause(-1,2),
				new Clause(-1,-2),
				new Clause(1,-3)
		};
		TwoSatSolver solver = new TwoSatSolver(clauses);
		assertEquals(true, solver.solve());
	}
}
