package snake;

import games.Game;
import games.GamesFrame;
import login.Person;

public class SnakeGame {
	
	private int score;
	private Game game;
	private Person user;
	private GamesFrame gamesFrame;
	
	// Game 1
	public SnakeGame(Game game, Person user, GamesFrame gamesFrame) {
		
		this.game = game;
		this.user = user;
		this.gamesFrame = gamesFrame;
		
		launchGame();
	}

	private void updateHighScores() {
		if (score > user.getScores().getGame1Score()) {
			user.getScores().setGame1Score(score);
		}
		if (score > game.getMaxscore()) {
			game.setMaxscore(score);
		}
		gamesFrame.refreshHighScores();
	}

	private void launchGame() {
		new SnakeFrame(this);
	}
	
	void setScore(int score) {
		this.score = score;	
		updateHighScores();
	}

	int getGlobalMaxScore() {
		return game.getMaxscore();
	}
	
	int getPersonalMaxScore() {
		return user.getScores().getGame1Score();
	}
	
}
