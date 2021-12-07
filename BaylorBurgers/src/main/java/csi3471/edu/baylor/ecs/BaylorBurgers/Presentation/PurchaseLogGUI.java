package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;

public class PurchaseLogGUI extends JDialog {
	
	private String cardNum = null;
	
    public PurchaseLogGUI(String cardNum){
    	this.cardNum = cardNum;
        createAndShowGUI();
    }
    
    private void createAndShowGUI(){
        this.setTitle("Receipt");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        //this.pack();
        this.setSize(400, 250);
        this.setVisible(true);
    }
    
    private void addGUIComponents() {
        JPanel receiptPanel = new JPanel();
        receiptPanel.setLayout(new GridLayout(3, 1, 2, 2));
        Random random = new Random();
        int orderNumber = Math.abs(random.nextInt() % 1000);
        
        JLabel label = new JLabel("Your order number: " + orderNumber);
        JLabel labelCard = new JLabel();
        String str = "Card: ";
        
        for (int i = 0; i < cardNum.length() - 4; i++) {
        	str += "*";
        }
        str += cardNum.substring(cardNum.length() - 4, cardNum.length());
        
        labelCard.setText(str);
       
        JButton doneButton = new JButton("Okay");
       
        receiptPanel.add(labelCard);
        receiptPanel.add(label);
        receiptPanel.add(doneButton);
        add(receiptPanel);
        
        doneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Kills program
				System.exit(0);
			}
        });
    }
}