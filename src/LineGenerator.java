import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class LineGenerator extends Main {

	/**
	 * 
	 */
	private static final long serialVerzionUID = 3059159587358238294L;

	int x1 = 100;
	int l1 = 0;
	int l2 = 0;
	int l3 = 100;

	// Generates Random Lines
	@Override
	public void paint(Graphics g) {
		Graphics2D g1d = (Graphics2D) g;
		Graphics2D g2d = (Graphics2D) g;
		Graphics2D g3d = (Graphics2D) g;

		for (int i = 1; i < 10; i++) {
			Random r = new Random();
			int Low = 100;
			int High = 200;
			int R = r.nextInt(High - Low) + Low;
			
			Random randomZahl = new Random();
			int low = 1;
			int high = 5;
			int rz; // die Zufallszahl
			rz = randomZahl.nextInt(high - low) + low;// wählt eine Zufallszahl
														// zwischen 1 - 5

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
			} else {
				l1 = 400;
				l2 = 0;
			}

			g1d.setColor(Color.blue);
			g1d.fillRect(0, x1, R, 15);
			g1d.drawRect(0, x1, R, 15);
			x1 = x1 + 80;

			g2d.setColor(Color.red);
			g2d.fillRect(0, x1, 10, 15);
			g2d.drawRect(0, x1, 10, 15);
			x1 = x1 + 80;

			g3d.setColor(Color.blue);
			g3d.fillRect(0, x1, R, 15);
			g3d.drawRect(0, x1, R, 15);
			x1 = x1 + 80;

		}
	}
}