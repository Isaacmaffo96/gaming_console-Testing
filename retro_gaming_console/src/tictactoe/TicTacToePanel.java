package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToePanel extends JPanel implements ActionListener {
	
	private Random random = new Random();
	private JPanel title_panel = new JPanel();
	private JPanel button_panel = new JPanel();
	private JLabel textfield = new JLabel();
	private JButton[] buttons = new JButton[9]; // buttons matrix
	private int playerScore;
	private TicTacToeGame ticTacToeGame;
	boolean player1_turn;

	public TicTacToePanel(TicTacToeGame ticTacToeGame){
		
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.playerScore = 0;
		this.ticTacToeGame = ticTacToeGame;
				
		// Title panel
		setTitle();
		
		// Button matrix
		setButtons();
		
		// Begin the game
		firstTurn();
		
		title_panel.add(textfield);
		this.add(title_panel,BorderLayout.NORTH);
		this.add(button_panel);

	}
	
	private void setTitle() {
		// text
		textfield.setBackground(new Color(0x380A2A));
		//textfield.setForeground(new Color(25,255,0));
		textfield.setForeground(Color.white);
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		// panel
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
	}

	private void setButtons() {
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(0x480852));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			buttons[i].setText("");
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setBackground(new Color(0x380A2A));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
	}
	
	private boolean isValid(int pos) {
		return buttons[pos].getText()=="";
	}
	
	private void firstTurn() {
		// decide which player has to start
		
		// delay 2 second
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("Player turn");
		}
		else {
			player1_turn=false;
			textfield.setText("AI turn");
			computerTurn();
		}
	}
	
	private void computerTurn() {
		int i;
		while (true) {
			i = random.nextInt(9);
			if (isValid(i)) {
				break;
			}
		}
		buttons[i].setForeground(new Color(0x2b50c8));
		buttons[i].setText("O");
		if (checkComputerWin())
			return;
		if (checkTie())
			return;
		player1_turn=true;
		textfield.setText("Player turn");
	}

	private boolean checkPlayerWin() {
		//check X win conditions
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			playerWins(0,1,2);
			return true;
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			playerWins(3,4,5);
			return true;
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			playerWins(6,7,8);
			return true;
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			playerWins(0,3,6);
			return true;
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			playerWins(1,4,7);
			return true;
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			playerWins(2,5,8);
			return true;
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			playerWins(0,4,8);
			return true;
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			playerWins(2,4,6);
			return true;
		}
		return false;
	}
	
	private boolean checkComputerWin() {
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			computerWins(0,1,2);
			return true;
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			computerWins(3,4,5);
			return true;
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			computerWins(6,7,8);
			return true;
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			computerWins(0,3,6);
			return true;
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			computerWins(1,4,7);
			return true;
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			computerWins(2,5,8);
			return true;
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			computerWins(0,4,8);
			return true;
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			computerWins(2,4,6);
			return true;
		}
		return false;
	}
	
	private boolean checkTie() {
		
		for (int i=0; i<9; i++)
			if (buttons[i].getText()=="")
				return false;
		
		textfield.setText("Tie");
		
		for(int i=0;i<9;i++)
			buttons[i].setEnabled(false);
		
		return true;
		
	}

	private void playerWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		if (playerScore < ticTacToeGame.getGlobalMaxScore()) {
			textfield.setForeground(new Color(0xF400A1));
			textfield.setFont(new Font("Ink Free",Font.BOLD,40));
			textfield.setText("<html>Player wins<br>Global record!</html>");
		}
		else if (playerScore < ticTacToeGame.getPersonalMaxScore()) {
			textfield.setForeground(Color.green);
			textfield.setFont(new Font("Ink Free",Font.BOLD,40));
			textfield.setText("<html>Player wins<br>Personal record!</html>");
		}
		else {
			textfield.setText("Player wins" );
		}
		ticTacToeGame.setScore(playerScore);
	}
	
	private void computerWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("AI wins");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(isValid(i)) {
						playerScore += 1;
						buttons[i].setForeground(new Color(0xd4af37));
						buttons[i].setText("X");
						textfield.setText("AI turn");
						player1_turn=false;
						if (checkPlayerWin())
							return;
						if (checkTie())
							return;
						computerTurn();
					}
				}
			}			
		}
	}
	
}
