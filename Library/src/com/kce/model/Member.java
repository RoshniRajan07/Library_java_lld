package com.kce.model;

public class Member {

    private int memberId;
    private String name;
    private int totalBorrowed = 0;

    public int getMemberId() { 
    	return memberId;
    	}
    public void setMemberId(int memberId) {
    	this.memberId = memberId; }

    public String getName() {
    	return name; }
    public void setName(String name) { 
    	this.name = name;
    	}

    public int getTotalBorrowed() {
    	return totalBorrowed;
    	}
    public void setTotalBorrowed(int totalBorrowed) {
    	this.totalBorrowed = totalBorrowed; 
    	}
}