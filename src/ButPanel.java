import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButPanel extends JPanel{
	JButton btnDraw;
	public JTextField textAdd;
	JButton btnAdd;
	JTextField textDel;
	JButton btnDel;
	JTextArea initArr;
	JButton btnArr;
	
	static boolean drawPanel = true;
	
	
private static ButPanel instance;

public static ButPanel getInstance() {
	if (instance == null) instance = new ButPanel();
	return instance;
}
public ButPanel() {
	setLayout(null);
	setBounds(800, 0, 200, 600);
	setBackground(Color.GREEN);
	btnDraw = new JButton("DRAW");
	btnDraw.setBounds(35, 10, 130, 50);
	
	add(btnDraw);
	
	textAdd = new JTextField();
	textAdd.setBounds(25, 70, 150, 50);
	
	add(textAdd);
	
	btnAdd = new JButton("ADD");
	btnAdd.setBounds(35, 130, 130, 50);
	
	add(btnAdd);
	
	textDel = new JTextField();
	textDel.setBounds(25, 200, 150, 50);
	
	add(textDel);
	
	btnDel = new JButton("DELETE");
	btnDel.setBounds(35, 260, 130, 50);
	
	add(btnDel);
	
	
	 initArr = new JTextArea();
	 initArr.setBounds(25, 320, 150, 150);
	 initArr.setLineWrap(true);
	 initArr.setWrapStyleWord(true);
	add(initArr);
	
	btnArr = new JButton("INITIALIZE");
	btnArr.setBounds(35, 480, 130, 50);
	
	add(btnArr);
	
	
	
	

btnDraw.addActionListener(TCommand.getInstance().aDraw);
btnAdd.addActionListener(TCommand.getInstance().addVal);
btnDel.addActionListener(TCommand.getInstance().delVal);
btnArr.addActionListener(TCommand.getInstance().iniVal);
}

}
