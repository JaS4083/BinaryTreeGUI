import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TreeGui extends BinaryTreeAVL {
	int r = 15;
	int d = r *2;
	
	BPanel panel = BPanel.getInstance();

	private static TreeGui instance;
	
	public static TreeGui getInstance() {
		if (instance == null) instance = new TreeGui();
	  return instance;
	}
	public void draw (Graphics2D gg, int right) {
		drawNode(gg, 0, right, 1, 50, root);
		//panel.repaint();
	}
	
	
public void drawNode (Graphics2D gg,int left, int right, int level, int dy, Node n) {
	System.out.println("new feture!!!");
		if (n == null) return;
		int x = (left + right)/2;
		int y = level * dy;
		
		int x0 = x -r;
		int y0 = y - d+2;
		
		String text = String.valueOf(n.val);
		int strW = gg.getFontMetrics().stringWidth(String.valueOf(n.val));
		int strH = gg.getFontMetrics().getHeight();
		int strX = x - strW/2;
		int strY = y - strH/2;
		
		gg.setColor(Color.GREEN);
		gg.setStroke(new BasicStroke(3));
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gg.drawOval(x0, y0, d, d);
		
		
		if (n.left != null) {
			gg.setColor(Color.RED);
			gg.setStroke(new BasicStroke(1));
			
			gg.drawLine(x, y-r, (left +x)/2, (level +1) * dy -r);
		}
		
		if (n.right != null) {
			gg.setColor(Color.RED);
			gg.setStroke(new BasicStroke(1));
			
			gg.drawLine(x, y-r, (x + right)/2, (level +1) * dy -r);
		}
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		gg.setColor(Color.ORANGE);
		gg.setStroke(new BasicStroke(2));
		gg.drawString(text, strX, strY);
		
		
		drawNode(gg, left, x, level+1, dy, n.left);
		drawNode(gg, x, right, level+1, dy, n.right);
	}

}
