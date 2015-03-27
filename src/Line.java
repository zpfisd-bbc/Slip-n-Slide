import java.awt.Image;
import java.awt.Rectangle;
import java.io.InputStream;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG, dominic.pfister@bbcag.ch
 * @version 1.0
 */


public class Line {
	
	//Variablen
	private String ordner;
	private String soundName;
	
	private int zufallsZahl;
	private int zufallsSound;
	private String pfad1; //Pfad für Linie 1
	private String pfad2; //Pfad für Linie 2
	private Image imageL;
	private Image imageR;
	private Image borderL;
	private Image borderR;
	private static int linienAbstand = 100;
	private static int x = 7;
	private int y = 200;
	private int yMove;
	private int scrollSpeed = 5; //Geschwindigkeit für Bewegen von Linien
	
	
	public Line() {
		this.ordnerSelector();
		this.redoLine();
	}
	
	//Erstellt eine komplett neue Linie
	public void redoLine() { //Wird gebraucht falls eine Linie
		this.randomZahl(5); //bereits vorhanden ist
		this.pathSelector();
		this.addImage();
	}
	
	//Sound
	public void sound(String pfad) {
		// Sound
		InputStream sound;
		sound = getClass().getClassLoader().getResourceAsStream(pfad);
		try {
			AudioStream audioStream;
			audioStream = new AudioStream(sound);
			AudioPlayer.player.start(audioStream);
			
		} catch (Exception e) { 
			JOptionPane.showMessageDialog(null, e); 
		}
	}
	
	//Erstellt Image für Objekt
	public void addImage() {
        ImageIcon lnL = new ImageIcon(this.getClass().getResource(pfad1));
        ImageIcon lnR = new ImageIcon(this.getClass().getResource(pfad2));
        if (ordner.equals(this.getSoundName())) {
            ImageIcon borderL = new ImageIcon(this.getClass().getResource("/brown/border_left.jpg"));
            ImageIcon borderR = new ImageIcon(this.getClass().getResource("/brown/border_right.jpg"));
    		this.setBorderL(borderL.getImage());
    		this.setBorderL(borderR.getImage());
        } else if (ordner.equals("blue")) {
            ImageIcon borderL = new ImageIcon(this.getClass().getResource("/blue/border_left.jpg"));
            ImageIcon borderR = new ImageIcon(this.getClass().getResource("/blue/border_right.jpg"));
    		this.setBorderL(borderL.getImage());
    		this.setBorderL(borderR.getImage());
        } else if (ordner.equals("black")) {
            ImageIcon borderL = new ImageIcon(this.getClass().getResource("/black/border_left.jpg"));
            ImageIcon borderR = new ImageIcon(this.getClass().getResource("/black/border_right.jpg"));
    		this.setBorderL(borderL.getImage());
    		this.setBorderL(borderR.getImage());
        } else if (ordner.equals("orange")) {
            ImageIcon borderL = new ImageIcon(this.getClass().getResource("/orange/border_left.jpg"));
            ImageIcon borderR = new ImageIcon(this.getClass().getResource("/orange/border_right.jpg"));
    		this.setBorderL(borderL.getImage());
    		this.setBorderL(borderR.getImage());
        } else if (ordner.equals("violet")){
            ImageIcon borderL = new ImageIcon(this.getClass().getResource("/violet/border_left.jpg"));
            ImageIcon borderR = new ImageIcon(this.getClass().getResource("/violet/border_right.jpg"));
    		this.setBorderL(borderL.getImage());
    		this.setBorderL(borderR.getImage());
        } else {
            ImageIcon borderL = new ImageIcon(this.getClass().getResource("/blue/border_left.jpg"));
            ImageIcon borderR = new ImageIcon(this.getClass().getResource("/blue/border_right.jpg"));
    		this.setBorderL(borderL.getImage());
    		this.setBorderL(borderR.getImage());
        }
		this.setImageL(lnL.getImage());
		this.setImageR(lnR.getImage());

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
     * Selects the path for images
     */
	public void pathSelector() {
			switch (zufallsZahl) {
			case 1:
				this.setPfad1("/images/0px.png");
				this.setPfad2("/" + this.getOrdner() + "/400px.jpg");
				break;
			case 2:
				this.setPfad1("/" + this.getOrdner() + "/100px.jpg");
				this.setPfad2("/" + this.getOrdner() + "/300px.jpg");
				break;
			case 3:
				this.setPfad1("/" + this.getOrdner() + "/200px.jpg");
				this.setPfad2("/" + this.getOrdner() + "/200px.jpg");
				break;
			case 4:
				this.setPfad1("/" + this.getOrdner() + "/300px.jpg");
				this.setPfad2("/" + this.getOrdner() + "/100px.jpg");
				break;
			case 5:
				this.setPfad1("/" + this.getOrdner() + "/400px.jpg");
				this.setPfad2("/images/0px.png");
				break;
			}
	}
	
	/**
	 * 
	 * Gibt den Rand der Linie 1 (linker Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsL() {
        return new Rectangle(10, this.getY() - 20, imageL.getWidth(null), imageL.getHeight(null));
    }

	/**
	 * 
	 * Gibt den Rand der Linie 1 (rechter Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsR() {
        return new Rectangle(this.getImageL().getWidth(null) +  Line.getLinienAbstand() + 7, this.getY() - 20, imageR.getWidth(null), imageR.getHeight(null));
    }
	/**
	 * 
	 * Gibt den Rand der Linie 2 (linker Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsL2() {
        return new Rectangle(10, this.getY() + 180, imageL.getWidth(null), imageL.getHeight(null));
    }

	/**
	 * 
	 * Gibt den Rand der Linie 2 (rechter Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsR2() {
        return new Rectangle(this.getImageL().getWidth(null) + Line.getLinienAbstand() + 7, this.getY() + 180, imageR.getWidth(null), imageR.getHeight(null));
    }
	/**
	 * 
	 * Gibt den Rand der Linie 3 (linker Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsL3() {
        return new Rectangle(10, this.getY() + 380, imageL.getWidth(null), imageL.getHeight(null));
    }

	/**
	 * 
	 * Gibt den Rand der Linie 3 (rechter Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsR3() {
        return new Rectangle(this.getImageL().getWidth(null) +  Line.getLinienAbstand() + 7, this.getY() + 380, imageR.getWidth(null), imageR.getHeight(null));
    }
	/**
	 * 
	 * Gibt den Rand der Linie 4 (linker Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsL4() {
        return new Rectangle(10, this.getY() + 580, imageL.getWidth(null), imageL.getHeight(null));
    }

	/**
	 * 
	 * Gibt den Rand der Linie 4 (rechter Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsR4() {
        return new Rectangle(this.getImageL().getWidth(null) +  Line.getLinienAbstand() + 7, this.getY() + 580, imageR.getWidth(null), imageR.getHeight(null));
    }
	/**
	 * 
	 * Gibt den Rand der Linie 5 (linker Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsL5() {
        return new Rectangle(10, this.getY() + 780, imageL.getWidth(null), imageL.getHeight(null));
    }

	/**
	 * 
	 * Gibt den Rand der Linie 5 (rechter Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsR5() {
        return new Rectangle(this.getImageL().getWidth(null) +  Line.getLinienAbstand() + 7, this.getY() + 780, imageR.getWidth(null), imageR.getHeight(null));
    }
    
	/**
	 * 
	 * Gibt den Rand des Borders (linker Teil) zurück
	 * 	
	 */
    public Rectangle getBoundsBorderL() {
        return new Rectangle(15, 0, borderL.getWidth(null), borderL.getHeight(null));
    }
    
	/**
	 * 
	 * Gibt den Rand des Borders (rechter Teil) zurück
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

	public void setOrdner(String ordner) {
		this.ordner = ordner;
	}

	public String getSoundName() {
		return soundName;
	}

	public void setSoundName(String soundName) {
		this.soundName = soundName;
	}
	
	
}