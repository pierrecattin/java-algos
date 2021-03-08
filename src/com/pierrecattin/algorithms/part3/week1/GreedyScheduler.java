package com.pierrecattin.algorithms.part3.week1;

import java.util.ArrayList;

import com.pierrecattin.algorithms.utilities.Job;

public class GreedyScheduler {
	
	public static enum Method{
		DIFF,
		RATIO
	}
	
	public static long schedule(ArrayList<Job> jobs, Method method) {
		long weightedCost=0;
		long currentTime=0;
		
		ArrayList<Job> remainingJobs = new ArrayList<>(jobs);
		while(remainingJobs.size()>0) {
			int indexCurrentJob=indexBestJob(remainingJobs, method);
			Job currentJob=remainingJobs.get(indexCurrentJob);
			currentTime += currentJob.getLength();
			weightedCost += currentTime*currentJob.getWeight();
			remainingJobs.remove(indexCurrentJob);
			//System.out.println("Scheduling "+currentJob);
			//System.out.println("Current time "+currentTime);
			//System.out.println("weightedCost "+weightedCost);
		}
		return(weightedCost);
	}
	
	private static int indexBestJob(ArrayList<Job> jobs, Method method) {
		double bestScore=Integer.MIN_VALUE;
		int index=-1;
		for (int i=0; i<jobs.size(); i++) {
			double score = score(jobs.get(i), method);
			if(score>bestScore) {
				bestScore=score;
				index=i;
			} else if(score==bestScore) {
				if(jobs.get(i).getWeight()>jobs.get(index).getWeight()) {
					index=i;
				}
			}
		}
		return(index);
	}
	private static double score(Job job, Method method) {
		double score;
		if(method==Method.DIFF) {
			score=job.getWeight()-job.getLength();
		} else {
			score=(double)job.getWeight()/(double)job.getLength();
		}
		return(score);
	}
	
	

}
