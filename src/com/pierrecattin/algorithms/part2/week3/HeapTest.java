package com.pierrecattin.algorithms.part2.week3;

public class HeapTest {

	public static void main(String[] args) {
		Heap heap = new Heap();
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
		System.out.println(heap);
		
		System.out.println(heap.extractMin());
		System.out.println(heap);
		
	}

}
