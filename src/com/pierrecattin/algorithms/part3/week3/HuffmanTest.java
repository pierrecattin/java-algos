package com.pierrecattin.algorithms.part3.week3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.InputReader;

public class HuffmanTest {

	public static void main(String[] args) {
		ArrayList<Integer> symbolWeights = InputReader.readIntegerList("res/huffman.txt");
		HashMap<String, Integer> symbols= new HashMap<>();
		for(int i=0; i<symbolWeights.size(); i++) {
			symbols.put(String.valueOf(i), symbolWeights.get(i));
		}
		HuffmanEncoder encoder=new HuffmanEncoder(symbols);
		int maxLength=Integer.MIN_VALUE;
		int minLength = Integer.MAX_VALUE;
		for(String s:symbols.keySet()) {
			ArrayList<Boolean> encoding = encoder.encode(s);
			int l = encoding.size();
			if(l>maxLength) {
				maxLength=l;
			}
			if(l<minLength) {
				minLength=l;
			}
		}
		
		System.out.println("Max length="+maxLength);
		System.out.println("Min length="+minLength);
	}
	
	@Test
	void huffmanTest() {
		HashMap<String, Integer> symbols= new HashMap<>();
		symbols.put("a", 10);
		symbols.put("b", 20);
		symbols.put("c", 3);
		symbols.put("d", 40);
		symbols.put("e", 10);
		HuffmanEncoder encoder = new HuffmanEncoder(symbols);
		//System.out.println(encoder.getTree());
		//ArrayList<Boolean> encoding = encoder.encode("b");
		//System.out.println(encoding);
		//System.out.println(encoder.decode(encoding));
		for(String s:symbols.keySet()) {
			assertEquals(s,encoder.decode(encoder.encode(s)));
		}
		
	}

}
