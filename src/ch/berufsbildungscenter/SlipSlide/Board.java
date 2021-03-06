package ch.berufsbildungscenter.SlipSlide;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG, dominic.pfister@bbcag.ch
 * @version 1.0
 */

public class Board extends JFrame implements ActionListener {

	// SerialID
	private static final long serialVersionUID = 1L;

	// Variablen
	Player player;
	JFrame score = new JFrame();
	AudioStream audioStream;
	JLabel scoreLabel = new JLabel("<html><span style='font-size:20px'>Score: 0</span></html>", JLabel.CENTER); 
	
	private String ordner;
	
	private Line l = new Line();
	private Line l2 = new Line();
	private Line l3 = new Line();
	private Line l4 = new Line();
	private Line l5 = new Line();
	private Line border = new Line();
	
	private boolean alreadyExecutedL1 = false; 
	private boolean alreadyExecutedL2 = false;
	private boolean alreadyExecutedL3 = false;
	private boolean alreadyExecutedL4 = false;
	private boolean alreadyExecutedL5 = false;
	private boolean firstRun = true;
	
	private int highscore = 0;
	private int playerSpeedDown;
	private int playerSpeed;
	
	public Board(int speedDown, int speed) {
		
		//Erzeugt ein kleines Fenster für den Score
		score();
		
		// Initialisiert das JFrame
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource(
				"/" + l.getOrdner() + "/bg2.jpg")))); //Setzt das Hintergrundbild
		
		setTitle("Slip 'n' Slide");
		setSize(517, 1000); // Breite und Länge von Fenster
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
        setFocusable(true); //Nimmt das JFrame in den Fokus
		
		addKeyListener(new TastenAdapter());
        player = new Player();
        Timer timer = new Timer(25, this); //25ms = 40fps
		timer.start();	
		
		//SpielSund
		sound(l.getSoundName());
		
			//Setzt die Geschwindigkeiten für den Spieler
		player.setPlayerSpeedDown(speedDown);
		player.setPlayerSpeedLeft(speed);
		player.setPlayerSpeedRight(speed);
		
		playerSpeedDown = speedDown;
		playerSpeed = speed;
		
		this.setOrdner(l.getOrdner());
		l2.setOrdner(this.getOrdner());
		l3.setOrdner(this.getOrdner());
		l4.setOrdner(this.getOrdner());
		l5.setOrdner(this.getOrdner());
		
		l2.redoLine();
		l3.redoLine();
		l4.redoLine();
		l5.redoLine();
		
		l.setOrdner(ordner);
		l.redoLine();
	}
	
	/**
	 * Erzeugt ein neues JFrame welches den Score anzeigt
	 */
	public void score() {
		//JFrame für den Score
		score.setFocusable(false); //Kann nicht angewählt werden
		score.setTitle("Slip 'n' Slide");
		score.setUndecorated(true);
		score.setSize(120, 100); // Breite und Länge von Fenster
		score.setVisible(true);
		score.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		score.setResizable(false);
		score.setLocation(1240, 50); //Erzeugt das Frame direkt neben dem Spiel Frame
		score.add(scoreLabel);
	}
	
	/**
	 * Fügt den Sound hinzu
	 */
	public void sound(String pfad) {
		InputStream sound;
		sound = getClass().getClassLoader().getResourceAsStream(pfad);  //Dynamischer Pfad
		try {
			AudioStream audioStream;
			audioStream = new AudioStream(sound);
			AudioPlayer.player.start(audioStream);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e); //Ausgabe der Errormeldung
		}
	}
	
	
	/**
	 * Zeichnet die Linien, den Spieler und die Ränder
	 */
    public void paint(Graphics g) {
		
        super.paint(g);
        Graphics2D g1 = (Graphics2D)g;

    	
		//Zeichnet Linie 1
		while (l.getZufallsZahl() == l5.getZufallsZahl() && !alreadyExecutedL1) { //Beim ersten Durchlauf,
			l.redoLine(); //prüft ob die Linie gleich wie die vorherige ist
		}
		
		//Setzt den Spieler in die Lücke der ersten Linie
		if (l.getZufallsZahl() == 1 && firstRun) { //Wird nur beim ersten Durchlauf gebraucht
        	player.setxPos(48);
    	} else if (l.getZufallsZahl() == 2 && firstRun) {
        	player.setxPos(140);
    	} else if (l.getZufallsZahl() == 3 && firstRun) {
        	player.setxPos(240);
    	} else if (l.getZufallsZahl() == 4 && firstRun) {
        	player.setxPos(340);
    	} else if (l.getZufallsZahl() == 5 && firstRun) {
        	player.setxPos(440);
    	}
    	firstRun = false;
    	
		alreadyExecutedL1 = true;
        if (l.getY() != -10) {
        	g1.drawImage(l.getImageL(), Line.getX(), l.getY(), this);
        	g1.drawImage(l.getImageR(), l.getImageL().getWidth(null) +  Line.getLinienAbstand() + 7, l.getY(), this);
    	} else { //Erstellt eine neue Linie wenn diese aus dem Rahmen fährt
    		l = null;
    		l = new Line();
    		l.setOrdner(this.getOrdner());
    		l.redoLine();
    		l.setY(l.getY() + 800);
            
            //Prüft ob Linie 1 gleich wie die vorherige ist
            while (l.getZufallsZahl() == l5.getZufallsZahl()) {
            	l.redoLine();
            }
    	}
        
        
        
        //Zeichnet Linie 2
        while (l.getZufallsZahl() == l2.getZufallsZahl() && !alreadyExecutedL2) { //Wird nur einmal ausgeführt
        	l2.redoLine();
        }
    	alreadyExecutedL2 = true;
        if (l2.getY() != -190) {
        	g1.drawImage(l2.getImageL(), Line.getX(), l2.getY() + 200, this);
        	g1.drawImage(l2.getImageR(), l2.getImageL().getWidth(null) +  Line.getLinienAbstand() + 7 , l2.getY() + 200, this);
    	} else {
    		l2 = null;
    		l2 = new Line();
    		l2.setOrdner(this.getOrdner());
    		l2.redoLine();
    		l2.setY(l2.getY() + 620);
            
            //Prüft ob Linie 2 gleich wie die vorherige ist
            while (l.getZufallsZahl() == l2.getZufallsZahl()) {
            	l2.redoLine();
            }
    	}
        
        
        //Zeichnet Linie 3
		while (l2.getZufallsZahl() == l3.getZufallsZahl() && !alreadyExecutedL3) { //Wird nur einmal ausgeführt
			l3.redoLine();
		}
		alreadyExecutedL3 = true;
        if (l3.getY() != -390) {
        	g1.drawImage(l3.getImageL(), Line.getX(), l3.getY() + 400, this);
        	g1.drawImage(l3.getImageR(), l3.getImageL().getWidth(null) +  Line.getLinienAbstand()  + 7, l3.getY() + 400, this);
    	} else {
    		l3 = null;
    		l3 = new Line();
    		l3.setOrdner(this.getOrdner());
    		l3.redoLine();
    		l3.setY(l3.getY() + 420);
            
            //Prüft ob Linie 3 gleich wie die vorherige ist
            while (l2.getZufallsZahl() == l3.getZufallsZahl()) {
            	l3.redoLine();
            }

    	}
        
        
        //Zeichnet Linie 4
		while (l3.getZufallsZahl() == l4.getZufallsZahl() && !alreadyExecutedL4) { //Wird nur einmal ausgeführt
			l4.redoLine();
		}
		alreadyExecutedL4 = true;
        if (l4.getY() != -590) {
        	g1.drawImage(l4.getImageL(), Line.getX(), l4.getY() + 600, this);
        	g1.drawImage(l4.getImageR(), l4.getImageL().getWidth(null) +  Line.getLinienAbstand() + 7, l4.getY() + 600, this);
    	} else {
    		l4 = null;
    		l4 = new Line();
    		l4.setOrdner(this.getOrdner());
    		l4.redoLine();
    		l4.setY(l.getY());
    		
            //Prüft ob Linie 4 gleich wie die vorherige ist
            while (l3.getZufallsZahl() == l4.getZufallsZahl()) {
            	l4.redoLine();
            }
    	}
        
        
        //Zeichnet Linie 5
		while (l4.getZufallsZahl() == l5.getZufallsZahl() && !alreadyExecutedL5) { //Wird nur einmal ausgeführt
			l5.redoLine();
		}
		alreadyExecutedL5 = true;
        if (l5.getY() != -790) {
        	g1.drawImage(l5.getImageL(), Line.getX(), l5.getY() + 800, this);
        	g1.drawImage(l5.getImageR(), l5.getImageL().getWidth(null) +  Line.getLinienAbstand() + 7, l5.getY() + 800, this);
    	} else {
    		l5 = null;
    		l5 = new Line();
    		l5.setOrdner(this.getOrdner());
    		l5.redoLine();
    		l5.setY(l5.getY() + 20);
    		
            //Prüft ob Linie 5 gleich wie die vorherige ist
            while (l4.getZufallsZahl() == l5.getZufallsZahl()) {
            	l5.redoLine();
            }
    	}
                
        //Zeichnet den Rand
        g1.drawImage(border.getBorderL(), 4, 0, 16, 1000, this);
        g1.drawImage(border.getBorderL(), 499, 0, 15, 1000, this);
        
        //Zeichnet den Spieler
        g1.drawImage(player.getImage(), player.getxPos(), player.getyPos(), this);
        Toolkit.getDefaultToolkit().sync();
    }
    
    
    
    
    /**
     * Überprüft ob der Spieler eine Linie berührt hat
     */
    public void checkCollisions() {

        Rectangle prec = player.getBoundsPlayer();
        
        Rectangle lineL = l.getBoundsL(-20);
        Rectangle lineR = l.getBoundsR(-20);
        Rectangle line2L = l2.getBoundsL(180);
        Rectangle line2R = l2.getBoundsR(180);
        Rectangle line3L = l3.getBoundsL(380);
        Rectangle line3R = l3.getBoundsR(380);
        Rectangle line4L = l4.getBoundsL(580);
        Rectangle line4R = l4.getBoundsR(580);
        Rectangle line5L = l5.getBoundsL(780);
        Rectangle line5R = l5.getBoundsR(780);
        
		if (prec.intersects(lineL) || prec.intersects(lineR)) { //Checkt Linie 1
			player.setyPos(l.getY() - 30 - 2);
			player.setPlayerSpeedDown(0);
		} else if (prec.intersects(line2L) || prec.intersects(line2R)) {  //Checkt Linie 2
			player.setyPos(l2.getY() + 200 -30 - 2);
			player.setPlayerSpeedDown(0);
		} else if (prec.intersects(line3L) || prec.intersects(line3R)) {  //Checkt Linie 3
			player.setyPos(l3.getY() + 400 - 30 - 2);
			player.setPlayerSpeedDown(0);
		} else if (prec.intersects(line4L) || prec.intersects(line4R)) {  //Checkt Linie 4
			player.setyPos(l4.getY() + 600 - 30 - 2);
			player.setPlayerSpeedDown(0);
		} else if (prec.intersects(line5L) || prec.intersects(line5R)) {  //Checkt Linie 5
			player.setyPos(l5.getY() + 800 - 30 - 2);
			player.setPlayerSpeedDown(0);
		} else {
			player.setPlayerSpeedDown(playerSpeedDown); //Setzt die Geschwindigkeit zurück
		} 
	}
    
    /**
     * Achtet darauf dass der Spieler nicht den linken / rechten Rand überschreitet
     */
    public void checkBorder() {
        if (player.getxPos() <= 20) {
        	player.setxPos(19);
        } else if (player.getxPos() >= 468) {
        	player.setxPos(467);
        } else {
        	player.setPlayerSpeedLeft(playerSpeed);
        	player.setPlayerSpeedRight(playerSpeed);
        }
    }
    
    /**
     * Prüft welche Taste gedrückt bzw losegelassen wurde
     */
    private class TastenAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
    
    /**
     * Funktion um den Score zu zählen
     */
    public void highscore() {
    	
    	if(player.getyPos() == l.getY() + 13 
    			|| player.getyPos() == l2.getY() + 213 
    			|| player.getyPos() == l3.getY() + 413 
    			|| player.getyPos() == l4.getY() + 613 
    			|| player.getyPos() == l5.getY() + 813) {	
    		this.setHighscore(this.getHighscore() + 1);
        	sound("sound/scorer.wav");
        	//Ändert den Text im JFrame score zum aktuellen Score
        	scoreLabel.setText("<html><span style='font-size:20px'>Score: " + highscore + "</span></html>");
       	}
    }
	
    public void actionPerformed(ActionEvent e) { //Funktion wird alle 25ms von timer aufgerufen
        checkCollisions();
    	l.move();
        l2.move();
        l3.move();
        l4.move();
        l5.move();
        repaint(20, 0, 479, 1000);
        player.move();
        highscore();
        checkBorder();
        if (player.getyPos() > 1000 || player.getyPos() < 0) { //Prüft ob der Spieler den Rahmen verlassen hat
        	sound("sound/death.wav");
        	dispose(); //Löscht Frame
            ((Timer)e.getSource()).stop(); //Stoppt den Timer
        	SlipGUI s = new SlipGUI();
        	s.endScreen();
        }
    }

    //Getter und setter
	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}

	public String getOrdner() {
		return ordner;
	}

	public void setOrdner(String ordner) {
		this.ordner = ordner;
	}
}