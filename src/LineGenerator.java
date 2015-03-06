import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class LineGenerator extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3059159587358238294L;

	int x1 = 100;
	
	// Generates Random Lines
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		for (int i = 1; i < 10; i++)	{
			Random r = new Random();
			int Low = 200;
			int High = 400;
			int R = r.nextInt(High-Low) + Low;
			
			g2d.setColor(Color.BLUE);
			g2d.fillRect(0, x1, R, 15);
			g2d.drawRect(0, x1, R, 15);
			
			x1 += 250;
		}
	}
	
	public static void randomZahl()  {
		int l1 = 0;
		int l2 = 0;
		int l3 = 100; //Länge vom Abstand, bleibt gleich
		Random randomZahl = new Random();
		int low = 1;
		int high = 5;
		int r; //die Zufallszahl
		
		while (playerDead != true) { //prüft ob der Spieler bereits tot ist
			r = randomZahl.nextInt(high-low)+low;//wählt eine Zufallszahl zwischen 1 bis 5
			
			if (r == 1) {
				l1 = 0;
				l2 = 400;
			} else if (r == 2) {
				l1 = 100;
				l2 = 300;
			} else if (r == 3) {
				l1 = 200;
				l2 = 200;
			} else if (r == 4) {
				l1 = 300;
				l2 = 100;
			} else {
				l1 = 400;
				l2 = 0;
			}
		}
	}
}