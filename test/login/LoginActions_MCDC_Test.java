package login;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoginActions_MCDC_Test {

	SetupFacade setupFacade;
	LoginFrame loginFrame;
	
	@Before
	public void initFrame(){
		setupFacade = SetupFacade.createSetupFacade();
		loginFrame = new LoginFrame(setupFacade);
		setupFacade.initMap();
	}
	
	
	/* MCDC TEST 1
	 * 
	 * if(!(loginFrame.credentialsMap.isEmpty()) &&
	 *		(((loginFrame.credentialsMap.containsKey(userID)) 
	 *		&& (loginFrame.credentialsMap.get(userID)).getPassword().equals(password)) 
	 *		|| (userID.equals("guest") && password.equals("guest")))){
	 * 
	 *  # = number of test case
	 *  #  (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))	| Decision
	 *  1	F		T				-				-				-			-			|	F
	 *  2	T		F				T				F				-			-			|	F
	 *  3	T		F				T				T				-			-			|	T
	 *  4	T		F				F				-				F			-			|	F
	 *  5	T		F				F				-				T			T			|	T
	 *  6	T		F				F				-				T			F			|	F
	 */
	
	
	/* #   (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))	| Decision
	 * 1	F		T				-				-				-			-			|	F		*/ 
	@Test
	public final void mcdc1_test_1() {
		setupFacade.resetMap(); // Map empty
		LoginActions l1 = new LoginActions(loginFrame);
		l1.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful");	// False
	}
	
	/* #   (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))	| Decision
	 * 2	T		F				T				F				-			-			|	F		*/ 
	@Test
	public final void mcdc1_test_2() {
		LoginActions l2 = new LoginActions(loginFrame);
		loginFrame.userIDField.setText("Isaacmaffo96"); // correct ID
		loginFrame.userPasswordField.setText("Password"); // wrong Password
		l2.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful"); // False
	}
	
	/* #   (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))	| Decision
	 * 3	T		F				T				T				-			-			|	T		*/ 
	@Test
	public final void mcdc1_test_3() {
		LoginActions l3 = new LoginActions(loginFrame);
		loginFrame.userIDField.setText("Isaacmaffo96"); // correct ID
		loginFrame.userPasswordField.setText("Im_1041473"); // correct password
		l3.loginButtonAction();
		assertEquals(loginFrame.messageLabel.getText(),"Login successful"); // True
	}
	
	/* #   (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))	| Decision
	 * 4	T		F				F				-				F			-			|	F		*/ 
	@Test
	public final void mcdc1_test_4() {
		LoginActions l4 = new LoginActions(loginFrame);
		loginFrame.userIDField.setText("Isaac"); // wrong ID and wrong ID_guest
		loginFrame.userPasswordField.setText(""); // - Password
		l4.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful"); // False
	}
	
	/* #   (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))	| Decision
	 * 5	T		F				F				-				T			T			|	T		*/ 
	@Test
	public final void mcdc1_test_5() {
		LoginActions l5 = new LoginActions(loginFrame);
		loginFrame.userIDField.setText("guest"); // correct guest ID
		loginFrame.userPasswordField.setText("guest"); // correct guest password
		l5.loginButtonAction();
		assertEquals(loginFrame.messageLabel.getText(),"Login successful"); // True
	}
	
	/* #   (! (Map_Empty) && ((Map_UserID && Map_Password) || (ID_guest && Password_guest))	| Decision
	 * 6	T		F				F				-				T			F			|	F		*/ 
	@Test
	public final void mcdc1_test_6() {
		LoginActions l6 = new LoginActions(loginFrame);
		loginFrame.userIDField.setText("guest"); // correct guest ID
		loginFrame.userPasswordField.setText("Password"); // wrong guest password
		l6.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Login successful"); // False
	}
	
	// Branch Coverage for the nested if:
	/* (loginFrame.credentialsMap.containsKey("guestuser"))
	 *						T							// OK
	 *						F							// needs to modify the map */
	@Test
	public final void map_test() {
		LoginActions l1 = new LoginActions(loginFrame);
		loginFrame.userIDField.setText("guest"); // correct guest ID
		loginFrame.userPasswordField.setText("guest"); // correct guest password
		setupFacade.removeGuest(); // remove guest
		l1.loginButtonAction();
		assertEquals(loginFrame.messageLabel.getText(),"An error has occurred"); // True
	}
	
	/* MCDC TEST 2
	 * 
	 * else if ((loginFrame.credentialsMap.isEmpty()) || ((!loginFrame.credentialsMap.containsKey(userID)) && (!userID.equals("guest"))) ) {
	 * 		loginFrame.messageLabel.setForeground(Color.red);
	 * 		loginFrame.messageLabel.setText("Username not found");
	 * 
	 *	# (Map_Empty || ( (!Map_UserID) && (!ID_guest) ) )	|	Decision
	 *	1		T			-	-			-	-			|		T
	 *	2		F			F	T			-	-			|		F
	 *	3		F			T	F			T	F			|		T
	 *	4		F			T	F			F	T			|		F
	 */
	
	 /*	# (Map_Empty || ( (!Map_UserID) && (!ID_guest) ) )	|	Decision
	  *	1		T				-				-			|		T	*/
	@Test
	public final void mcdc2_test_1() {
		setupFacade.resetMap(); // Map empty
		LoginActions l1 = new LoginActions(loginFrame);
		l1.loginButtonAction();
		assertEquals(loginFrame.messageLabel.getText(),"Username not found"); // True
	}
	
	 /*	# (Map_Empty || ( (!Map_UserID) && (!ID_guest) ) )	|	Decision
	  *	2		F			F	T			-	-			|		F	*/
	@Test
	public final void mcdc2_test_2() {
		LoginActions l2 = new LoginActions(loginFrame);
		loginFrame.userIDField.setText("isaacmaffo96"); // correct ID
		l2.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Username not found"); // False
	}
	
	 /*	# (Map_Empty || ( (!Map_UserID) && (!ID_guest) ) )	|	Decision
	  *	3		F			T	F			T	F			|		T	*/
	@Test
	public final void mcdc2_test_3() {
		LoginActions l3 = new LoginActions(loginFrame);
		loginFrame.userIDField.setText("isaac"); // wrong ID
		l3.loginButtonAction();
		assertEquals(loginFrame.messageLabel.getText(),"Username not found"); // True
	}
	
	 /*	# (Map_Empty || ( (!Map_UserID) && (!ID_guest) ) )	|	Decision
	  *	4		F			T	F			F	T			|		F	*/
	@Test
	public final void mcdc2_test_4() {
		LoginActions l4 = new LoginActions(loginFrame);
		loginFrame.userIDField.setText("guest"); // correct guest ID
		l4.loginButtonAction();
		assertNotEquals(loginFrame.messageLabel.getText(),"Username not found"); // False
	}
	
	// Statement Cover
	
	@Test
	public final void statement_test1() {
		LoginActions l1 = new LoginActions(loginFrame);
		l1.guestButtonAction();
		assertEquals(loginFrame.messageLabel.getText(),"Guest login successful"); // True
	}
	
	@Test
	public final void statement_test2() {
		LoginActions l2 = new LoginActions(loginFrame);
		l2.resetButtonAction();
		assertEquals(loginFrame.userIDField.getText(),""); // True
		assertEquals(String.valueOf(loginFrame.userPasswordField.getPassword()),""); // True
		assertEquals(loginFrame.messageLabel.getText(),""); // True
	}
	
	// 100% Statement
	// 100% Branch
	// 100% Term
	
}
