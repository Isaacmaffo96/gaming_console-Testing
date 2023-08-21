package snake;

import java.util.concurrent.TimeUnit;

public class SnakePanelVerification {
	
	public static void main(String[] args) {
		
		
		SnakeFrame_V snakeFrame_V = new SnakeFrame_V();
		
		try {
		    TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		
		snakeFrame_V.snakePanel_V.setDirection('D');
		
		try {
		    TimeUnit.MILLISECONDS.sleep(1200);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
			
		snakeFrame_V.snakePanel_V.setDirection('R');
		
		try {
		    TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		
		snakeFrame_V.snakePanel_V.setDirection('R');
		snakeFrame_V.snakePanel_V.setDirection('U');
		
		try {
		    TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		
		snakeFrame_V.snakePanel_V.setDirection('R');
		
		try {
		    TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}

		snakeFrame_V.snakePanel_V.setDirection('D');


		/* I simulate the behavior of a player pressing the arrow keys

		SetupFacade setupFacade = SetupFacade.createSetupFacade();
		
		@SuppressWarnings("unused")
		GamesFrame gamesFrame = new GamesFrame(setupFacade.getCredentialsMap().get("isaacmaffo96"), setupFacade.getGamesList());
				
		try {
			
	        Robot robot = new Robot();

	        // Simulate a key press
	        robot.keyPress(KeyEvent.VK_ENTER);
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        robot.keyPress(KeyEvent.VK_DOWN);
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        robot.keyPress(KeyEvent.VK_LEFT);
	        robot.keyRelease(KeyEvent.VK_UP);

		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		*/
		
	}
}
