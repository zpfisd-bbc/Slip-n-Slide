import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	
	//Variables
	private boolean ingame = true;
	private Player player;
	private Timer timer;
	private LineGenerator lg = new LineGenerator();

	// Serial ID
	private static final long serialVersionUID = 4648172894076113183L;
	
    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        player = new Player();

        timer = new Timer(5, this); //5ms
        timer.start();
    }

    public void paint(Graphics g) {
    
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void GenerateLine(Graphics g) {
    	LineGenerator lg = new LineGenerator();
    	lg.paint(g);
    }
    
    public void actionPerformed(ActionEvent e) { //Funktion wird alle 5ms aufgerufen
        player.move();
        repaint();  
    }
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
    
	public void addNotify() {
		super.addNotify();
		gameInit();
	}

	public void gameInit() {
		this.setPlayer(new Player());
		this.setLg(lg);
	}

	public boolean isIngame() {
		return ingame;
	}

	public void setIngame(boolean ingame) {
		this.ingame = ingame;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public LineGenerator getLg() {
		return lg;
	}

	public void setLg(LineGenerator lg) {
		this.lg = lg;
	}

}