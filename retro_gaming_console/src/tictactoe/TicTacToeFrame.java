package tictactoe;

import javax.swing.*;

public class TicTacToeFrame extends JFrame{
	
	TicTacToePanel ticTacToePanel;

	public TicTacToeFrame(TicTacToeGame ticTacToeGame){
		
		this.ticTacToePanel = new TicTacToePanel(ticTacToeGame);
		this.add(ticTacToePanel);
		this.setTitle("Tic Tac Toe");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500,500);
		//this.setResizable(false);
		//this.pack();
		setIcon();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	private void setIcon() {
		ImageIcon image = new ImageIcon("tictactoe.png");
		this.setIconImage(image.getImage());
	}

}