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

/* test the wrong behavior of the sign up action
 * with incorrect format of the field
 * output message: "Please fill in all fields" or "Username already used" or "Date of Birth Field Error" or "Incorrect mail format" or "Password not valid"
 * return value: 1
 */
@RunWith(Parameterized.class)
public class SignupActions_Incorrect_Parameters_Test {
	
	SetupFacade setupFacade;
	SignupFrame signupFrame;
	String name;
	String surname;
	String username;
	String dateOfBirth;
	String mail;
	String password;
	SignupActions s;
	
	@Before
	public void initFrame(){
		this.setupFacade = SetupFacade.createSetupFacade();
		this.signupFrame = new SignupFrame(setupFacade.getCredentialsMap());
	}
	
	@Parameters
	public static Collection <String[]> setParameters(){
		List<String[]> params = new ArrayList<>();
		params.add(new String[] {"Isaac","Maffeis","isaacmaffo96","1996-05-10","isaacmaffo96@gmail.com","Im_1041473"}); // "Username already used"
		params.add(new String[] {"Mario","","mariorossi23","1992-04-09","mariorossi@gmail.com","MarioRossi_23"}); // "One field empty"
		params.add(new String[] {"Bianca","Ferrari","biancaaa","2001/09/04","biancaf@hotmail.it","BF!2001!bf"}); // "Date of Birth Field Error"
		params.add(new String[] {"Luigi","Verdi","verdeluigi","1982-10-22","verdeluigimail.com","_VerdE-82_"}); // "Incorrect mail format"
		params.add(new String[] {"Rosa","Ferrero","rosa01","2000-01-01","rosaferrero@gmail.com","rosaa01"}); // "Password not valid"
		return params;
	}
	
	public SignupActions_Incorrect_Parameters_Test(String name, String surname, String username, String dateOfBirth, String mail, String password ) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.dateOfBirth = dateOfBirth;
		this.mail = mail;
		this.password = password;
	}
	
	@Test
	public void test() {
		
		s = new SignupActions(signupFrame);
		
		signupFrame.nameField.setText(name);
		signupFrame.surnameField.setText(surname);
		signupFrame.usernameField.setText(username);
		signupFrame.dateOfBirthField.setText(dateOfBirth);
		signupFrame.mailField.setText(mail);
		signupFrame.passwordField.setText(password);
		
		int result = s.signupButtonAction();
		assertEquals(result, 1);
		assertNotEquals(signupFrame.messageLabel.getText(),"Account created successfully"); // False
	}

}