package me.cs158.tag.main;

import me.cs158.tag.events.*;
import me.cs158.tag.events.hostile.GhostFight;
import me.cs158.tag.events.hostile.GoblinFight;
import me.cs158.tag.events.passive.*;
import me.cs158.tag.events.passive.Dummy;
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
		this.board = new Event[this.size][this.size];
		this.initializeBoard();
	}
	
	private void initializeBoard() {
		this.board[6][3] = new FinalRoom();
		
		for(int i = 0; i < 35; i++) {
			int x = (int) (Math.random()*this.size);
			int y = (int) (Math.random()*this.size);
			int eventNum = (int) (Math.random()*2 + 1);
			Event temp = null;
			boolean open = this.board[x][y] == null;
			switch(eventNum) {
			case 0: if(open) temp = new FindPotion(); break;
			case 1: if(open) temp = new GhostFight(); break;
			case 2: if(open) temp = new GoblinFight(); break;
			default: temp = null;
			}
			this.board[x][y] = temp;
			
		}
		
		
		for(int r = 0; r < this.board.length; r++) {
			for(int c = 0; c < this.board[0].length; c++) {
				if(this.board[r][c] == null) {
					this.board[r][c] = new Dummy();
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
	
	public void setBoard(int x, int y, Event e) {
		this.board[x][y] = e;
	}
}
