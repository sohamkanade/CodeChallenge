package com.aws.session4;

public class Board {
	private Cell [][] cells = new Cell[8][8];

	public Board() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				cells[i][j] = new Cell();
			}
		}
	}

	// setup board with chess pieces for initial 
	public void setUp() {

	}
}
