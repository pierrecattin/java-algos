package com.pierrecattin.algorithms.part1.week4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.InputReader;

class RSelectTest {

	@Test
	void testSelect() {

		InputReader reader = new InputReader();
		ArrayList<Integer> input = reader.readIntegerList("res\\problem6.5test2.txt");
		//System.out.println(input.toString());

		int res= RSelect.select(input, (int)(input.size()/2)-1, 0,input.size()-1);
		assertEquals(res, 4715);
	}

}
