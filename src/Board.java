import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		Timer timer = new Timer(25, this);
		timer.start();
	}
	
    public void paint(Graphics g) {
    	

        super.paint(g);
        Graphics2D g1 = (Graphics2D)g;
        
        
        g1.drawImage(l.getImageL(), Line.getX(), l.getY(), this);
        g1.drawImage(l.getImageR(), l.getImageL().getWidth(null) +  Line.getLinienAbstand() , l.getY(), this);
        
        g1.drawImage(l2.getImageL(), Line.getX(), l2.getY() + 200, this);
        g1.drawImage(l2.getImageR(), l2.getImageL().getWidth(null) +  Line.getLinienAbstand() , l2.getY() + 200, this);
        
        g1.drawImage(l3.getImageL(), Line.getX(), l3.getY() + 400, this);
        g1.drawImage(l3.getImageR(), l3.getImageL().getWidth(null) +  Line.getLinienAbstand() , l3.getY() + 400, this);
        
        g1.drawImage(l4.getImageL(), Line.getX(), l4.getY() + 600, this);
        g1.drawImage(l4.getImageR(), l4.getImageL().getWidth(null) +  Line.getLinienAbstand() , l4.getY() + 600, this);
        
        g1.drawImage(l5.getImageL(), Line.getX(), l5.getY() + 800, this);
        g1.drawImage(l5.getImageR(), l5.getImageL().getWidth(null) +  Line.getLinienAbstand() , l5.getY() + 800, this);
        
        // Borders
        
        g1.drawImage(border.getBorderL(), 4, 0, 16, 1000, this);
        g1.drawImage(border.getBorderL(), 499, 0, 15, 1000, this);    }

	public static void main(String[] args) {
		new Board(); // Fügt alle Methoden aus Board() hinzu
	}

    public void actionPerformed(ActionEvent e) { //Funktion wird alle 5ms aufgerufen
        l.move();
        l2.move();
        l3.move();
        l4.move();
        l5.move();
        repaint(20, 0, 479, 1000);
    }
}
