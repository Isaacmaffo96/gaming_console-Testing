package login;

import java.awt.Color;

import games.GamesFrame;

public class LoginActions {
	
	LoginFrame loginFrame;
	String userID;
	String password;
	
	LoginActions(LoginFrame loginFrame){
		this.loginFrame = loginFrame;
	}
	
	void resetButtonAction() {
		loginFrame.userIDField.setText("");
		loginFrame.userPasswordField.setText("");
		loginFrame.messageLabel.setText("");
	}
	
	void loginButtonAction() {
		
		userID = loginFrame.userIDField.getText().toLowerCase();
		password = String.valueOf(loginFrame.userPasswordField.getPassword());
		
		// Adapted for MCDC Testing purposes
		
		// Login successful
		if(!(loginFrame.credentialsMap.isEmpty()) &&
				(((loginFrame.credentialsMap.containsKey(userID)) 
				&& (loginFrame.credentialsMap.get(userID)).getPassword().equals(password))
				|| (userID.equals("guest") && password.equals("guest")))){
			
			if (userID.equals("guest")) {
				if (loginFrame.credentialsMap.containsKey("guestuser")) {
					loginFrame.messageLabel.setForeground(Color.green);
					loginFrame.messageLabel.setText("Login successful");
					loginFrame.user = loginFrame.credentialsMap.get("guestuser");
				}
				else {
					loginFrame.messageLabel.setForeground(Color.red);
					loginFrame.messageLabel.setText("An error has occurred");
					return;
				}
			}
			else {
				loginFrame.messageLabel.setForeground(Color.green);
				loginFrame.messageLabel.setText("Login successful");
				loginFrame.user = loginFrame.credentialsMap.get(userID);
			}
			loginFrame.dispose(); // close loginFrame frame
			GamesFrame gamesFrame = new GamesFrame(loginFrame.user, loginFrame.setupFacade.getGamesList());
			
		}
		
		// Username not found
		else if ((loginFrame.credentialsMap.isEmpty()) || ((!loginFrame.credentialsMap.containsKey(userID)) && (!userID.equals("guest"))) ) {
			loginFrame.messageLabel.setForeground(Color.red);
			loginFrame.messageLabel.setText("Username not found");
		}
		
		// Wrong password
		else {
			loginFrame.messageLabel.setForeground(Color.red);
			loginFrame.messageLabel.setText("Wrong password");
		}
		
	}


	void guestButtonAction() {
		loginFrame.user = loginFrame.credentialsMap.get("guestuser");
		loginFrame.user.getScores().resetScores();
		loginFrame.messageLabel.setForeground(Color.green);
		loginFrame.messageLabel.setText("Guest login successful");
		loginFrame.dispose(); // close this frame
		GamesFrame gamesFrame = new GamesFrame(loginFrame.user, loginFrame.setupFacade.getGamesList());
	}
	
}
