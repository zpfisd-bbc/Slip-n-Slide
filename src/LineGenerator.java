import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class LineGenerator extends Main {	
	
	// ID
	private static final long serialVersionUID = -8999417439148765241L;

	// Generates Random Lines
	public void generateLine(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLUE);
		g2d.drawLine(10, 20, 10, 20);
	}

}
