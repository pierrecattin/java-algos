package com.pierrecattin.algorithms.part2.week3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.InputReader;

public class HeapTest {
	
	@Test
	void testHeap() {
		Heap heap = new Heap(Heap.Type.MIN);
		heap.insert(4);
		heap.insert(4);
		heap.insert(8);
		heap.insert(9);
		heap.insert(4);
		heap.insert(12);
		heap.insert(9);
		heap.insert(11);
		heap.insert(13);
		heap.insert(7);
		heap.insert(10);
		//System.out.println(heap);
		heap.insert(5);
		//System.out.println(heap);
		
		System.out.println(heap.extractExtrema());
		//System.out.println(heap);
		
		Integer[] expectedArray = {4, 4, 5, 9, 7, 8, 9, 11, 13, 12, 10};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(expectedArray)); 
		assertEquals(expected, heap.getArray());
	}

	
	@Test
	void testMedianMaintenance() {
		ArrayList<Integer> input = InputReader.readIntegerList("res/Median.txt");
		int mediansSum=medianMaintenance(input);
		assertEquals(1213, mediansSum%10000);
		System.out.println(mediansSum%10000);
		

	}
	
	private static int medianMaintenance(ArrayList<Integer> input) {
		int mediansSum=0;
		
		
		Heap leftHeap = new Heap(Heap.Type.MAX);
		Heap rightHeap = new Heap(Heap.Type.MIN);
		
		System.out.println("x0="+input.get(0));
		System.out.println("x1="+input.get(1));
		
		if(input.get(0)<input.get(1)) {
			leftHeap.insert(input.get(0));
			rightHeap.insert(input.get(1));
			mediansSum += input.get(0) + input.get(0);
		} else {
			leftHeap.insert(input.get(1));
			rightHeap.insert(input.get(0));
			mediansSum += input.get(0) + input.get(1);
		}
		System.out.println("mediansSum1="+mediansSum);
		
		for(int i=2; i<input.size(); i++) {
			int x = input.get(i);
			int maxLeft = leftHeap.getExtrema();
			int minRight = rightHeap.getExtrema();
			
			if(x<maxLeft) {
				leftHeap.insert(x);
			} else if(x>minRight) {
				rightHeap.insert(x);
			} else if (leftHeap.size() <= rightHeap.size()){
				leftHeap.insert(x);
			} else {
				rightHeap.insert(x);
			}
			
			if(rightHeap.size()>leftHeap.size()+1) {
				leftHeap.insert(rightHeap.extractExtrema());
			} else if(leftHeap.size()>rightHeap.size()+1) {
				rightHeap.insert(leftHeap.extractExtrema());
			}
			
			int median;
			if(rightHeap.size()>leftHeap.size()) {
				median=rightHeap.getExtrema();
			} else {
				median=leftHeap.getExtrema();
			}
			mediansSum += median;
			
		}
		return(mediansSum);
	}

}
