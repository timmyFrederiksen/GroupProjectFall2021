package csi3471.edu.baylor.ecs.BaylorBurgers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class PurchaseItemGUI extends JDialog {

    JPanel panel;

    public PurchaseItemGUI(){
        panel = new JPanel();
        createAndShowGUI();
    }
    private void addGUIComponents(){
        panel.setLayout(null);

        JLabel label = new JLabel("How many of this item would you like? (max 50)");
        label.setBounds(10, 20, 450, 25);
        panel.add(label);


        Vector<Integer> listOfQuantities = new Vector<>();
        for(int i = 0; i < 50; i++){
            listOfQuantities.add(i + 1);
        }
        JComboBox quantityCB = new JComboBox(listOfQuantities);
        quantityCB.setEditable(false);

        //JTextField quantity = new JTextField();
        quantityCB.setBounds(10, 50, 65, 25);
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
    }
    private void createAndShowGUI() {

        this.setTitle("Baylor Burgers");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        this.setSize(500, 500);
        this.setVisible(true);
    }



}
