package model;

public class SnakeProva {

	public static void main(String[] args) {
		
		Snake snake = new Snake();
		
		System.out.println("Empty Board\n" + snake.toString() + "\n");
		
		snake.newGame();
		
		System.out.println("new Game\n" +  snake.toString() + "\n");
		
		snake.move(Direction.RIGHT);

		System.out.println("Direction: right\n" +  snake.toString() + "\n");
		
		snake.move(Direction.DOWN);

		System.out.println("Direction: down\n" +  snake.toString() + "\n");
		
		snake.move(Direction.DOWN);

		System.out.println("Direction: down\n" +  snake.toString() + "\n");
		
		snake.move(Direction.LEFT);

		System.out.println("Direction: left\n" +  snake.toString() + "\n");
		
		snake.move(Direction.LEFT);

		System.out.println("Direction: left\n" +  snake.toString() + "\n");

		
		snake.move(Direction.UP);

		System.out.println("Direction: up\n" +  snake.toString() + "\n");
		
		/* snake.move(Direction.LEFT);
		 * 
		 * System.out.println("Direction: left\n" +  snake.toString() + "\n");
		 */
		
		snake.move(Direction.UP);

		System.out.println("Direction: up\n" +  snake.toString() + "\n");
		
		
		
	}

}
