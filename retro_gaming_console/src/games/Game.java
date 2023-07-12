package games;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Game {
	
	private String name;
	private int maxscore;
	private ImageIcon icon;
	
	Game(String name, ImageIcon icon, int maxscore) {
		this.name = name;
		this.maxscore = maxscore;
	}
	
	Game(String name, ImageIcon icon) {
		this(name, icon, 0);
	}
	
	Game(String name) {
		this(name, null, 0);
	}

	public String getName() {
		return name;
	}

	public ImageIcon getIcon() {
		return icon;
	}
	
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
	public boolean iconIsNull() {
		if (this.icon == null)
			return true;
		else
			return false;
	}

	public void setIconByPath(String iconPath) {
		try {
			this.icon = new ImageIcon(iconPath);
		} catch (Exception e) {
			e.printStackTrace();
			this.icon = null;
		}
	}

	public int getMaxscore() {
		return maxscore;
	}

	public void setMaxscore(int maxscore) {
		if (maxscore> this.maxscore)
			this.maxscore = maxscore;
	}

}
