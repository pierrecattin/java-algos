package com.pierrecattin.algorithms.part3.week4;



public class KnapSackTest {

	public static void main(String[] args) {
		KnapSack smallSack=KnapSackReader.read("res/knapsack1.txt");
		System.out.println("Score of small instance: "+smallSack.solveIteratively());


		KnapSack largeSack=KnapSackReader.read("res/knapsack_big.txt");
		System.out.println("Score of large instance: "+
				largeSack.solveRecursively(largeSack.getNbItems()-1, largeSack.getCapacity()));
	}
}
