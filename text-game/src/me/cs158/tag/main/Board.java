package me.cs158.tag.main;

import me.cs158.tag.events.*;

public class Board {
	/*
	 * @param	board	this is the game board, it consists of events which could be a fight or a scroll or something
	 * @param	size	this is the size of the board, should be kinda fucking obvious
	 */
	private Event[][] board;
	private int size;
	
	public Board() {
		board = new Event[10][10];
		this.initializeBoard();
	}
	
	public Board(int size) {
		this.size = size;
		board = new Event[this.size][this.size];
		this.initializeBoard();
	}
	
	private void initializeBoard() {
		int x = (int) (Math.random()*this.size + 1);
		int y = (int) (Math.random()*this.size + 1);
		System.out.println("Ghost fight at (" + x + "," + y + ")");
		this.board[x][y] = new GhostFight();
		
	}
}
