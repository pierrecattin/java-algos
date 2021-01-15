package com.pierrecattin.algorithms.part1.week3;

import java.util.ArrayList;
import java.util.Collections;

public class Partition {	
	public static int part(ArrayList<Integer> A, int l, int r) {
		int pivot = A.get(l);
		int i = l+1; // i will be the first element that is greater than pivot

		for(int j=l+1; j<=r; j++) { // j is first element that has not been processed
			if(A.get(j)<pivot) {
				Collections.swap(A, j, i); // put j in place of first element greater than pivot
				i = i+1; // because there's one more processed element smaller than pivot
			}
		}
		Collections.swap(A, l, i-1); // put pivot right before first element greater than pivot

		return(i-1); // return pivot position
	}

}
