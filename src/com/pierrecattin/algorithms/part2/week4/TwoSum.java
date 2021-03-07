package com.pierrecattin.algorithms.part2.week4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.InputReader;

public class TwoSum {
	public static void main(String[] args) {
		ArrayList<Long> input =  InputReader.readLongList("res/algo1-programming_prob-2sum.txt");
		HashTable<Long, Integer> table = makeTable(input);
		int count =0;
		for (int i=-10000; i<=10000;i++) {
			if(hasTwoSum(input, table, i)) {
				count++;
			}
		}
		System.out.println("Number of targets with TwoSums in input: "+count);
	}
	
	@Test
	public void twoSumTest() {
		ArrayList<Long> numbers =  new ArrayList<>() ;
		numbers.add((long)1);
		numbers.add((long)2);
		numbers.add((long)4);
		HashTable<Long, Integer> table = makeTable(numbers);
		assertEquals(true, hasTwoSum(numbers, table, 3));
		assertEquals(false, hasTwoSum(numbers, table, 4));
	}
	
	@Test
	public void hashTableTest() {
		HashTable<Integer, String> table = new HashTable<>(10);
		table.put(1, "ONE");
		table.put(2, "TWO");
		table.put(11, "ELEVEN");
		assertEquals("ONE", table.get(1));
		assertEquals("TWO", table.get(2));
		assertEquals("ELEVEN", table.get(11));
		table.put(1, "ONE_replaced");
		assertEquals("ONE_replaced", table.get(1));
		assertEquals(null, table.get(3));
		assertEquals(true, table.containsKey(2));
		assertEquals(false, table.containsKey(3));
	}
		
	public static boolean hasTwoSum(ArrayList<Long> numbers, HashTable<Long, Integer> table, int target) {
		for(int i=0; i<numbers.size(); i++) {
			Long firstInt = numbers.get(i);
			if(table.containsKey(target-firstInt)) {
				if(target != 2*firstInt ) {
					return(true);
				}
			}
		}
		return(false);
	}
	private static HashTable<Long, Integer> makeTable(ArrayList<Long> input) {
		HashTable<Long, Integer> table = new HashTable<>((int)input.size());
		for(long key:input) {
			table.put(key, null);
		}
		return(table);
	}
}
