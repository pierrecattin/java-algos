/**
 * 
 */
package com.pierrecattin.algorithms.part1.week4;
import java.util.ArrayList;

import com.pierrecattin.algorithms.utilities.*;

public class Main {

	public static void main(String[] args) {
		InputReader reader = new InputReader();
		ArrayList<Integer> input = reader.readIntegerList("res\\problem6.5test2.txt");
		//System.out.println(input.toString());
		
		int res= RSelect.select(input, (int)(input.size()/2)-1, 0,input.size()-1);
		
		//QuickSort.sort(input, 0, input.size()-1);
		//System.out.println(input.toString());
		System.out.println(res);
		
	}

}
