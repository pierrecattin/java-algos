package com.pierrecattin.algorithms.part4.week3;

public class City {
	private double xCoordinate;
	private double yCoordinate;
	public City (double xCoordinate, double yCoordinate) {
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
	}
	
	public double getXCoordinate() {
		return(xCoordinate);
	}
	
	public double getYCoordinate() {
		return(yCoordinate);
	}
	
	public double distanceFrom(City otherCity) {
		double dist = Math.sqrt(
				Math.pow(xCoordinate-otherCity.getXCoordinate(), 2) + 
				Math.pow(yCoordinate-otherCity.getYCoordinate(), 2)
				);
		return(dist);
	}
	
	public String toString() {
		return(xCoordinate+"; "+yCoordinate);
	}

}
