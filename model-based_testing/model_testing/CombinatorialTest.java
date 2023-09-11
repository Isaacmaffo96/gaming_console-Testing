package model_testing;

import static org.junit.Assert.*;

import org.junit.Test;

/*
	Combinatorial testing
	Model: Snake.asm
	Variables: Direction, Snake, Status.
	Domains:
	- Direction:[UP, DOWN, LEFT, RIGHT];
	- Snake: [MOVE, EAT, CRASH WALL, HIT BODY];
	- Status: [SET_UP, IN_GAME, GAME_OVER].
	
	IPO: In-Parameter-Order
	Pairwise testing t = 2
	*-----------------------------------------*
	|# | Direction  | Snake      | Status     |
	|--|------------|------------|------------|
	|1 | UP		    | MOVE	  	 | SET_UP	  |
	|2 | UP		    | EAT	   	 | IN_GAME    |
	|3 | UP		    | CRASH WALL | IN_GAME    |
	|4 | UP		    | HIT BODY   | GAME_OVER  |
	|5 | DONW	    | MOVE	     | IN_GAME    |
	|6 | DONW	    | EAT	     | SET_UP	  |
	|7 | DONW	    | CRASH WALL | GAME_OVER  |
	|8 | DONW	    | HIT BODY   | IN_GAME    |
	|9 | LEFT	    | MOVE	     | GAME_OVER  |
	|10| LEFT	    | EAT        | IN_GAME    |
	|11| LEFT	    | CRASH WALL | SET_UP	  |
	|12| LEFT	    | HIT BODY   | SET_UP	  |
	|13| RIGHT	    | MOVE	     | IN_GAME    |
	|14| RIGHT	    | EAT	     | GAME_OVER  |
	|15| RIGHT	    | CRASH WALL | SET_UP	  |
	|16| RIGHT	    | HIT BODY   | IN_GAME    |
	*-----------------------------------------*
*/

public class CombinatorialTest {

	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |1 | UP		   | MOVE	  	| SET_UP	 | */
	@Test // (expected = IndexOutOfBoundsException.class)
	public void test1() {
		Snake snake = new Snake();
		assertEquals(snake.status,Status.SETUP);
		snake.move(Direction.UP);
		assertEquals(snake.status,Status.SETUP);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |2 | UP		   | EAT	   	| IN_GAME    | */
	@Test
	public void test2() {
		Snake snake = new Snake();
		snake.newGame();
		assertEquals(snake.status,Status.IN_GAME);
		snake.move(Direction.DOWN);
		snake.move(Direction.DOWN);
		snake.move(Direction.RIGHT);
		snake.move(Direction.UP);
		assertEquals(snake.status,Status.IN_GAME);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.BODY);
		assertEquals(snake.board[2][2], Sign.BODY);
		assertEquals(snake.board[3][2], Sign.BODY);
		assertEquals(snake.board[3][3], Sign.BODY);
		assertEquals(snake.board[2][3], Sign.HEAD);
		assertNotEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.score,1);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |3 | UP		   | CRASH WALL | IN_GAME    | */
	@Test
	public void test3() {
		Snake snake = new Snake();
		snake.newGame();
		assertEquals(snake.status,Status.IN_GAME);
		snake.move(Direction.UP);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.HEAD);
		assertEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.board[0][2], Sign.WALL);
		assertEquals(snake.score,0);
		assertEquals(snake.status,Status.GAME_OVER);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |4 | UP		   | HIT BODY   | GAME_OVER  |
	 */
	@Test
	public void test4() {
		Snake snake = new Snake();
		snake.newGame();
		snake.move(Direction.UP);
		assertEquals(snake.status,Status.GAME_OVER);
		snake.move(Direction.DOWN);
		snake.move(Direction.LEFT);
		snake.move(Direction.UP);
		assertEquals(snake.status,Status.GAME_OVER);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.HEAD);
		assertNotEquals(snake.board[1][2], Sign.BODY);
		assertNotEquals(snake.board[2][2], Sign.BODY);
		assertNotEquals(snake.board[2][1], Sign.HEAD);
		assertEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.score,0);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |5 | DONW	   | MOVE	    | IN_GAME    |
	 */
	@Test
	public void test5() {
		Snake snake = new Snake();
		snake.newGame();
		assertEquals(snake.status,Status.IN_GAME);
		snake.move(Direction.DOWN);
		assertEquals(snake.status,Status.IN_GAME);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.BODY);
		assertEquals(snake.board[2][2], Sign.HEAD);
		assertEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.score,0);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |6 | DONW	   | EAT	    | SET_UP	 |
	 */
	@Test
	public void test6() {
		Snake snake = new Snake();
		assertEquals(snake.status,Status.SETUP);
		snake.move(Direction.RIGHT);
		snake.move(Direction.DOWN);	
		assertNotEquals(snake.board[2][3], Sign.APPLE);

	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |7 | DONW	   | CRASH WALL | GAME_OVER  |
	 */
	@Test
	public void test7() {
		Snake snake = new Snake();
		snake.newGame();
		snake.move(Direction.UP);
		assertEquals(snake.status,Status.GAME_OVER);
		snake.move(Direction.DOWN);	
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.HEAD);
		assertEquals(snake.board[2][3], Sign.APPLE);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |8 | DONW	   | HIT BODY   | IN_GAME    |
	 */
	@Test
	public void test8() {
		Snake snake = new Snake();
		snake.newGame();
		assertEquals(snake.status,Status.IN_GAME);
		snake.move(Direction.DOWN);	
		snake.move(Direction.DOWN);	
		snake.move(Direction.RIGHT);
		snake.move(Direction.RIGHT);
		snake.move(Direction.UP);
		snake.move(Direction.LEFT);
		snake.move(Direction.DOWN);	
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.BODY);
		assertEquals(snake.board[2][2], Sign.BODY);
		assertEquals(snake.board[3][2], Sign.BODY);
		assertEquals(snake.board[3][3], Sign.BODY);
		assertEquals(snake.board[3][4], Sign.BODY);
		assertEquals(snake.board[2][4], Sign.BODY);
		assertEquals(snake.board[2][3], Sign.HEAD);
		assertNotEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.status,Status.GAME_OVER);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |9 | LEFT	   | MOVE	    | GAME_OVER  |
	 */
	@Test
	public void test9() {
		Snake snake = new Snake();
		snake.newGame();
		snake.move(Direction.UP);	
		assertEquals(snake.status,Status.GAME_OVER);
		snake.move(Direction.LEFT);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.HEAD);
		assertEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.status,Status.GAME_OVER);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |10| LEFT	   | EAT        | IN_GAME    |
	 */
	@Test
	public void test10() {
		Snake snake = new Snake();
		snake.newGame();
		assertEquals(snake.status,Status.IN_GAME);
		snake.move(Direction.RIGHT);	
		snake.move(Direction.RIGHT);	
		snake.move(Direction.DOWN);	
		snake.move(Direction.LEFT);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.BODY);
		assertEquals(snake.board[1][3], Sign.BODY);
		assertEquals(snake.board[1][4], Sign.BODY);
		assertEquals(snake.board[2][4], Sign.BODY);
		assertEquals(snake.board[2][3], Sign.HEAD);
		assertNotEquals(snake.board[2][3], Sign.APPLE);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |11| LEFT	   | CRASH WALL | SET_UP	 |
	 */
	@Test
	public void test11() {
		Snake snake = new Snake();
		assertEquals(snake.status,Status.SETUP);
		snake.move(Direction.LEFT);	
		assertEquals(snake.status,Status.SETUP);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |12| LEFT	   | HIT BODY   | SET_UP	 |
	 */
	@Test
	public void test12() {
		Snake snake = new Snake();
		assertEquals(snake.status,Status.SETUP);
		snake.move(Direction.DOWN);	
		snake.move(Direction.DOWN);	
		snake.move(Direction.RIGHT);
		snake.move(Direction.UP);
		snake.move(Direction.LEFT);
		assertEquals(snake.status,Status.SETUP);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |13| RIGHT	   | MOVE	    | IN_GAME    |
	 */
	@Test
	public void test13() {
		Snake snake = new Snake();
		snake.newGame();
		assertEquals(snake.status,Status.IN_GAME);
		snake.move(Direction.RIGHT);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.BODY);
		assertEquals(snake.board[1][3], Sign.HEAD);
		assertEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.score,0);
		assertEquals(snake.status,Status.IN_GAME);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |14| RIGHT	   | EAT	    | GAME_OVER  |
	 */
	@Test
	public void test14() {
		Snake snake = new Snake();
		snake.newGame();
		snake.move(Direction.UP);
		assertEquals(snake.status,Status.GAME_OVER);
		snake.move(Direction.DOWN);
		snake.move(Direction.RIGHT);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.HEAD);
		assertNotEquals(snake.board[1][2], Sign.BODY);
		assertNotEquals(snake.board[2][2], Sign.BODY);
		assertNotEquals(snake.board[2][3], Sign.HEAD);
		assertEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.score,0);
		assertEquals(snake.status,Status.GAME_OVER);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |15| RIGHT	   | CRASH WALL | SET_UP	 |
	 */
	@Test
	public void test15() {
		Snake snake = new Snake();
		assertEquals(snake.status,Status.SETUP);
		snake.move(Direction.RIGHT);
		snake.move(Direction.RIGHT);
		snake.move(Direction.RIGHT);
		assertEquals(snake.status,Status.SETUP);
	}
	
	/* |# | Direction  | Snake      | Status     |
	 * |--|------------|------------|------------|
	 * |16| RIGHT	   | HIT BODY   | IN_GAME    |
	 */
	@Test
	public void test16() {
		Snake snake = new Snake();
		snake.newGame();
		assertEquals(snake.status,Status.IN_GAME);
		snake.move(Direction.DOWN);
		snake.move(Direction.DOWN);
		snake.move(Direction.LEFT);
		snake.move(Direction.UP);
		assertEquals(snake.status,Status.IN_GAME);
		snake.move(Direction.RIGHT);
		assertEquals(snake.board[1][1], Sign.BODY);
		assertEquals(snake.board[1][2], Sign.BODY);
		assertEquals(snake.board[2][2], Sign.BODY);
		assertEquals(snake.board[3][2], Sign.BODY);
		assertEquals(snake.board[3][1], Sign.BODY);
		assertEquals(snake.board[2][1], Sign.HEAD);
		assertEquals(snake.board[2][3], Sign.APPLE);
		assertEquals(snake.score,0);
		assertEquals(snake.status,Status.GAME_OVER);
	}

}
