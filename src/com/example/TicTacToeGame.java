package com.example;

import java.util.*;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);
	public static char player;
	public static char comp;
	public static char letter;
	public static char[] board = new char[10];

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
			comp = 'X';
			break;
		}
	}

	// uc2
	public static void main(String[] args) {
		TicTacToeGame t = new TicTacToeGame();
		System.out.println("Welcome to Tic Tac Toe Game!!");
		System.out.println("----------------------------");
		t.createBoard(); // Empty initially
		t.chooseLetter();
		// uc2 called
	}

}