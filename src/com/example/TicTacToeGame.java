package com.example;

import java.util.*;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);
	public static char player;
	public static char comp;
	public static char letter;
	public static char[] board = new char[10];
	public static int count = 0;

	public static char[] createBoard() {
		for (int i = 0; i < board.length; i++)
			board[i] = ' ';
		return board;
	}

	// UC1

	public static void chooseLetter() {
		System.out.print("Enter your letter:");
		letter = sc.next().charAt(0);
		System.out.println("Player: " + letter);
		switch (letter) {
		case 'X':
			System.out.println("Computer: 0");
			player = letter;
			comp = '0';
			break;
		case '0':
			System.out.println("Computer: X");
			player = letter;
			board[1] = letter;
			comp = 'X';
			break;
		}
	}

	// uc2
	public static void printBoard() {
		System.out.println("Your current board after moves looks like:");
		System.out.println(" -------------");
		System.out.println(" | " + board[1] + " | " + board[2] + " | " + board[3] + " | ");
		System.out.println(" -------------");
		System.out.println(" | " + board[4] + " | " + board[5] + " | " + board[6] + " | ");
		System.out.println(" -------------");
		System.out.println(" | " + board[7] + " | " + board[8] + " | " + board[9] + " | ");
		System.out.println(" -------------");
	}

	// uc3
	public static void compPos(char c) {
		int i = ((int) Math.floor(Math.random() * 10) % 9) + 1;
		if (board[i] == ' ') {
			board[i] = c;
			count++;
		} else
			compPos(c);
	}

	public static void desiredLocation() {
		// char turn = 'X';
		char flag;
		System.out.println();
		System.out.println("Do you wish to play ? (y/n)");
		flag = sc.next().charAt(0);
		while (flag == 'y' || flag == 'Y') {
			System.out.println();
			System.out.println("Enter the desired position :");
			int choice = Integer.parseInt(sc.next());
			if (choice >= 1 && choice <= 9) {
				if (board[choice] == ' ') {

					System.out.println("Enter the letter:");
					letter = sc.next().charAt(0);
					player = letter;
					board[choice] = player;
					count++;
					comp = (letter == 'X') ? '0' : 'X';
					if (count <= 8) {
						compPos(comp);
					} else {
						printBoard();
						System.out.println("Game Ends!");
						break;
					}
					printBoard();
				} else {
					System.out.println("Slot already taken!");
				}
			} else {
				System.out.println("Invalid position!!");
			}
			// printBoard();
			System.out.println("Do you wish to continue ? (y/n)");
			flag = sc.next().charAt(0);
			// sc.nextLine();
		}
	}

	// uc4 and uc5 to check for empty block
	public static void main(String[] args) {
		TicTacToeGame t = new TicTacToeGame();
		System.out.println("Welcome to Tic Tac Toe Game!!");
		System.out.println("----------------------------");
		t.createBoard(); // Empty initially
		// t.chooseLetter();
		t.desiredLocation();
		// t.printBoard();
		// uc2 called
	}

}