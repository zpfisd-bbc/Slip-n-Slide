import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

	// Serial ID
	private static final long serialVersionUID = 4648172894076113183L;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Slip 'n' Slide");
		frame.add(new Main());
		frame.setSize(1920, 1050);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	LineGenerator line = new LineGenerator();	
	
}