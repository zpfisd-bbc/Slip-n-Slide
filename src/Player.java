import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG, dominic.pfister@bbcag.ch
 * @version 1.0
 */

public class Player {
	
	//Variablen
	private int xPos = 20;
	private int yPos;
	private Image image;
	private int xMove;
	private int yMove;
	private int playerSpeedLeft = 7; //Links und Rechts Geschwindigkeit
	private int playerSpeedRight = 7;
	private int playerSpeedDown = 10; //Gravity

	public Player() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/Triangle.png"));
		this.setImage(ii.getImage()); //Wandelt das Bild in ein ImageIcon um
	}
	
	
	/**
	 * 
	 * Moves the Player-Sprite with x and y
	 * 
	 */
	public void move() {
		xPos += xMove;
		yPos += yMove + playerSpeedDown;
	}
	
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			xMove = 1 * -(playerSpeedLeft); //Geschwindigkeit nach Links
		}

		if (key == KeyEvent.VK_RIGHT) {
			xMove = 1 * playerSpeedRight; //Geschwindigkeit nach rechts
		}

	}

	
	/**
	 * 
	 * checks if the key is released
	 * 
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		//Wenn losgelassen wird, wird die Geschwindigkeit auf 0 gesetzt
		if (key == KeyEvent.VK_LEFT) {
			xMove = 0; 
		}

		if (key == KeyEvent.VK_RIGHT) {
			xMove = 0;
		}
	}
	
	/**
	 * 
	 * Returns a rectangular shape with the bounds of the Image
	 * 	
	 */
    public Rectangle getBoundsPlayer() {
        return new Rectangle(this.getxPos(), this.getyPos(), image.getWidth(null), image.getHeight(null));
    }

	
	//Getter und setter
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getxMove() {
		return xMove;
	}

	public void setxMove(int xMove) {
		this.xMove = xMove;
	}

	public int getyMove() {
		return yMove;
	}

	public void setyMove(int yMove) {
		this.yMove = yMove;
	}

	public int getPlayerSpeedLeft() {
		return playerSpeedLeft;
	}

	public void setPlayerSpeedLeft(int playerSpeedLeft) {
		this.playerSpeedLeft = playerSpeedLeft;
	}
	
	public int getPlayerSpeedRight() {
		return playerSpeedRight;
	}

	public void setPlayerSpeedRight(int playerSpeedRight) {
		this.playerSpeedRight = playerSpeedRight;
	}

	public int getPlayerSpeedDown() {
		return playerSpeedDown;
	}

	public void setPlayerSpeedDown(int playerSpeedDown) {
		this.playerSpeedDown = playerSpeedDown;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	
}