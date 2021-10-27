package csi3471.edu.baylor.ecs.BaylorBurgers;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUIHandler {

	private JFrame frame;
	private JPanel panel;	
	
	public void startGUI() {

		frame = new JFrame("Menu");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("Items:");
		label.setBounds(10, 20, 80, 25);
		panel.add(label);

		
		
		
		frame.setVisible(true);
		
	}

}
