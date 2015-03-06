import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 * 
 */

/**
 * @author Dominic Pfister, ICT Berufsbildungscenter AG, dominic.pfister@bbcag.ch
 *
 */
class Player extends Main {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void drawPlayer(Graphics g) { //Zeichnet ein dreieck
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setPaint(Color.cyan);
		g2d.draw(new Line2D.Double(50, 150, 150, 150));
		g2d.draw(new Line2D.Double(50, 150, 150, 150));
		g2d.draw(new Line2D.Double(50, 150, 150, 150));
	}
	
	public static void move(String direction) {
	}
	
}
