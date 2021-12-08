package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.*;
import csi3471.edu.baylor.ecs.BaylorBurgers.Persistence.MenuDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;


public class MainMenuGUI extends JFrame implements ActionListener{

    private JLabel mainMenuLabel;
    private JPanel mainMenuHeader, mainMenuButtons;
    private JButton drinksButton, foodButton;
    private MenuBar menuBar;


    public MainMenuGUI(){
        super();
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

        Color green = new Color(21, 71, 52);
        Color gold = new Color(255, 184, 28);
        mainMenuLabel.setBackground(gold);
        mainMenuButtons.setBackground(gold);
        mainMenuHeader.setBackground(green);
        

        drinksButton.setPreferredSize(new Dimension(300, 300));
        foodButton.setPreferredSize(new Dimension(300, 300));

        mainMenuButtons.add(drinksButton);
        mainMenuButtons.add(foodButton);

        mainMenuHeader.add(mainMenuLabel);
      
        menuBar = new MenuBar();
        setJMenuBar(menuBar);
        menuBar.getBackMenu().addActionListener(this);
        menuBar.getCartMenu().addActionListener(this);
        menuBar.getHelp().addActionListener(this);

        drinksButton.addActionListener(this);
        foodButton.addActionListener(this);


        add(mainMenuHeader, BorderLayout.NORTH);
        add(mainMenuButtons, BorderLayout.CENTER);
        //add(viewCart, BorderLayout.SOUTH);
    }

    private void createAndShowGUI() {
        this.setTitle("Baylor Burgers Main Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

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
        }else if(e.getSource() == drinksButton){
            dispose();
            
            MenuDAO gateway = new MenuDAO();
            Vector<FoodDescription> items = null;
            try {
                //gateway.createEmployeeTable();
                items = gateway.find("Drinks");
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            CategoryGUI categoryGUI = new CategoryGUI(new Category("Drinks"), items);
        }
        else if(e.getSource() == foodButton){
            dispose();
            
            MenuDAO gateway = new MenuDAO();
            Vector<FoodDescription> items = null;
            try {
                //gateway.createEmployeeTable();
                items = gateway.find("Food");
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            CategoryGUI categoryGUI = new CategoryGUI(new Category("Food"), items);
        }
    }

}