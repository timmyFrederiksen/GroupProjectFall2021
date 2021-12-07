package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PaymentGUI extends JDialog {
	
	private JLabel rewardLabel;
	// FIXME: I think putting a private double(or float) price here makes sense
	
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
        gridPane.setLayout(new GridLayout(2, 2, 2, 2));
        
        rewardLabel = new JLabel();
        
        JButton cardButton = new JButton("Card");
        JButton otherButton = new JButton("Other");
        JButton rewardButton = new JButton("Press for Discount");
        JButton cancelButton = new JButton("Cancel");
        
        gridPane.add(cardButton);
        gridPane.add(otherButton);
        gridPane.add(cancelButton);
        gridPane.add(rewardButton);
        
        paymentPanel.add(gridPane);
        paymentPanel.add(rewardLabel);
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
    
        rewardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				int pick = random.nextInt();
				if (pick % 1000 == 0) {
					rewardLabel.setText("You won a 100% discount!!!");
					PurchaseLogGUI receipt = new PurchaseLogGUI();
				} else if (pick % 100 == 0) {
					rewardLabel.setText("You won a 50% discount!!!");
					// Add discount to price
				} else if (pick % 10 == 0) {
					// Add discount to price
					rewardLabel.setText("You won a 10% discount!!!");
				} else {
					rewardLabel.setText("You did not win a discount");
				}
				rewardButton.setEnabled(false);
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

