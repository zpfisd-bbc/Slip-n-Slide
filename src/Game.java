import java.awt.Graphics;

import javax.swing.JFrame;


public class Game extends JFrame{
	
	//Variables
	private int y1 = 230; //Länge von Abständen zwischen Linien

	private static final long serialVersionUID = -7803629994015778818L;

	public void paint(Graphics g) {
		LineGenerator l = new LineGenerator();
		l.paint(g);
	}
	
	public Game() {
		add(new Board());
		setSize(517, 1000); // Breite und Länge von Fenster
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	public static void main(String[] args) {
		new Game();
		paint(g);
	}
	
	//Getters and setters
	public int getY1() {
		return y1;
	}

	public void setY1(int y) {
		this.y1 = y;
	}

}