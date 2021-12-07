package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.stream.Collectors;

public class ItemGUI extends JDialog {

    private FoodDescription itemDescription;

    String[] labelTitles = new String[]{"Item Name: ", "Item Price: $"};
    String[] itemLabels;
    private ArrayList<JLabel> titleLabels;
    private ArrayList<JLabel> detailsLabels;

    public ItemGUI(String text, Vector<FoodDescription> items) {
    	itemDescription = null;
    	itemDescription = items.stream().filter(s->s.getName() == text).collect(Collectors.toList()).get(0);

        itemLabels = new String[]{itemDescription.getName(), itemDescription.getPrice().toString()};

        titleLabels = new ArrayList<>();

        for(int i = 0; i < labelTitles.length; i++){
            JLabel label = new JLabel(labelTitles[i] + itemLabels[i]);
            //label.setPreferredSize(new Dimension(100, 20));
            titleLabels.add(label);
        }
        detailsLabels = new ArrayList<>();
        /*JLabel itemName =  new JLabel(itemDescription.getName());
        itemName.setPreferredSize(new Dimension(100, 20));
        detailsLabels.add(itemName);
        JLabel itemPrice =  new JLabel(itemDescription.getPrice().toString());
        itemPrice.setPreferredSize(new Dimension(100, 20));
        detailsLabels.add(itemPrice);*/

        createAndShowGUI();
    }
    
	private void addGUIComponents() {
        //GridLayout detailsGrid = new GridLayout(2, 2);
        //JPanel detailsPanel = new JPanel();
        //detailsPanel.setBorder(new EmptyBorder(new Insets(0, 25, 0, 0)));
        //detailsPanel.setPreferredSize(new Dimension(10, 10));
        //detailsPanel.setLayout(detailsGrid);

        /*for(int i = 0; i < titleLabels.size(); i++){
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            titleLabels.get(i).setBorder(border);
            detailsLabels.get(i).setBorder(border);
            detailsPanel.add(titleLabels.get(i));
            detailsPanel.add(detailsLabels.get(i));
        }*/

        JPanel descriptionPanel = new JPanel();
        Color green = new Color(21, 71, 52);
        Color gold = new Color(255, 184, 28);
        descriptionPanel.setBackground(gold);
        this.setBackground(green);

        BoxLayout boxLayout = new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS);

        descriptionPanel.setLayout(boxLayout);

        JLabel descriptTitleLabel = new JLabel("Item Description:");
        JLabel descriptionLabel = new JLabel(itemDescription.getDetails());
        JButton orderButton = new JButton("Order " + itemDescription.getName());

        descriptionPanel.setBorder(new EmptyBorder(new Insets(50, 25, 25, 0)));


        for(JLabel label : titleLabels){
            descriptionPanel.add(label);
            descriptionPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        }
        descriptionPanel.add(descriptTitleLabel);
        descriptionPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        descriptionPanel.add(orderButton);

        //GridLayout itemGridLayout = new GridLayout(2, 1);
        //this.setLayout(itemGridLayout);
        //add(detailsPanel);
        add(descriptionPanel);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PurchaseItemGUI purchaseItemGUI = new PurchaseItemGUI(itemDescription);
            }
        });
    }
    private void createAndShowGUI() {
        this.setTitle("Baylor Burgers " + itemDescription.getName());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        //this.pack();
        this.setSize(400, 450);
        this.setVisible(true);
    }
}
