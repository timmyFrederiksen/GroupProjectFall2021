package csi3471.edu.baylor.ecs.BaylorBurgers;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUIHandler {

	private JFrame frame;
	private JPanel panelMenu;	
	
	public void startGUI() {
		
		// Hard coded in the image paths and button text only bc i can, sue me
		
		String paths[] = {"./target/resources/fries.png", "./target/resources/hot-dog.png",
				"./target/resources/hamburger.png", "./target/resources/taco.png",
				"./target/resources/pizza.png"};
		
		String names[] = {"McFries", "McHot McDog", "McSuperBurger", "McTaco", "McPizza"};

		frame = new JFrame("Menu");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		panelMenu = new JPanel(new GridLayout(0, 2));
		panelMenu.setBounds(0, 0, 200, 500);
		frame.add(panelMenu);
		
		frame.add(new JScrollPane(panelMenu), BorderLayout.CENTER);
		List<JButton> itemButtons = new ArrayList<JButton>();
		for(int i = 0; i < paths.length; i++) {
		    ImageIcon image = new ImageIcon(paths[i]);
		    JButton button = new JButton(image);
		    button.setText(names[i]);
		    itemButtons.add(button);
		    panelMenu.add(button);
		}
		
		
		frame.setVisible(true);
		
	}

}
