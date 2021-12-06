package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class MainMenuGUI extends JFrame implements ActionListener{

    JLabel mainMenuLabel;
    JPanel mainMenuPanel, mainMenuHeader, mainMenuButtons;
    JButton drinksButton, foodButton;
    MenuBar menuBar;


    public MainMenuGUI(){
        createAndShowGUI();
    }
    private JMenuBar initMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        JMenuItem backMenu = new JMenuItem("Back");
        JMenuItem helpMenu = new JMenuItem("Help");
        JMenuItem cartMenu = new JMenuItem("Cart");

        menu.add(backMenu);
        menu.add(helpMenu);
        menu.add(cartMenu);
        cartMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartGUI cartGUI = new CartGUI();
            }
        });

        menuBar.add(menu);

        return menuBar;
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

        /*JButton viewCart = new JButton("View Cart");
        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartGUI cartGUI = new CartGUI();
            }
        });*/

        menuBar = new MenuBar();
        setJMenuBar(menuBar);

        menuBar.getBackMenu().addActionListener(this);
        menuBar.getCartMenu().addActionListener(this);



        add(mainMenuHeader, BorderLayout.NORTH);
        add(mainMenuButtons, BorderLayout.CENTER);
        //add(viewCart, BorderLayout.SOUTH);

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
        this.setSize(725, 510);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuBar.getBackMenu()){
            dispose();
            javax.swing.SwingUtilities.invokeLater(LoginGUI::showGUI);
        }else if(e.getSource() == menuBar.getCartMenu()){
            dispose();
            new CartGUI();
        }
    }

}
