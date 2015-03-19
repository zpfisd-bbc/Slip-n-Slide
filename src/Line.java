import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG,
 *         dominic.pfister@bbcag.ch
 * @version 1.0
 */

public class Line {
	private final static int ABSTAND_LAENGE = 100; // Verändert sich nicht
	private static int zufallsZahl = 0;
	private static int lastZahl = 0;

	private int längeLn1 = 0;
	private int längeLn2 = 0;
	private int linienAbstand = 30; // Verändert sich nicht, abstand zwischen
									// ganzen Linien

	public Line(Graphics g2, int abstand) {
		zufallsZahl = this.randomZahl(6);
		linienAbstand = abstand;

		while (zufallsZahl == lastZahl) { // Überprüft dass keine Lücke
											// zweimal vorkommt
			zufallsZahl = this.randomZahl(6);
		}

		// Wählt die Länge der Linien aus aufgrund von der zufallsZahl
		switch (zufallsZahl) {
		case 1:
			this.setLängeLn1(0);
			this.setLängeLn2(400);
			break;
		case 2:
			this.setLängeLn1(100);
			this.setLängeLn2(300);
			break;
		case 3:
			this.setLängeLn1(200);
			this.setLängeLn2(300);
			break;
		case 4:
			this.setLängeLn1(300);
			this.setLängeLn2(100);
			break;
		case 5:
			this.setLängeLn1(400);
			this.setLängeLn2(0);
			break;
		}
		paintLine(g2);
		lastZahl = zufallsZahl; // Speichert die letzte Zufallszahl
		linienAbstand += 200;
	}

	public void paintLine(Graphics g2) {
		// Linie 1 Left
		g2.setColor(Color.GRAY);
		g2.drawRect(10, linienAbstand, längeLn1, 15);
		g2.fillRect(10, linienAbstand, längeLn1, 15);

		g2.setColor(Color.LIGHT_GRAY); // Schatteneffekt
		g2.drawRect(10, linienAbstand, längeLn1, (int) 7.5);
		g2.fillRect(10, linienAbstand, längeLn1, (int) 7.5);

		// Line 1 Right
		g2.setColor(Color.GRAY);
		g2.drawRect(ABSTAND_LAENGE + längeLn1, linienAbstand, längeLn2, 15);
		g2.fillRect(ABSTAND_LAENGE + längeLn1, linienAbstand, längeLn2, 15);

		g2.setColor(Color.LIGHT_GRAY); // Schatteneffekt
		g2.fillRect(ABSTAND_LAENGE + längeLn1, linienAbstand, längeLn2,
				(int) 7.5);
		g2.fillRect(ABSTAND_LAENGE + längeLn1, linienAbstand, längeLn2,
				(int) 7.5);
	}

	// wählt eine Zufallszahl zwischen 1 - 5
	public int randomZahl(int maxZahl) {
		Random rz = new Random();
		return rz.nextInt(maxZahl);
	}

	public void scrollUp(Graphics g2) {
		int linienAbstand = this.getLinienAbstand();
		this.setLinienAbstand(linienAbstand - 1 - 600);

		g2.clearRect(0, 0, 517, 1000); // Nur aktuelle Linie

		if (linienAbstand >= 1000) {
			linienAbstand = 150;
			this.randomZahl(6);

			while (zufallsZahl == lastZahl) { // Überprüft dass keine Lücke
												// zweimal vorkommt
				this.randomZahl(6);
			}

			// Setzt die Linienlängen
			switch (zufallsZahl) {
			case 1:
				this.setLängeLn1(0);
				this.setLängeLn2(400);
				break;
			case 2:
				this.setLängeLn1(100);
				this.setLängeLn2(300);
				break;
			case 3:
				this.setLängeLn1(200);
				this.setLängeLn2(300);
				break;
			case 4:
				this.setLängeLn1(300);
				this.setLängeLn2(100);
				break;
			case 5:
				this.setLängeLn1(400);
				this.setLängeLn2(0);
				break;
			}
		}

		paintLine(g2);

		lastZahl = zufallsZahl; // Speichert die letzte Zufallszahl
		linienAbstand += 150;
	}

	public void paint(Graphics g) {

	}

	private int getLängeLn1() {
		return längeLn1;
	}

	private void setLängeLn1(int längeLn1) {
		this.längeLn1 = längeLn1;
	}

	private int getLängeLn2() {
		return längeLn2;
	}

	private void setLängeLn2(int längeLn2) {
		this.längeLn2 = längeLn2;
	}

	private int getLinienAbstand() {
		return linienAbstand;
	}

	private void setLinienAbstand(int linienAbstand) {
		this.linienAbstand = linienAbstand;
	}

}