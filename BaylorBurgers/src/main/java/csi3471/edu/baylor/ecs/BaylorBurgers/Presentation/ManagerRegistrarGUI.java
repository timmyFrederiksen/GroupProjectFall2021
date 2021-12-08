package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class ManagerRegistrarGUI extends JFrame  {
	private JPanel panel;
    private JLabel passwordLabel;
    private JButton registerButton;
    private JButton cancelButton;
    private JLabel failure;
    private JTextField usernameText;
    private JPasswordField passwordText;

    ManagerRegistrarGUI(){
        createAndShowGUI();
    }

    public void createAndShowGUI() {
        setTitle("Manager Registration");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addGUIComponents();

        setVisible(true);
    }
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
                if(!m.managerExists()) {
                	String filename = "./target/resources/managers.txt";
            		String managerString = m.toString() + "\n";
            		FileWriter fWriter;
					try {
						fWriter = new FileWriter(filename);
						fWriter.write(managerString);
						fWriter.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					failure.setText("You are registered!");
                }else {
                	JOptionPane.showMessageDialog(new JFrame("Error"), "Manager already exists", "Warning", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

    }
}
