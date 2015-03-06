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
}