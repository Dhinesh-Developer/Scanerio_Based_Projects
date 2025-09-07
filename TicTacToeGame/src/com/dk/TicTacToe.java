package com.dk;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Tic Tac Toe ---");
            System.out.println("1. Start Game");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("👋 Exiting game.");
                break;
            }

            Board board = new Board();
            char currentPlayer = 'X';
            boolean gameEnded = false;

            while (!gameEnded) {
                board.printBoard();
                System.out.println("Player " + currentPlayer + ", enter row and column (1-3): ");
                int row = sc.nextInt() - 1;
                int col = sc.nextInt() - 1;

                if (!board.placeMark(row, col, currentPlayer)) {
                    System.out.println("❌ Invalid move, try again.");
                    continue;
                }

                if (board.checkWin(currentPlayer)) {
                    board.printBoard();
                    System.out.println("🎉 Player " + currentPlayer + " Wins!");
                    gameEnded = true;
                } else if (board.isFull()) {
                    board.printBoard();
                    System.out.println("🤝 It's a Draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; 
                }
            }
        }

        sc.close();
    }
}