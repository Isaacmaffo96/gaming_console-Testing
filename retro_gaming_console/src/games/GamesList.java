package games;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GamesList {
	
	private ArrayList<Game> gamesList;

	public GamesList() {
		this.gamesList = new ArrayList<Game>();
		addGames();
	}
	
	private void addGames() {
		

		Game game1 = new Game("Snake");
		game1.setIconByPath("snake.png");
		gamesList.add(game1);
		
		Game game2 = new Game("Minesweeper");
		game2.setIconByPath("Minesweeper.png");
		gamesList.add(game2);

	}

	public ArrayList<Game> getGamesList() {
		return gamesList;
	}
	
}
