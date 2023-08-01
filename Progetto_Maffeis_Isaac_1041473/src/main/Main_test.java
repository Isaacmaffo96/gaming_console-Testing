package main;

import games.GamesFrame;
import login.SignupFrame;
import login.LoginFrame;
import login.SetupFacade;

public class Main_test {

	public static void main(String[] args) {
		
		//finds Java version    
		String str=System.getProperty("java.version");  
		//prints Java version  
		System.out.println("Java Version is: "+str);    
		
				
		//SetupFacade setupFacade = SetupFacade.createSetupFacade();
						
		//LoginFrame loginFrame = new LoginFrame(setupFacade);
		// SignupFrame signupFrame = new SignupFrame(setupFacade.getCredentialsMap());
		// GamesFrame gamesFrame = new GamesFrame(setupFacade.getCredentialsMap().get("isaacmaffo96"), setupFacade.getGamesList());
			
	}

}
