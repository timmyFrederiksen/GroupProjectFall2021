package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import javax.swing.*;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.CartItem;

import java.awt.*;


public class CartItemPanel extends JPanel {
	private JLabel itemName, itemQuantity, itemPrice;
	private JPanel formPanel, centerPanel, rightPanel;

	private JButton removeButton, editButton;

    public CartItemPanel(CartItem ci) {
    	itemName = new JLabel("Item Name: " + ci.getItemType().getName());
        itemQuantity = new JLabel("Item Quantity: " + ci.getQuantity());
        itemPrice = new JLabel("Item Price: " + (ci.getItemType().getPrice())*ci.getQuantity());
        formPanel = new JPanel();
        removeButton = new JButton("Remove Item");
        editButton = new JButton("Edit Item");
        centerPanel = new JPanel();
        rightPanel = new JPanel();
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        BoxLayout boxLayout = new BoxLayout(formPanel, BoxLayout.Y_AXIS);
        formPanel.setLayout(boxLayout);
        BoxLayout rightBoxLayout = new BoxLayout(rightPanel, BoxLayout.Y_AXIS);
        rightPanel.setLayout(rightBoxLayout);


        formPanel.add(itemName);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        formPanel.add(itemQuantity);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        formPanel.add(itemPrice);


        centerPanel.setPreferredSize(new Dimension(200, 125));

        rightPanel.add(editButton);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        rightPanel.add(removeButton);

        //formPanel.setBackground(Color.YELLOW);
        //centerPanel.setBackground(Color.BLUE);
        //rightPanel.setBackground(Color.YELLOW);

        add(formPanel, BorderLayout.LINE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);
    }
}
