package me.cs158.tag.main;

import me.cs158.tag.events.*;

import me.cs158.tag.events.passive.*;
import me.cs158.tag.events.passive.Dumby;
import me.cs158.tag.events.passive.EastScroll;
import me.cs158.tag.player.Player;

public class Board {
	/*
	 * @param	board	this is the game board, it consists of events which could be a fight or a scroll or something
	 * @param	size	this is the size of the board, should be kinda fucking obvious
	 */
	private Event[][] board;
	private int size;
	private Player p;
	
	public Board() {
		board = new Event[10][10];
		this.initializeBoard();
	}
	
	public Board(int size, Player p) {
		this.p = p;
		this.size = size;
		board = new Event[this.size][this.size];
		this.initializeBoard();
	}
	
	private void initializeBoard() {
		int x = (int) (Math.random()*this.size + 1);
		int y = (int) (Math.random()*this.size + 1);
		
		this.board[1][1] = new FindPotion(p);
		this.board[1][2] = new EastScroll();
		this.board[1][3] = new TurnEightScroll();
		
		for(int r = 0; r < this.board.length; r++) {
			for(int c = 0; c < this.board[0].length; c++) {
				if(this.board[r][c] == null) {
					this.board[r][c] = new Dumby();
				}
			}
		}
	}
	
	public void checkPos(Player p) {
		if(p.getX() < 0) {
			p.setX(0);
			System.out.println("Out of bounds.");
		}
		if(p.getX() == this.getSize()) {
			p.setX(this.getSize()-1);			
			System.out.println("Out of bounds.");

		}
		if(p.getY() < 0) {
			p.setY(0);
			System.out.println("Out of bounds.");

		}
		if(p.getY() == this.getSize()) {
			p.setY(this.getSize()-1);
			System.out.println("Out of bounds.");

		}
		
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Event getBoard(int x, int y){
		return this.board[x][y];
	}
}
