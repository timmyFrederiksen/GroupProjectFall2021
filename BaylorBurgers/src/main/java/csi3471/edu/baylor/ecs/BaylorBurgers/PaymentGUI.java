package csi3471.edu.baylor.ecs.BaylorBurgers;

import javax.swing.*;
import java.awt.*;

public class PaymentGUI extends JDialog {
    public PaymentGUI(){
        createAndShowGUI();
    }
    private void createAndShowGUI(){
        this.setTitle("Baylor Burgers Pay for Cart");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        //this.pack();
        this.setSize(400, 450);
        this.setVisible(true);
    }
    private void addGUIComponents() {
        JPanel paymentPanel = new JPanel();
        JButton buyButton = new JButton("Buy");
        paymentPanel.add(buyButton, BorderLayout.SOUTH);
        add(paymentPanel);
    }
}

