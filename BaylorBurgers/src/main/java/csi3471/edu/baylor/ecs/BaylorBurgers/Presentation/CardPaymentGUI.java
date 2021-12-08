package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * CardPaymentGUI creates and manages the GUI for entering card payment
 * information; this class also checks for valid input.
 * <p>
 * CardPaymentGUI extends from JDialog
 */
class CardPaymentGUI extends JDialog {
    private String[] input = null;
    ArrayList<JTextField> textFields = new ArrayList<>();
    private String[] names = new String[]{"Card Number:", "CVV:", "Expiration Month:", 
    		"Expiration Year:"};

    /**
     * Constructor for CardPaymentGUI.
     */
    public CardPaymentGUI() {
        super();
        createAndShowGUI();
    }

    /**
     * Creates the GUI for CardPaymentGUI and displays it.
     */
    private void createAndShowGUI() {
    	
        setPreferredSize(new Dimension(450, 300));
        setTitle("Card Payment");

        JPanel listPane = new JPanel();
        //listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Enter Information:");
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setAlignmentY(Component.TOP_ALIGNMENT);

        listPane.add(label);
        listPane.setVisible(true);

        JPanel gridPane = new JPanel();
        gridPane.setLayout(new GridLayout(5, 2, 2, 2));

        ArrayList<JLabel> labels = new ArrayList<>();

        for(int i = 0; i < names.length; i++){
            textFields.add(new JTextField(""));
            labels.add(new JLabel(names[i]));
        }

        for(int i = 0; i < names.length; i++){
            gridPane.add(labels.get(i));
            gridPane.add(textFields.get(i));
        }


        JButton saveInfo = new JButton("Complete Payment");
        saveInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    
            	Boolean isValid = true;
            	String cardNum = textFields.get(0).getText();
            	String cvv = textFields.get(1).getText();
            	String expMonth = textFields.get(2).getText();
            	String expYear = textFields.get(3).getText();
            	
            	// Check for card number numeric
            	for (int c = 0; c < cardNum.length(); c++) {
            		if (!Character.isDigit(cardNum.charAt(c))) {
            			isValid = false;
            		}
            	}
            	
            	// Check the card number length (13-19 digits)
            	if (cardNum.length() > 19 || cardNum.length() < 13) {
            		isValid = false;
            	}
            	
            	// Check the cvv for digits only
            	for (int c = 0; c < cvv.length(); c++) {
            		if (!Character.isDigit(cvv.charAt(c))) {
            			isValid = false;
            		}
            	}
            	
            	// Check the size of cvv (3-4 digits)
            	if (cvv.length() > 4 || cvv.length() < 3) {
            		isValid = false;
            	} 
            	
            	// Expiration Month check (1-2 digits)
            	if (expMonth.length() > 2 || expMonth.length() < 1) {
            		isValid = false;
            	}
            	
            	// Expiration Month check for digits
            	for (int c = 0; c < expMonth.length(); c++) {
            		if (!Character.isDigit(expMonth.charAt(c))) {
            			isValid = false;
            		}
            	}
                if(isValid) {
                    if (!(Integer.parseInt(expMonth) > 0 && Integer.parseInt(expMonth) <= 12)){
                        isValid = false;
                    }
                }
            	
            	// Expiration Year check (1-2 digits)
            	if (expYear.length() != 4) {
            		isValid = false;
            	}
            	
            	// Expiration Year check for digits
            	for (int c = 0; c < expYear.length(); c++) {
            		if (!Character.isDigit(expYear.charAt(c))) {
            			isValid = false;
            		}
            	} 
            	
            	if (isValid) {
            		dispose();
            		// Prints receipt (might want to include price in here too)
            		PurchaseLogGUI receipt = new PurchaseLogGUI(cardNum, 1);
            	} else {
            		// Invalid Card Info
            		JOptionPane.showMessageDialog(new JFrame("Error"), "Invalid Card Information", "Warning", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
        JButton cancelInfo = new JButton("Cancel");
        cancelInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        gridPane.add(saveInfo);
        gridPane.add(cancelInfo);


        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.add(label);
        newPanel.add(gridPane);

        add(newPanel);
        setVisible(true);
        pack();
        setLocationRelativeTo(getParent());
    }
}
