package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * This class creates and manages a GUI for purchasing an item
 * <p>
 * This class extends JDialog
 */
public class PurchaseItemGUI extends JDialog {

    JPanel panel;
    protected FoodDescription itemType;

    /**
     * Constructs a PurchaseItemGUI from a provided FoodDescription
     * @param itemType The provided FoodDescription
     */
    public PurchaseItemGUI(FoodDescription itemType) {
        this.itemType = itemType;
        panel = new JPanel();
        createAndShowGUI();
    }

    /**
     * Adds GUI components to the GUI backbone and provides functionality 
     * for the buttons.
     */
    private void addGUIComponents() {
        panel.setLayout(null);

        JLabel label = new JLabel("How many of this item would you like? (max 50)");
        label.setBounds(10, 20, 450, 25);
        panel.add(label);

        Color green = new Color(21, 71, 52);
        Color gold = new Color(255, 184, 28);
        panel.setBackground(gold);
        this.setBackground(green);

        Vector<Integer> listOfQuantities = new Vector<>();
        for (int i = 0; i < 50; i++) {
            listOfQuantities.add(i + 1);
        }
        JComboBox quantityCB = new JComboBox(listOfQuantities);

        quantityCB.setEditable(false);

        //JTextField quantity = new JTextField();
        quantityCB.setBounds(10, 50, 75, 30);
        panel.add(quantityCB);

        JLabel notesLabel = new JLabel("Are there any changes you would like to make to the item?");
        notesLabel.setBounds(10, 130, 375, 25);
        panel.add(notesLabel);

        JTextArea notes = new JTextArea();
        notes.setLineWrap(true);
        notes.setBounds(10, 160, 375, 200);
        panel.add(notes);

        JButton purchaseButton = new JButton("Purchase");
        purchaseButton.setBounds(10, 400, 150, 50);
        panel.add(purchaseButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 400, 150, 50);
        panel.add(cancelButton);

        add(panel);


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer index = quantityCB.getSelectedIndex() + 1;
                if (index > 0) {
                    CartItem item = new CartItem(itemType, index, notes.getText(),
                            (double) itemType.getPrice());
                    Cart c = new Cart();
                    c.addItem(item);
                    dispose();
                    JOptionPane.showMessageDialog(new JFrame("Purchased!"),
                            "You have purchased your item(s)", "Successful", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    /**
     * Creates a GUI backbone for a PurchaseItemGUI.
     */
    private void createAndShowGUI() {

        this.setTitle("Baylor Burgers");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        this.setSize(500, 500);
        this.setVisible(true);
    }


}
