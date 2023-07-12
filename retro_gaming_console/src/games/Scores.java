package games;

public class Scores {
	
	private int game1Score;
	private int game2Score;
	
	public Scores() {
		this.resetScores();
	}
	
	public void resetScores() {
		this.game1Score = 0;
		this.game2Score = 0;
	}

	int getGame1Score() {
		return game1Score;
	}

	void setGame1Score(int game1Score) {
		this.game1Score = game1Score;
	}

	int getGame2Score() {
		return game2Score;
	}

	void setGame2Score(int game2Score) {
		this.game2Score = game2Score;
	}
	
}
