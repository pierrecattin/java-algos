package com.pierrecattin.algorithms.part2.week4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TwoSum {
	public static void main(String[] args) {

		
	}
	
	@Test
	void hashTableTest() {
		HashTable<String> table = new HashTable<>(10);
		table.put(1, "ONE");
		table.put(2, "TWO");
		table.put(11, "ELEVEN");
		assertEquals("ONE", table.get(1));
		assertEquals("TWO", table.get(2));
		assertEquals("ELEVEN", table.get(11));
		table.put(1, "ONE_replaced");
		assertEquals("ONE_replaced", table.get(1));
		assertEquals(null, table.get(3));
	}
}
