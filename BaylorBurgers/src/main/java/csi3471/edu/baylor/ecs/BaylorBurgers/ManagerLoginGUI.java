package csi3471.edu.baylor.ecs.BaylorBurgers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class ManagerLoginGUI extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel failure;
    private JTextField usernameText;
    private JPasswordField passwordText;

    ManagerLoginGUI(){
        createAndShowGUI();
    }

    public void createAndShowGUI() {
        setTitle("Manager Login");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addGUIComponents();

        setVisible(true);
    }
    public void addGUIComponents() {
        panel = new JPanel();
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

        loginButton = new JButton("LoginGUI");
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

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

