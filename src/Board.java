import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG,
 *         dominic.pfister@bbcag.ch
 * @version 1.0
 */

public class Board extends JFrame {

	// SerialID
	private static final long serialVersionUID = 1L;

	// Variablen
	// private boolean inGame = true;
	private List<Line> lines = new ArrayList<Line>();

	public Board() {

		// Initialisiert das JFrame
		// getContentPane().setBackground(Color.YELLOW); // Setzt die
		// Hintergrundfarbe
		setSize(517, 1000); // Breite und Länge von Fenster
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void paint(Graphics g) {
		Line l1 = new Line(g, 230);
		Line l2 = new Line(g, 430);
		Line l3 = new Line(g, 630);
		Line l4 = new Line(g, 830);
		lines.add(l1);
		lines.add(l2);
		lines.add(l3);
		lines.add(l4);

		while (true) {
			play(g);
		}
	}

	public static void main(String[] args) {
		Board b = new Board(); // Fügt alle Methoden aus Board() hinzu
	}

	public void play(Graphics g) {
		
		try {
			Thread.sleep(1000); // Setzt die ms in der die Funtkion aufgerufen
								// wird
		} catch (InterruptedException e) {
		}

		for (Line l : lines) {
			l.scrollUp(g);
		}
	}
}
