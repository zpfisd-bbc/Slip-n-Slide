import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;

import sun.audio.*;

import javax.sound.sampled.AudioFileFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG, dominic.pfister@bbcag.ch
 * @version 1.0
 */

public class Board extends JFrame implements ActionListener {

	// SerialID
	private static final long serialVersionUID = 1L;

	// Variablen
	Player player;
	
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
		

		// Initialisiert das JFrame
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/" + l.getOrdner() + "/bg2.jpg"))));
		setTitle("Slip 'n' Slide");
		setSize(517, 1000); // Breite und Länge von Fenster
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		addKeyListener(new TAdapter());
        setFocusable(true);
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
	
	
	
    public void paint(Graphics g) {


        super.paint(g);
        Graphics2D g1 = (Graphics2D)g;
        
		//Zeichnet Linie 1
		while (l.getZufallsZahl() == l5.getZufallsZahl() && !alreadyExecutedL1) { //Wird nur einmal ausgeführt
			l.redoLine();
		}
        
		//Setzt den Spieler in die Lücke der Linie
		if (l.getZufallsZahl() == 1 && firstRun) {
    		try {
        		player.setxPos(48);
        		firstRun = false;
			} catch (NullPointerException e) {
        		player.setxPos(48);
        		firstRun = false;
			}
    	} else if (l.getZufallsZahl() == 2 && firstRun) {
    		try {
        		player.setxPos(140);
        		firstRun = false;
			} catch (NullPointerException e) {
        		player.setxPos(140);
        		firstRun = false;
			}
    	} else if (l.getZufallsZahl() == 3 && firstRun) {
    		try {
        		player.setxPos(240);
        		firstRun = false;
			} catch (NullPointerException e) {
        		player.setxPos(240);
        		firstRun = false;
			}
    	} else if (l.getZufallsZahl() == 4 && firstRun) {
    		try {
        		player.setxPos(340);
        		firstRun = false;
			} catch (NullPointerException e) {
        		player.setxPos(340);
        		firstRun = false;
			}
    	} else if (l.getZufallsZahl() == 5 && firstRun) {
    		try {
        		player.setxPos(440);
        		firstRun = false;
			} catch (NullPointerException e) {
        		player.setxPos(440);
        		firstRun = false;
			}
    	}
		
	    	l2.setOrdner(l.getOrdner());
	    	l3.setOrdner(l2.getOrdner());
	    	l4.setOrdner(l3.getOrdner());
	    	l5.setOrdner(l4.getOrdner());
    	
    			alreadyExecutedL1 = true;
                if (l.getY() != -10) {
                	g1.drawImage(l.getImageL(), Line.getX(), l.getY(), this);
                	g1.drawImage(l.getImageR(), l.getImageL().getWidth(null) +  Line.getLinienAbstand() + 7, l.getY(), this);
            	} 
                else {
            		l = null;
            		l = new Line();
            		l.setY(l.getY() + 800);
            		l.getBoundsL(); 
            		l.getBorderR();
                    
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
            	} 
                else {
            		l2 = null;
            		l2 = new Line();
            		l2.setY(l2.getY() + 620);
            		l2.getBoundsL(); 
            		l2.getBorderR();
                    
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
            	}
                else {
            		l3 = null;
            		l3 = new Line();
            		l3.setY(l3.getY() + 420);
            		l3.getBoundsL(); 
            		l3.getBorderR();
                    
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
            	} 
                else {
            		l4 = null;
            		l4 = new Line();
            		l4.setY(l.getY());
            		l4.getBoundsL(); 
            		l4.getBorderR();
            		
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
            	} 
                else {
            		l5 = null;
            		l5 = new Line();
            		l5.setY(l5.getY() + 20);
            		l5.getBoundsL(); 
            		l5.getBorderR();
            		
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
        g.dispose();
        
        checkCollisions();
    }
    
    
    
    
    /**
     * Überprüft ob der Spieler eine Linie berührt hat
     */
    public void checkCollisions() {

        Rectangle prec = player.getBoundsPlayer();
        Rectangle lineL = l.getBoundsL();
        Rectangle lineR = l.getBoundsR();
        Rectangle line2L = l2.getBoundsL2();
        Rectangle line2R = l2.getBoundsR2();
        Rectangle line3L = l3.getBoundsL3();
        Rectangle line3R = l3.getBoundsR3();
        Rectangle line4L = l4.getBoundsL4();
        Rectangle line4R = l4.getBoundsR4();
        Rectangle line5L = l5.getBoundsL5();
        Rectangle line5R = l5.getBoundsR5();
        
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
			player.setPlayerSpeedDown(playerSpeedDown);
		} 
	}
    
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
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
    
    public void highscore() {
    	
    	if(player.getyPos() == l.getY() + 13 
    			|| player.getyPos() == l2.getY() + 213 
    			|| player.getyPos() == l3.getY() + 413 
    			|| player.getyPos() == l4.getY() + 613 
    			|| player.getyPos() == l5.getY() + 813) {	
    		setHighscore(getHighscore() + 1);
        	sound("sound/scorer.wav");
    		System.out.println("Score: " + highscore);    	}
    }
	
    public void actionPerformed(ActionEvent e) { //Funktion wird alle 25ms aufgerufen
        l.move();
        l2.move();
        l3.move();
        l4.move();
        l5.move();
        repaint(20, 0, 479, 1000);
        player.move();
        highscore();
        checkBorder();
        if (player.getyPos() > 1000 || player.getyPos() < 0) {
        	sound("sound/death.wav");
			JOptionPane.showMessageDialog(null, "Du bist Tot"); 
        }
    }

	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}
}