package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Cart;

import java.util.Random;

public class PurchaseLogGUI extends JDialog {
	
	private String cardNum = null;
	
    public PurchaseLogGUI(String cardNum, int choice){
    	this.cardNum = cardNum;
        createAndShowGUI(choice);
    }
    
    public PurchaseLogGUI() {
    	this.cardNum = "";
    	createAndShowGUI(0);
    }
    
    private void createAndShowGUI(int type){
        this.setTitle("Receipt");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents(type);

        //this.pack();
        this.setSize(400, 250);
        this.setVisible(true);
    }
    
    private void addGUIComponents(int type) {
        JPanel receiptPanel = new JPanel();
        receiptPanel.setLayout(new GridLayout(4, 1, 2, 2));
        Random random = new Random();
        int orderNumber = Math.abs(random.nextInt() % 1000);
        Cart c = new Cart();
        JLabel label = new JLabel("Your order number: " + orderNumber);
        JLabel priceLabel = new JLabel(String.format("Price: $%.2f", c.getTotalPrice()));
       
        JButton doneButton = new JButton("Okay");
        JLabel cardLabel = new JLabel();
        
        Color gold = new Color(255, 184, 28);
        receiptPanel.setBackground(gold);
       
        if (type == 1) {
        	
            String str = "Card: ";
            
            for (int i = 0; i < cardNum.length() - 4; i++) {
            	str += "*";
            }
            str += cardNum.substring(cardNum.length() - 4, cardNum.length());
            
            cardLabel.setText(str);
        	receiptPanel.add(cardLabel);
        } else if (type == 2) {
        	cardLabel.setText("Helped by: " + cardNum);
        	receiptPanel.add(cardLabel);
        }
        
        receiptPanel.add(label);
        receiptPanel.add(priceLabel);
        receiptPanel.add(doneButton);
        add(receiptPanel);
        
        doneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Exits program
				System.exit(0);
			}
        });
    }
}