package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Manager;

/**
 * This class creates and handles GUI for manager registration
 * and also provides logic for manager registration.
 * <p>
 * This class extends JFrame.
 */
public class ManagerRegistrarGUI extends JFrame  {
	private JPanel panel;
    private JLabel passwordLabel;
    private JButton registerButton;
    private JButton cancelButton;
    private JLabel failure;
    private JTextField usernameText;
    private JPasswordField passwordText;

    /**
     * This function begins the process of building the GUI for
     * a ManagerRegistrarGUI object.
     */
    ManagerRegistrarGUI(){
        createAndShowGUI();
    }
    
    /**
     * This function creates the backbone for the GUI.
     */
    public void createAndShowGUI() {
        setTitle("Manager Registration");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addGUIComponents();

        setVisible(true);
    }
    
    /**
     * This function adds GUI components to the GUI backbone, and also
     * handles logic behind the GUI. 
     */
    public void addGUIComponents() {
        panel = new JPanel();
        Color green = new Color(21, 71, 52);
        Color gold = new Color(255, 184, 28);
        panel.setBackground(gold);
        panel.setVisible(true);
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

        registerButton = new JButton("Register");
        registerButton.setBounds(10, 80, 80, 25);
        panel.add(registerButton);

        cancelButton = new JButton("Back");
        cancelButton.setBounds(100, 80, 165, 25);
        panel.add(cancelButton);

        failure = new JLabel("");
        failure.setBounds(10, 110, 300, 25);
        panel.add(failure);

        add(panel, BorderLayout.CENTER);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ManagerLoginGUI ManagerLoginGUI = new ManagerLoginGUI();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager m = new Manager(usernameText.getText(), new String(passwordText.getPassword()));
                if(usernameText.getText().equals("") || new String(passwordText.getPassword()).equals("")){
                    JOptionPane.showMessageDialog(new JFrame("Error"),
                            "Invalid credentials.", "Warning", JOptionPane.ERROR_MESSAGE);

                }
                else if(!m.managerExists()) {
                	String filename = "./target/managers.txt";
            		String managerString = m.toString() + "\n";
            		FileWriter fWriter;
					try {
						fWriter = new FileWriter(filename, true);
						fWriter.write(managerString);
						fWriter.close();
					} catch(FileNotFoundException e1){}
					catch(IOException e1) {
						e1.printStackTrace();
					}
					failure.setText("You are registered!");
					dispose();
					new ManagerMainPageGUI();
                }else {
                	JOptionPane.showMessageDialog(new JFrame("Error"), "Manager already exists", "Warning", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

    }
}
