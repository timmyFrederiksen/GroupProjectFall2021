package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import javax.swing.*;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Cart;
import csi3471.edu.baylor.ecs.BaylorBurgers.Business.CartItem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CartItemPanel extends JPanel implements ActionListener {
	private JLabel itemName, itemQuantity, itemPrice;
	private JPanel formPanel, centerPanel, rightPanel;
	private CartItem ci;
    private CartGUI cartDisplay;


    private JButton removeButton, editButton;

    public CartItemPanel(CartItem ci) {
        this.ci = ci;
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
    public CartItemPanel(CartItem ci, CartGUI cartGUI) {
        this.ci = ci;
        itemName = new JLabel("Item Name: " + ci.getItemType().getName());
        itemQuantity = new JLabel("Item Quantity: " + ci.getQuantity());
        itemPrice = new JLabel("Item Price: " + (ci.getItemType().getPrice())*ci.getQuantity());
        formPanel = new JPanel();
        removeButton = new JButton("Remove Item");
        editButton = new JButton("Edit Item");
        centerPanel = new JPanel();
        rightPanel = new JPanel();
        this.cartDisplay = cartGUI;
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
        //rightPanel.setPreferredSize(new Dimension(200, 125));

        //rightPanel.add(editButton);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        rightPanel.add(removeButton);
        
        
        Color gold = new Color(255, 184, 28);
        formPanel.setBackground(gold);
        centerPanel.setBackground(gold);
        rightPanel.setBackground(gold);
        setBackground(gold);


        removeButton.addActionListener(this);

        //formPanel.setBackground(Color.YELLOW);
        //centerPanel.setBackground(Color.BLUE);
        //rightPanel.setBackground(Color.YELLOW);

        add(formPanel, BorderLayout.LINE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == removeButton){
            Cart.removeItem(ci);
            cartDisplay.dispose();
            new CartGUI();
        }
    }
}
