package com.pierrecattin.algorithms.part3.week2;
import com.pierrecattin.algorithms.utilities.Node;

public class Edge {
	  private final Node source;
	  private final Node destination;
	  private final Integer distance;

	  public Edge(Node source, Node destination,Integer distance) {
	    this.source = source;
	    this.destination = destination;
	    this.distance=distance;
	  }
	  
	  public Node getSource() {
		  return(source);
	  }
	  public Node getDestination() {
		  return(destination);
	  }
	  public int getDistance() {
		  return(distance);
	  }
	  
	  public String toString() {
		  return(source.getName() + " -> "+ destination.getName() + " ("+distance+")");
	  }
}
