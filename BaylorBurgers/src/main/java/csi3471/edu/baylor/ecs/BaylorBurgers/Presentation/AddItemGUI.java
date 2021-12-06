package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;


import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;
import csi3471.edu.baylor.ecs.BaylorBurgers.Persistence.MenuDAO;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

class AddItemGUI extends JDialog {
    private String[] input = null;
    ArrayList<JTextField> textFields = new ArrayList<>();
    private String[] names = new String[]{"Item Name:", "Item Category:", "Item Price:", "Item Description:"};
    private String[] categoryNames = new String[]{"Drinks", "Food"};

    public AddItemGUI() {
        super();
        createAndShowGUI();
    }


    private void createAndShowGUI() {
        setPreferredSize(new Dimension(450, 300));
        setTitle("Add Item");

        JPanel listPane = new JPanel();
        //listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Enter Information:");
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setAlignmentY(Component.TOP_ALIGNMENT);

        listPane.add(label);
        listPane.setVisible(true);

        int numPairs = names.length + 1;
        JPanel infoPane = new JPanel(new SpringLayout());
        
        JTextField nameField = new JTextField(15);
        JTextField categoryField = new JTextField(15);
        JTextField priceField = new JTextField(15);
        JTextField descriptionField = new JTextField(15);
        textFields.add(nameField);
        textFields.add(categoryField);
        textFields.add(priceField);
        textFields.add(descriptionField);
        JComboBox categoryBox = new JComboBox(categoryNames);
        for (int i = 0; i < (names.length); i++) {
            JLabel l = new JLabel(names[i], JLabel.TRAILING);
            infoPane.add(l);
            if(i == 1){
                
                l.setLabelFor(categoryBox);
                infoPane.add(categoryBox);
            }else{
                //JTextField textField = new JTextField(15);
                l.setLabelFor(textFields.get(i));
                infoPane.add(textFields.get(i));
            }
        }

        JButton saveInfo = new JButton("Save");
        saveInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuDAO gateway = new MenuDAO();

                try {
                    //gateway.createEmployeeTable();
                    gateway.save(new FoodDescription(textFields.get(0).getText(),
                    		(String)categoryBox.getSelectedItem(), Double.parseDouble(textFields.get(2).getText()), textFields.get(3).getText()));
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
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
        infoPane.add(saveInfo);
        infoPane.add(cancelInfo);

        SpringUtilities.makeCompactGrid(infoPane,
                numPairs, 2,            //rows, cols
                6, 6,           //initX, initY
                6, 6);             //xPad, yPad


        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.add(label);
        newPanel.add(infoPane);

        add(newPanel);
        setVisible(true);
        pack();
        setLocationRelativeTo(getParent());
    }
}
