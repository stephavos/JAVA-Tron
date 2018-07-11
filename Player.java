package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Main.Tron;

public class Player {

	private String name;
	private int direction;
	private LengthNode head;
	private Color color;

	public static int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

	public Player(String name, int direction, Color color, int x, int y) {
		
		this.name = name;
		this.direction = direction;
		this.color = color;
		head = new LengthNode(x, y, null);
	}

	public String getName() {
		
		return name;
	}

	public void setDirection(int direction) {
		
		this.direction = direction;
	}



	public int getDirection() {
		
		return direction;
	}

	public LengthNode getHead() {
		
		return head;
	}

	public void step()
	{
		switch(direction)
		{
		case 0: 		//UP
			head = new LengthNode(head.getX(), head.getY() - Tron.PIXELSIZE, head);
			break;
		case 1: 		//RIGHT
			head = new LengthNode(head.getX() + Tron.PIXELSIZE, head.getY(), head);
			break;
		case 2: 		//DOWN
			head = new LengthNode(head.getX(), head.getY() + Tron.PIXELSIZE, head);
			break;
		case 3: 		//LEFT
			head = new LengthNode(head.getX() - Tron.PIXELSIZE, head.getY(), head);
			break;
		case -1: 		//LEFT DEBUG: En Java % n'est pas MODULO, mais RESTE donc si reste négatif, alors revenir à la norme.
			this.direction = 3;
			head = new LengthNode(head.getX(), head.getY() - Tron.PIXELSIZE, head);
			break;
		}

	}



	public boolean loosed(Player other, int maxWidth, int maxHeight)
	{
		/*
		 * collision with oneself
		 */
		for(LengthNode p = head.getNext(); p.getNext() != null ; p = p.getNext())
			if(head.sameValues(p))
				return true;
		/*
		 * collision with the opponent
		 */
		for(LengthNode p = other.getHead(); p.getNext() != null ; p = p.getNext())
			if(head.sameValues(p))
				return true;
		/*
		 * collision with a wall
		 */
		if(head.getX() < 0 || head.getY() < 0 || head.getX() > maxWidth + Tron.PIXELSIZE || head.getY() > maxHeight + Tron.PIXELSIZE)
			return true;

		return false;
	}
	
	public void isWinner(long gameTimer) {
		
		/*
		 * long converted to float
		 */
		float GameTimer = gameTimer;
		GameTimer = GameTimer/1000;
		String Time = Float.toString(GameTimer);
		
		try {
			String url="jdbc:mysql://chabanvpn.ovh:3306/tron?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		    String user="root";
		    String password="";
		   
		    Connection conn = null;
		    conn = DriverManager.getConnection(url, user, password);
		    System.out.println("[SQL] - connected to the bdd!");
		    
		    CallableStatement cStmt = conn.prepareCall("{call add_record(?, ?)}");
		    cStmt.setString(1, this.getName());
		    cStmt.setString(2, Time);
		    cStmt.execute();
		    System.out.println("[SQL] - Saved in the BDD!");


		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		System.out.println("->playeur " + this.getName() + " Won!");
		System.out.println("->time of the game: " + GameTimer + "s");
		System.out.println("-> END!");
		
		/*
		 * Pop-up window
		 */
		JOptionPane.showMessageDialog(null, "Playeur " + this.getName() + " WON!\npress F8 after OK to start again", "Game Over", JOptionPane.INFORMATION_MESSAGE);
	}


	public void draw(Graphics g)
	{
		g.setColor(color);
		LengthNode p = head;
		for(;p != null; p=p.getNext()) {
			g.fillRect(p.getX(), p.getY(), Tron.PIXELSIZE, Tron.PIXELSIZE);	//AJOUTER au joueur un carré de pos getX, getY de la taille PIXELSIZE
		}
	}
	
	
}




