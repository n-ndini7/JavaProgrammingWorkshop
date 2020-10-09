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
			//count++;
		} else
			compPos(c);
	}

	public static void desiredLocation(int t){
    // char turn = 'X';
    // char flag = 'y';
		int win = 0;
		while (win == 0) {
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
						if (turn == 2 && count == 2) {
						} else
							ComputerPlaysToWin();
					}
					printBoard();
				} else {
					System.out.println("Slot already taken!");
				}
			} else {
				System.out.println("Invalid position!!");
			}
			win = Winner();
			switch (win) {
			case 1:
				System.out.println("PLayer has won the game!");
				System.out.println();
				System.out.println("Thankyou for playing!!");
				System.exit(0);
			case 2:
				System.out.println("Computer has won the game!");
				System.out.println();
				System.out.println("Thankyou for playing!!");
				System.exit(0);
			case 9:
				System.out.println("It's a draw!!!");
				System.out.println();
				System.out.println("Thankyou for playing!!");
				System.exit(0);

			}
			if (count == 9) {
				System.out.println("It's a draw!!! \n \nThankyou for playing!!");
				System.exit(0);
      }
    }
  }
	// uc4 and uc5 to check for empty block
  
	public static int playerWins() {
		int j = 0;
		if ((board[1] == player && board[2] == player && board[3] == player)
				|| (board[4] == player && board[5] == player && board[6] == player)
				|| (board[7] == player && board[8] == player && board[9] == player)
				|| (board[1] == player && board[4] == player && board[7] == player)
				|| (board[2] == player && board[5] == player && board[8] == player)
				|| (board[3] == player && board[6] == player && board[9] == player)
				|| (board[1] == player && board[5] == player && board[9] == player)
				|| (board[3] == player && board[5] == player && board[7] == player))
			j = 3;
		return j;
	}

	// player wins
	public static int computerWins() {
		int k = 0;
		if (player == 'X') {
			if ((board[1] == '0' && board[2] == '0' && board[3] == '0')
					|| (board[4] == '0' && board[5] == '0' && board[6] == '0')
					|| (board[7] == '0' && board[8] == '0' && board[9] == '0')
					|| (board[1] == '0' && board[4] == '0' && board[7] == '0')
					|| (board[2] == '0' && board[5] == '0' && board[8] == '0')
					|| (board[3] == '0' && board[6] == '0' && board[9] == '0')
					|| (board[1] == '0' && board[5] == '0' && board[9] == '0')
					|| (board[3] == '0' && board[5] == '0' && board[7] == '0'))
				k = 4;
		} else {
			if ((board[1] == 'X' && board[2] == 'X' && board[3] == 'X')
					|| (board[4] == 'X' && board[5] == 'X' && board[6] == 'X')
					|| (board[7] == 'X' && board[8] == 'X' && board[9] == 'X')
					|| (board[1] == 'X' && board[4] == 'X' && board[7] == 'X')
					|| (board[2] == 'X' && board[5] == 'X' && board[8] == 'X')
					|| (board[3] == 'X' && board[6] == 'X' && board[9] == 'X')
					|| (board[1] == 'X' && board[5] == 'X' && board[9] == 'X')
					|| (board[3] == 'X' && board[5] == 'X' && board[7] == 'X'))
				k = 4;
		}
		return k;
		// computer wins
	}

	public static void ComputerPlaysToWin() {
		if (player == 'X')
			comp = '0';
		else
			comp = 'X';
		if (count < 2) {
			compPos(comp);
			count++;
		} else {
			// winning condition in row 1
			if (board[1] == comp && board[2] == comp && board[3] == ' ')
				board[3] = comp;
			else if (board[1] == comp && board[2] == ' ' && board[3] == comp)
				board[2] = comp;
			else if (board[1] == ' ' && board[2] == comp && board[3] == comp)
				board[1] = comp;
			// winning condition in row 2
			else if (board[4] == comp && board[5] == comp && board[6] == ' ')
				board[6] = comp;
			else if (board[5] == comp && board[6] == comp && board[4] == ' ')
				board[4] = comp;
			else if (board[4] == comp && board[6] == comp && board[5] == ' ')
				board[5] = comp;
			// winning condition in row 3
			else if (board[7] == comp && board[8] == comp && board[9] == ' ')
				board[9] = comp;
			else if (board[8] == comp && board[9] == comp && board[7] == ' ')
				board[7] = comp;
			else if (board[7] == comp && board[9] == comp && board[8] == ' ')
				board[8] = comp;

			// winning condition in column 1
			else if (board[1] == comp && board[4] == comp && board[7] == ' ')
				board[7] = comp;
			else if (board[1] == comp && board[7] == comp && board[4] == ' ')
				board[4] = comp;
			else if (board[4] == comp && board[7] == comp && board[1] == ' ')
				board[1] = comp;
			// winning condition in column 2
			else if (board[2] == comp && board[5] == comp && board[8] == ' ')
				board[8] = comp;
			else if (board[2] == comp && board[8] == comp && board[5] == ' ')
				board[5] = comp;
			else if (board[5] == comp && board[8] == comp && board[2] == ' ')
				board[2] = comp;
			// winning condition in column 3
			else if (board[3] == comp && board[6] == comp && board[9] == ' ')
				board[9] = comp;
			else if (board[3] == comp && board[9] == comp && board[6] == ' ')
				board[6] = comp;
			else if (board[6] == comp && board[9] == comp && board[3] == ' ')
				board[3] = comp;

			// winning condition in diagonal 1
			else if (board[1] == comp && board[5] == comp && board[9] == ' ')
				board[9] = comp;
			else if (board[1] == comp && board[9] == comp && board[5] == ' ')
				board[5] = comp;
			else if (board[5] == comp && board[9] == comp && board[1] == ' ')
				board[1] = comp;
			// winning condition in diagonal 2
			else if (board[3] == comp && board[5] == comp && board[7] == ' ')
				board[7] = comp;
			else if (board[3] == comp && board[7] == comp && board[5] == ' ')
				board[5] = comp;
			else if (board[5] == comp && board[7] == comp && board[3] == ' ')
				board[3] = comp;

			else 
				compPos(comp);
			// for random move
			count++;
		}
	}

	// Computer makes a move to win

	public static int Winner() {
		int i = 0;
		int a = playerWins();
		int b = computerWins();
		if (a == 3 && b != 4)
			i = 1;
		else if (b == 4 && a != 3)
			i = 2;
		else if (a == 3 && b == 4)
			i = 9;
    
		return i;
	}

	public static void toss() {
		System.out.println("Toss and play!");
		turn = ((int) Math.floor(Math.random() * 10) % 2) + 1;
		int choice = 1;
		if (turn == 1) {
			System.out.println("Player's turn!");
			System.out.println("Enter the letter:");
			letter = sc.next().charAt(0);
			desiredLocation(turn);
		} else {
			System.out.println("Computer's turn!");
			System.out.println("Enter the letter:");
			letter = sc.next().charAt(0);
			int l = ((int) Math.floor(Math.random() * 10) % 9) + 1;
			comp = (letter == 'X') ? '0' : 'X';
			System.out.println("Computer placed " + comp + " at " + l + " position");
			board[l] = comp;
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