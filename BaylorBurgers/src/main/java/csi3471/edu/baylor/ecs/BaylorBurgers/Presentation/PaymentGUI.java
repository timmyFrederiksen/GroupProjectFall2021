package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentGUI extends JDialog {
    public PaymentGUI(){
        createAndShowGUI();
    }
    private void createAndShowGUI(){
        this.setTitle("Baylor Burgers Pay for Cart");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        //this.pack();
        this.setSize(400, 450);
        this.setVisible(true);
    }
    private void addGUIComponents() {
        JPanel paymentPanel = new JPanel();
        
        JPanel gridPane = new JPanel();
        gridPane.setLayout(new GridLayout(3, 2, 2, 2));
        
        JLabel codeLabel = new JLabel("Rewards Code:");
        gridPane.add(codeLabel);

        JTextField codeTextField = new JTextField();
        gridPane.add(codeTextField);
        
        JButton cardButton = new JButton("Card");
        JButton otherButton = new JButton("Other");
        JButton applyCodeButton = new JButton("Apply Code");
        JButton cancelButton = new JButton("Cancel");
        
        gridPane.add(cardButton);
        gridPane.add(otherButton);
        gridPane.add(cancelButton);
        gridPane.add(applyCodeButton);
        
        paymentPanel.add(gridPane);
        add(paymentPanel);
        
        cardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardPaymentGUI cardPaymentGUI = new CardPaymentGUI();
			}
        });
        
        otherButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerPaymentConfirmGUI managerOverride = new ManagerPaymentConfirmGUI();
			}
        });
    
        applyCodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Check Reward for the entered code
			}
        });
        
        cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
        });
    }
}

