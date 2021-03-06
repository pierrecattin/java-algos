package com.pierrecattin.algorithms.part3.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;

import com.pierrecattin.algorithms.utilities.GraphWithLength;
import com.pierrecattin.algorithms.utilities.Node;

public class Kruskal {
	public static UnionFind<Node> singeLinkClustering(GraphWithLength graph, int nbClusters) {
		UnionFind<Node> clusters = new UnionFind<>();
		for(Node n:graph.getNodes()) {
			clusters.add(n);
		}
		
		ArrayList<Edge> edges = new ArrayList<>();
		for (Node source : graph.getNodes()) {
			if( graph.getEdgesFrom(source)!=null) {
				for (Entry<Node, Integer> destinationDistance : graph.getEdgesFrom(source).entrySet()) {
					Edge e = new Edge(source, destinationDistance.getKey(), destinationDistance.getValue());
					edges.add(e);
				}
			}
		}
				
		Collections.sort(edges, 
                (e1, e2) -> e1.getDistance() - e2.getDistance());
		System.out.println("Edges created");
		//System.out.println(edges);
		
		
		for (Edge e:edges) {
			if(!clusters.sameGroup(e.getSource(), e.getDestination())) {
				clusters.union(e.getSource(), e.getDestination());
				if(clusters.nbGroups()<=nbClusters) {
					break;
				}
				
			}
		}
		System.out.println("Clusters defined");
		int maxDistance=Integer.MAX_VALUE;
		for (Edge e:edges) {
			if(!clusters.sameGroup(e.getSource(), e.getDestination())) {
				if(e.getDistance()<maxDistance) {
					maxDistance=e.getDistance();
				}
			}
		}
		System.out.println("Min distance between two nodes of different clusters: "+maxDistance);
		
		return(clusters);
	}




}
