/**
 * 
 */
package com.pierrecattin.algorithms.part1.week3;
import java.util.ArrayList;

import com.pierrecattin.algorithms.utilities.*;

public class Main {

	public static void main(String[] args) {
		InputReader reader = new InputReader();
		ArrayList<Integer> input = reader.readIntegerList("res\\QuickSort.txt");
		
		IntegerObject comparisons = new IntegerObject();
		ArrayList<Integer> unsortedInput = new ArrayList<Integer>();
		for(QuickSort.Method method : QuickSort.Method.values()) {
			System.out.println(method);
			unsortedInput=(ArrayList<Integer>)input.clone();
			comparisons.value=0;
			//System.out.println(unsortedInput);
			QuickSort.sort(unsortedInput, 0,input.size()-1, method, comparisons);
			//System.out.println(unsortedInput);
			System.out.println(comparisons);
		}

		
	}

}
