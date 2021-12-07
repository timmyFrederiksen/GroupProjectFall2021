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
import java.util.Vector;

class AddItemGUI extends JDialog implements ActionListener{
    private JPanel listPane;
    private JTextField nameField, categoryField, priceField, descriptionField;
    private JComboBox categoryBox;
    private JButton saveInfo, cancelInfo;

    private String[] input = null;
    private ArrayList<JTextField> textFields = new ArrayList<>();
    private String[] names = new String[]{"Item Name:", "Item Category:", "Item Price:", "Item Description:"};
    private String[] categoryNames = new String[]{"Drinks", "Food"};

    private Long id;

    public AddItemGUI() {
        super();
        id = null;
        nameField = new JTextField(15);
        categoryField = new JTextField(15);
        priceField = new JTextField(15);
        descriptionField = new JTextField(15);
        categoryBox = new JComboBox(categoryNames);
        saveInfo = new JButton("Save");
        cancelInfo = new JButton("Cancel");
        createAndShowGUI();
    }


    public AddItemGUI(FoodDescription fd) {
        super();
        id = fd.getId();
        nameField = new JTextField(fd.getName());
        categoryField = new JTextField(fd.getCategory());
        priceField = new JTextField(fd.getPrice().toString());
        descriptionField = new JTextField(fd.getDetails());
        categoryBox = new JComboBox(categoryNames);
        if(fd.getCategory().equals("Food")) {
            categoryBox.setSelectedIndex(1);
        }
        saveInfo = new JButton("Save");
        cancelInfo = new JButton("Cancel");
        createAndShowGUI();
    }


    private void createAndShowGUI() {
        setPreferredSize(new Dimension(450, 300));
        setTitle("Add Item");

        listPane = new JPanel();
        //listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Enter Information:");
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setAlignmentY(Component.TOP_ALIGNMENT);

        listPane.add(label);
        listPane.setVisible(true);

        int numPairs = names.length + 1;
        JPanel infoPane = new JPanel(new SpringLayout());

        textFields.add(nameField);
        textFields.add(categoryField);
        textFields.add(priceField);
        textFields.add(descriptionField);


        for (int i = 0; i < (names.length); i++) {
            JLabel l = new JLabel(names[i], JLabel.TRAILING);
            infoPane.add(l);
            if(i == 1){
                l.setLabelFor(categoryBox);
                infoPane.add(categoryBox);
            }else{
                l.setLabelFor(textFields.get(i));
                infoPane.add(textFields.get(i));
            }
        }

        saveInfo.addActionListener(this);
        cancelInfo.addActionListener(this);

        infoPane.add(saveInfo);
        infoPane.add(cancelInfo);

        SpringUtilities.makeCompactGrid(infoPane,
                numPairs, 2,
                6, 6,
                6, 6);


        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.add(label);
        newPanel.add(infoPane);

        add(newPanel);
        setVisible(true);
        pack();
        setLocationRelativeTo(getParent());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveInfo) {
            MenuDAO gateway = new MenuDAO();

            try {
                //gateway.createEmployeeTable();
                FoodDescription query = new FoodDescription(textFields.get(0).getText(),
                        (String)categoryBox.getSelectedItem(), Double.parseDouble(textFields.get(2).getText()), textFields.get(3).getText());
                query.setId(id);
                gateway.save(query);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            dispose();
            Vector<FoodDescription> items = null;
            try {
                //gateway.createEmployeeTable();
                items = gateway.findAll();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            new ManagerMenuGUI(items);
        }else if(e.getSource() == cancelInfo) {
            dispose();
        }
    }
}