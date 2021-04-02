package com.pierrecattin.algorithms.part3.week4;



public class KnapSackTest {

	public static void main(String[] args) {
		KnapSack sack=KnapSackReader.read("res/knapsack1.txt");
		System.out.println(sack);
		
		System.out.println(sack.solveForValue());
	}

}
