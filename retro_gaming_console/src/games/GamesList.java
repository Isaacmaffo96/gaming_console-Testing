package games;

import java.util.ArrayList;

public class GamesList {
	
	private ArrayList<Game> gamesList;

	public GamesList() {
		this.gamesList = new ArrayList<Game>();
		addGames();
	}
	
	private void addGames() {
		

		Game game1 = new Game("Snake",8);
		game1.setIconByPath("snake.png");
		gamesList.add(game1);
		
		Game game2 = new Game("TicTacToe",4);
		game2.setIconByPath("tictactoe.png");
		gamesList.add(game2);

	}

	public ArrayList<Game> getGamesList() {
		return gamesList;
	}
	
}
