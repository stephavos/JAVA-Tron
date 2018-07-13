package Controller;

import java.awt.Graphics;
import java.util.Date;

import Main.Tron;
import Model.Player;
import View.GamePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class GameLogic.
 */
public class GameLogic {
	
	/** The player 2. */
	private Player player1, player2;
	
	/** The height. */
	private int width, height;

	/**
	 * Instantiates a new game logic.
	 *
	 * @param maxWidth the max width
	 * @param maxHeight the max height
	 */
	public GameLogic(int maxWidth, int maxHeight) {
		
		width = maxWidth;
		height = maxHeight;

		player1 = new Player(Tron.p1Name,Tron.p1InitOrientation, Tron.p1Color, Tron.P1StartX * Tron.PIXELSIZE, Tron.P1StartY * Tron.PIXELSIZE);  
		player2 = new Player(Tron.p2Name, Tron.p2InitOrientation, Tron.p2Color, Tron.P2StartX * Tron.PIXELSIZE, Tron.P2StartY * Tron.PIXELSIZE); 
		
	}


	/**
	 * Sets the p 1 direction.
	 *
	 * @param direct the new p 1 direction
	 */
	public void setP1Direction(int direct) {
		
		player1.setDirection(direct);
	}

	/**
	 * Sets the p 2 direction.
	 *
	 * @param direct the new p 2 direction
	 */
	public void setP2Direction(int direct) {
		
		player2.setDirection(direct);
	}

	/**
	 * Gets the p 1 name.
	 *
	 * @return the p 1 name
	 */
	public String getP1Name() 
	{
		return player1.getName();
	}

	/**
	 * Gets the p 2 name.
	 *
	 * @return the p 2 name
	 */
	public String getP2Name() {
		
		return player2.getName();
	}

	/**
	 * Gets the p1.
	 *
	 * @return the p1
	 */
	public Player getP1() {
		
		return player1;
	}

	/**
	 * Gets the p2.
	 *
	 * @return the p2
	 */
	public Player getP2() {
		
		return player2;
	}


	/**
	 * Step and ok.
	 *
	 * @return true, if successful
	 */
	public boolean stepAndOk() {

		player1.step();
		player2.step();
		
		/**
		 * Checking the finished status of the game.
		 */
		if(player1.loosed(player2, width, height))
		{
			player2.isWinner(GameOverTimer());
			return false;
		}
		else if(player2.loosed(player1, width, height))
		{
			player1.isWinner(GameOverTimer());
			return false;
		}
		/**
		 * If no one has lost, then the game continues.
		 */
		return true;
	}
	
	/**
	 * Game over timer.
	 *
	 * @return the long
	 */
	public long GameOverTimer() {
		
		/**
		 * Takes current date, subtracts the initial time -> Execution time.
		 */
		long GameTimer = (new Date()).getTime() - GamePanel.startTime;
		return GameTimer;
	}


	/**
	 * Reset Position of the players.
	 */
	public void reset() {
		
		player1 = new Player(Tron.p1Name,Tron.p1InitOrientation, Tron.p1Color, Tron.P1StartX * Tron.PIXELSIZE, Tron.P1StartY * Tron.PIXELSIZE);
		player2 = new Player(Tron.p2Name,Tron.p2InitOrientation, Tron.p2Color, Tron.P2StartX * Tron.PIXELSIZE, Tron.P2StartY * Tron.PIXELSIZE);
	}



	/**
	 * Draw.
	 *
	 * @param g the g
	 */
	public void draw(Graphics g) {
		
		player1.draw(g);
		player2.draw(g);
	}

	
}
