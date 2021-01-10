package com.pierrecattin.algorithms.part1.week4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class QuickSort {
	public static void sort(ArrayList<Integer> A, int l, int r) {
		if(l<r) {
			int i = choosePivot(l, r);
			Collections.swap(A, l, i);
			int j = Partition.part(A, l, r);

			sort(A, l, j-1);
			sort(A, j+1, r);
		}
	}

	public static int choosePivot(int l, int r) {
		Random rand = new Random();
		return (l+rand.nextInt(r-l));	
	}
}
