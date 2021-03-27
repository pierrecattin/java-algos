package com.pierrecattin.algorithms.part3.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;

import com.pierrecattin.algorithms.utilities.GraphWithLength;
import com.pierrecattin.algorithms.utilities.Node;

public class BigClustering {
	public static GraphWithLength createGraph(ArrayList<String> nodes) {
		GraphWithLength graph = new GraphWithLength(false);
		
		HashSet<String> uniqueNodes =  new HashSet<>(nodes);
		HashMap<String, Node> nodeNameMapping = new HashMap<>();
		for(String nodeName:uniqueNodes) {
			Node node = new Node(nodeName);
			nodeNameMapping.put(nodeName, node);
			graph.addNode(node);
		}
		System.out.println("Nodes entered: " + nodeNameMapping.size());
		
		for(Entry<String, Node> sourceNode:nodeNameMapping.entrySet()) {
			HashMap<String, Integer> closeNodes = getCloseNodes(sourceNode.getKey());
			for(Entry<String, Integer> destinationNode : closeNodes.entrySet()) {
				if(uniqueNodes.contains(destinationNode.getKey())) {
					graph.addEdge(sourceNode.getValue(), nodeNameMapping.get(destinationNode.getKey()), destinationNode.getValue());
				}
			}	
		}
		System.out.println("Graph Created");
		return(graph);
	}
	
	private static HashMap<String, Integer> getCloseNodes(String node){
		ArrayList<Integer> bits = new ArrayList<>();
		Scanner bitsReader = new Scanner(node);
		while(bitsReader.hasNextInt()) {
			bits.add(bitsReader.nextInt());
		}
		bitsReader.close();
		
		HashMap<String, Integer> closeNodes = new HashMap<>();
		for (int bitChange1=0; bitChange1<bits.size(); bitChange1++) {
			for(int bitChange2=0; bitChange2<bits.size(); bitChange2++) {
				String closeNode = "";
				for(int i=0; i<bits.size();i++) {
					int bitValue = 0;
					if(i==bitChange1 | i==bitChange2) {
						bitValue=1-bits.get(i);
					} else {
						bitValue=bits.get(i);
					}
					closeNode += (bitValue+" ");
				}
				
				int distance = 2;
				if(bitChange1==bitChange2) {
					distance=1;
				}
				closeNodes.put(closeNode, distance);
				
			}
		}

		return(closeNodes);
	}

}
