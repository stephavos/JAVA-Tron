package Main;

import java.awt.Color;

import Model.Player;
import View.GameFrame;


// TODO: Auto-generated Javadoc
/**
 * The Class Tron.
 */
public class Tron {
	/**
	 * setting of the game
	 * 
	 *The pixelsize. */
	
	public static int PIXELSIZE = 2;
	/**
	 * coordinated playeurs
	 *
	 * The P 1 start X. */
	
	public static int P1StartX = 600;
	
	/** The P 1 start Y. */
	public static int P1StartY = 200;
	
	/** The P 2 start X. */
	public static int P2StartX = 0;
	
	/** The P 2 start Y. */
	public static int P2StartY = 200;
	
	/** The p 1 init orientation. */

	public static int p1InitOrientation = Player.LEFT;
	
	/** The p 2 init orientation. */
	public static int p2InitOrientation = Player.RIGHT;
	
	/** The gridw.size of the game window */
	
	public static int GRIDW = 600;
	
	/** The gridh. */
	public static int GRIDH = 400;
	
	/** The p 1 color. Blue */
	
	public static Color p1Color = new Color(3,3,173); 
	
	/** The p 2 color. Red */
	public static Color p2Color = new Color(173,3,3); 
	

	
	/** The playeur 1 name. */
	
	public static String p1Name = "Blue";
	
	/** The playeur 2 name. */
	public static String p2Name = "Red";
	
/** The Gametype. p1= <-/-> and p2= Q/D*/

	public static boolean Gametype = false;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		 System.out.println("-> Gride size: " + GRIDW + " X " + GRIDH);
		 System.out.println("-> Playeur size: " + PIXELSIZE + " pixels");
		 GameFrame f = new GameFrame();
		 f.addKeyListener(f.gamePanel);
	}
}

