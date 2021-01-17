package com.pierrecattin.algorithms.part1.week3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.InputReader;

class QuickSortTest {

	@Test
	void testFirst() {
		InputReader reader = new InputReader();
		ArrayList<Integer> input = reader.readIntegerList("res\\QuickSort.txt");
		
		IntegerObject comparisons = new IntegerObject();
		comparisons.value=0;
		QuickSort.sort(input, 0,input.size()-1, QuickSort.Method.FIRST, comparisons);
		assertEquals(comparisons.value, 162085);
	}
	

	@Test
	void testLast() {
		InputReader reader = new InputReader();
		ArrayList<Integer> input = reader.readIntegerList("res\\QuickSort.txt");
		
		IntegerObject comparisons = new IntegerObject();
		comparisons.value=0;
		QuickSort.sort(input, 0,input.size()-1, QuickSort.Method.LAST, comparisons);
		assertEquals(comparisons.value, 164123);
	}
	
	@Test
	void testMedianOfThree() {
		InputReader reader = new InputReader();
		ArrayList<Integer> input = reader.readIntegerList("res\\QuickSort.txt");
		
		IntegerObject comparisons = new IntegerObject();
		comparisons.value=0;
		QuickSort.sort(input, 0,input.size()-1, QuickSort.Method.MEDIANOFTHREE, comparisons);
		assertEquals(comparisons.value, 138382);
	}


}
