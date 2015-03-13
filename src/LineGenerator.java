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
		Graphics2D g1d = (Graphics2D) g;
		Graphics2D border = (Graphics2D) g;
		Graphics2D g3d = (Graphics2D) g;

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
			g1d.setColor(Color.LIGHT_GRAY);
			g1d.fillRect(10, y1, l1, 15);
			g1d.drawRect(10, y1, l1, 15);

			g1d.setColor(Color.GRAY); // Schatteneffekt für Line 1
			g1d.fillRect(10, y1 + 8, l1, (int) 7.5);
			g1d.drawRect(10, y1 + 8, l1, (int) 7.5);

			// Line 2
			g3d.setColor(Color.LIGHT_GRAY);
			g3d.fillRect(l3 + l1, y1, l2, 15);
			g3d.drawRect(l3 + l1, y1, l2, 15);

			g3d.setColor(Color.GRAY); // Schatteneffekt für Line 2
			g3d.fillRect(l3 + l1, y1 + 8, l2, (int) 7.5);
			g3d.drawRect(l3 + l1, y1 + 8, l2, (int) 7.5);

			y1 += 250; // Erhöht Grösse von Abstand zwischen der kompletten
						// Linien
			lastZahl = rz; // Speichert die letzte Zufallszahl

			// Border links
			border.setColor(Color.LIGHT_GRAY);
			border.fillRect(0, 0, 10, 1080);
			border.drawRect(0, 0, 10, 1080);

			// Border rechts
			border.setColor(Color.LIGHT_GRAY);
			border.fillRect(500, 0, 10, 1080);
			border.drawRect(500, 0, 10, 1080);
		}
	}
}