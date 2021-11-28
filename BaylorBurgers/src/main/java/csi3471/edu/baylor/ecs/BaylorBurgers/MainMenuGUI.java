package csi3471.edu.baylor.ecs.BaylorBurgers;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame {

    JLabel mainMenuLabel;
    JPanel mainMenuPanel, mainMenuHeader, mainMenuButtons;
    JButton drinksButton, foodButton;


    public MainMenuGUI(){
        createAndShowGUI();
    }
    private void addGUIComponents() {
        mainMenuLabel = new JLabel("Main Menu");
        mainMenuLabel.setFont(new Font("Arial", Font.PLAIN, 48));
        mainMenuLabel.setPreferredSize(new Dimension(500, 100));

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        mainMenuHeader = new JPanel(flowLayout);
        mainMenuButtons = new JPanel(flowLayout);


        EmptyBorder panelBorder = new EmptyBorder(10, 10 , 0, 0);
        //Border border = BorderFactory.createLineBorder(Color.BLACK);
        //mainMenuLabel.setBorder(border);
        mainMenuLabel.setBorder(panelBorder);
        mainMenuButtons.setBorder(panelBorder);

        drinksButton = new JButton("Drinks");
        foodButton = new JButton("Food");

        drinksButton.setBackground(Color.WHITE);
        foodButton.setBackground(Color.WHITE);


        drinksButton.setPreferredSize(new Dimension(300, 300));
        foodButton.setPreferredSize(new Dimension(300, 300));

        mainMenuButtons.add(drinksButton);
        mainMenuButtons.add(foodButton);

        mainMenuHeader.add(mainMenuLabel);

        JButton viewCart = new JButton("View Cart");
        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartGUI cartGUI = new CartGUI();
            }
        });

        add(mainMenuHeader, BorderLayout.NORTH);
        add(mainMenuButtons, BorderLayout.CENTER);
        add(viewCart, BorderLayout.SOUTH);

        drinksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CategoryGUI categoryGUI = new CategoryGUI(new Category("Drinks"));
            }
        });
    }
    private void createAndShowGUI() {
        this.setTitle("Baylor Burgers Main Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        //this.pack();
        this.setSize(750, 625);
        this.setVisible(true);
    }

}
