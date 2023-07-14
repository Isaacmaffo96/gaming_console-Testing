package games;

public class Scores {
	
	private int game1Score;
	private int game2Score;
	
	public Scores() {
		this.resetScores();
	}
	
	public Scores(int game1Score, int game2Score) {
		this.game1Score = game1Score;
		this.game2Score = game2Score;
	}

	public void resetScores() {
		this.game1Score = 0;
		this.game2Score = 0;
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
	
}
