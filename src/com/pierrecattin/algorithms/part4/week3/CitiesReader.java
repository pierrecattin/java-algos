package com.pierrecattin.algorithms.part4.week3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CitiesReader {
	public static City[] read(String path) {
		City[] cities=null;
		try {
			File inputFile = new File(path);
			Scanner myReader = new Scanner(inputFile);
			cities = new City[myReader.nextInt()];
			int count=0;
			while (myReader.hasNextDouble()) {
				myReader.nextInt(); // city number
				cities[count] = new City(myReader.nextDouble(), myReader.nextDouble());
				count++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return(cities);
	}
}
