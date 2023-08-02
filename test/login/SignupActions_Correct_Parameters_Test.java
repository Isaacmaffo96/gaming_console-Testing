package login;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/* test the normal behavior of the sign up action
 * with correct format of the field
 * output message: "Account created successfully"
 * return value: 0
 */
@RunWith(Parameterized.class)
public class SignupActions_Correct_Parameters_Test {
	
	SetupFacade setupFacade;
	SignupFrame signupFrame;
	String name;
	String surname;
	String username;
	String dateOfBirth;
	String mail;
	String password;
	SignupActions s1;
	
	@Before
	public void initFrame(){
		this.setupFacade = SetupFacade.createSetupFacade();
		this.signupFrame = new SignupFrame(setupFacade.getCredentialsMap());
	}
	
	@Parameters
	public static Collection <String[]> setCorrectParameters(){
		List<String[]> params = new ArrayList<>();
		params.add(new String[] {"Mario","Rossi","mariorossi23","1992-04-09","mariorossi@gmail.com","MarioRossi_23"});
		params.add(new String[] {"Bianca","Ferrari","biancaaa","2001-09-04","biancaf@hotmail.it","BF!2001!bf"});
		params.add(new String[] {"Luigi","Verdi","verdeluigi","1982-10-22","verdeluigi@mail.com","_VerdE-82_"});
		return params;
	}
	
	public SignupActions_Correct_Parameters_Test(String name, String surname, String username, String dateOfBirth, String mail, String password ) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.dateOfBirth = dateOfBirth;
		this.mail = mail;
		this.password = password;
	}
	
	@Test
	public void correct_test() {
		
		setupFacade.initMap();
		
		s1 = new SignupActions(signupFrame);
		
		signupFrame.nameField.setText(name);
		signupFrame.surnameField.setText(surname);
		signupFrame.usernameField.setText(username);
		signupFrame.dateOfBirthField.setText(dateOfBirth);
		signupFrame.mailField.setText(mail);
		signupFrame.passwordField.setText(password);
		
		int result1 = s1.signupButtonAction();
		assertEquals(result1, 0);
		assertEquals(signupFrame.messageLabel.getText(),"Account created successfully");
	}

}
