package com.acbhu.carbooking;

public class TripTime {

	private int startTime;
	private int endTime;
	
	public TripTime(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	
}
