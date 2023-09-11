package model_testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class Scenario1Test {
	
	@Test
	public void newGameTest() {
		Snake snake = new Snake();
		assertEquals(snake.status,Status.SETUP);
		snake.newGame();
		assertEquals(snake.status,Status.IN_GAME);
		for(int i = 0; i < snake.board.length - 1; i++)
			assertEquals(snake.board[0][i],Sign.WALL);
		for(int i = 1; i < snake.board.length; i++)
			assertEquals(snake.board[5][i],Sign.WALL);
		for(int j = 1; j < snake.board.length; j++)
			assertEquals(snake.board[j][0], Sign.WALL);
		for(int j = 0; j <snake. board.length - 1; j++)
			assertEquals(snake.board[j][5], Sign.WALL);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.HEAD);
		assertEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.score,0);
	}
	
	@Test
	public void eatAppleTest() {
		Snake snake = new Snake();
		assertEquals(snake.status,Status.SETUP);
		snake.newGame();
		snake.move(Direction.RIGHT);
		assertEquals(snake.status,Status.IN_GAME);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.BODY);
		assertEquals(snake.board[1][3], Sign.HEAD);
		assertEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.score,0);
		snake.move(Direction.DOWN);
		assertEquals(snake.status,Status.IN_GAME);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.BODY);
		assertEquals(snake.board[1][3], Sign.BODY);
		assertEquals(snake.board[2][3], Sign.HEAD);
		assertNotEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.score,1);
	}
	
	@Test
	public void crashTest() {
		Snake snake = new Snake();
		assertEquals(snake.status,Status.SETUP);
		snake.newGame();
		snake.move(Direction.RIGHT);
		snake.move(Direction.DOWN);
		snake.move(Direction.RIGHT);
		assertEquals(snake.status,Status.IN_GAME);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.BODY);
		assertEquals(snake.board[1][3], Sign.BODY);
		assertEquals(snake.board[2][3], Sign.BODY);
		assertEquals(snake.board[2][4], Sign.HEAD);
		snake.move(Direction.RIGHT);
		assertEquals(snake.status,Status.GAME_OVER);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.BODY);
		assertEquals(snake.board[1][3], Sign.BODY);
		assertEquals(snake.board[2][3], Sign.BODY);
		assertEquals(snake.board[2][4], Sign.HEAD);
	}

}
