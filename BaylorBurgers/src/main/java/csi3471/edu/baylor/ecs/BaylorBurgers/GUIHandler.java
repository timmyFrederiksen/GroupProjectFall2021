package csi3471.edu.baylor.ecs.BaylorBurgers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.plaf.MenuBarUI;

public class GUIHandler implements ActionListener {

	private JFrame frame;
	private JPanel panelMenu;
	private JMenuBar header;
	private JMenu menu;
	private JMenuItem exit;
	
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

		header = new JMenuBar();

		menu = new JMenu("Menu");
		menu.setSize(100, 100);
		header.add(menu);
		exit = new JMenuItem("Exit");
		menu.add(exit);
		frame.setJMenuBar(header);


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
		    
		    button.addActionListener(this);
		}
		
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// FIXME: we will have to change this to be able to tell which item got selected
		
		
		JDialog addItem = new JDialog();
		addItem.setSize(500, 500);
		addItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		addItem.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("How many of this item would you like?");
		label.setBounds(10, 20, 250, 25);
		panel.add(label);

		JTextField quantity = new JTextField();
		quantity.setBounds(10, 50, 65, 25);
		panel.add(quantity);

		JLabel notesLabel = new JLabel("Are there any changes you would like to make to the item?");
		notesLabel.setBounds(10, 130, 375, 25);
		panel.add(notesLabel);

		JTextArea notes = new JTextArea();
		notes.setLineWrap(true);
		notes.setBounds(10, 160, 375, 200);
		panel.add(notes);

		addItem.setVisible(true);
		
	}

}
