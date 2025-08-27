package com.dk;

import java.util.Scanner;


public class DungeonGame {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		// Get Grid size
		System.out.println("Enter the grid size (rows columns):"); //5 5
		int rows = in.nextInt();
		int cols = in.nextInt();
		
		// Initialize dungeon with '.'
		char[][] dungeon = new char[rows][cols];
		
		// Initialize dungeon with '.'
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				dungeon[i][j] = '.';
			}
		}
		
		//Getting the Adventurer position.
		System.out.println("Enter Adventurer position (row column):");
		int aRow = in.nextInt();
		int aCol = in.nextInt();
		dungeon[aRow][aCol] = 'A';
		
		System.out.println("Enter Monster position (row column):");
		int mRow = in.nextInt();
		int mCol = in.nextInt();
		dungeon[mRow][mCol] = 'M';
		
		System.out.println("Enter Trigger position (row column):");
		int tRow = in.nextInt();
		int tCol = in.nextInt();
		dungeon[tRow][tCol] = 'T';
		
		System.out.println("Enter Treasure position (row column):");
		int tpRow = in.nextInt();
		int tpCol = in.nextInt();
		dungeon[tpRow][tpCol] = 'X';
		
		// Getting the Number of pits.
		System.out.println("Enter number of pits:");
		int pits = in.nextInt();
		
		for(int i=0;i<pits;i++) {
			System.out.println("Enter pit "+(i+1)+" position (row column):");
			int pRow = in.nextInt();
			int pCol = in.nextInt();
			dungeon[pRow][pCol] = 'P';
		}
		
		// print the dungeon
		System.out.println();
		System.out.println("\nDungeon Layout:");
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print(dungeon[i][j]+" ");
			}
			System.out.println();
		}
		
		
		// Logic Part
		
		// 1. Calculating distance.
		
		int adventureToTrigger = Math.abs(aRow - tRow) + Math.abs(aCol - tCol);
		int monsterToTrigger = Math.abs(mRow - tRow) + Math.abs(mCol - tCol);
		int adventureToTreasure = Math.abs(aRow - tpRow) + Math.abs(aCol - tpCol);
		int monsterToTreasure = Math.abs(mRow - tpRow) + Math.abs(mCol - tpCol);
		
		System.out.println("Result:");
		if(adventureToTrigger < monsterToTrigger) {
			System.out.println("Adventure reaches the trigger first!");
			System.out.println("Monster is frozen!");
			System.out.println("Adventure can safely reach the treasure!");
			
			// Mission Possible - Adventure wins via Trigger
		}else if(adventureToTrigger > monsterToTrigger) {
			System.out.println("Monster reaches the trigger first!");
			System.out.println("Trigger is deactivated!");
			if(adventureToTreasure < monsterToTreasure) {
				System.out.println("Adventure can still reach treasure before the monster");
			}else {
				System.out.println("Monster will catch the adventure!");
			}
			// Mission Impossible
		}else {
			// If they reach trigger at same time, fall back to direct treasure distance
			if(adventureToTreasure < monsterToTreasure) {
				System.out.println("Adventure can reach the treasure before the monster!");
			}else {
				System.out.println("Monster will catch the adventure!");
			}
			// Mission Impossible
		}
		
		in.close();
		
	}
}

