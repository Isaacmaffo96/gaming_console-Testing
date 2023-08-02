package login;

import java.awt.Color;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class SignupActions {
	
	SignupFrame signupFrame;
	
	SignupActions(SignupFrame signupFrame){
		this.signupFrame = signupFrame;
	}
	
	int signupButtonAction() {
		String name = signupFrame.nameField.getText();
		String surname = signupFrame.surnameField.getText();
		String username = signupFrame.usernameField.getText().toLowerCase().trim();
		String dateOfBirth = signupFrame.dateOfBirthField.getText();
		String mail = signupFrame.mailField.getText().toLowerCase().trim();
		String password = String.valueOf(signupFrame.passwordField.getPassword());
		signupFrame.messageLabel.setForeground(Color.red);

		// fields check
		if (name.isEmpty() || surname.isEmpty() || username.isEmpty() || dateOfBirth.isEmpty() || mail.isEmpty()
				|| password.isEmpty()) {
			signupFrame.messageLabel.setText("Please fill in all fields");
			return 1; // error
		}

		// username check
		if (signupFrame.credentialsMap.containsKey(username)) {
			signupFrame.messageLabel.setText("Username already used");
			return 1; // error
		}

		// dateOfBirth check
		if (!dateOfBirth.matches("(\\d){4}(\\-)(\\d){2}(\\-)(\\d){2}")) { // YYYY-MM-DD
			signupFrame.messageLabel.setText("Date format YYYY-MM-DD");
			/* JOptionPane.showMessageDialog(signupFrame, "Date format YYYY-MM-DD\nexample: 1992-12-22",
					"Date of Birth Field Error", JOptionPane.ERROR_MESSAGE);
			 * automated tests cannot close the show message dialog once opened */
			return 1; // error
		}

		// mail check
		if (!mail.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			signupFrame.messageLabel.setText("Incorrect mail format");
			return 1; // error
		}

		// password check
		// must contain at least one digit [0-9]
		// must contain at least one lowercase Latin character [a-z]
		// must contain at least one uppercase Latin character [A-Z]
		// must contain at least one special character [!@#&()–_[{}]:;',?/*~$^+=<>]
		// must contain a length of at least 8 characters and a maximum of 20 characters
		if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–_[{}]:;',?/*~$^+=<>]).{8,20}$")) {
			signupFrame.messageLabel.setText("Password not valid");
			/* JOptionPane.showMessageDialog(signupFrame,
					"The password:\r\n" + "must contain at least one digit [0-9];\r\n"
							+ "must contain at least one lowercase Latin character [a-z];\r\n"
							+ "must contain at least one uppercase Latin character [A-Z];\r\n"
							+ "must contain at least one special character [!@#&()–_[{}]:;',?/*~$^+=<>];\r\n"
							+ "must contain a length of at least 8 characters and a maximum of 20 characters.",
					"Password Field Error", JOptionPane.ERROR_MESSAGE);
			* automated tests cannot close the show message dialog once opened */
			return 1; // error
		}

		Person newUser = new Person(name, surname, username, LocalDate.parse(dateOfBirth), mail, password);
		signupFrame.credentialsMap.put(username, newUser);
		signupFrame.messageLabel.setForeground(Color.green);
		signupFrame.messageLabel.setText("Account created successfully");
		/*JOptionPane.showMessageDialog(signupFrame, "Account created successfully,\nyou can now complete the login.",
		 		"Signed up!", JOptionPane.INFORMATION_MESSAGE);
		 * automated tests cannot close the show message dialog once opened */
		try {
			TimeUnit.SECONDS.sleep(1);
			// wait a second to close the frame so that the message can be read
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		signupFrame.dispose();
		return 0; // success
	}
	
}
