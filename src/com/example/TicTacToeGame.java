package com.example;

import java.util.*;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);
	public static char player;
	public static char comp;
	public static char letter;
	public static char[] board = new char[10];
	public static int count = 0;
	public static int turn;

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

	public static void desiredLocation(int t) {
		// char turn = 'X';
		char flag;
		System.out.println("Do you wish to play ? (y/n)");
		flag = sc.next().charAt(0);
		System.out.println("Enter the letter:");
		letter = sc.next().charAt(0);
		while (flag == 'y' || flag == 'Y') {
			System.out.println();
			System.out.println("Enter the desired position :");
			int choice = Integer.parseInt(sc.next());
			if (choice >= 1 && choice <= 9) {
				if (board[choice] == ' ') {
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
			if (count < 9) {
				System.out.println("Do you wish to continue ? (y/n)");
				flag = sc.next().charAt(0);
			} else {
				flag = 'n';
			}
		}
		int dec = Winner();
		if (dec == 1 && t == 1)
			System.out.println("Player won the game!");
		else if (dec == 1 && t == 2)
			System.out.println("Computer won the game!");
		else
			System.out.println("It's a draw!");
		System.out.println("Thankyou for playing!");
	}

	// uc4 and uc5 to check for empty block

	public static int Winner() {
		int i = 0;
			if ((board[1] == 'X' && board[2] == 'X' && board[3] == 'X')
					|| (board[4] == 'X' && board[5] == 'X' && board[6] == 'X')
					|| (board[7] == 'X' && board[8] == 'X' && board[9] == 'X'))
				i = 1;
			if ((board[1] == 'X' && board[4] == 'X' && board[7] == 'X')
					|| (board[2] == 'X' && board[5] == 'X' && board[8] == 'X')
					|| (board[3] == 'X' && board[6] == 'X' && board[9] == 'X'))
				i = 1;
			else if ((board[1] == '0' && board[4] == '0' && board[7] == '0')
					|| (board[2] == '0' && board[5] == '0' && board[8] == '0')
					|| (board[3] == '0' && board[6] == '0' && board[9] == '0'))
				i = 1;
			else if ((board[1] == '0' && board[4] == '0' && board[7] == '0')
					|| (board[2] == '0' && board[5] == '0' && board[8] == '0')
					|| (board[3] == '0' && board[6] == '0' && board[9] == '0'))
				i = 1;
			else if ((board[1] == 'X' && board[5] == 'X' && board[9] == 'X')
					|| (board[3] == 'X' && board[5] == 'X' && board[7] == 'X'))
				i = 1;
			else if ((board[1] == '0' && board[5] == '0' && board[9] == '0')
					|| (board[3] == '0' && board[5] == '0' && board[7] == '0'))
				i = 1;
			else
				i = 2;
		return i;
	}

	public static void toss() {
		System.out.println("Toss and play!");
		turn = ((int) Math.floor(Math.random() * 10) % 2) + 1;
		int choice = 1;
		if (turn == 1) {
			System.out.println("Player's turn!");
			desiredLocation(turn);
		} else {
			System.out.println("Computer's turn!");
			int l = ((int) Math.floor(Math.random() * 10) % 9) + 1;
			board[l] = 'X';
			System.out.println("Computer placed X at " + l + " position");
			count++;
			desiredLocation(turn);
		}

	}

	public static void main(String[] args) {
		TicTacToeGame t = new TicTacToeGame();
		System.out.println("Welcome to Tic Tac Toe Game!!");
		System.out.println("----------------------------");
		t.createBoard(); // Empty initially
		// t.chooseLetter();
		// t.desiredLocation();
		// t.printBoard();
		t.toss();

	}

}