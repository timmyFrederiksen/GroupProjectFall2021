package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import javax.swing.*;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;
import csi3471.edu.baylor.ecs.BaylorBurgers.Persistence.MenuDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuItemPanel extends JPanel implements ActionListener{

    private JPanel p, centerPanel, rightPanel, leftPanel;
    private JTextField name, category, price, descriptionText;
    private JTextArea description;

    private JButton removeButton = new JButton("Remove Item");
    private JButton editButton = new JButton("Edit Item");

    private FoodDescription fd;

    private ManagerMenuGUI managerMenuGUI;


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

    public MenuItemPanel(FoodDescription foodDescription) {
        fd = foodDescription;
        this.name = new JTextField(foodDescription.getName());
        this.category = new JTextField(foodDescription.getCategory());
        this.descriptionText = new JTextField();
        this.price = new JTextField(foodDescription.getPrice().toString());
        this.description = new JTextArea(foodDescription.getDetails());

        this.name.setColumns(15);
        centerPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel = new JPanel();
        createAndShowGUI();
    }

    public MenuItemPanel(FoodDescription foodDescription, ManagerMenuGUI managerMenuGUI) {
        this.managerMenuGUI = managerMenuGUI;
        fd = foodDescription;
        this.name = new JTextField(foodDescription.getName());
        this.category = new JTextField(foodDescription.getCategory());
        this.descriptionText = new JTextField();
        this.price = new JTextField(String.format("%.2f", foodDescription.getPrice()));
        this.description = new JTextArea(foodDescription.getDetails());

        this.name.setColumns(15);
        centerPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel = new JPanel();
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        setPreferredSize(new Dimension(550, 175));
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
        
        Color gold = new Color(255, 184, 28);
        p.setBackground(gold);
        this.setBackground(gold);
        rightPanel.setBackground(gold);
        leftPanel.setBackground(gold);
        centerPanel.setBackground(gold);

        JScrollPane scroll = new JScrollPane(description);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        leftPanel.add(p);
        scroll.setPreferredSize(new Dimension(60, 50));
        leftPanel.add(scroll);

        centerPanel.setPreferredSize(new Dimension(75, 125));

        rightPanel.add(editButton);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        rightPanel.add(removeButton);


        add(leftPanel, BorderLayout.LINE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);

        removeButton.addActionListener(this);
        editButton.addActionListener(this);


    }
    //@Override

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == removeButton) {
            MenuDAO gateway = new MenuDAO();
            try {
                //gateway.createEmployeeTable();
                gateway.delete(name.getText());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            Vector<FoodDescription> items = null;
            try {
                //gateway.createEmployeeTable();
                items = gateway.findAll();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            managerMenuGUI.dispose();
            new ManagerMenuGUI(items);


        }
        else if(e.getSource() == editButton) {
            managerMenuGUI.dispose();
            AddItemGUI addItemGUI = new AddItemGUI(fd);
        }
    }

}