package com.pierrecattin.algorithms.part2.week4;

import java.util.ArrayList;

public class HashTable<KeyType, ValueType> {
	private int nbBuckets;
	private ArrayList<ArrayList<KeyType>> keys;
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
	
	public void put(KeyType key, ValueType value) {
		int keyHash = hash(key);
		int posInBucket = positionInBucket(key);
		if(posInBucket==-1) {
			// key not yet in HashTable
			keys.get(keyHash).add(key);
			values.get(keyHash).add(value); 
		} else {
			// key already in HashTable -> replace
			values.get(keyHash).set(posInBucket, value); 
		}
	}
	
	public ValueType get(KeyType key) {
		int posInBucket =positionInBucket(key);
		if(posInBucket==-1) {
			return(null);
		} else {
			return(values.get(hash(key)).get(posInBucket));
		}
	}
		
	private int positionInBucket(KeyType key) {
		return(keys.get(hash(key)).indexOf(key));
	}
	
	public boolean containsKey(KeyType key) {
		return(positionInBucket(key)!=-1);
	}

	private int hash(KeyType key) {
		int keyNum = key.hashCode();
		return(Math.abs((17+31*keyNum)%nbBuckets));
	}

}
