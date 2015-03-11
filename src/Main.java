import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
	protected static JFrame frame = new JFrame("Slip 'n' Slide");

	// Serial ID
	private static final long serialVersionUID = 4648172894076113183L;

	public static void main(String[] args) throws IOException {
		frame.add(new Main());
		frame.setSize(527, 900);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.ORANGE);
	}

	public void paint(Graphics g) {
		LineGenerator l = new LineGenerator();
		l.paint(g);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		Main.frame = frame;
	}
}