package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.GameLogic;
import Main.Tron;
import Model.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class GamePanel.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The logic. */
	private GameLogic logic;
	
	/** The Constant H. */
	public static final int W = Tron.GRIDW * Tron.PIXELSIZE, H = Tron.GRIDH * Tron.PIXELSIZE;

	/** The Clock. */
	Timer Clock;
	
	/** The start time. */
	public static long  startTime;

	/**
	 * Instantiates a new game panel.
	 */
	public GamePanel() {
		
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		setSize(W, H);
	
		
		
		logic = new GameLogic(W, H);
		Clock = new Timer(30, this);

	}

	

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		logic.draw(g);
	}


	
	/**
	 * Start.
	 */
	public void start() {
		/*
		 * calculates part time
		 */
		startTime = System.currentTimeMillis();
		/*
		 * reset the logic
		 */
				logic.reset();
		/*
		 * starting the clock
		 */
		Clock.start();
		System.out.println("-> Start!");
	}
	
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		/*
		 * With each cycle of Clock
		 */
		if(e.getSource()==Clock)
		{
			/*
			 * the game continues
			 */
			if(logic.stepAndOk())
				/*
				 * Show the advancements of the two calculated players in stepAndOk
				 */
				repaint();
			else
			{   /*
				 * Otherwise he stops
				 */
				Clock.stop();	
			}
			repaint();
		}

	}

/* (non-Javadoc)
 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
 */
public void keyPressed(KeyEvent e) {
	/*
	 * Player 1 keys if "directional" mode
	 */
	if(e.getKeyCode() == KeyEvent.VK_DOWN && Tron.Gametype == true){
		if(logic.getP1().getDirection() != Player.UP)
			logic.setP1Direction(Player.DOWN);
	}
	else if(e.getKeyCode() == KeyEvent.VK_UP && Tron.Gametype == true){
		if(logic.getP1().getDirection() != Player.DOWN)
			logic.setP1Direction(Player.UP);
	}
	else if(e.getKeyCode() == KeyEvent.VK_LEFT && Tron.Gametype == true){
		if(logic.getP1().getDirection() != Player.RIGHT)
			logic.setP1Direction(Player.LEFT);
	}
	else if(e.getKeyCode() == KeyEvent.VK_RIGHT && Tron.Gametype == true){
		if(logic.getP1().getDirection() != Player.LEFT)
			logic.setP1Direction(Player.RIGHT);
	}

	/*
	 * Player 2 keys if "directional" mode
	 */
	if(e.getKeyCode() == KeyEvent.VK_S && Tron.Gametype == true){
		if(logic.getP2().getDirection() != Player.UP)
			logic.setP2Direction(Player.DOWN);
	}
	else if(e.getKeyCode() == KeyEvent.VK_Z && Tron.Gametype == true){
		if(logic.getP2().getDirection() != Player.DOWN)
			logic.setP2Direction(Player.UP);
	}
	else if(e.getKeyCode() == KeyEvent.VK_Q && Tron.Gametype == true){
		if(logic.getP2().getDirection() != Player.RIGHT)
			logic.setP2Direction(Player.LEFT);
	}
	else if(e.getKeyCode() == KeyEvent.VK_D && Tron.Gametype == true){
		if(logic.getP2().getDirection() != Player.LEFT)
			logic.setP2Direction(Player.RIGHT);
	}
	
	/*
	 * Player 1 keys if "pivot" mode
	 * 
	 * the result is not a modulo but returns a negative number
	 */
	
	if(e.getKeyCode() == KeyEvent.VK_LEFT && Tron.Gametype == false){
		logic.setP1Direction(((logic.getP1().getDirection()) - 1) % 4);
	}
	else if(e.getKeyCode() == KeyEvent.VK_RIGHT && Tron.Gametype == false){
		logic.setP1Direction(((logic.getP1().getDirection()) + 1) % 4);
	}

			
	/*
	 *  Player 1 keys if "pivot" mode
	 *  
	 *  the result is not a modulo but returns a negative number
	 */
	
	if(e.getKeyCode() == KeyEvent.VK_Q && Tron.Gametype == false){
		logic.setP2Direction(((logic.getP2().getDirection()) - 1) % 4);
	}
	else if(e.getKeyCode() == KeyEvent.VK_D && Tron.Gametype == false){
		logic.setP2Direction(((logic.getP2().getDirection()) + 1) % 4);
	}
			
	/*
	 * restart a new game
	 */
	if(e.getKeyCode() == KeyEvent.VK_F8)
	{
		start();
	}
}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}



}
