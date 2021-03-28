package com.pierrecattin.algorithms.part3.week3;

import java.util.ArrayList;
import java.util.HashMap;
import com.pierrecattin.algorithms.utilities.InputReader;

public class HuffmanTest {

	public static void main(String[] args) {
		ArrayList<Integer> symbolWeights = InputReader.readIntegerList("res/huffman.txt");
		HashMap<String, Integer> symbols= new HashMap<>();
		for(int i=0; i<symbolWeights.size(); i++) {
			symbols.put(String.valueOf(i), symbolWeights.get(i));
		}
		
		
		HuffmanEncoding encoding=new HuffmanEncoding(symbols);
		System.out.println(encoding.getTree());
		

	}

}
