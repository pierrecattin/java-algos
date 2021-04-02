package com.pierrecattin.algorithms.part3.week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class KnapSackReader {
	public static KnapSack read(String path) {
		Integer size=null;
		ArrayList<Long> values=new ArrayList<>();
		ArrayList<Long> weights=new ArrayList<>();
		try {
			File inputFile = new File(path);
			Scanner myReader = new Scanner(inputFile);
			size=myReader.nextInt();
			myReader.nextLong();
			while (myReader.hasNextLong()) {
				values.add(myReader.nextLong());
				weights.add(myReader.nextLong());
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return(new KnapSack(size, values, weights));
	}
}
