package com.skilldistillery.foodtruck;

public class FoodTruck {
	private int ftID;
	private double ftRating;
	private String ftName;
	private String ftType;
	private static int idNumTotal = 0;
	
	FoodTruck(double ftRating, String ftName, String ftType) {
		this.ftID = idNumTotal;	
		FoodTruck.idNumTotal ++;

			this.ftRating = ftRating;
			this.ftName = ftName;
			this.ftType = ftType;
	}

	public int getFtID() {
		return ftID;
	}
	public void setFtID(int ftID) {
		this.ftID = ftID;
	}
	public double getFtRating() {
		return ftRating;
	}
	public void setFtRating(double ftRating) {
		this.ftRating = ftRating;
	}
	public String getFtName() {
		return ftName;
	}
	public void setFtName(String ftName) {
		this.ftName = ftName;
	}
	public String getFtType() {
		return ftType;
	}
	public void setFtType(String ftType) {
		this.ftType = ftType;
	}
	public static int getIdNumTotal() {
		return idNumTotal;
	}
	public static void setIdNumTotal(int idNumTotal) {
		FoodTruck.idNumTotal = idNumTotal;
	}

	@Override
	public String toString() {
		return "FoodTruck [ftID=" + ftID + ", ftRating=" + ftRating + ", ftName=" + ftName + ", ftType=" + ftType + "]";
	}
	}
