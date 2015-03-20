import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

	// Variablen
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
		setSize(517, 1000); // Breite und Länge von Fenster
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
       
        if (l.getY() != -10) {
        g1.drawImage(l.getImageL(), Line.getX(), l.getY(), this);
        g1.drawImage(l.getImageR(), l.getImageL().getWidth(null) +  Line.getLinienAbstand() , l.getY(), this);
    	} 
        else {
    		l = null;
    		l = new Line();
    	}
        
        if (l2.getY() != -10) {
        g1.drawImage(l2.getImageL(), Line.getX(), l2.getY() + 200, this);
        g1.drawImage(l2.getImageR(), l2.getImageL().getWidth(null) +  Line.getLinienAbstand() , l2.getY() + 200, this);
    	} 
        else {
    		l2 = null;
    		l2 = new Line();
    	}
        
        if (l3.getY() != -10) {
        g1.drawImage(l3.getImageL(), Line.getX(), l3.getY() + 400, this);
        g1.drawImage(l3.getImageR(), l3.getImageL().getWidth(null) +  Line.getLinienAbstand() , l3.getY() + 400, this);
    	} 
        else {
    		l3 = null;
    		l3 = new Line();
    	}
        
        if (l4.getY() != -10) {
        g1.drawImage(l4.getImageL(), Line.getX(), l4.getY() + 600, this);
        g1.drawImage(l4.getImageR(), l4.getImageL().getWidth(null) +  Line.getLinienAbstand() , l4.getY() + 600, this);
    	} 
        else {
    		l4 = null;
    		l4 = new Line();
    	}
        
        if (l5.getY() != -10) {
        g1.drawImage(l5.getImageL(), Line.getX(), l5.getY() + 800, this);
        g1.drawImage(l5.getImageR(), l5.getImageL().getWidth(null) +  Line.getLinienAbstand() , l5.getY() + 800, this);
    	} 
        else {
    		l5 = null;
    		l5 = new Line();
    	}
        
        // Borders
        
        g1.drawImage(border.getBorderL(), 4, 0, 16, 1000, this);
        g1.drawImage(border.getBorderL(), 499, 0, 15, 1000, this);    
    
        
        Graphics2D gP = (Graphics2D) g;
        gP.drawImage(player.getImage(), player.getxPos(), player.getyPos(), this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

	public static void main(String[] args) {
		new Board(); // Fügt alle Methoden aus Board() hinzu
	}
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
	
    public void actionPerformed(ActionEvent e) { //Funktion wird alle 5ms aufgerufen
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
