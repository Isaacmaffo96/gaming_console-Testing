package tictactoe;

import games.Game;
import games.GamesFrame;
import login.Person;

public class TicTacToeGame{
		
	private int score;
	private Game game;
	private Person user;
	private GamesFrame gamesFrame;
	
	public TicTacToeGame(Game game, Person user, GamesFrame gamesFrame) {
		// Game 2
		this.game = game;
		this.user = user;
		this.gamesFrame = gamesFrame;
		
		launchGame();
	}

	private void updateHighScores() {
		if (score < user.getScores().getGame1Score()) {
			user.getScores().setGame1Score(score);
		}
		if (score < game.getMaxscore()) {
			game.setMaxscore(score);
		}
		gamesFrame.refreshHighScores();
	}

	private void launchGame() {
		new TicTacToeFrame(this);
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
