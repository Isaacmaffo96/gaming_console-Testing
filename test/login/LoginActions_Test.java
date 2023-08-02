package login;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoginActions_Test {
	
	SetupFacade setupFacade;
	LoginFrame loginFrame;
	
	@Before
	public void initFrame(){
		setupFacade = SetupFacade.createSetupFacade();
		loginFrame = new LoginFrame(setupFacade);
	}

	@Test
	public void reset_test() {
		
		setupFacade.initMap();
				
		LoginActions l1 = new LoginActions(loginFrame);
		
		loginFrame.userIDField.setText("User1"); // id
		loginFrame.userPasswordField.setText("Password1"); // password
		loginFrame.messageLabel.setText("Message"); // message
		l1.resetButtonAction();
		// check if the fields have been cleared
		assertEquals(loginFrame.userIDField.getText(), "");
		assertEquals(String.valueOf(loginFrame.userPasswordField.getPassword()),"");
		assertTrue(loginFrame.messageLabel.getText().equals(""));
		
	}
	
	@Test
	public void guest_test() {
	
		setupFacade.initMap();
		
		LoginActions l2 = new LoginActions(loginFrame);
		
		l2.guestButtonAction();
		// check if the games scores have been cleared
		assertEquals(loginFrame.user.getScores().getGame1Score(),0);
		assertEquals(loginFrame.user.getScores().getGame2Score(),0);
		// check the login procedure
		assertEquals(loginFrame.messageLabel.getText(), "Guest login successful");
		
	}

}
