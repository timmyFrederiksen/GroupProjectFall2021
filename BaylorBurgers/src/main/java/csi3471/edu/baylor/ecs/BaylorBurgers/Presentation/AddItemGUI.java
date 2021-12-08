package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;


import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;
import csi3471.edu.baylor.ecs.BaylorBurgers.Persistence.MenuDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * This class creates and manages the GUI associated with adding an item to 
 * the menu.
 * <p>
 * This class extends JDialog and implements ActionListener
 */
class AddItemGUI extends JDialog implements ActionListener {
    private JPanel listPane;
    private JTextField nameField, categoryField, priceField, descriptionField;
    private JComboBox categoryBox;
    private JButton saveInfo, cancelInfo;

    private String[] input = null;
    private ArrayList<JTextField> textFields = new ArrayList<>();
    private String[] names = new String[]{"Item Name:", "Item Category:", "Item Price:", "Item Description:"};
    private String[] categoryNames = new String[]{"Drinks", "Food"};

    private Long id;

    /**
     * This function constructs an AddItemGUI object. 
     */
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

    /**
     * This function constructs an AddItemGUI object with specified a
     * FoodDescription object.
     * @param fd The specified FoodDescription object
     */
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

    /**
     * This function creates and displays the GUI for adding an
     * item to the menu. 
     */
    private void createAndShowGUI() {
        setPreferredSize(new Dimension(450, 300));
        setTitle("Add Item");

        listPane = new JPanel();

        Color green = new Color(21, 71, 52);
        Color gold = new Color(255, 184, 28);
        listPane.setBackground(green);
        this.setBackground(gold);
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
        newPanel.setBackground(gold);
        infoPane.setBackground(gold);
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.add(label);
        newPanel.add(infoPane);


        add(newPanel);
        setVisible(true);
        pack();
        setLocationRelativeTo(getParent());
    }

    /**
     * This function listens for a button press and will perform the
     * designated actions upon said press.
     * @param e The button that has been pressed 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == saveInfo) {

            Boolean isValid = true;
            String name = textFields.get(0).getText();
            String price = textFields.get(2).getText();
            String description = textFields.get(3).getText();

            if(name.equals("") || price.equals("") || description.equals("")){
                isValid = false;
            }
            if(description.length() >= 255 || name.length() >= 15){
                isValid = false;
            }

            try{
                double t = Double.parseDouble(price);
            } catch (NumberFormatException numberFormatException) {
                isValid = false;
            }


            if (isValid) {
                MenuDAO gateway = new MenuDAO();

                try {
                    FoodDescription query = new FoodDescription(textFields.get(0).getText(),
                            (String)categoryBox.getSelectedItem(), Double.parseDouble(textFields.get(2).getText()), textFields.get(3).getText());
                    query.setId(id);

                    gateway.save(query);
                    Vector<FoodDescription> items = null;
                    items = gateway.findAll();
                    ManagerMenuGUI m = new ManagerMenuGUI();
                    m.updatePanel(items);
                    //m.createAndShowGUI();
                    m.createAndShowGUI();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                dispose();
            } else {
                // Invalid Card Info
                JOptionPane.showMessageDialog(new JFrame("Error"), "Invalid Information: For More Info Read Guide", "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == cancelInfo) {
            dispose();
        }
    }
}