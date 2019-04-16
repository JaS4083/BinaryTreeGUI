import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TCommand {
	
	
	
	private static TCommand instance;
	public TreeGui tr;
	public DrawPanel aDraw;
	public AddValue addVal;
	public DelValue delVal;
	public InitializeVal iniVal;
	boolean initialize;
	
	private TCommand() {
		aDraw = new DrawPanel();
		addVal = new AddValue();
		delVal = new DelValue();
		iniVal = new InitializeVal();
		tr = TreeGui.getInstance();
		initialize = true;
	}
	
	public static TCommand getInstance() {
		if (instance  ==null) instance = new TCommand();
		
	  return instance;
	}
	
	
	private class DrawPanel implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(initialize) {
			int [] ini = {50, 60, 30, 20, 25, 26, 15, 22, 28, 24, 65, 75, 73, 55, 64, 61, 62, 80};
			tr.init(ini);
			initialize = false;
			}

			BPanel pan = BPanel.getInstance();
			pan.repaint();
			System.out.println("Drawing");
		}
	}
	
	private class AddValue implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (tr != null) {				
			tr.add(Integer.parseInt(ButPanel.getInstance().textAdd.getText()));
			BPanel pan = BPanel.getInstance();
			pan.repaint();
			}
			
		}
	}
	private class DelValue implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			tr.del(Integer.parseInt(ButPanel.getInstance().textDel.getText()));
			BPanel pan = BPanel.getInstance();
			pan.repaint();
		}
		
	}
	
	private class InitializeVal implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			BPanel pan = BPanel.getInstance();
			String val = ButPanel.getInstance().initArr.getText();
			String valArr[] = val.split(", ");
			for (String S: valArr) {
				try {
					
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tr.add(Integer.parseInt(S));
				
				pan.repaint();
				
			}
			
		}
		
	}

}
