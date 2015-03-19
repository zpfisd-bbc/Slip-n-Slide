import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG,
 *         dominic.pfister@bbcag.ch
 * @version 1.0
 */

public class LineGenerator {

	// Variablen
	private int längeLn1 = 0;
	private int längeLn2 = 0;
	private int abstandLänge = 100; // Verändert sich nicht
	private int linienAbstand = 30; // Verändert sich nicht, abstand zwischen
									// ganzen Linien
	private int lastZahl = 0; // Speichert die letzte Zufallszahl
	private int zufallsZahl = 0;
	ArrayList<Integer> zufallsZahlen = new ArrayList<Integer>(); // Speichert
																	// alle
																	// Zufallszahlen

	// private int scrollSpeed = 0;

	// wählt eine Zufallszahl zwischen 1 - 5
	public void randomZahl(int maxZahl) {
		Random rz = new Random();
		zufallsZahl = rz.nextInt(maxZahl);
	}

	// Zeichnet die Linien
	public void paint(Graphics g2) {
		this.randomZahl(6);
		for (int i = 1; i < 6; i++) {
			while (zufallsZahl == lastZahl) { // Überprüft dass keine Lücke
												// zweimal vorkommt
				this.randomZahl(6);
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

			// Fügt die letzte Zufallszahl in die Liste hinzu
			zufallsZahlen.add(this.getZufallsZahl());

			// Linie 1 Left
			g2.setColor(Color.GRAY);
			g2.drawRect(10, linienAbstand, längeLn1, 15);
			g2.fillRect(10, linienAbstand, längeLn1, 15);

			g2.setColor(Color.LIGHT_GRAY); // Schatteneffekt
			g2.drawRect(10, linienAbstand, längeLn1, (int) 7.5);
			g2.fillRect(10, linienAbstand, längeLn1, (int) 7.5);

			// Line 1 Right
			g2.setColor(Color.GRAY);
			g2.drawRect(abstandLänge + längeLn1, linienAbstand, längeLn2, 15);
			g2.fillRect(abstandLänge + längeLn1, linienAbstand, längeLn2, 15);

			g2.setColor(Color.LIGHT_GRAY); // Schatteneffekt
			g2.fillRect(abstandLänge + längeLn1, linienAbstand, längeLn2,
					(int) 7.5);
			g2.fillRect(abstandLänge + längeLn1, linienAbstand, längeLn2,
					(int) 7.5);

			lastZahl = zufallsZahl; // Speichert die letzte Zufallszahl
			linienAbstand += 200;

			// Test purpose only
			System.out.println("RZ: " + zufallsZahl);
			System.out.println(längeLn1);
			System.out.println(längeLn2);
		}
	}

	// Zeichnet die Linien
	public void repaint(Graphics g2) {
		g2.clearRect(0, 0, 517, 1000);

		for (int i = 1; i < 5; i++) {
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

			// Linie 1 Left
			g2.setColor(Color.GRAY);
			g2.drawRect(10, linienAbstand, längeLn1, 15);
			g2.fillRect(10, linienAbstand, längeLn1, 15);

			g2.setColor(Color.LIGHT_GRAY); // Schatteneffekt
			g2.drawRect(10, linienAbstand, längeLn1, (int) 7.5);
			g2.fillRect(10, linienAbstand, längeLn1, (int) 7.5);

			// Line 1 Right
			g2.setColor(Color.GRAY);
			g2.drawRect(abstandLänge + längeLn1, linienAbstand, längeLn2, 15);
			g2.fillRect(abstandLänge + längeLn1, linienAbstand, längeLn2, 15);

			g2.setColor(Color.LIGHT_GRAY); // Schatteneffekt
			g2.fillRect(abstandLänge + längeLn1, linienAbstand, längeLn2,
					(int) 7.5);
			g2.fillRect(abstandLänge + längeLn1, linienAbstand, längeLn2,
					(int) 7.5);

			lastZahl = zufallsZahl; // Speichert die letzte Zufallszahl
			linienAbstand += 150;

			System.out.println("RZ: " + zufallsZahl);
			System.out.println(längeLn1);
			System.out.println(längeLn2);
		}
		scrollUp(g2);
	}

	public void scrollUp(Graphics g2) {
		try {
			Thread.sleep(10); // Setzt die ms in der die Funtkion aufgerufen
								// wird
		} catch (InterruptedException e) {
		}
		int linienAbstand = this.getLinienAbstand();
		this.setLinienAbstand(linienAbstand - 1 - 600);
		g2.clearRect(0, 0, 517, 1000);

		for (int i = 1; i < 5; i++) {
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

			// Linie 1 Left
			g2.setColor(Color.GRAY);
			g2.drawRect(10, linienAbstand, längeLn1, 15);
			g2.fillRect(10, linienAbstand, längeLn1, 15);

			g2.setColor(Color.LIGHT_GRAY); // Schatteneffekt
			g2.drawRect(10, linienAbstand, längeLn1, (int) 7.5);
			g2.fillRect(10, linienAbstand, längeLn1, (int) 7.5);

			// Line 1 Right
			g2.setColor(Color.GRAY);
			g2.drawRect(abstandLänge + längeLn1, linienAbstand, längeLn2, 15);
			g2.fillRect(abstandLänge + längeLn1, linienAbstand, längeLn2, 15);

			g2.setColor(Color.LIGHT_GRAY); // Schatteneffekt
			g2.fillRect(abstandLänge + längeLn1, linienAbstand, längeLn2,
					(int) 7.5);
			g2.fillRect(abstandLänge + längeLn1, linienAbstand, längeLn2,
					(int) 7.5);

			lastZahl = zufallsZahl; // Speichert die letzte Zufallszahl
			linienAbstand += 150;

			System.out.println("RZ: " + zufallsZahl);
			System.out.println(längeLn1);
			System.out.println(längeLn2);
		}

	}

	// Public setter und getter
	public int getLängeLn1() {
		return längeLn1;
	}

	public void setLängeLn1(int längeLn1) {
		this.längeLn1 = längeLn1;
	}

	public int getLängeLn2() {
		return längeLn2;
	}

	public void setLängeLn2(int längeLn2) {
		this.längeLn2 = längeLn2;
	}

	public int getLinienAbstand() {
		return linienAbstand;
	}

	public void setLinienAbstand(int linienAbstand) {
		this.linienAbstand = linienAbstand;
	}

	public int getZufallsZahl() {
		return zufallsZahl;
	}

	public void setZufallsZahl(int zufallsZahl) {
		this.zufallsZahl = zufallsZahl;
	}

}
