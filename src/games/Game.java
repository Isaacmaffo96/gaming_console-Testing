package games;

import javax.swing.ImageIcon;

public class Game {
	
	private String name;
	private int maxscore;
	private ImageIcon icon;
	
	Game(String name, int maxscore) {
		this.name = name;
		this.maxscore = maxscore;
	}
	
	public Game(String name) {
		this(name, 0);
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
		this.maxscore = maxscore;
	}

}
