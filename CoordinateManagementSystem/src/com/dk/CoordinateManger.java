package com.dk;

import java.util.HashMap;
import java.util.Map;

public class CoordinateManger {

	Map<Integer, Point> points = new HashMap<>();

	public void addPoints(double x,double y) {
		Point p = new Point(x,y);
		points.put(p.getPointId(), p);
		System.out.println("Point added with ID: "+p.getPointId());
	}

	public void viewPoints() {
		if(points.isEmpty()) {
			System.out.println("No points available!");
			return;
		}

		for(Point x: points.values()) {
			System.out.println(x);
		}
	}

	public void findDistance(int id1,int id2) {
		Point p1 = points.get(id1);
		Point p2 = points.get(id2);
		if(p1 == null || p2 == null) {
			System.out.println("Invalid Points ID!");
			return;
		}

		System.out.println("Distance : "+p1.distance(p2));

	}

	public void findNearestToOrigin() {
		if(points.isEmpty()) {
			System.out.println("No Points available");
			return;
		}

		Point origin = new Point(0,0);
		Point nearest = null;
		double minDist = Double.MAX_VALUE;
		for(Point x : points.values()) {
			double d = x.distance(origin);
			if(d < minDist) {
				minDist = d;
				nearest = x;
			}
		}
		System.out.println("Nearest point to origin: " + nearest + " with distance " + minDist);
	}

	public void findNearestToPoint(int id) {
		Point ref = points.get(id);
		if(ref == null) {
			System.out.println("Invalid point ID!");
			return;
		}

		Point nearest = null;
		double minDist = Double.MAX_VALUE;
		for(Point x : points.values()) {
			if(x.getPointId() == id) continue;
			double d = x.distance(ref);
			if( d < minDist) {
				nearest = ref;
				minDist = d;
			}

			if (nearest != null)
				System.out.println("Nearest point to " + ref + " is " + nearest + " with distance " + minDist);
			else
				System.out.println("No other points available.");
		}

	}

	public void findWithinRadius(double radius) {
		Point origin = new Point(0,0);
		boolean found = false;
		for(Point x : points.values()) {
			if(x.distance(origin) <= radius) {
				System.out.println(x + " is within radius " + radius);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No points found within radius " + radius);
		}


	}




}
