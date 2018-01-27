package com.alife.util;

public class CustomStopWatch {
	
	private Long startTime;
	private Long endTime;
	private boolean isStarted = false;
	
	public CustomStopWatch reset(){
		startTime = null;
		endTime   = null;
		isStarted = false;
		return this;
	}
	
	public CustomStopWatch start(){
		startTime = System.nanoTime();
		endTime   = null;
		isStarted =  true;
		return this;
	}
	
	public CustomStopWatch stop(){
		endTime = System.nanoTime();
		isStarted = false;
		return this;
	}
	
	public boolean isRunning(){
		return isStarted;
	}
	
	public long getElapsedTimeInNanoSecond(){
		return endTime-startTime;
	}
	
	public double getElapsedTimeInMilliSecond(){
		return (endTime-startTime) / 1000000.0;
	}
}
