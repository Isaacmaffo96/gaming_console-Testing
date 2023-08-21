package snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class SnakePanel_V extends JPanel implements ActionListener{

	/*@ spec_public*/ static final int SCREEN_WIDTH = 900;
	/*@ spec_public*/ static final int SCREEN_HEIGHT = 506;
	/*@ spec_public*/ static final int UNIT_SIZE = 50;
	/*@ spec_public*/ static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
	static final int DELAY = 175;
	/*@ spec_public*/ final int x[] = new int[GAME_UNITS];
	/*@ spec_public*/ final int y[] = new int[GAME_UNITS];
	/*@ spec_public*/ int bodyParts = 6;
	/*@ spec_public*/ int applesEaten = 0;
	/*@ spec_public*/ int score = 0;
	/*@ spec_public*/ int appleX;
	/*@ spec_public*/ int appleY;
	/*@ spec_public*/ char direction = 'R';
	/*@ spec_public*/ boolean running = false;
	Timer timer;
	Random random;
	
	// invariants:
	// x not null and length x[] == GAME_UNITS
	//@ public invariant x != null && x.length == GAME_UNITS;
	// y not null and length y[] == GAME_UNITS
	//@ public invariant y != null && y.length == GAME_UNITS;
	// bodyParts >= 6
	//@ public invariant bodyParts >= 6;
	// applesEaten >= 0
	//@ public invariant applesEaten >= 0;
	// appleX 0 <= appleX <= (SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE
	//@ public invariant appleX >= 0 && appleX <= (SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
	// appleY 0 <= appleY <= (SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE
	//@ public invariant appleY >= 0 && appleY <= (SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
	// score >= 0
	//@ public invariant score >= 0;
	// direction = 'U' or 'D' or 'R' or 'L'
	//@ public invariant direction =='U' || direction =='D' || direction =='R' || direction =='L';
	
	SnakePanel_V(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		//this.setBackground(Color.black);
		this.setFocusable(true);
		startGame();
	}
	
	public void startGame() {
		firstApple(); // for testing purposes only
		//newApple();
		running = true;
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		
		if(running) {
			
			//g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
			
			//@ loop_invariant i>=0 && i<=bodyParts;
			for(int i = 0; i< bodyParts;i++) {
				if(i == 0) {
					//g.setColor(Color.green);
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE); // or FillRect []
				}
				else {
					//g.setColor(new Color(45,180,0));
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}			
			}
			//g.setColor(Color.white);
			g.setFont( new Font("Bernard MT Condensed",Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		}
		else {
			gameOver(g);
		}
		
	}
	
	// for testing purposes only
	public void firstApple() {
		appleX = 1*UNIT_SIZE;
		appleY = 0*UNIT_SIZE;
	}
	
	public void newApple(){
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
	
	// postconditions:
	// x[i] = x[i-1] for (i = bodyParts;i>0;i--)
	//@ ensures (\forall int j; j> 0 && j <= bodyParts; x[j] == \old(x[j-1]));
	// y[i] = y[i-1] for (i = bodyParts;i>0;i--)
	//@ ensures (\forall int j; j> 0 && j <= bodyParts; y[j] == \old(y[j-1]));
	public void move(){
		
		//@ loop_invariant i>=0 && i<=bodyParts;
		for(int i = bodyParts;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
		
	}
	
	// postconditions:
	//@ ensures (x[0] == appleX && y[0] == appleY) ==> (bodyParts == \old(bodyParts) + 1);
	//@ ensures (x[0] == appleX && y[0] == appleY) ==> (applesEaten == \old(applesEaten) + 1);
	public void checkApple() {
		if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}
	
	// postconditions:
	//@ ensures ((\forall int i; i > 0 && i <= bodyParts; (x[0] == x[i]) && (y[0] == y[i])) ==> running == false);
	//@ ensures x[0] < 0 ==> running == false;
	//@ ensures x[0] > SCREEN_WIDTH ==> running == false;
	//@ ensures y[0] < 0 ==> running == false;
	//@ ensures y[0] > SCREEN_HEIGHT ==> running == false;
	public void checkCollisions() {
		
		//@ loop_invariant i>=0 && i<=bodyParts;
		for(int i = bodyParts;i>0;i--) {
			//checks if head collides with body
			if((x[0] == x[i])&& (y[0] == y[i])) {
				running = false;
			}
		}
		//check if head touches left border
		if(x[0] < 0) {
			running = false;
		}
		//check if head touches right border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		//check if head touches top border
		if(y[0] < 0) {
			running = false;
		}
		//check if head touches bottom border
		if(y[0] > SCREEN_HEIGHT) {
			running = false;
		}
		
		if(!running) {
			timer.stop();
		}
	}
	
	public void gameOver(Graphics g) {
		//Score
		score = applesEaten;
		//g.setColor(Color.red);
		g.setFont( new Font("Bernard MT Condensed",Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		//Game Over text
		//g.setColor(Color.red);
		g.setFont( new Font("Bernard MT Condensed",Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}
	
	// preconditions:
	// d = 'U' or 'D' or 'R' or 'L'
	//@ requires d =='L' || d =='R' || d =='U' || d =='D';
	
	// postconditions:
	// direction = 'U' or 'D' or 'R' or 'L'
	//@ ensures direction =='L' || direction =='R' || direction =='U' || direction =='D';
	public void setDirection(char d) {
		switch(d) {
		case 'L':
			if(direction != 'R')
				direction = 'L';
			break;
		case 'R':
			if(direction != 'L')
				direction = 'R';
			break;
		case 'U':
			if(direction != 'D') 
				direction = 'U';
			break;
		case 'D':
			if(direction != 'U')
				direction = 'D';
			break;
		}
	}
	
}