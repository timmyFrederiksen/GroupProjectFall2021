package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuItemPanel extends JPanel {

    private JPanel p, centerPanel, rightPanel, leftPanel;
    private JTextField name, category, price, descriptionText;
    private JTextArea description;
    
    private JButton removeButton = new JButton("Remove Item");
    private JButton editButton = new JButton("Edit Item");


    public MenuItemPanel(String name, String category, Double price, String description){
    	
    	this.name = new JTextField(name); 
    	this.category = new JTextField(category); 
    	this.descriptionText = new JTextField();    
    	this.price = new JTextField(price.toString());    
        this.description = new JTextArea(description);
        this.name.setColumns(15);
        centerPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel = new JPanel();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        String[] labels = {"Item Name: ", "Item Category: ", "Item Price: ", "Item Description: "};
        JTextField[] textFields = {name, category, price, descriptionText};
        int numPairs = labels.length;

        p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            textFields[i].setEditable(false);
            if(i == numPairs - 1){
                textFields[i].setVisible(false);
            }
            l.setLabelFor(textFields[i]);
            p.add(textFields[i]);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                numPairs, 2,            //rows, cols
                6, 6,           		//initX, initY
                6, 6);             		//xPad, yPad

        BoxLayout rightBoxLayout = new BoxLayout(rightPanel, BoxLayout.Y_AXIS);
        rightPanel.setLayout(rightBoxLayout);
        BoxLayout leftBoxLayout = new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
        leftPanel.setLayout(leftBoxLayout);
        description.setEditable(false);
        description.setLineWrap(true);
        description.setPreferredSize(new Dimension(50, 30));
        JScrollPane scroll = new JScrollPane(description);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        leftPanel.add(p);
        //leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        leftPanel.add(scroll);


        centerPanel.setPreferredSize(new Dimension(75, 125));

        rightPanel.add(editButton);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        rightPanel.add(removeButton);


        add(leftPanel, BorderLayout.LINE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);
    }
}