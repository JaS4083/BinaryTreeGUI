import javax.swing.JFrame;

public class BFrame extends JFrame {
	
	BFrame(){
		
		setLayout(null);
		setBounds(250, 250, 1000, 600);
		setTitle("Bianry Tree Visualization");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
    ButPanel bpanel = ButPanel.getInstance();	
	BPanel pan =  BPanel.getInstance();
	
	
	add(pan);
	add(bpanel);
	
	setVisible(true);
	}
}
