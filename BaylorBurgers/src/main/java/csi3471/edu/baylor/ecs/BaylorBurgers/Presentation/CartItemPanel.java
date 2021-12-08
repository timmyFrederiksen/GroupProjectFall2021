package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import javax.swing.*;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Cart;
import csi3471.edu.baylor.ecs.BaylorBurgers.Business.CartItem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates and manages the GUI associated with Cart item panels.
 * <p>
 * This class extends JPanel implements ActionListener.
 */
public class CartItemPanel extends JPanel implements ActionListener {
	private JLabel itemName, itemQuantity, itemPrice, itemDetailLabel;
	private JTextArea itemDetailText;
	private JPanel formPanel, centerPanel, rightPanel, detailPanel;
	private CartItem ci;
    private CartGUI cartDisplay;

    private JButton removeButton, editButton;

    /**
     * Constructs a CartItemPanel.
     * @param ci CartItem to be displayed
     */
    public CartItemPanel(CartItem ci) {
        this.ci = ci;
    	itemName = new JLabel("Item Name: " + ci.getItemType().getName());
        itemQuantity = new JLabel("Quantity: " + ci.getQuantity());
        itemPrice = new JLabel(String.format("Total Price: $%.2f",
                (ci.getItemType().getPrice())*ci.getQuantity()));
        itemDetailLabel = new JLabel("Customer's Customizations: ");
        itemDetailText = new JTextArea(ci.getOrderNotes());
        formPanel = new JPanel();
        detailPanel = new JPanel();
        removeButton = new JButton("Remove Item");
        editButton = new JButton("Edit Item");
        centerPanel = new JPanel();
        rightPanel = new JPanel();
        createAndShowGUI();
    }
    
    /**
     * Constructs a CartItemPanel.
     * @param ci CartItem to be displayed
     * @param cartGUI CartGUI to display to
     */
    public CartItemPanel(CartItem ci, CartGUI cartGUI) {
        this.ci = ci;
        itemName = new JLabel("Item Name: " + ci.getItemType().getName());
        itemQuantity = new JLabel("Quantity: " + ci.getQuantity());
        itemPrice = new JLabel(String.format("Total Price: $%.2f",
                (ci.getItemType().getPrice())*ci.getQuantity()));
        itemDetailLabel = new JLabel("Customer's Customizations: ");
        itemDetailText = new JTextArea(ci.getOrderNotes());
        formPanel = new JPanel();
        detailPanel = new JPanel();
        removeButton = new JButton("Remove Item");
        editButton = new JButton("Edit Item");
        centerPanel = new JPanel();
        rightPanel = new JPanel();
        this.cartDisplay = cartGUI;
        createAndShowGUI();
    }

    /**
     * Creates GUI and displays it.
     */
    private void createAndShowGUI() {

        setPreferredSize(new Dimension(500, 175));

        BoxLayout boxLayout = new BoxLayout(formPanel, BoxLayout.Y_AXIS);
        formPanel.setLayout(boxLayout);
        detailPanel.setLayout(new SpringLayout());
        BoxLayout rightBoxLayout = new BoxLayout(rightPanel, BoxLayout.Y_AXIS);
        rightPanel.setLayout(rightBoxLayout);

        itemDetailText.setEditable(false);
        itemDetailText.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(itemDetailText);
        scroll.setPreferredSize(new Dimension(60, 50));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Color gold = new Color(255, 184, 28);

        detailPanel.add(itemName);
        detailPanel.add(itemQuantity);
        detailPanel.add(itemPrice);
        detailPanel.add(itemDetailLabel);
        detailPanel.setBackground(gold);
        detailPanel.add(scroll);

        SpringUtilities.makeCompactGrid(detailPanel,
                5, 1,
                6, 6,
                6, 6);

        formPanel.add(detailPanel);
        //formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        //formPanel.add(scroll);

        centerPanel.setPreferredSize(new Dimension(200, 125));
        //rightPanel.setPreferredSize(new Dimension(200, 125));

        //rightPanel.add(editButton);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        rightPanel.add(removeButton);
        
        
        formPanel.setBackground(gold);
        centerPanel.setBackground(gold);
        rightPanel.setBackground(gold);
        setBackground(gold);

        removeButton.addActionListener(this);

        add(formPanel, BorderLayout.LINE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);
    }

    /**
     * Listens for button presses and executes command designated by
     * the pressed button.
     * @param e The button that was pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == removeButton){
            Cart.removeItem(ci);
            cartDisplay.dispose();
            new CartGUI();
        }
    }
}
