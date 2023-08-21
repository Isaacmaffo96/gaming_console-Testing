package login;

/* SignupActions class modified to perform static analysis (ESC) */

public class SignupActions_V {
		
	/*@ spec_public @*/ String name;
	/*@ spec_public @*/ String surname;
	/*@ spec_public @*/ String username;
	/*@ spec_public @*/ String dateOfBirth;
	/*@ spec_public @*/ String mail;
	/*@ spec_public @*/ String password;
	
	/*@ spec_public @*/ String array[];
	
	
	SignupActions_V(String name,String surname,	String username,String dateOfBirth,	String mail,String password){
		array = new String[5];
		array[0] = "isaacmaffo96";
		array[1] = "supermario";
		array[2] = "pacman";
		array[3] = "luigi";
		array[4] = "guest";

		this.name = name;
		this.surname = surname;
		this.username = username;
		this.dateOfBirth = dateOfBirth;
		this.mail = mail;
		this. password = password;
	}
	
	//@ ensures (name == "" || surname == "" || username == "" || dateOfBirth == "" || mail == ""|| password == "") ==> \result == "Please fill in all fields";
	//@ ensures !(name == "" || surname == "" || username == "" || dateOfBirth == "" || mail == ""|| password == "") ==> \result == "fields ok";
	String chekFields() {
		// fields check
		if (name == "" || surname == "" || username == "" || dateOfBirth == "" || mail == ""|| password == "") {
			return "Please fill in all fields";
		}
		return "fields ok";
	}
	
	
	//@ requires array != null && array.length == 5;
	//@ requires username != null;
	// @ ensures ((\exists int j; j>=0 && j<5; array[j] == username) ==> \result == "Username already taken");
	//@ ensures (!(\exists int j; j>=0 && j<5; array[j] == username) ==> \result == "username ok");
	//@ normal_behavior
	String checkUsername() {
		// username check
		int i = 0;
		//@ loop_invariant array !=null && 0 <= i && i <= array.length;
		while (i < array.length) {
			if (array[i] == username) {
				return "Username already taken";
			}
			i++;
		}
		return "username ok";
	}
	
	
	String checkdateOfBirth() {
		// dateOfBirth check
		if (!dateOfBirth.matches("(\\d){4}(\\-)(\\d){2}(\\-)(\\d){2}")) { // YYYY-MM-DD
			return "Date format YYYY-MM-DD";
		}
		return "date of birth ok";
	}

	String checkMail() {
		// mail check
		if (!mail.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			return "Incorrect mail format";
		}
		return "mail ok";
	}
	
	
	String checkPassword() {
		// password check
		
		// must contain at least one digit [0-9]
		// must contain at least one lowercase Latin character [a-z]
		// must contain at least one uppercase Latin character [A-Z]
		// must contain at least one special character [!@#&()–_[{}]:;',?/*~$^+=<>]
		// must contain a length of at least 8 characters and a maximum of 20 characters
		if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–_[{}]:;',?/*~$^+=<>]).{8,20}$")) {
			return "Password not valid";
		}
		return "password ok";
	}

}
