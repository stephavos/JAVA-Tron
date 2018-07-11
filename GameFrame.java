package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class GameFrame.
 */
public class GameFrame extends JFrame implements ActionListener{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The Constant FRAME_HEIGHT. */
	public static final int FRAME_WIDTH = GamePanel.W, FRAME_HEIGHT = GamePanel.H;

	
	/** The game panel. */
	public GamePanel gamePanel;

	/**
	 * Instantiates a new game frame.
	 */
	public GameFrame() {
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Tron Java");
		setResizable(false);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		gamePanel = new GamePanel();
		
		gamePanel.setVisible(true);
		add(gamePanel);
		gamePanel.start();
		
		setVisible(true);
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		
			gamePanel.setVisible(true);
			add(gamePanel);
			gamePanel.start();
		
	}

}
