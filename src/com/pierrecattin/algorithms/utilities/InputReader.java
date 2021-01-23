/**
 * 
 */
package com.pierrecattin.algorithms.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
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
	
	public Graph graphReader(String path){
		Graph graph = new Graph(false);
		try {
			File inputFile = new File(path);
			Scanner myReader = new Scanner(inputFile);
			while (myReader.hasNextLine()) {
				graph.addNodes(0);

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return(graph);
	}
}