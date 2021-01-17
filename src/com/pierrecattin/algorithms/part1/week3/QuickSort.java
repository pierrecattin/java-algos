package com.pierrecattin.algorithms.part1.week3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import com.pierrecattin.algorithms.part1.week4.RSelect;


public class QuickSort {
	public enum Method{
		FIRST,
		LAST,
		MEDIANOFTHREE,
		RANDOM
	}

	private static final Arrays mArray = null;
		
	public static void sort(ArrayList<Integer> A, int l, int r, Method method, IntegerObject comparisons) {
		if(l<r) {
			int i = choosePivot(A, l, r, method);
			Collections.swap(A, l, i);
			int j = Partition.part(A, l, r);

			comparisons.value = comparisons.value + j-l;
			sort(A, l, j-1, method, comparisons);
			
			comparisons.value = comparisons.value + r-j;
			sort(A, j+1, r, method, comparisons);
		}
		//System.out.println(comparisons);
		//return(comparisons);
	}
	
	
	public static int choosePivot(ArrayList<Integer> A, int l, int r, Method method) {
		if(method==Method.FIRST) {
			return(l);
		} else if(method==Method.LAST) {
			return(r);
		} else if(method==Method.MEDIANOFTHREE) {
			//System.out.println(A);
			//System.out.println("l="+l+"   ; r="+r + "    ;l+((r-l)/2)="+ (l+((r-l)/2)));
		
			ArrayList<Integer> three=new ArrayList<Integer>();
			three.add(A.get(l));
			three.add(A.get(r));
			three.add(A.get(l+((r-l)/2)));
				
			int med = RSelect.select(three, 1, 0,2); 
			//System.out.println("median="+med);
			//System.out.println("index="+A.indexOf(med));
			return(A.indexOf(med));
		} else if(method==Method.RANDOM) {
			Random rand = new Random();
			return (l+rand.nextInt(r-l));	
		}
		return(l);
	}

}
