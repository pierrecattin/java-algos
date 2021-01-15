package com.pierrecattin.algorithms.part1.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.pierrecattin.algorithms.part1.week3.Partition;

public class RSelect {

	public static int select(ArrayList<Integer> A, int order, int l, int r) {
		int res=-1;
		if(l==r) {
			res=A.get(l);
		} else {
			Random rand = new Random();
			int p = l+rand.nextInt(r-l);
			Collections.swap(A, l, p);
			int j = Partition.part(A, l, r);

			if(j==order) {
				res=A.get(j);
			} else if(j>order) {
				res=select(A,order,l,j-1);
			} else if(j<order) {
				res=select(A,order,j+1,r);
			}
		}
		return(res);
	}
}
