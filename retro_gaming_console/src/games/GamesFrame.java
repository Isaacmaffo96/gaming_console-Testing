package games;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import login.Person;
import login.SetupFacade;

public class GamesFrame extends JFrame implements ActionListener{
	
	private SetupFacade setupFacade;
	private ArrayList<Game> gamesList;
	private Person user;
	
	// game 1 panel
	private Game game1;
	private JPanel game1Panel;
	private JLabel game1NameLabel;
	private JButton game1Button;
	private JLabel game1HighScoreLabel;
	
	// game 2 panel
	private Game game2;
	private JPanel game2Panel;
	private JLabel game2NameLabel;
	private JButton game2Button;
	private JLabel game2HighScoreLabel;
	
	// user Panel
	private JPanel userPanel;
	private JLabel usernameLabel;
	private JLabel userHighScoresLabel;
	private JLabel game1UserHighScoreLabel;
	private JLabel game2UserHighScoreLabel;
	
	// info Label
	private JLabel infoLabel;
	
	
	public GamesFrame(Person user, SetupFacade setupFacade) {
		
		this.setupFacade = setupFacade;
		this.user = user;
		this.gamesList = setupFacade.getGamesList();
		
		this.setTitle("Retro Gaming Console");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
		this.setResizable(false); //prevent from being resized
		this.setSize(900,506); //sets the x-dimension, and y-dimension
		this.setLocationRelativeTo(null); // position of the frame center of the screen
		
		// icon
		this.setIcon();
		
		// background image
		this.setBackground();
			
		// game1 panel
		setGame1Panel();
		
		// game2 panel
		setGame2Panel();
		
		// user panel
		setUserPanel();
		
		// set info label
		setInfoLabel();
		
		this.setLayout(null); // custom layout
		this.setVisible(true); // frame visible	
	}

	private void setGame1Panel() {
		
		game1 = gamesList.get(0);
		game1Panel = new JPanel();
		game1Panel.setBounds(65,65,185,137);
		//game1Panel.setBackground(Color.black);
		game1Panel.setOpaque(false);
		
		// name
		game1NameLabel = new JLabel(game1.getName(), SwingConstants.CENTER);
		game1NameLabel.setBounds(0,0,185,25);
		game1NameLabel.setFont(new Font(null, Font.PLAIN, 22));
		game1NameLabel.setForeground(Color.white);
		
		// button
		if (!game1.iconIsNull()) {
			game1Button = new JButton(game1.getIcon());
		} else {
			game1Button = new JButton();
		}
		game1Button.setBounds(52,32,80,80);
		
		// High score
		game1HighScoreLabel = new JLabel("High Score: " + gamesList.get(0).getMaxscore(), SwingConstants.CENTER);
		game1HighScoreLabel.setBounds(0,115,185,25);
		game1HighScoreLabel.setFont(new Font(null, Font.PLAIN, 17));
		game1HighScoreLabel.setForeground(Color.white);
		
		game1Panel.add(game1NameLabel);
		game1Panel.add(game1Button);
		game1Panel.add(game1HighScoreLabel);
		game1Panel.setLayout(null); // custom layout

		this.add(game1Panel);

	}

	private void setGame2Panel() {
		
		game2 = gamesList.get(1);
		game2Panel = new JPanel();
		game2Panel.setBounds(322,62,185,137);
		//game1Panel.setBackground(Color.black);
		game2Panel.setOpaque(false);
		
		// name
		game2NameLabel = new JLabel(game2.getName(), SwingConstants.CENTER);
		game2NameLabel.setBounds(0,0,185,25);
		game2NameLabel.setFont(new Font(null, Font.PLAIN, 22));
		game2NameLabel.setForeground(Color.white);
		
		// button
		if (!game2.iconIsNull()) {
			game2Button = new JButton(game2.getIcon());
		} else {
			game2Button = new JButton();
		}
		game2Button.setBounds(52,32,80,80);
		
		// High score
		game2HighScoreLabel = new JLabel("High Score: " + gamesList.get(0).getMaxscore(), SwingConstants.CENTER);
		game2HighScoreLabel.setBounds(0,114,185,25);
		game2HighScoreLabel.setFont(new Font(null, Font.PLAIN, 17));
		game2HighScoreLabel.setForeground(Color.white);
		
		game2Panel.add(game2NameLabel);
		game2Panel.add(game2Button);
		game2Panel.add(game2HighScoreLabel);
		game2Panel.setLayout(null); // custom layout

		this.add(game2Panel);

	}

	private void setUserPanel() {
		/*
		private JLabel ;
		private JLabel ;
		private JLabel game2UserHighScoreLabel;
		*/
		userPanel = new JPanel();
		userPanel.setBounds(570,270,220,135);
		//userPanel.setBackground(Color.black);
		userPanel.setOpaque(false);
		
		// name
		usernameLabel = new JLabel(user.getUsername(), SwingConstants.CENTER);
		usernameLabel.setBounds(0,0,220,27);
		usernameLabel.setFont(new Font("Rockwell", Font.PLAIN, 25));
		usernameLabel.setForeground(Color.white);
		
		// High score
		userHighScoresLabel = new JLabel("Personal High Scores:");
		userHighScoresLabel.setBounds(35,40,180,25);
		userHighScoresLabel.setFont(new Font(null, Font.PLAIN, 17));
		userHighScoresLabel.setForeground(Color.white);
		
		// game 1 high score
		game1UserHighScoreLabel = new JLabel(game1.getName() + ": " + user.getScores().getGame1Score());
		game1UserHighScoreLabel.setBounds(35,60,180,25);
		game1UserHighScoreLabel.setFont(new Font(null, Font.PLAIN, 17));
		game1UserHighScoreLabel.setForeground(Color.white);
		
		// game 1 high score
		game2UserHighScoreLabel = new JLabel(game2.getName() + ": " + user.getScores().getGame2Score());
		game2UserHighScoreLabel.setBounds(35,80,180,25);
		game2UserHighScoreLabel.setFont(new Font(null, Font.PLAIN, 17));
		game2UserHighScoreLabel.setForeground(Color.white);

		userPanel.add(usernameLabel);
		userPanel.add(userHighScoresLabel);
		userPanel.add(game1UserHighScoreLabel);
		userPanel.add(game2UserHighScoreLabel);
		userPanel.setLayout(null); // custom layout

		this.add(userPanel);
		
		
	}
	
	private void setInfoLabel(){
		infoLabel = new JLabel("Select a game");
		infoLabel.setBounds(600,50,220,135);
		infoLabel.setFont(new Font("Rockwell", Font.PLAIN, 30));
		infoLabel.setForeground(Color.white);
		this.add(infoLabel);
	}
	
	private void setIcon() {
		ImageIcon image = new ImageIcon("RetroGamingLogo.jpeg");
		this.setIconImage(image.getImage()); //change icon
	}
	
	private void setBackground() {
		try {
			Image background_image = ImageIO.read(new File("GamesBackground.png"));
			this.setContentPane(new JPanel() {
		         @Override
		         public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            g.drawImage(background_image, 0, 0, null);
		         }
		      });
		} catch (IOException e) {
			this.getContentPane().setBackground(new Color(0x123456)); //change color of background
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
