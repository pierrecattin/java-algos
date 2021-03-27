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

	public static ArrayList<Integer> readIntegerList(String path){
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
	
	public static ArrayList<String> readStringList(String path){
		ArrayList<String> inputList = new ArrayList<String>();	
		try {
			File inputFile = new File(path);
			Scanner myReader = new Scanner(inputFile).useDelimiter("\n");;
			while (myReader.hasNext()) {
				inputList.add(myReader.next());

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return(inputList);

	}
	
	
	public static ArrayList<Long> readLongList(String path){
		ArrayList<Long> inputList = new ArrayList<Long>();	
		try {
			File inputFile = new File(path);
			Scanner myReader = new Scanner(inputFile);
			while (myReader.hasNext()) {
				inputList.add(Long.parseLong(myReader.next()));

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return(inputList);

	}


	public static Graph readGraph(String path, boolean directed){
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

	public static GraphWithLength readGraphWithLength(String path, boolean directed){
		GraphWithLength graph = new GraphWithLength(directed);

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
					String destinationNodeName;
					String nextEntry = colReader.next();
					int IndexOfComma = nextEntry.indexOf(",");
					destinationNodeName = nextEntry.substring(0, IndexOfComma);
					int distance = Integer.parseInt(nextEntry.substring(IndexOfComma+1));		

					Node destinationNode;
					if(nodeNames.containsKey(destinationNodeName)) {
						destinationNode = nodeNames.get(destinationNodeName);
					} else {
						destinationNode = new Node(destinationNodeName);
						nodeNames.put(destinationNodeName, destinationNode);
					}
					if(directed || !graph.hasEdge(sourceNode, destinationNode)) {
						graph.addEdge(sourceNode, destinationNode, distance);
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
	
	public static ArrayList<Job> readJobs(String path){
		ArrayList<Job>  jobs = new ArrayList<>() ;	
		try {
			File inputFile = new File(path);
			Scanner myReader = new Scanner(inputFile);
			myReader.next();
			while (myReader.hasNextInt()) {
				jobs.add(new Job(myReader.nextInt(), myReader.nextInt()));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return(jobs);

	}

}