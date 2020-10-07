package com.example;

import java.util.*;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);

	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < board.length; i++)
			board[i] = ' ';
		return board;
	}

	// UC1
	public static void main(String[] args) {
		TicTacToeGame t = new TicTacToeGame();
		System.out.println("Welcome to Tic Tac Toe Game!!");
		System.out.println("----------------------------");
		char[] board = t.createBoard(); // Empty initially
	}

}