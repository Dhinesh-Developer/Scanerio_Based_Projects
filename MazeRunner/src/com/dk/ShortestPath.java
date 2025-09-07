package com.dk;

// Maze Runner -> finding the shortest path from one end to another end.
import java.util.Scanner;

public class ShortestPath {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter matrix dimensions (n x n):"); // 7
		int n = in.nextInt(); // size of the matrix
		
		char[][] matrix = new char[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j] = '0'; // set default value '0'
			}
		}
		
		System.out.println("Enter Adventurer position (row col):");
		int aRow = in.nextInt();
		int aCol = in.nextInt();
		matrix[aRow][aCol] = 'A';
		
		System.out.println("Enter Destination position (row col):");
		int dRow = in.nextInt();
		int dCol = in.nextInt();
		matrix[dRow][dCol] = 'D';
		
		
		// Print the Matrix.
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		// Find the shortest path.
		
		System.out.println();
		int shortestPath = findShortestPath(aRow,aCol,dRow,dCol);
		System.out.println("\nThe shortest path is: "+shortestPath);
		
		in.close();
		
	}

	private static int findShortestPath(int startX, int startY, int endX, int endY) {
		return Math.max(Math.abs(endX-startX), Math.abs(endY-startY));
		// (0,3) // (4,5) = (4-0) , (5-3) = Max(4,2) = 4
	}
	
	
/* ----------- OUTPUT -------------
Enter matrix dimensions (n x n):
7
Enter Adventurer position (row col):
0 3
Enter Destination position (row col):
4 5
0 0 0 A 0 0 0 
0 0 0 0 0 0 0 
0 0 0 0 0 0 0 
0 0 0 0 0 0 0 
0 0 0 0 0 D 0 
0 0 0 0 0 0 0 
0 0 0 0 0 0 0 


The shortest path is: 4

	 **/
	
}
