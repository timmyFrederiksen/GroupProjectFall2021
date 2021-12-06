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

        for (int i = 0; i < (names.length); i++) {
            JLabel l = new JLabel(names[i], JLabel.TRAILING);
            infoPane.add(l);
            if(i == 1){
                JComboBox categoryBox = new JComboBox(categoryNames);
                l.setLabelFor(categoryBox);
                infoPane.add(categoryBox);
            }else{
                JTextField textField = new JTextField(15);
                l.setLabelFor(textField);
                infoPane.add(textField);
            }
        }

        JButton saveInfo = new JButton("Save");
        saveInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuDAO gateway = new MenuDAO();

                try {
                    gateway.createEmployeeTable();
                    gateway.save(new FoodDescription("ASD", "Drinks", 3.7d, "Tasty"));
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
