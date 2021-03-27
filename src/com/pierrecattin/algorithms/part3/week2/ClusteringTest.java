package com.pierrecattin.algorithms.part3.week2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.*;

public class ClusteringTest {

	public static void main(String[] args) {
		GraphWithLength graph = InputReader.readGraphWithLength("res/clustering1.txt", false);
		Kruskal.singeLinkClustering(graph,4);
		
		ArrayList<String> input = InputReader.readStringList("res/clustering_big.txt");
		System.out.println("Input read");
		GraphWithLength bigGraph= BigClustering.createGraph(input);
		//System.out.println(bigGraph);
		
		UnionFind<Node> cluster = Kruskal.singeLinkClustering(bigGraph, 1);
		System.out.println("Nb clusters: "+ cluster.nbGroups());
	}
	
	@Test
	void testUnionFind() {
		UnionFind<Integer> uf = new UnionFind<>();
		for(int i=0; i<7; i++) {
			uf.add(i);
		}
		
		assertEquals(false,uf.sameGroup(1, 5));
		uf.union(1, 5);
		assertEquals(true,uf.sameGroup(1, 5));
		uf.union(0, 2);
		uf.union(3, 2);
		uf.union(3, 5);
		assertEquals(0,uf.find(0));
		assertEquals(0,uf.find(1));
		assertEquals(0,uf.find(2));
		assertEquals(0,uf.find(3));
		assertEquals(4,uf.find(4));
		assertEquals(0,uf.find(5));
		assertEquals(6,uf.find(6));
	}

}
