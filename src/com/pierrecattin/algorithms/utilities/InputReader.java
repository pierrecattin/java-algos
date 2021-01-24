/**
 * 
 */
package com.pierrecattin.algorithms.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author catti
 *
 */

public class InputReader {

	public ArrayList<Integer> readIntegerList(String path){
		ArrayList<Integer> inputList = new ArrayList<Integer>();	
		try {
			File inputFile = new File(path);
			Scanner myReader = new Scanner(inputFile);
			while (myReader.hasNextInt()) {
				inputList.add(myReader.nextInt());

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return(inputList);

	}
	
	public Graph readGraph(String path, boolean directed){
		Graph graph = new Graph(directed);
		try {
			File inputFile = new File(path);
			Scanner lineReader = new Scanner(inputFile);
			HashMap<String, Node> nodeNames = new HashMap<>();
			
			while (lineReader.hasNextLine()) {
				Scanner colReader = new Scanner(lineReader.nextLine());
				String sourceNodeName = colReader.next();
				Node sourceNode;
				if(nodeNames.containsKey(sourceNodeName)) {
					sourceNode = nodeNames.get(sourceNodeName);
				} else {
					sourceNode =  new Node(sourceNodeName);
					nodeNames.put(sourceNodeName, sourceNode);
				}
				
				
				while(colReader.hasNext()) {
					String destinationNodeName = colReader.next();
					Node destinationNode;
					if(nodeNames.containsKey(destinationNodeName)) {
						destinationNode = nodeNames.get(destinationNodeName);
					} else {
						destinationNode = new Node(destinationNodeName);
						nodeNames.put(destinationNodeName, destinationNode);
					}
					if(directed || !graph.hasEdge(sourceNode, destinationNode)) {
						graph.addEdge(sourceNode, destinationNode);
					}
				}
				colReader.close();
			}
			lineReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return(graph);
	}
}