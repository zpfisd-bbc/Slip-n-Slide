import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG, dominic.pfister@bbcag.ch
 * @version 1.0
 */

public class Line {
	
	//Variablen
	private int zufallsZahl;
	private String pfad1; //Pfad für Linie 1
	private String pfad2; //Pfad für Linie 2
	private Image imageL;
	private Image imageR;
	private Image borderL;
	private Image borderR;
	private static int linienAbstand = 100;
	private static int x = 20;
	private int y = 100;
	private int yMove;
	private int scrollSpeed = 1; //Geschwindigkeit für Bewegen von Linien
	private int lastZahl; //Speichert die letzte Zufallszahl
	
	public Line() {
		this.randomZahl(5);
		this.pathSelector();
        ImageIcon lnL = new ImageIcon(this.getClass().getResource(pfad1));
        ImageIcon lnR = new ImageIcon(this.getClass().getResource(pfad2));
        ImageIcon borderL = new ImageIcon(this.getClass().getResource("/images/border_left.jpg"));
        ImageIcon borderR = new ImageIcon(this.getClass().getResource("/images/border_right.jpg"));
		this.setImageL(lnL.getImage());
		this.setImageR(lnR.getImage());
		this.setBorderL(borderL.getImage());
		this.setBorderL(borderR.getImage());
		this.setLastZahl(zufallsZahl);
	}
	
    /**
     * Moves the line
    */
	public void move() {
		y += - scrollSpeed;  
	}
	
    /**
     * Selects a random number between 1 and "maxZahl"
     *
     * @param  maxZahl highest possible number
     */
	public void randomZahl(int maxZahl) { 
		Random rz = new Random();
		zufallsZahl = rz.nextInt(maxZahl) + 1;
	}
	
    /**
     * Selects the path for images
     */
	public void pathSelector() {
		switch (zufallsZahl) {
		case 1:
			this.setPfad1("/images/0px.png");
			this.setPfad2("/images/400px.jpg");
			break;
		case 2:
			this.setPfad1("/images/100px.jpg");
			this.setPfad2("/images/300px.jpg");
			break;
		case 3:
			this.setPfad1("/images/200px.jpg");
			this.setPfad2("/images/200px.jpg");
			break;
		case 4:
			this.setPfad1("/images/300px.jpg");
			this.setPfad2("/images/100px.jpg");
			break;
		case 5:
			this.setPfad1("/images/400px.jpg");
			this.setPfad2("/images/0px.png");
			break;
		}
		System.out.println(zufallsZahl);
	}

	
	//Getter und setter
	public String getPfad1() {
		return pfad1;
	}

	public void setPfad1(String pfad1) {
		this.pfad1 = pfad1;
	}

	public String getPfad2() {
		return pfad2;
	}

	public void setPfad2(String pfad2) {
		this.pfad2 = pfad2;
	}

	public int getZufallsZahl() {
		return zufallsZahl;
	}

	public void setZufallsZahl(int zufallsZahl) {
		this.zufallsZahl = zufallsZahl;
	}
	
	public int getY() {
		return y;
	}

	
	public void setY(int y) {
		this.y = y;
	}

	
	public int getyMove() {
		return yMove;
	}

	
	public void setyMove(int yMove) {
		this.yMove = yMove;
	}

	
	public int getScrollSpeed() {
		return scrollSpeed;
	}

	
	public void setScrollSpeed(int scrollSpeed) {
		this.scrollSpeed = scrollSpeed;
	}

	
	public static int getLinienAbstand() {
		return linienAbstand;
	}

	
	public static void setLinienAbstand(int linienAbstand) {
		Line.linienAbstand = linienAbstand;
	}

	
	public Image getImageL() {
		return imageL;
	}

	public void setImageL(Image imageL) {
		this.imageL = imageL;
	}

	public Image getImageR() {
		return imageR;
	}

	public void setImageR(Image imageR) {
		this.imageR = imageR;
	}

	public Image getBorderL() {
		return borderL;
	}

	public void setBorderL(Image borderL) {
		this.borderL = borderL;
	}

	public Image getBorderR() {
		return borderR;
	}

	public void setBorderR(Image borderR) {
		this.borderR = borderR;
	}

	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		Line.x = x;
	}

	public int getLastZahl() {
		return lastZahl;
	}

	public void setLastZahl(int lastZahl) {
		this.lastZahl = lastZahl;
	}
	
	
}