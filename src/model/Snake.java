package model;

import java.util.Random;

enum Sign {WALL, HEAD, BODY, APPLE, UNDEF;}
enum Status {SETUP, IN_GAME ,GAME_OVER;}
enum Direction {UP, DOWN, RIGHT,LEFT;}

public class Snake {
	
	Sign [][] board;
	Status status;
	int headX;
	int headY;
	int appleX;
	int appleY;
	int score;
	Random random = new Random();
	
	public Snake() {
		this.status = Status.SETUP;
		this.board = new Sign[6][6];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board.length; j++)
				this.board[i][j] = Sign.UNDEF;
	}
	
	private void setWalls() {
		for(int i = 0; i < board.length - 1; i++)
			this.board[0][i] = Sign.WALL;
		for(int i = 1; i < board.length; i++)
			this.board[5][i] = Sign.WALL;
		for(int j = 1; j < board.length; j++)
			this.board[j][0] = Sign.WALL;
		for(int j = 0; j < board.length - 1; j++)
			this.board[j][5] = Sign.WALL;
	}
	
	private void setHead() {
		this.board[1][2] = Sign.HEAD;
		this.headX = 1;
		this.headY = 2;
	}
	
	private void setBody() {
		this.board[1][1] = Sign.BODY;
	}
	
	private void setFirstApple() {
		this.board[2][3] = Sign.APPLE;
		this.appleX = 2;
		this.appleY = 3;
	}

	private void newApple() {
		int random_x;
		int random_y;
		do {
			random_x = random.nextInt(4) + 1;
			random_y = random.nextInt(4) + 1;
		}
		while (board[random_x][random_y] != Sign.UNDEF);
		this.appleX = random_x;
		this.appleY = random_y;
		this.board[appleX][appleY] = Sign.APPLE;

	}
	
	private void checkApple(int head_x, int head_y){
		if (board[head_x][head_y] == Sign.APPLE){
			this.score ++;
			this.newApple();
		}
	}
	
	public void move(Direction direction) {
		if (this.status != Status.IN_GAME)
			return;
		switch (direction){
		case UP:
			if(headX == 1 || board[headX-1][headY] == Sign.BODY) // check if it hits the top wall or eats the body
				this.status = Status.GAME_OVER;
			else {
				this.checkApple(headX-1,headY); // check if it eats the apple
				this.board[headX][headY] = Sign.BODY;
				this.board[headX-1][headY] = Sign.HEAD;
				this.headX -= 1;
			}
			break;
		case DOWN:
			if(headX == 5 || board[headX+1][headY] == Sign.BODY) // check if it hits the top wall or eats the body
				this.status = Status.GAME_OVER;
			else {
				this.checkApple(headX+1,headY); // check if it eats the apple
				this.board[headX][headY] = Sign.BODY;
				this.board[headX+1][headY] = Sign.HEAD;
				this.headX += 1;
			}
			break;
		case RIGHT:
			if(headY == 4 || board[headX][headY+1] == Sign.BODY) // check if it hits the top wall or eats the body
				this.status = Status.GAME_OVER;
			else {
				this.checkApple(headX,headY+1); // check if it eats the apple
				this.board[headX][headY] = Sign.BODY;
				this.board[headX][headY+1] = Sign.HEAD;
				this.headY += 1;
			}
			break;
		case LEFT:
			if(headY == 1 || board[headX][headY-1] == Sign.BODY) // check if it hits the top wall or eats the body
				this.status = Status.GAME_OVER;
			else {
				this.checkApple(headX,headY-1); // check if it eats the apple
				this.board[headX][headY] = Sign.BODY;
				this.board[headX][headY-1] = Sign.HEAD;
				this.headY -= 1;
			}
			break;
		}
	}
	
	public void newGame() {
		this.setWalls();
		this.setHead();
		this.setBody();
		this.setFirstApple();
		this.score = 0;
		this.status = Status.IN_GAME;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("#" + "\t");
		for (int i = 0; i < board.length; i++) {
			s.append(i + "\t");
		}
		s.append("\n");
		for (int i = 0; i < board.length; i++) {
			s.append(i + "\t");
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == Sign.UNDEF)
					s.append(" ");
				else if(board[i][j] == Sign.WALL)
					s.append("W");
				else if(board[i][j] == Sign.HEAD)
					s.append("H");
				else if(board[i][j] == Sign.BODY)
					s.append("B");
				else if(board[i][j] == Sign.APPLE)
					s.append("A");
				s.append("\t");
			}
			s.append("\n");
		}
		s.append("Status = " + this.status + "\n");
		s.append("Score = " + this.score);
		return s.toString();
	}
	
}
