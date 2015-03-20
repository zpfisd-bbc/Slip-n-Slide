import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG,
 *         dominic.pfister@bbcag.ch
 * @version 1.0
 */

public class Board extends JFrame implements ActionListener {

	// SerialID
	private static final long serialVersionUID = 1L;

	// Objects
	private Player player;
	private Line l = new Line();
	private Line l2 = new Line();
	private Line l3 = new Line();
	private Line l4 = new Line();
	private Line l5 = new Line();
	
	private Line border = new Line(); 
	
	public Board() {
		
		// Initialisiert das JFrame
		getContentPane().setBackground(Color.YELLOW); //Setzt die Hintergrundfarbe
		setSize(517, 1000); // Breite und LÃ¤nge von Fenster
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		addKeyListener(new TAdapter());
        setFocusable(true);
        player = new Player();
		Timer timer = new Timer(25, this);
		timer.start();
	}
	
    public void paint(Graphics g) {
    	

        super.paint(g);
        Graphics2D g1 = (Graphics2D)g;
        
        // Prüft ob die vorhergehende Linie nicht die gleiche Struktur besitzt
        try {
        	//Prüft Linie 1
        	while (l.getZufallsZahl() == l5.getZufallsZahl()) {
        		l.redoLine();
        	}
		} catch (NullPointerException e) {
		}
        
        //Prüft Linie 2
        while (l.getZufallsZahl() == l2.getZufallsZahl()) {
        	l2.redoLine();
        }
        
        //Prüft Linie 3
        while (l2.getZufallsZahl() == l3.getZufallsZahl()) {
        	l3.redoLine();
        }
        
        //Prüft Linie 4
        while (l3.getZufallsZahl() == l4.getZufallsZahl()) {
        	l4.redoLine();
        }
        
        //Prüft Linie 1
        while (l4.getZufallsZahl() == l5.getZufallsZahl()) {
        	l5.redoLine();
        }
               	// Wiederholt die Linien wenn sie aus dem Rahmen fahren
        		// setzt die neuen Coordinaten
                if (l.getY() != -10) {
                g1.drawImage(l.getImageL(), Line.getX(), l.getY(), this);
                g1.drawImage(l.getImageR(), l.getImageL().getWidth(null) +  Line.getLinienAbstand() , l.getY(), this);
            	} 
                else {
            		l = null;
            		l = new Line();
            		l.setY(l.getY() + 800);
            	}
                
                if (l2.getY() != -190) { // 150
                g1.drawImage(l2.getImageL(), Line.getX(), l2.getY() + 200, this);
                g1.drawImage(l2.getImageR(), l2.getImageL().getWidth(null) +  Line.getLinienAbstand() , l2.getY() + 200, this);
            	} 
                else {
            		l2 = null;
            		l2 = new Line();
            		l2.setY(l2.getY() + 620);
            	}
                
                if (l3.getY() != -390) { // 310
                g1.drawImage(l3.getImageL(), Line.getX(), l3.getY() + 400, this);
                g1.drawImage(l3.getImageR(), l3.getImageL().getWidth(null) +  Line.getLinienAbstand() , l3.getY() + 400, this);
            	} 
                else {
            		l3 = null;
            		l3 = new Line();
            		l3.setY(l3.getY() + 420);

            	}
                
                if (l4.getY() != -590) {
                g1.drawImage(l4.getImageL(), Line.getX(), l4.getY() + 600, this);
                g1.drawImage(l4.getImageR(), l4.getImageL().getWidth(null) +  Line.getLinienAbstand() , l4.getY() + 600, this);
            	} 
                else {
            		l4 = null;
            		l4 = new Line();
            		l4.setY(l.getY());
            	}
                
                if (l5.getY() != -790) {
                g1.drawImage(l5.getImageL(), Line.getX(), l5.getY() + 800, this);
                g1.drawImage(l5.getImageR(), l5.getImageL().getWidth(null) +  Line.getLinienAbstand() , l5.getY() + 800, this);
            	} 
                else {
            		l5 = null;
            		l5 = new Line();
            		l5.setY(l5.getY() + 20);
            	}
                
        // Borders
        g1.drawImage(border.getBorderL(), 4, 0, 16, 1000, this);
        g1.drawImage(border.getBorderL(), 499, 0, 15, 1000, this);    
    
        
        Graphics2D gP = (Graphics2D) g;
        gP.drawImage(player.getImage(), player.getxPos(), player.getyPos(), this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
        checkCollisions();
    }

	public static void main(String[] args) {
		new Board(); // Fängt alle Methoden aus Board() hinzu
	}
    
	// Prüft ob eine Taste gedrückt wird
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
	
    // checks collisions for all lines with the Sprite
    public void checkCollisions() {

        Rectangle prec = player.getBoundsPlayer();
        Rectangle lineL = l.getBoundsL();
        Rectangle lineR = l.getBoundsR();
        Rectangle line2L = l2.getBoundsL();
        Rectangle line2R = l2.getBoundsR();
        Rectangle line3L = l3.getBoundsL();
        Rectangle line3R = l3.getBoundsR();
        Rectangle line4L = l4.getBoundsL();
        Rectangle line4R = l4.getBoundsR();
        Rectangle line5L = l5.getBoundsL();
        Rectangle line5R = l5.getBoundsR();

        // if it collided with one:
		if (prec.intersects(lineL) || prec.intersects(lineR)
		 || prec.intersects(line2L) || prec.intersects(line2R)
		 || prec.intersects(line3L) || prec.intersects(line3R)
		 || prec.intersects(line4L) || prec.intersects(line4R)
		 || prec.intersects(line5L) || prec.intersects(line5R)) {
			
			// sets y achsis and stops the moving down
			System.out.println("Ich han collided Captain");
			player.setPlayerSpeedDown(0);
			player.setyPos(l.getY() - 30);
	
		} else {
			
			// continues to move down
			player.setPlayerSpeedDown(2);
		}
	}
    
    //Funktion wird alle 5ms aufgerufen
    public void actionPerformed(ActionEvent e) {
        l.move();
        l2.move();
        l3.move();
        l4.move();
        l5.move();
        repaint(20, 0, 479, 1000);
        player.move();
        repaint();  
    }
}
