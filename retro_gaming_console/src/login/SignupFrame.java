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

public class SignupFrame extends JFrame implements ActionListener {
	
	JLabel info1 = new JLabel("Sign Up!");
	JLabel info2 = new JLabel("It’s quick and easy.");
	JLabel nameLabel = new JLabel("Name:");
	JTextField nameField = new JTextField();
	JLabel surnameLabel = new JLabel("Surname:");
	JTextField surnameField = new JTextField();
	JLabel usernameLabel = new JLabel("Username:");
	JTextField usernameField = new JTextField();
	JLabel dateOfBirthLabel = new JLabel("Date of birth:");
	JTextField dateOfBirthField = new JTextField();
	JLabel mailLabel = new JLabel("Mail:");
	JTextField mailField = new JTextField();
	JLabel passwordLabel = new JLabel("Password:");
	JPasswordField passwordField = new JPasswordField();
	JButton signupButton = new JButton("Sign Up");
	JLabel messageLabel = new JLabel();
	JPanel fieldsPanel = new JPanel();
	HashMap<String,Person> credentialsMap;
	
	public SignupFrame(HashMap<String,Person> credentialsMap){
		this.credentialsMap = credentialsMap;
		this.setTitle("Sign Up!");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //close only this frame
		this.setResizable(false); //prevent from being resized
		this.setSize(360, 440);
		this.setLocationRelativeTo(null); // position of the frame center of the screen
		
		// icon
		this.setIcon();
		
		// background image
		this.setBackground();
		
		// fields
		this.setFields();
		
		
		
		//pack(); // resize to accommodate all the components
		
		this.setLayout(null); // custom layout
		this.setVisible(true); // frame visible
	}
	
	private void setFields() {
		
		fieldsPanel.setBounds(40, 40, 270, 320);
		Font fontFields = new Font("", Font.PLAIN, 14);
				
		info1.setBounds(10, 10, 100, 25);
		info1.setFont(new Font("", Font.PLAIN, 20)); // font
		info1.setForeground(Color.WHITE);
		info2.setBounds(10, 40, 200, 20);
		info2.setFont(new Font("", Font.PLAIN, 18)); // font
		info2.setForeground(Color.WHITE);

		
		nameLabel.setBounds(10,70,100,25);
		nameLabel.setFont(fontFields);
		nameLabel.setForeground(Color.WHITE);
		nameField.setBounds(100,70,150,25);
		nameField.setFont(fontFields);
		
		surnameLabel.setBounds(10,100,100,25);
		surnameLabel.setFont(fontFields);
		surnameLabel.setForeground(Color.WHITE);
		surnameField.setBounds(100,100,150,25);
		surnameField.setFont(fontFields);
		
		usernameLabel.setBounds(10,130,100,25);
		usernameLabel.setFont(fontFields);
		usernameLabel.setForeground(Color.WHITE);
		usernameField.setBounds(100,130,150,25);
		usernameField.setFont(fontFields);
		
		dateOfBirthLabel.setBounds(10,160,100,25);
		dateOfBirthLabel.setFont(fontFields);
		dateOfBirthLabel.setForeground(Color.WHITE);
		dateOfBirthField.setBounds(100,160,150,25);
		dateOfBirthField.setFont(fontFields);
		
		mailLabel.setBounds(10,190,100,25);
		mailLabel.setFont(fontFields);
		mailLabel.setForeground(Color.WHITE);
		mailField.setBounds(100,190,150,25);
		mailField.setFont(fontFields);
		
		passwordLabel.setBounds(10,220,100,25);
		passwordLabel.setFont(fontFields);
		passwordLabel.setForeground(Color.WHITE);
		passwordField.setBounds(100,220,150,25);
		passwordField.setFont(fontFields);
		
		signupButton.setBounds(10, 255, 240, 25);
		signupButton.addActionListener(this);
		signupButton.setFont(new Font(null,Font.PLAIN,17));
		
		messageLabel.setBounds(10, 285, 240, 25);
		messageLabel.setFont(new Font(null,Font.PLAIN,17));
		
		fieldsPanel.add(info1);
		fieldsPanel.add(info2);
		fieldsPanel.add(nameLabel);
		fieldsPanel.add(nameField);
		fieldsPanel.add(surnameLabel);
		fieldsPanel.add(surnameField);
		fieldsPanel.add(usernameLabel);
		fieldsPanel.add(usernameField);
		fieldsPanel.add(dateOfBirthLabel);
		fieldsPanel.add(dateOfBirthField);
		fieldsPanel.add(mailLabel);
		fieldsPanel.add(mailField);
		fieldsPanel.add(passwordLabel);
		fieldsPanel.add(passwordField);
		fieldsPanel.add(signupButton);
		fieldsPanel.add(messageLabel);
		fieldsPanel.setLayout(null); // custom layout
		;
		
		fieldsPanel.setBackground(new Color(0x221947)); 
		Border signupPanelBorder = BorderFactory.createLineBorder(new Color(0xF400A1), 2); // border cyan 2 pxl
		fieldsPanel.setBorder(signupPanelBorder);
		
		this.getRootPane().setDefaultButton(signupButton); // default triggered with enter key
		this.add(fieldsPanel);

	};
	
	private void setIcon() {
		ImageIcon image = new ImageIcon("RetroGamingLogo.jpeg");
		this.setIconImage(image.getImage()); //change icon
	}
	
	private void setBackground() {
		try {
			Image background_image = ImageIO.read(new File("signupBackground.jpg"));
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
		if(e.getSource()==signupButton) {
			
		}
		
	}

}
