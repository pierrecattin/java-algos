package com.pierrecattin.algorithms.part3.week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class KnapSackReader {
	public static KnapSack read(String path) {
		Integer size=null;
		ArrayList<Integer> values=new ArrayList<>();
		ArrayList<Integer> weights=new ArrayList<>();
		try {
			File inputFile = new File(path);
			Scanner myReader = new Scanner(inputFile);
			size=myReader.nextInt();
			myReader.nextLong();
			while (myReader.hasNextInt()) {
				values.add(myReader.nextInt());
				weights.add(myReader.nextInt());
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return(new KnapSack(size, values, weights));
	}
}
