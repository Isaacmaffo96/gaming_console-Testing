package main;

import login.CredentialsMap;
import login.SignupFrame;
import login.LoginFrame;

public class main_test {

	public static void main(String[] args) {
		
				
		CredentialsMap idandPasswords = new CredentialsMap();
						
		LoginFrame loginFrame = new LoginFrame(idandPasswords.getLoginCredentials());
		SignupFrame signupFrame = new SignupFrame(idandPasswords.getLoginCredentials());
	}

}
