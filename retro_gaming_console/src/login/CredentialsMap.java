package login;

import java.time.LocalDate;
import java.util.HashMap;

public class CredentialsMap {

	HashMap<String,Person> credentialsMap; // {id:person}
	Person mario = new Person("Super", "Mario", "mario", LocalDate.parse("1988-10-11"), "supermario@nintendo.com", "ItsmeMario!");
	Person luigi = new Person("Luigi", "Mario", "luigi", LocalDate.parse("1986-09-25"), "luigi@nintendo.com", "Numberone!");
	Person pacman = new Person("Pac", "Man", "pacman", LocalDate.parse("1980-01-15"), "pacman80@gmail.com", "paku-paku");
	Person isaac = new Person("Isaac", "Maffeis", "isaac", LocalDate.parse("1996-05-10"), "isaacmaffo96@gmail.com", "1041473");
	
	public CredentialsMap(){
		credentialsMap =  new HashMap<String,Person>();
		credentialsMap.put("mario",mario);
		credentialsMap.put("luigi",luigi);
		credentialsMap.put("pacman",pacman);
		credentialsMap.put("isaac",isaac);
	}
	
	public HashMap getLoginCredentials(){
		return credentialsMap;
	}
}