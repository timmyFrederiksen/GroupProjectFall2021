package csi3471.edu.baylor.ecs.BaylorBurgers;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class CartItemPanel extends JPanel {

    JLabel itemName = new JLabel("Item Name: ");
    JLabel itemQuanity = new JLabel("Item Quantity: ");
    JLabel itemPrice = new JLabel("Item Price: ");
    JPanel formPanel = new JPanel();
    JButton removeButton = new JButton("Remove Item");
    JButton editButton = new JButton("Edit Item");
    JPanel centerPanel = new JPanel();
    JPanel rightPanel = new JPanel();


    public CartItemPanel(){
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        BoxLayout boxLayout = new BoxLayout(formPanel, BoxLayout.Y_AXIS);
        formPanel.setLayout(boxLayout);
        BoxLayout rightBoxLayout = new BoxLayout(rightPanel, BoxLayout.Y_AXIS);
        rightPanel.setLayout(rightBoxLayout);


        formPanel.add(itemName);
        formPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        formPanel.add(itemQuanity);
        formPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        formPanel.add(itemPrice);


        centerPanel.setPreferredSize(new Dimension(200, 150));

        rightPanel.add(editButton);
        formPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        rightPanel.add(removeButton);

        formPanel.setBackground(Color.YELLOW);
        centerPanel.setBackground(Color.BLUE);
        rightPanel.setBackground(Color.YELLOW);

        add(formPanel, BorderLayout.LINE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);
    }
}
