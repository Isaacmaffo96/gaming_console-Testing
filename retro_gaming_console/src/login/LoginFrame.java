package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import games.GamesFrame;

public class LoginFrame extends JFrame implements ActionListener{
	
	// welcome
	JPanel welcomePanel = new JPanel();
	JLabel welcomeLabel = new JLabel("Welcome to the Retro Gaming Console");
	// login
	JLabel loginInfoLabel = new JLabel("Please login to your account");
	JPanel loginPanel = new JPanel();
	JButton loginButton = new JButton("Log in");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("Username:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel();
	SetupFacade setupFacade;
	HashMap<String,Person> credentialsMap;
	Person user;
	// signup
	JPanel signupPanel = new JPanel();
	JLabel signupLabel = new JLabel("Don't have an account?");
	JButton signupButton = new JButton("Sign up");
	JLabel guestLabel = new JLabel("or continue as a guest*");
	JButton guestButton = new JButton("Guest");
	JLabel signupInfoLabel = new JLabel();
	
	public LoginFrame(SetupFacade setupFacade) {
		this.setTitle("Retro Gaming Console");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
		this.setResizable(false); //prevent from being resized
		this.setSize(900,506); //sets the x-dimension, and y-dimension
		this.setLocationRelativeTo(null); // position of the frame center of the screen
		
		// icon
		this.setIcon();
		
		// background image
		this.setBackground();
		
		// Welcome Panel
		this.setWelcome();
		
		// login panel
		this.setLogin(setupFacade);
		
		// signup panel
		this.setSignup();

		//pack(); // resize to accommodate all the components
		this.setLayout(null); // custom layout
		this.setVisible(true); // frame visible	
	}
	
	private void setWelcome() {
		welcomeLabel.setForeground(new Color(0xFFFFF)); //set font color of text
		welcomeLabel.setFont(new Font("", Font.PLAIN, 20)); // font
		welcomePanel.add(welcomeLabel);
		welcomePanel.setBounds(60, 20, 400, 40);
		welcomePanel.setOpaque(false); // panel color transparent
		this.add(welcomePanel);
	}
	
	private void setLogin(SetupFacade setupFacade) {
		
		this.setupFacade = setupFacade;
		this.credentialsMap = setupFacade.getCredentialsMap(); // {ID:password}
		
		// Panel
		loginPanel.setBounds(60,65,400,170);
		loginPanel.setLayout(null);
		
		// Label
		Font fontFields = new Font("", Font.PLAIN, 14);
		
		loginInfoLabel.setBounds(95, 0, 250, 20);	
		loginInfoLabel.setForeground(new Color(0xFFFFF)); //set font color of text
		loginInfoLabel.setFont(new Font("", Font.PLAIN, 17)); // font
		
		userIDLabel.setBounds(25,30,75,25);
		userIDLabel.setForeground(new Color(0xFFFFF)); //set font color of text
		userIDLabel.setFont(fontFields); // font
		userIDField.setBounds(95,30,208,25);
		userIDField.setFont(fontFields); // font
		
		userPasswordLabel.setBounds(25,70,75,25);
		userPasswordLabel.setForeground(new Color(0xFFFFF)); //set font color of text
		userPasswordLabel.setFont(fontFields); // font
		userPasswordField.setBounds(95,70,208,25);
		userPasswordField.setFont(fontFields); // font
		
		messageLabel.setBounds(125,138,250,35);
		messageLabel.setFont(new Font(null,Font.PLAIN,17));
		
		loginButton.setBounds(95,110,104,25);
		loginButton.setFont(fontFields); // font
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(199,110,104,25);
		resetButton.setFont(fontFields); // font
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		loginPanel.add(loginInfoLabel);
		loginPanel.add(userIDLabel);
		loginPanel.add(userPasswordLabel);
		loginPanel.add(messageLabel);
		loginPanel.add(userIDField);
		loginPanel.add(userPasswordField);
		loginPanel.add(loginButton);
		loginPanel.add(resetButton);
		
		loginPanel.setOpaque(false);
		this.getRootPane().setDefaultButton(loginButton); // default triggered with enter key
		this.add(loginPanel);
	}
	
	private void setSignup() {
		
		Font fontFields = new Font("", Font.PLAIN, 14);
		
		signupPanel.setBounds(115, 235, 280, 120);
		signupPanel.setLayout(null);
		
		signupLabel.setBounds(20, 10, 250, 25);
		signupLabel.setForeground(new Color(0xFFFFF)); //set font color of text
		signupLabel.setFont(fontFields); // font
		signupButton.setBounds(175, 10, 90, 25);
		signupButton.setFont(fontFields); // font
		signupButton.addActionListener(this);
		
		guestLabel.setBounds(20, 40, 250, 25);
		guestLabel.setForeground(new Color(0xFFFFF)); //set font color of text
		guestLabel.setFont(fontFields); // font
		guestButton.setBounds(175, 40, 90, 25);
		guestButton.setFont(fontFields); // font
		guestButton.addActionListener(this);
		
		signupInfoLabel.setBounds(20, 60, 250, 50);
		signupInfoLabel.setText("<html>* Having an account allows you <br> to save your best scores</html>");
		signupInfoLabel.setFont(fontFields); // font
		signupInfoLabel.setForeground(new Color(0xF400A1)); //set font color of text
		
		signupPanel.add(signupLabel);
		signupPanel.add(signupButton);
		signupPanel.add(guestLabel);
		signupPanel.add(guestButton);
		signupPanel.add(signupInfoLabel);
		this.add(signupPanel);
		
		signupPanel.setBackground(new Color(0x172d4d));
		Border signupPanelBorder = BorderFactory.createLineBorder(Color.CYAN, 2); // border cyan 2 pxl
		signupPanel.setBorder(signupPanelBorder);
		//signupPanel.setOpaque(false);
	}
	
	private void setIcon() {
		ImageIcon image = new ImageIcon("RetroGamingLogo.jpeg");
		this.setIconImage(image.getImage()); //change icon
	}
	
	private void setBackground() {
		try {
			Image background_image = ImageIO.read(new File("LoginBackground.jpg"));
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
		
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			messageLabel.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText().toLowerCase();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(credentialsMap.containsKey(userID)) {
				if((credentialsMap.get(userID)).getPassword().equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					// this.dispose(); // close this frame
					// TODO - Open new Page (select game);
					user = credentialsMap.get(userID);
					this.dispose(); // close this frame
					GamesFrame gamesFrame = new GamesFrame(user, setupFacade.getGamesList());
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password");
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
			}
		}
		
		if(e.getSource()==signupButton) {
			SignupFrame signupFrame = new SignupFrame(credentialsMap);
		}
		
		if(e.getSource()==guestButton) {
			user = credentialsMap.get("guest");
			user.getScores().resetScores();
			this.dispose(); // close this frame
			GamesFrame gamesFrame = new GamesFrame(user, setupFacade.getGamesList());
		}
	}	
	
}
