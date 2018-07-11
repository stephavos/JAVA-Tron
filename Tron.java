package Main;

import java.awt.Color;

import Model.Player;
import View.GameFrame;


public class Tron {
	/*
	 * setting of the game
	 */
	
	/*
	 * Size of pixel
	 */
	public static int PIXELSIZE = 2;
	
	/*
	 * coordinated playeurs
	 */
	public static int P1StartX = 600;
	public static int P1StartY = 200;
	
	public static int P2StartX = 0;
	public static int P2StartY = 200;
	
	//Orientation de départ(Player.LEFT/RIGHT/UP/DOWN)
	public static int p1InitOrientation = Player.LEFT;
	public static int p2InitOrientation = Player.RIGHT;
	
	/*
	 * size of the game window
	 */
	public static int GRIDW = 600;
	public static int GRIDH = 400;
	
	/*
	 * RGB color of the 2 players
	 */
	public static Color p1Color = new Color(3,3,173); 
	/*
	 * blue
	 */
	
	public static Color p2Color = new Color(173,3,3); 
	/*
	 * Red
	 */

	
	/*
	 * Nickname of the players
	 */
	public static String p1Name = "Blue";
	public static String p2Name = "Red";
	
/*
 * Motion type (Pivot: use the Q, D and <-, -> keys to change angles (false), Direction: use direction keys (true).
 */
	public static boolean Gametype = false;
	
	
	
	public static void main(String[] args) {
		
		 System.out.println("-> Gride size: " + GRIDW + " X " + GRIDH);
		 System.out.println("-> Playeur size: " + PIXELSIZE + " pixels");
		 GameFrame f = new GameFrame();
		 f.addKeyListener(f.gamePanel);
	}
}

