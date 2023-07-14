package login;

import java.util.ArrayList;
import java.util.HashMap;

import games.Game;
import games.GamesList;

public class SetupFacade {
	
	// unique class for the entire program (singleton)
	private static SetupFacade setupFacadeInstance = null;
	private CredentialsMap credentialsMap;
	private GamesList gamesList;
	
	private SetupFacade() {
		this.credentialsMap =  new CredentialsMap();
		this.gamesList = new GamesList();
	}
	
	public static SetupFacade createSetupFacade() {
		if (setupFacadeInstance == null)
			setupFacadeInstance = new SetupFacade();
		return setupFacadeInstance;
	}
		
	// login info {username:Person}
	public HashMap<String,Person> getCredentialsMap() {
		return credentialsMap.getLoginCredentials();
	}
	
	// available games list
	public ArrayList<Game> getGamesList() {
		return gamesList.getGamesList();
	}
	
}
