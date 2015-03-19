import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG, dominic.pfister@bbcag.ch
 * @version 1.0
 */

public class Player {
	
	//Variablen
	private int xPos = 20;
	@SuppressWarnings("unused")
	private int yPos;
	private Image image;
	private String pfad;
	private int xMove;
	private int yMove;
	private int playerSpeed;
	private int playerSpeedDown = 1; //Gravity
//  private boolean playerDead; TODO

	public Player() {
		this.setPfad("Triangle.png"); //Setzt den Pfad für das Bild
		ImageIcon ii = new ImageIcon(this.getClass().getResource(pfad));
		this.setImage(ii.getImage()); //Wandelt das Bild in ein ImageIcon um
	}
	
	public void move() {
		xPos += xMove;
		yPos += yMove + playerSpeedDown;
	}
	
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			xMove = 1 * -(playerSpeed); //Geschwindigkeit nach Links
		}

		if (key == KeyEvent.VK_RIGHT) {
			xMove = 1 * playerSpeed; //Geschwindigkeit nach rechts
		}

	}

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
	
	//Getter und setter
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public String getPfad() {
		return pfad;
	}

	public void setPfad(String pfad) {
		this.pfad = pfad;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	
}
