package games;

public class Scores {
	
	private int game1Score;
	private int game2Score;
	private int game3Score;
	
	public Scores() {
		this.resetScores();
	}
	
	public void resetScores() {
		this.game1Score = 0;
		this.game2Score = 0;
		this.game3Score = 0;
	}

	public int getGame1Score() {
		return game1Score;
	}

	public void setGame1Score(int game1Score) {
		this.game1Score = game1Score;
	}

	public int getGame2Score() {
		return game2Score;
	}

	public void setGame2Score(int game2Score) {
		this.game2Score = game2Score;
	}

	public int getGame3Score() {
		return game3Score;
	}

	public void setGame3Score(int game3Score) {
		this.game3Score = game3Score;
	}
}
