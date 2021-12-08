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

/**
 * This class creates and manages GUI associated with cart display.
 * <p>
 * This class extends JDialog and implements ActionListener
 */
class CartFormGUI extends JDialog implements ActionListener {
    private JPanel listPane;
    private JTextField nameField, quantityField, priceField, customizationField;
    private JComboBox categoryBox;
    private JButton saveInfo, cancelInfo;

    private String[] input = null;
    private ArrayList<JTextField> textFields = new ArrayList<>();
    private String[] names = new String[]{"Item Name:", "Item Price:", "Item Quantity:", "Item Customization:"};

    /**
     * Constructs a CartFormGUI object. 
     */
    public CartFormGUI() {
        super();
        nameField = new JTextField(15);
        quantityField = new JTextField(15);
        priceField = new JTextField(15);
        customizationField = new JTextField(15);
        //categoryBox = new JComboBox(categoryNames);
        saveInfo = new JButton("Save");
        cancelInfo = new JButton("Cancel");
        createAndShowGUI();
    }

    /**
     * Creates GUI and displays it.
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
        //textFields.add(categoryField);
        textFields.add(priceField);
        textFields.add(customizationField);


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


    /**
     * Listens for button presses and executes commands for the pressed button.
     * @param e Button that was pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveInfo) {
            MenuDAO gateway = new MenuDAO();

            try {
                //gateway.createEmployeeTable();
                gateway.save(new FoodDescription(textFields.get(0).getText(),
                        (String)categoryBox.getSelectedItem(), Double.parseDouble(textFields.get(2).getText()), textFields.get(3).getText()));
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            dispose();
            //new ManagerMenuGUI();
        }else if(e.getSource() == cancelInfo) {
            dispose();
        }
    }
}
