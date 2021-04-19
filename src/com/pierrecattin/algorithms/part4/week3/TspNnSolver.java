package com.pierrecattin.algorithms.part4.week3;

import java.util.ArrayList;
import java.util.HashSet;

public class TspNnSolver {
	private City[] cities;
	private double tourDistance;	
	ArrayList<Integer> tour;
	HashSet<Integer> unvisitedCities;
	
	TspNnSolver (City[] cities){
		this.cities=cities;
		tourDistance=0;
		tour=new ArrayList<>(0);	
		unvisitedCities = new HashSet<>();
		for(int i=0; i<cities.length; i++) {
			unvisitedCities.add(i);
		}
	}
	
	public double solve() {
		tour.add(0);
		unvisitedCities.remove(0);
		while(unvisitedCities.size()>0) {
			System.out.println(100*tour.size()/cities.length+"%");
			visitClosest();
		}
		City firstCity = cities[tour.get(0)];
		City lastCity = cities[tour.get(tour.size()-1)];
		tourDistance += lastCity.distanceFrom(firstCity);
		return(tourDistance);
	}
	
	
	private void visitClosest() {
		City currentCity = cities[tour.get(tour.size()-1)];
		int closestIndex = -1;
		double closestDist=Double.MAX_VALUE;
		for(int cityIndex:unvisitedCities) {
			double currentDist = currentCity.distanceFrom(cities[cityIndex]);
			if(currentDist<closestDist) {
				closestIndex=cityIndex;
				closestDist=currentDist;
			}
		}
		unvisitedCities.remove(closestIndex);
		tour.add(closestIndex);
		tourDistance+=closestDist;
	}
	
	public ArrayList<Integer> getTour(){
		return(tour);
	}
	
	public double getTourDistance() {
		return(tourDistance);
	}

}
