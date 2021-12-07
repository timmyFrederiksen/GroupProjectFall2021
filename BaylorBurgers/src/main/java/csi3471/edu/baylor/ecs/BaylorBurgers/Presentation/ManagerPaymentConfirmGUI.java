package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class ManagerPaymentConfirmGUI extends JFrame {

    private JPanel panel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JLabel failure;
    private JTextField usernameText;
    private JPasswordField passwordText;

    ManagerPaymentConfirmGUI(){
        createAndShowGUI();
    }

    public void createAndShowGUI() {
        setTitle("Manager Payment Confirmation");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addGUIComponents();

        setVisible(true);
    }
    public void addGUIComponents() {
        Color gold = new Color(255, 184, 28);
    	
        panel = new JPanel();
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

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        failure = new JLabel("");
        failure.setBounds(10, 110, 300, 25);
        panel.add(failure);

        add(panel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Check for valid credentials
                // If valid, complete purchase. else don't
                Manager m = new Manager(usernameText.getText(), new String(passwordText.getPassword()));
                if (m.managerExists()) {
                	// Complete purchase
                	PurchaseLogGUI receipt = new PurchaseLogGUI(usernameText.getText(), 2);
                	dispose();
                } else {
                	JOptionPane.showMessageDialog(new JFrame("Error"), "Manager does not exist", "Warning", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
    }


}


