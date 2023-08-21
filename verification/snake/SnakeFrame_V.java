package snake;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SnakeFrame_V extends JFrame{

	SnakePanel_V snakePanel_V;
	
	SnakeFrame_V(){
		
		this.snakePanel_V = new SnakePanel_V();
		this.add(snakePanel_V);
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