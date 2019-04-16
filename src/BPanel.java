import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BPanel extends JPanel {
	
	private static BPanel instance ;
	public static BPanel getInstance() {
		if (instance == null) instance = new BPanel();
	   return instance;
		}
	private BPanel() {
		setBounds(0, 0, 800, 600);
		setBackground(Color.BLUE);
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		TreeGui tr = TCommand.getInstance().tr;
		
		System.out.println("Paint");
			tr.draw((Graphics2D)g, 800);
			
			
		}
}
