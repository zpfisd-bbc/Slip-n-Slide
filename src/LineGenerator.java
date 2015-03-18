import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class LineGenerator {
	int y1 = 230; // Länge von Abstand zwischen Linien
	int l1 = 1; // Länge von linie 1
	int l2 = 1; // Länge von line 2
	int l3 = 100; // Länge von Abstand
	int lastZahl = 0; // Speichert die letzte Zahl von ZufallsZahl
	int rz; // Die Zufallszahl

	// Generates Random Lines
	public void paint(Graphics g) {


		for (int i = 1; i < 10; i++) { // Testschlaufe, mit playerDead != true

			Random randomZahl = new Random();
			rz = randomZahl.nextInt(6 - 1) + 1; // wählt eine Zufallszahl zwischen 1 - 5

			while (rz == lastZahl) { // Überprüft dass keine Lücke zweimal vorkommt
				rz = randomZahl.nextInt(6 - 1) + 1; // wählt eine Zufallszahl zwischen 1 - 5
			}

			//Wählt aus welche Länge die Linien haben, aufgrund der Randomzahl
			if (rz == 1) {
				l1 = 0;
				l2 = 400;
			} else if (rz == 2) {
				l1 = 100;
				l2 = 300;
			} else if (rz == 3) {
				l1 = 200;
				l2 = 200;
			} else if (rz == 4) {
				l1 = 300;
				l2 = 100;
			} else if (rz == 5) {
				l1 = 400;
				l2 = 0;
			}

			// Line 1
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(10, y1, l1, 15);
			g.drawRect(10, y1, l1, 15);

			g.setColor(Color.GRAY); // Schatteneffekt für Line 1
			g.fillRect(10, y1 + 8, l1, (int) 7.5);
			g.drawRect(10, y1 + 8, l1, (int) 7.5);

			// Line 2
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(l3 + l1, y1, l2, 15);
			g.drawRect(l3 + l1, y1, l2, 15);

			g.setColor(Color.GRAY); // Schatteneffekt für Line 2
			g.fillRect(l3 + l1, y1 + 8, l2, (int) 7.5);
			g.drawRect(l3 + l1, y1 + 8, l2, (int) 7.5);

			y1 += 250; // Erhöht Grösse von Abstand zwischen der kompletten
						// Linien
			lastZahl = rz; // Speichert die letzte Zufallszahl

			// Border links
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, 10, 1080);
			g.drawRect(0, 0, 10, 1080);

			// Border rechts
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(500, 0, 10, 1080);
			g.drawRect(500, 0, 10, 1080);
		}
	}
	
	
	//Getters und Setters
	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getL1() {
		return l1;
	}

	public void setL1(int l1) {
		this.l1 = l1;
	}

	public int getL2() {
		return l2;
	}

	public void setL2(int l2) {
		this.l2 = l2;
	}

	public int getL3() {
		return l3;
	}

	public void setL3(int l3) {
		this.l3 = l3;
	}

	public int getLastZahl() {
		return lastZahl;
	}

	public void setLastZahl(int lastZahl) {
		this.lastZahl = lastZahl;
	}

	public int getRz() {
		return rz;
	}

	public void setRz(int rz) {
		this.rz = rz;
	}
}