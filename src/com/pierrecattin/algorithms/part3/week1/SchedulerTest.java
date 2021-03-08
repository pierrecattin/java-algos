package com.pierrecattin.algorithms.part3.week1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.pierrecattin.algorithms.utilities.*;

public class SchedulerTest {
	public static void main(String[] args) {
		ArrayList<Job> jobs = InputReader.readJobs("res/jobs.txt");
		//System.out.println(jobs.get(1));
		System.out.println("Score with diff method="+GreedyScheduler.schedule(jobs, GreedyScheduler.Method.DIFF));
		System.out.println("Score with ratio method="+GreedyScheduler.schedule(jobs, GreedyScheduler.Method.RATIO));
		
	}
	
	@Test 
	void testGreedyScheduler() {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job(3,5));
		jobs.add(new Job(1,2));
		assertEquals(23, GreedyScheduler.schedule(jobs, GreedyScheduler.Method.DIFF));
		assertEquals(22, GreedyScheduler.schedule(jobs, GreedyScheduler.Method.RATIO));
	}
	
	
	
	
	
}
