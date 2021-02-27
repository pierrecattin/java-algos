package com.pierrecattin.algorithms.part2.week4;

import java.util.ArrayList;

public class HashTable<ValueType> {
	private int nbBuckets;
	private ArrayList<ArrayList<Integer>> keys;
	private ArrayList<ArrayList<ValueType>> values;
	
	public 
	HashTable(int nbBuckets){
		this.nbBuckets = nbBuckets;
		keys=new ArrayList<>();
		values=new ArrayList<>();
		for(int i=0;i<nbBuckets; i++) {
			values.add(new ArrayList<>());
			keys.add(new ArrayList<>());
		}
	}
	
	public void put(int key, ValueType value) {
		int keyHash = hash(key);
		int posInBucket=keys.get(keyHash).indexOf(key);
		if(posInBucket==-1) {
			// key not yet in HashTable
			keys.get(keyHash).add(key);
			values.get(keyHash).add(value); 
		} else {
			// key already in HashTable -> replace
			values.get(keyHash).set(posInBucket, value); 
		}
	}
	
	public ValueType get(int key) {
		int keyHash = hash(key);
		int posInBucket=keys.get(keyHash).indexOf(key);
		if(posInBucket==-1) {
			return(null);
		} else {
			return(values.get(keyHash).get(posInBucket));
		}
	}

	private int hash(int key) {
		return((17+31*key)%nbBuckets);
	}
}
