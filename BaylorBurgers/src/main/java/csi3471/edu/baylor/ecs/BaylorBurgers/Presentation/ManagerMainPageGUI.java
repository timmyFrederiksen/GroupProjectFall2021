package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Category;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ManagerMainPageGUI extends JFrame {
    JLabel mainMenuLabel;
    JPanel mainMenuPanel, mainMenuHeader, mainMenuButtons;
    JButton viewMenuButton, viewPurchasesButton;

    public ManagerMainPageGUI(){
        createAndShowGUI();
    }


    private void addGUIComponents() {
        mainMenuLabel = new JLabel("Manager Main Page");
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

        viewMenuButton = new JButton("View Menu");
        viewPurchasesButton = new JButton("View Purchases");

        viewMenuButton.setBackground(Color.WHITE);
        viewPurchasesButton.setBackground(Color.WHITE);


        viewMenuButton.setPreferredSize(new Dimension(300, 150));
        viewPurchasesButton.setPreferredSize(new Dimension(300, 150));

        mainMenuButtons.add(viewMenuButton);
        mainMenuButtons.add(viewPurchasesButton);

        mainMenuHeader.add(mainMenuLabel);

        setJMenuBar(initMenu());
        add(mainMenuHeader, BorderLayout.NORTH);
        add(mainMenuButtons, BorderLayout.CENTER);


    }
    private JMenuBar initMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        JMenuItem backMenu = new JMenuItem("Back");
        JMenuItem helpMenu = new JMenuItem("Help");
        //JMenuItem cartMenu = new JMenuItem("Cart");

        menu.add(backMenu);
        menu.add(helpMenu);
        //menu.add(cartMenu);

        menuBar.add(menu);

        return menuBar;
    }
    private void createAndShowGUI() {
        this.setTitle("Baylor Burgers Manager Main Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        this.setSize(675, 375);
        this.setVisible(true);
    }
}
