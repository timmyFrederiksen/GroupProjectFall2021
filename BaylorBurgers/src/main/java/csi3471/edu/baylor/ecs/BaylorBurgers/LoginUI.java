package csi3471.edu.baylor.ecs.BaylorBurgers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class LoginUI implements ActionListener {
	

	private JFrame frame;
	private JPanel panel;
	private JLabel passwordLabel;
	private JButton loginButton;
	private JButton registerButton;
	private JLabel failure;
	private JTextField usernameText;
	private JPasswordField passwordText;

	public static Manager manager;

	public void beginLogin() {
		
		frame = new JFrame("Manager Login");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("Username:");
		label.setBounds(10, 20, 80, 25);
		panel.add(label);

		usernameText = new JTextField();
		usernameText.setBounds(100, 20, 165, 25);
		panel.add(usernameText);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);

		loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
		loginButton.addActionListener(this);

		registerButton = new JButton("Register Manager");
		registerButton.setBounds(100, 80, 165, 25);
		panel.add(registerButton);
		registerButton.addActionListener(this);

		failure = new JLabel("");
		failure.setBounds(10, 110, 300, 25);
		panel.add(failure);

		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Manager manager = new Manager(usernameText.getText(), String.valueOf(passwordText.getPassword()));
		if (e.getSource() == loginButton) {
			
			if (manager.managerExists()) {
				// manager authenticated
				
				//load
				frame.dispose();
				LoginUI.manager = manager;
				GUIHandler ui = new GUIHandler();
				ui.startGUI();
				
			} else {
				// failed authentication
				
				failure.setText("Invalid credentials");
			}
			
		} else if (e.getSource() == registerButton) {
			
			//create file for this new manager
			if(manager.managerExists()) {
				
				// Attempted to register existing manager
				JOptionPane.showMessageDialog(new JFrame("Error"), "Manager already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			
			} else {
			
				// Registering new manager
				LoginUI.manager = manager;
				
				String str = manager.toString();
				try {
					FileWriter myWriter = new FileWriter("./target/resources/managers.txt", true);
					myWriter.write(str + '\n');
					myWriter.close();
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				frame.dispose();
				GUIHandler ui = new GUIHandler();
				ui.startGUI();
			}
		}
	}
	
	public static void main(String args[]) {
		LoginUI loginui = new LoginUI();
		loginui.beginLogin();
	}
	
}