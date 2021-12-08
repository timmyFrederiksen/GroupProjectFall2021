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

/**
 * This class creates and manages the GUI for items.
 * <p>
 * This class extends JDialog.
 */
public class ItemGUI extends JDialog {

    private FoodDescription itemDescription;

    String[] labelTitles = new String[]{"Item Name: ", "Item Price: $"};
    String[] itemLabels;
    private ArrayList<JLabel> titleLabels;
    private ArrayList<JLabel> detailsLabels;

    /**
     * Constructs an ItemGUI object and begins the GUI building process. 
     * @param text String used as a filter
     * @param items Vector of FoodDescription objects provided
     */
    public ItemGUI(String text, Vector<FoodDescription> items) {
        itemDescription = null;
        itemDescription = items.stream().filter(s->s.getName() == text).collect(Collectors.toList()).get(0);

        itemLabels = new String[]{itemDescription.getName(), String.format("%.2f", itemDescription.getPrice())};

        titleLabels = new ArrayList<>();

        for(int i = 0; i < labelTitles.length; i++){
            JLabel label = new JLabel(labelTitles[i] + itemLabels[i]);
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

    /**
     * Adds GUI components to the GUI backbone and adds button functionality.
     */
    private void addGUIComponents() {
        //JPanel descriptionPanel = new JPanel();
        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new SpringLayout());
        Color green = new Color(21, 71, 52);
        Color gold = new Color(255, 184, 28);
        //descriptionPanel.setBackground(gold);
        areaPanel.setBackground(gold);
        this.setBackground(green);

        //BoxLayout boxLayout = new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS);
        //descriptionPanel.setLayout(boxLayout);


        JLabel descriptTitleLabel = new JLabel("Item Description:");
        JTextArea descriptionArea = new JTextArea(itemDescription.getDetails());
        JLabel descriptionLabel = new JLabel(itemDescription.getDetails());
        JButton orderButton = new JButton("Order " + itemDescription.getName());

        descriptionArea.setEditable(false);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(descriptionArea);
        scroll.setPreferredSize(new Dimension(150, 50));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        areaPanel.setBorder(new EmptyBorder(new Insets(25, 25, 25, 0)));
        //descriptionPanel.setBorder(new EmptyBorder(new Insets(50, 25, 25, 0)));

        for(JLabel label : titleLabels){
            areaPanel.add(label);
            //descriptionPanel.add(label);
            //descriptionPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        }

        areaPanel.add(descriptTitleLabel);
        areaPanel.add(scroll);

        /*descriptTitleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        descriptionPanel.add(descriptTitleLabel);
        descriptionPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        descriptionPanel.add(scroll);*/

        areaPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        areaPanel.add(orderButton);

        SpringUtilities.makeCompactGrid(areaPanel,
                6, 1,
                6, 6,
                6, 18);

        add(areaPanel);
        //add(descriptionPanel);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PurchaseItemGUI purchaseItemGUI = new PurchaseItemGUI(itemDescription);
            }
        });
    }
    
    /**
     * Creates GUI backbone and displays it after components are added.
     */
    private void createAndShowGUI() {
        this.setTitle("Baylor Burgers " + itemDescription.getName());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        //this.pack();
        this.setSize(425, 450);
        this.setVisible(true);
    }
}
