package com.dk;


class Board {
 private char[][] grid;
 private static final int SIZE = 3;

 public Board() {
     grid = new char[SIZE][SIZE];
     for (int i = 0; i < SIZE; i++) {
         for (int j = 0; j < SIZE; j++) {
             grid[i][j] = '-'; 
         }
     }
 }

 public boolean placeMark(int row, int col, char player) {
     if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || grid[row][col] != '-') {
         return false;
     }
     grid[row][col] = player;
     return true;
 }

 public void printBoard() {
     System.out.println();
     for (int i = 0; i < SIZE; i++) {
         for (int j = 0; j < SIZE; j++) {
             System.out.print(" " + grid[i][j] + " ");
             if (j < SIZE - 1) System.out.print("|");
         }
         System.out.println();
         if (i < SIZE - 1) {
             System.out.println("---+---+---");
         }
     }
     System.out.println();
 }

 public boolean checkWin(char player) {
     // Rows
     for (int i = 0; i < SIZE; i++) {
         if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) return true;
     }
     // Columns
     for (int j = 0; j < SIZE; j++) {
         if (grid[0][j] == player && grid[1][j] == player && grid[2][j] == player) return true;
     }
     // Diagonals
     if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) return true;
     if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) return true;

     return false;
 }

 public boolean isFull() {
     for (int i = 0; i < SIZE; i++) {
         for (int j = 0; j < SIZE; j++) {
             if (grid[i][j] == '-') return false;
         }
     }
     return true;
 }
}