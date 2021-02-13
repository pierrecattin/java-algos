package com.pierrecattin.algorithms.part2.week2;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.*;

public class DijkstraTest {

	@Test
	void testDijkstra() {
		GraphWithLength graph = InputReader.readGraphWithLength("res/dijkstraData.txt", true);	
		//System.out.print(graph);
		HashMap<String, Node> nodesByName = new HashMap<>();
		for (Node n : graph.getNodes()) {
			nodesByName.put(n.getName(), n);
		}

		HashMap<Node, Integer> shortestPaths = Dijkstra.shortestPath(graph, nodesByName.get("1"));

		String[] destinationNames = {"7","37","59","82","99","115","133","165","188","197"};

		String solFilePath = "out/dijkstra_solution.txt";
		File resFile = new File(solFilePath);
		try {
			FileWriter myWriter = new FileWriter(solFilePath);
			for(String dest : destinationNames) {
				myWriter.write(shortestPaths.get(nodesByName.get(dest))+",");
			}
			myWriter.close();
		}catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
		assertEquals(shortestPaths.get(nodesByName.get("37")), 2610);
	}
	
	
	
}
