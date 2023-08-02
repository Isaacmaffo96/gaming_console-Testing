package snake;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SnakeFrame extends JFrame{

	SnakePanel snakePanel;
	
	SnakeFrame(SnakeGame snakeGame){
		
		this.snakePanel = new SnakePanel(snakeGame);
		this.add(snakePanel);
		this.setTitle("Snake");
		this.setIcon();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	private void setIcon() {
		ImageIcon image = new ImageIcon("snake.png");
		this.setIconImage(image.getImage());
	}

}