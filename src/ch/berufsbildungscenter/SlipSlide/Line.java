package ch.berufsbildungscenter.SlipSlide;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG, dominic.pfister@bbcag.ch
 * @version 1.0
 */


public class Line {
	
	//Variablen
	private static String ordner;
	private static String soundName;
	private int zufallsZahl;
	private int zufallsSound;
	private String pfad1; //Pfad für Linie 1
	private String pfad2; //Pfad für Linie 2
	private String pfadBorderL; //Pfad für Border Links
	private String pfadBorderR; //Pfad für Border Rechts
	private Image imageL;
	private Image imageR;
	private Image borderL;
	private Image borderR;
	private static int linienAbstand = 100;
	private static int x = 7; //Rechter Abstand
	private int y = 200;
	private int yMove;
	private int scrollSpeed = 5; //Geschwindigkeit für Bewegen von Linien
	
	//Konstruktor
	public Line() {
		this.ordnerSelector();
		this.redoLine();
	}
	
	/**
	 * Erstellt eine vorhandene Linie mit neuer Zufallszahl aber ohne neuen Ordner
	 */
	public void redoLine() { //Wird gebraucht falls eine Linie
		this.randomZahl(5); //bereits vorhanden ist
		this.pathSelector();
		this.addImage();
	}
	
	
	//Erstellt Image für Objekt
	public void addImage() {
        ImageIcon lnL = new ImageIcon(this.getClass().getResource(pfad1));
        ImageIcon lnR = new ImageIcon(this.getClass().getResource(pfad2));
        ImageIcon borderL = new ImageIcon(this.getClass().getResource(pfadBorderL));
        ImageIcon borderR = new ImageIcon(this.getClass().getResource(pfadBorderR));
        this.setBorderL(borderL.getImage());
    	this.setBorderL(borderR.getImage());
		this.setImageL(lnL.getImage());
		this.setImageR(lnR.getImage());
	}
	
    /**
     * Bewegt die Linie
    */
	public void move() {
		y += - scrollSpeed;
	}
		
    /**
     * Wählt eine zufällige Zahl zwischen 1 und "maxZahl" aus
     *
     * @param  maxZahl highest possible number
     */
	public void randomZahl(int maxZahl) { 
		Random rz = new Random();
		zufallsZahl = rz.nextInt(maxZahl) + 1;
	}
	
	/**
	 * Wählt den Ordner aufgrund der Zufallszahl für die Grafiken aus
	 */
	public void ordnerSelector () {
			this.randomZahl(5);
		
			switch (zufallsZahl) {
			case 1:
				this.setOrdner("black");
				this.setSoundName("sound/" + ordner + ".wav");
				break;
			case 2:
				this.setOrdner("blue");
				this.setSoundName("sound/" + ordner + ".wav");
				break;
			case 3:
				this.setOrdner("brown");
				this.setSoundName("sound/" + ordner + ".wav");
				break;
			case 4:
				this.setOrdner("orange");
				this.setSoundName("sound/" + ordner + ".wav");
				break;
			case 5:
				this.setOrdner("violet");
				this.setSoundName("sound/" + ordner + ".wav");
				break;
			default:
				this.setOrdner("blue");
				this.setSoundName("sound/" + ordner + ".wav");
				break;
			}
			redoLine();
		}
	
    /**
     * Wählt den Pfad aufgrund der Zufallszahl für jedes einzelne Bild aus. Der zufällige Ordner wird benötigt.
     */
	public void pathSelector() {
			switch (zufallsZahl) {
			case 1:
				this.setPfad1("/images/0px.png");
				this.setPfad2("/" + this.getOrdner() + "/400px.jpg");
				this.setPfadBorderL("/" + this.getOrdner() + "/border_left.jpg");
				this.setPfadBorderR("/" + this.getOrdner() + "/border_right.jpg");
				break;
			case 2:
				this.setPfad1("/" + this.getOrdner() + "/100px.jpg");
				this.setPfad2("/" + this.getOrdner() + "/300px.jpg");
				this.setPfadBorderL("/" + this.getOrdner() + "/border_left.jpg");
				this.setPfadBorderR("/" + this.getOrdner() + "/border_right.jpg");
				break;
			case 3:
				this.setPfad1("/" + this.getOrdner() + "/200px.jpg");
				this.setPfad2("/" + this.getOrdner() + "/200px.jpg");
				this.setPfadBorderL("/" + this.getOrdner() + "/border_left.jpg");
				this.setPfadBorderR("/" + this.getOrdner() + "/border_right.jpg");
				break;
			case 4:
				this.setPfad1("/" + this.getOrdner() + "/300px.jpg");
				this.setPfad2("/" + this.getOrdner() + "/100px.jpg");
				this.setPfadBorderL("/" + this.getOrdner() + "/border_left.jpg");
				this.setPfadBorderR("/" + this.getOrdner() + "/border_right.jpg");
				break;
			case 5:
				this.setPfad1("/" + this.getOrdner() + "/400px.jpg");
				this.setPfadBorderL("/" + this.getOrdner() + "/border_left.jpg");
				this.setPfadBorderR("/" + this.getOrdner() + "/border_right.jpg");
				this.setPfad2("/images/0px.png");
				break;
			}
	}

	
	/**
	 * 
	 * Gibt die Hitbox der Linie (linker Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsL(int y) {
        return new Rectangle(10, this.getY() + y, imageL.getWidth(null), imageL.getHeight(null));
    }

	/**
	 * 
	 * Gibt die Hitbox der Linie (rechter Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsR(int y) {
        return new Rectangle(this.getImageL().getWidth(null) + Line.getLinienAbstand() + x, this.getY() + y, imageR.getWidth(null), imageR.getHeight(null));
    }
    
	/**
	 * 
	 * Gibt die Hitbox des Borders (linker Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsBorderL() {
        return new Rectangle(15, 0, borderL.getWidth(null), borderL.getHeight(null));
    }
    
	/**
	 * 
	 * Gibt die Hitbox des Borders (rechter Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsBorderR() {
        return new Rectangle(479, 1000, borderL.getWidth(null), borderL.getHeight(null));
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

	public String getPfadBorderL() {
		return pfadBorderL;
	}

	public void setPfadBorderL(String pfadBorderL) {
		this.pfadBorderL = pfadBorderL;
	}

	public String getPfadBorderR() {
		return pfadBorderR;
	}

	public void setPfadBorderR(String pfadBorderR) {
		this.pfadBorderR = pfadBorderR;
	}

	public int getZufallsZahl() {
		return zufallsZahl;
	}

	public void setZufallsZahl(int zufallsZahl) {
		this.zufallsZahl = zufallsZahl;
	}
	
	public int getZufallsSound() {
		return zufallsSound;
	}

	public void setZufallsSound(int zufallsSound) {
		this.zufallsSound = zufallsSound;
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

	public String getOrdner() {
		return ordner;
	}

	@SuppressWarnings("static-access")
	public void setOrdner(String ordner) {
		this.ordner = ordner;
	}

	public String getSoundName() {
		return soundName;
	}

	@SuppressWarnings("static-access")
	public void setSoundName(String soundName) {
		this.soundName = soundName;
	}
	
	
}