package com.dk;

public class Point {
	
	private static int counter = 1000;
	private int pointId;
	private double x;
	private double y;
	
	public Point(double x,double y) {
		this.pointId = counter++;
		this.x = x;
		this.y = y;
	}
	
	public double distance(Point other) {
		return Math.sqrt(Math.pow(other.x- this.x,2)  + Math.pow(other.y - this.y, 2));
	}

	@Override
	public String toString() {
		return "Point [pointId=" + pointId + ", x=" + x + ", y=" + y + "]";
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Point.counter = counter;
	}

	public int getPointId() {
		return pointId;
	}

	public void setPointId(int pointId) {
		this.pointId = pointId;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
}
