package com.pierrecattin.algorithms.part4.week3;

import java.util.ArrayList;

public class TspNnSolver {
	private City[] cities;
	private double tourDistance;	
	ArrayList<Integer> visitedCities;
	
	TspNnSolver (City[] cities){
		this.cities=cities;
		tourDistance=0;
		visitedCities=new ArrayList<>(0);	
	}
	
	public double solve() {
		visitedCities.add(0);
		while(visitedCities.size()<cities.length) {
			System.out.println(100*visitedCities.size()/cities.length+"%");
			visitClosest();
		}
		City firstCity = cities[visitedCities.get(0)];
		City lastCity = cities[visitedCities.get(visitedCities.size()-1)];
		tourDistance += lastCity.distanceFrom(firstCity);
		return(tourDistance);
	}
	
	
	private void visitClosest() {
		City currentCity = cities[visitedCities.get(visitedCities.size()-1)];
		int closestIndex = -1;
		double closestDist=Double.MAX_VALUE;
		for (int i=0; i<cities.length; i++) {
			if(!visitedCities.contains(i)) {
				double currentDist = currentCity.distanceFrom(cities[i]);
				if(currentDist<closestDist) {
					closestIndex=i;
					closestDist=currentDist;
				}
			}
		}
		visitedCities.add(closestIndex);
		tourDistance+=closestDist;
	}
	
	public ArrayList<Integer> getTour(){
		return(visitedCities);
	}
	
	public double getTourDistance() {
		return(tourDistance);
	}

}
