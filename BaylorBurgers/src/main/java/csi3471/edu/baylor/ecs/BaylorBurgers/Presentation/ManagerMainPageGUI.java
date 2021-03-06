package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Category;
import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;
import csi3471.edu.baylor.ecs.BaylorBurgers.Persistence.MenuDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;
import java.util.Vector;

/**
 * This class creates and manages GUI for the main manager page.
 * <p>
 * This class extends JFrame and implements ActionListener
 */
public class ManagerMainPageGUI extends JFrame implements ActionListener {
    private JLabel mainMenuLabel;
    private JPanel mainMenuPanel, mainMenuHeader, mainMenuButtons;
    private JButton viewMenuButton, viewPurchasesButton;
    private MenuBar menuBar;

    /**
     * This function begins the process of building the GUI for
     * ManagerMainPageGUI.
     */
    public ManagerMainPageGUI(){
        createAndShowGUI();
    }

    /**
     * This function adds GUI components to the GUI and displays it.
     */
    private void addGUIComponents() {
        mainMenuLabel = new JLabel("Manager Main Page");
        mainMenuLabel.setFont(new Font("Arial", Font.PLAIN, 48));
        mainMenuLabel.setPreferredSize(new Dimension(500, 100));

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        mainMenuHeader = new JPanel(flowLayout);
        mainMenuButtons = new JPanel(flowLayout);

        Color green = new Color(21, 71, 52);
        Color gold = new Color(255, 184, 28);
        mainMenuHeader.setBackground(green);
        mainMenuButtons.setBackground(gold);

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
        //mainMenuButtons.add(viewPurchasesButton);

        mainMenuHeader.add(mainMenuLabel);

        menuBar = new MenuBar();
        menuBar.removeCartMenu();
        menuBar.removeHelpMenu();
        menuBar.getBackMenu().addActionListener(this);

        setJMenuBar(menuBar);
        add(mainMenuHeader, BorderLayout.NORTH);
        add(mainMenuButtons, BorderLayout.CENTER);


        viewMenuButton.addActionListener(this);
    }

    /** 
     * This function creates a GUI backbone for the ManagerMainPageGUI.
     */
    private void createAndShowGUI() {
        this.setTitle("Baylor Burgers Manager Main Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        this.setSize(675, 375);
        this.setVisible(true);
    }
    
    /**
     * This function listens for a button push on the GUI and
     * implements logic for each individual button. Overrides default
     * functionality in ActionListener.
     * @param e Determines which button was hit and indicates which
     * functionality needs to happen.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuBar.getBackMenu()){
            dispose();
            ManagerLoginGUI managerLoginGUI = new ManagerLoginGUI();
        }else if(e.getSource() == viewMenuButton) {
            dispose();
            MenuDAO gateway = new MenuDAO();

            Vector<FoodDescription> items = null;
            try {
                items = gateway.findAll();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            ManagerMenuGUI m = new ManagerMenuGUI();
            m.updatePanel(items);
            m.createAndShowGUI();
        }
    }
}
