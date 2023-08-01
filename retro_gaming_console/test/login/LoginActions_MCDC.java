package login;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoginActions_MCDC {
	
	SetupFacade setupFacade;
	LoginFrame loginFrame;
	
	@Before
	public void initFrame(){
		setupFacade = SetupFacade.createSetupFacade();
		loginFrame = new LoginFrame(setupFacade);
	}

	@Test
	public void test1() {
		
		setupFacade.initMap();
		
		/* if(!(loginFrame.credentialsMap.isEmpty()) &&
		 *		(((loginFrame.credentialsMap.containsKey(userID)) 
		 *		&& (loginFrame.credentialsMap.get(userID)).getPassword().equals(password)) 
		 *		|| (userID.equals("guest") && password.equals("guest")))){
		 * 
		 * 
		 * MCDC: (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))  	| Decisione
		 *  1	  T		F				F				-				F			-				|	F
		 *  2	  T		F				T				F				F			-				|	F
		 *  3	  T		F				T				T				-			-				|   T
		 *  4	  T		F				F				-				T			F				|	F
		 *  5	  T		F				F				-				T			T				|	T
		 *  6	  F		T				-				-				-			-				|	F
		 */
		
		LoginActions l1 = new LoginActions(loginFrame);
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))  	| Decisione
		 *   1	  T		F				F				-				F			-				|	F
		 */	 
		loginFrame.userIDField.setText("Isaac"); // wrong ID
		loginFrame.userPasswordField.setText("Password"); // wrong Password
		l1.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful"); // False
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))  	| Decisione
		 *  2	  T		F				T				F				F			-				|	F
		 */	
		loginFrame.userIDField.setText("Isaacmaffo96"); // correct ID
		loginFrame.userPasswordField.setText("Password"); // wrong Password
		l1.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful"); // False
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))  	| Decisione
		 *  3	  T		F				T				T				-			-				|   T
		 */	
		loginFrame.userIDField.setText("Isaacmaffo96"); // correct ID
		loginFrame.userPasswordField.setText("Im_1041473"); // correct password
		l1.loginButtonAction();
		assertEquals(loginFrame.messageLabel.getText(),"Login successful"); // True
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))  	| Decisione
		 *  4	  T		F				F				-				T			F				|	F
		 */	
		loginFrame.userIDField.setText("guest"); // correct guest ID
		loginFrame.userPasswordField.setText("Password"); // wrong guest password
		l1.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful"); // False
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))  	| Decisione
		 *  5	  T		F				F				-				T			T				|	T
		 */	
		loginFrame.userIDField.setText("guest"); // correct guest ID
		loginFrame.userPasswordField.setText("guest"); // correct guest password
		l1.loginButtonAction();
		assertEquals(loginFrame.messageLabel.getText(),"Login successful"); // True
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))  	| Decisione
		 *  6	  F		T				-				-				-			-				|	F
		 */	
		setupFacade.resetMap(); // Map empty
		l1.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful");	// False
	}

	@Test
	public void test2() {
		
		setupFacade.initMap();
		
		/*  if (userID.equals("guest") && password.equals("guest"))
		 * 
		 * MCDC: ((ID_guest && Password_guest))  	| Decisione
		 *  1	  	  F				-				|	F
		 *  2	      T				F				|	F
		 *  3		  T				T				|	T
		 */
		
		LoginActions l2 = new LoginActions(loginFrame);
		
		/* MCDC: ((ID_guest && Password_guest))  	| Decisione
		 *  1	  	  F				(F)				|	F
		 */	
		loginFrame.userIDField.setText("NOTguest"); // wrong guest ID
		loginFrame.userPasswordField.setText("WrongPassword"); // wrong guest password
		l2.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful"); // False
		
		/* MCDC: ((ID_guest && Password_guest))  	| Decisione
		 *  2		  T				F				|	F
		 */	
		loginFrame.userIDField.setText("guest"); // correct guest ID
		loginFrame.userPasswordField.setText("WrongPassword"); // wrong guest password
		l2.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful"); // False
		
		/* MCDC: ((ID_guest && Password_guest))  	| Decisione
		 *  3	      T				T				|	T
		 *  
		 *  if (loginFrame.credentialsMap.containsKey("guestUser")) | Decisione
		 *  						T								|	T
		 */	
		loginFrame.userIDField.setText("guest"); // correct guest ID
		loginFrame.userPasswordField.setText("guest"); // correct guest password
		l2.loginButtonAction();
		assertEquals(loginFrame.messageLabel.getText(),"Login successful"); // True
		
		/* if (loginFrame.credentialsMap.containsKey("guestUser"))  | Decisione
		 *  						F								|	F 
		 */
		setupFacade.getCredentialsMap().remove("guestuser");
		loginFrame.userIDField.setText("guest"); // correct guest ID
		loginFrame.userPasswordField.setText("guest"); // correct guest password
		l2.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful"); // False
		assertEquals(loginFrame.messageLabel.getText(),"An error has occurred"); // True	
		
		
		/* 100% Condition coverage
		 * (userID.equals("guest") & password.equals("guest"))
		 *  bitwise operator & to avoid the short circuit evaluation
		 *  in order to cover all the conditions in testing
		 *  
		 *  #    ((ID_guest & Password_guest))  	| Decisione
		 *  4	      F				T				|	F
		 */
		loginFrame.userIDField.setText("NOTguest"); // wrong guest ID
		loginFrame.userPasswordField.setText("guest"); // correct guest password
		l2.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful"); // False
		
		
	}

	@Test
	public void test3() {
		
		setupFacade.initMap();
		
		/* else if (!(loginFrame.credentialsMap.isEmpty()) &&
		 *		((loginFrame.credentialsMap.containsKey(userID) &&
		 *		!(loginFrame.credentialsMap.get(userID)).getPassword().equals(password))
		 *		|| (userID.equals("guest") && !(password.equals("guest"))))) {
		 * 
		 * 
		 * MCDC: (! (Map_Empty) && ((Map_UserID && !(Map_Password)) || (ID_guest && !(Password_guest))) | Decisione
		 *  1	  T		F				F		   -		-				F		-		-			|	F
		 *  2	  T		F				T		   F		T				F		-		-			|	F
		 *  3	  T		F				T		   T		F				-		-		-			|   T
		 *  4	  T		F				F		   -		-				T		F		T			|	F
		 *  5	  T		F				F		   -		-				T		T		F			|	T
		 *  6	  F		T				-		   -		-				-		-		-			|	F
		 */
		
		LoginActions l3 = new LoginActions(loginFrame);
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && !(Map_Password)) || (ID_guest && !(Password_guest))) | Decisione
		 *  1	  T		F				F		   -		-				F		-		-			|	F
		 */	 
		loginFrame.userIDField.setText("Isaac"); // wrong ID
		loginFrame.userPasswordField.setText("Password"); // wrong Password
		l3.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Wrong password"); // False
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && !(Map_Password)) || (ID_guest && !(Password_guest))) | Decisione
		 *  2	  T		F				T		   F		T				F		-		-			|	F
		 */	
		loginFrame.userIDField.setText("Isaacmaffo96"); // correct ID
		loginFrame.userPasswordField.setText("Im_1041473"); // correct Password
		l3.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Wrong password"); // False
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && !(Map_Password)) || (ID_guest && !(Password_guest))) | Decisione
		 *  3	  T		F				T		   T		F				-		-		-			|   T
		 */	
		loginFrame.userIDField.setText("Isaacmaffo96"); // correct ID
		loginFrame.userPasswordField.setText("Password"); // wrong password
		l3.loginButtonAction();
		assertEquals(loginFrame.messageLabel.getText(),"Wrong password"); // True
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && !(Map_Password)) || (ID_guest && !(Password_guest))) | Decisione
		 *  4	  T		F				F		   -		-				T		F		T			|	F
		 */	
		loginFrame.userIDField.setText("guest"); // correct guest ID
		loginFrame.userPasswordField.setText("guest"); // correct guest password
		l3.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Wrong password"); // False
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && !(Map_Password)) || (ID_guest && !(Password_guest))) | Decisione
		 *  5	  T		F				F		   -		-				T		T		F			|	T
		 */	
		loginFrame.userIDField.setText("guest"); // correct guest ID
		loginFrame.userPasswordField.setText("Password"); // wrong guest password
		l3.loginButtonAction();
		assertEquals(loginFrame.messageLabel.getText(),"Wrong password"); // True
		
		/* MCDC: (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))  	| Decisione
		 *  6	  F		T				-				-				-			-				|	F
		 */	
		setupFacade.resetMap(); // map empty
		l3.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Wrong password"); // False
	}

}
