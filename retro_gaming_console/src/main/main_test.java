package main;

import games.GamesFrame;
import games.GamesList;
import login.CredentialsMap;
import login.SignupFrame;
import login.LoginFrame;
import login.SetupFacade;

public class main_test {

	public static void main(String[] args) {
		
				
		SetupFacade setupFacade = SetupFacade.createSetupFacade();
						
		 LoginFrame loginFrame = new LoginFrame(setupFacade);
		// SignupFrame signupFrame = new SignupFrame(setupFacade);
		//GamesFrame gamesFrame = new GamesFrame(setupFacade.getCredentialsMap().get("isaacmaffo96"));
	}

}
