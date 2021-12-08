package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * This class creates and manages Payment options.
 * <p>
 * This class extends JDialog.
 */
public class PaymentGUI extends JDialog {
	
	private JLabel rewardLabel;
	private JLabel priceLabel = null;
	
	/**
	 * This constructs a PaymentGUI objects and begins building it.
	 */
    public PaymentGUI(){
        createAndShowGUI();
    }
    
    /** 
     * This function creates the GUI backbone for the PaymentGUI object.
     */
    private void createAndShowGUI(){
        this.setTitle("Baylor Burgers Pay for Cart");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        //this.pack();
        this.setSize(400, 450);
        this.setVisible(true);
    }
    
    /**
     * This function adds GUI components to the GUI backbone. It also
     * handles button presses.
     */
    private void addGUIComponents() {
        JPanel paymentPanel = new JPanel();
        
        Color gold = new Color(255, 184, 28);
        paymentPanel.setBackground(gold);
        
        JPanel gridPane = new JPanel();
        gridPane.setLayout(new GridLayout(6, 1, 2, 2));
        gridPane.setBackground(gold);
        
        Cart c = new Cart();
        Double sum = c.getTotalPrice();
        priceLabel = new JLabel(String.format("Price: $%.2f", sum));
        rewardLabel = new JLabel();
        
        JButton cardButton = new JButton("Card");
        JButton otherButton = new JButton("Other");
        JButton rewardButton = new JButton("Press for Discount");
        JButton cancelButton = new JButton("Cancel");
        
        
        gridPane.add(cardButton);
        gridPane.add(otherButton);
        gridPane.add(cancelButton);
        gridPane.add(rewardButton);
        
       
        gridPane.add(rewardLabel);
        gridPane.add(priceLabel);

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
    
        rewardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cart c = new Cart();
				Random random = new Random();
				int pick = random.nextInt();
				if (pick % 1000 == 0) {
					rewardLabel.setText("You won a 100% discount!!!!");
					c.addDiscount(100.0);
					PurchaseLogGUI receipt = new PurchaseLogGUI();
				} else if (pick % 100 == 0) {
					rewardLabel.setText("You won a 50% discount!!!");
					c.addDiscount(50.0);
					priceLabel.setText(String.format("Price: $%.2f", c.getTotalPrice()));
					
					
				} else if (pick % 10 == 0) {
					// Add discount to price
					c.addDiscount(10.0);
					rewardLabel.setText("You won a 10% discount!!");
					priceLabel.setText(String.format("Price: $%.2f", c.getTotalPrice()));
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

