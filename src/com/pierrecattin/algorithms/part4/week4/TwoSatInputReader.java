package com.pierrecattin.algorithms.part4.week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwoSatInputReader {
	public static Clause[] read(String path) {
		Clause[] clauses=null;
		try {
			File inputFile = new File(path);
			Scanner myReader = new Scanner(inputFile);
			clauses = new Clause[myReader.nextInt()];
			int count=0;
			while (myReader.hasNextInt()) {
				int var1 = myReader.nextInt(); 
				int var2 = myReader.nextInt(); 
				clauses[count] = new Clause(var1, var2);
				count++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return(clauses);
	}
}
