import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG, dominic.pfister@bbcag.ch
 *
 */

public class Player {
	private int x;
	private int y;
	private Image image;
	private String pfad;
	private int dx = 0;
	private int dy = 0;


	public Player() {
		this.setPfad("Triangle.png"); //Setzt den Pfad für den Sprite
        ImageIcon ii = new ImageIcon(this.getClass().getResource(pfad));
		this.setImage(ii.getImage()); //Wandelt ImageIcon in Image um
	}
	
	public void move() {
        x += dx;
        y += dy;
    }
	
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = -3;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 3;
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}
	
	public void resetState(){
		this.setX(518 / 2);
		this.setY(500);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getPfad() {
		return pfad;
	}

	public void setPfad(String pfad) {
		this.pfad = pfad;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

}