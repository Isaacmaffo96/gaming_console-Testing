package main;

import games.Game;
import games.GamesFrame;
import login.SignupFrame;
import snake.SnakeGame;
import login.LoginFrame;
import login.SetupFacade;

public class main_test {

	public static void main(String[] args) {
		
				
		SetupFacade setupFacade = SetupFacade.createSetupFacade();
						
		LoginFrame loginFrame = new LoginFrame(setupFacade);
		// SignupFrame signupFrame = new SignupFrame(setupFacade.getCredentialsMap());
		// GamesFrame gamesFrame = new GamesFrame(setupFacade.getCredentialsMap().get("isaacmaffo96"), setupFacade.getGamesList());
		// SnakeGame snakeGame = new SnakeGame(new Game("snake"),setupFacade.getCredentialsMap().get("isaacmaffo96"));
	}

}
