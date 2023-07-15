package login;

import java.time.LocalDate;
import java.util.HashMap;

import games.Scores;

public class CredentialsMap {

	HashMap<String,Person> credentialsMap; // {id:person}
	
	public CredentialsMap(){
		credentialsMap =  new HashMap<String,Person>();
		addDefault(); // default accounts
		addGuest(); // guest user, no registration required
	}
	
	private void addDefault() {
		Person mario = new Person("Super", "Mario", "supermario", LocalDate.parse("1988-10-11"), "supermario@nintendo.com", "ItsmeMario!1", new Scores(8,5));
		Person luigi = new Person("Luigi", "Mario", "luigi", LocalDate.parse("1986-09-25"), "luigi@nintendo.com", "Number1!", new Scores(2,4));
		Person pacman = new Person("Pac", "Man", "pacman", LocalDate.parse("1980-01-15"), "pacman80@gmail.com", "Paku-Paku80", new Scores(5,4));
		Person isaac = new Person("Isaac", "Maffeis", "isaacmaffo96", LocalDate.parse("1996-05-10"), "isaacmaffo96@gmail.com", "Im_1041473",new Scores(4,5));
		
		credentialsMap.put(mario.getUsername(),mario);
		credentialsMap.put(luigi.getUsername(),luigi);
		credentialsMap.put(pacman.getUsername(),pacman);
		credentialsMap.put(isaac.getUsername(),isaac);
	}
	
	private void addGuest() {
		Person guest = new Person("Guest","User","guest", LocalDate.parse("2000-01-01"),"guestuser@mail.com","GuestUser_2000");
		credentialsMap.put(guest.getUsername(),guest);
	}
	
	public HashMap<String, Person> getLoginCredentials(){
		return credentialsMap;
	}
}