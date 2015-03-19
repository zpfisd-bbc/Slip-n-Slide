import java.awt.Color;
import java.awt.Graphics;
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
	private LineGenerator lg = new LineGenerator();

	public Board() {

		// Initialisiert das JFrame
		getContentPane().setBackground(Color.YELLOW); // Setzt die
														// Hintergrundfarbe
		setSize(517, 1000); // Breite und Länge von Fenster
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void paint(Graphics g) { // Fügt die paint() Methode von
									// LineGenerator hinzu
		lg.paint(g);
	}

	public static void main(String[] args) {
		new Board(); // Fügt alle Methoden aus Board() hinzu
	}

}
