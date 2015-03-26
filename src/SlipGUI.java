import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlipGUI extends JFrame {

	private static final long serialVersionUID = -1682033293925443840L;
	
	//Buttons vom Main Menu
	JPanel menuPane = new JPanel(new GridLayout(5, 1));
	JButton start = new JButton("START");
	JButton store = new JButton("STORE");
	JButton score = new JButton("SCORE");
	JLabel menuLabel = new JLabel("<html><span style='font-size:20px'>Main Menu</span></html>", JLabel.CENTER);
	Player player = new Player();
	
	//Buttons vom Mode Menu
	JPanel modePane = new JPanel(new GridLayout(5, 1));
	JButton normal = new JButton("NORMAL");
	JButton hard = new JButton("HARD");
	JButton multiplayer = new JButton("MULTIPLAYER");
	JLabel modeLabel = new JLabel("<html><span style='font-size:20px'>Mode Menu</span></html>", JLabel.CENTER);
	
	private int playerSpeedDown;
	private int playerSpeed;

	public SlipGUI() {
		
		//Fügt Buttons ins Main Menu hinzu
		menuPane.add(menuLabel);
		menuPane.add(start);
		menuPane.add(store);
		menuPane.add(score);
		
		//Fügt Buttons ins Mode Menu hinzu
		modePane.add(modeLabel);
		modePane.add(normal);
		modePane.add(hard);
		modePane.add(multiplayer);
		
		//Durchsichtige Buttons
		this.getStart().setBorder((BorderFactory.createEmptyBorder(15, 15, 15, 15)));
		this.getStart().setBorderPainted(true);
		this.getStart().setContentAreaFilled(false);
		this.getStart().setFocusPainted(false);
		
		this.getStore().setBorder((BorderFactory.createEmptyBorder(15, 15, 15, 15)));
		this.getStore().setBorderPainted(true);
		this.getStore().setContentAreaFilled(false);
		this.getStore().setFocusPainted(false);
		
		this.getScore().setBorder((BorderFactory.createEmptyBorder(15, 15, 15, 15)));
		this.getScore().setBorderPainted(true);
		this.getScore().setContentAreaFilled(false);
		this.getScore().setFocusPainted(false);
		
		this.getNormal().setBorder((BorderFactory.createEmptyBorder(15, 15, 15, 15)));
		this.getNormal().setBorderPainted(true);
		this.getNormal().setContentAreaFilled(false);
		this.getNormal().setFocusPainted(false);
		
		this.getHard().setBorder((BorderFactory.createEmptyBorder(15, 15, 15, 15)));
		this.getHard().setBorderPainted(true);
		this.getHard().setContentAreaFilled(false);
		this.getHard().setFocusPainted(false);
		
		this.getMultiplayer().setBorder((BorderFactory.createEmptyBorder(15, 15, 15, 15)));
		this.getMultiplayer().setBorderPainted(true);
		this.getMultiplayer().setContentAreaFilled(false);
		this.getMultiplayer().setFocusPainted(false);

		//Erzeugt das JFrame
		JFrame frame = new JFrame("Slip'n'Slide");
		frame.setSize(517, 1000); // Breite und Länge von Fenster
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(menuPane, BorderLayout.CENTER);
		
		//Listener für den Start Knopf im Main Menu
	    start.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			menuPane.setVisible(false); //Versteckt das Main Menu
	    			frame.add(modePane, BorderLayout.CENTER);
	    		} catch (NullPointerException e1) {
	    		}
	    		
	    	}
	    });
	    
	    //Listener für den Normal Knopf im Mode Menu
	    normal.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			frame.dispose();
	    			new Board(15, 7);
	    		} catch (NullPointerException e1) {
	    		}
	    		
	    	}
	    });
	    
	    //Listener für den Hard Knopf im Mode Menu
	    hard.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			frame.dispose();
	    			new Board(1, 4);
	    		} catch (NullPointerException e1) {
	    		}
	    	}
	    });
	}

	public JPanel getMenuPane() {
		return menuPane;
	}

	public void setMenuPane(JPanel menuPane) {
		this.menuPane = menuPane;
	}

	public JPanel getModePane() {
		return modePane;
	}

	public void setModePane(JPanel modePane) {
		this.modePane = modePane;
	}

	public static void main(String[] args) {
		new SlipGUI();
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	public JButton getStore() {
		return store;
	}

	public void setStore(JButton store) {
		this.store = store;
	}

	public JButton getScore() {
		return score;
	}

	public void setScore(JButton score) {
		this.score = score;
	}

	public JButton getNormal() {
		return normal;
	}

	public void setNormal(JButton normal) {
		this.normal = normal;
	}

	public JButton getHard() {
		return hard;
	}

	public void setHard(JButton hard) {
		this.hard = hard;
	}

	public JButton getMultiplayer() {
		return multiplayer;
	}

	public void setMultiplayer(JButton multiplayer) {
		this.multiplayer = multiplayer;
	}

	public int getPlayerSpeedDown() {
		return playerSpeedDown;
	}

	public void setPlayerSpeedDown(int playerSpeedDown) {
		this.playerSpeedDown = playerSpeedDown;
	}

	public int getPlayerSpeedLeft() {
		return playerSpeed;
	}

	public void setPlayerSpeedLeft(int playerSpeedLeft) {
		this.playerSpeed = playerSpeedLeft;
	}

}