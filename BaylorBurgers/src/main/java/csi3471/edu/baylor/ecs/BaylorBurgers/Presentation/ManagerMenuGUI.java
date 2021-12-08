package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class ManagerMenuGUI extends JFrame implements ActionListener{
    private JLabel managerMenuLabel;
    private JPanel menuLabelPanel, addItemPanel;
    private static JPanel managerMenuPanel = new JPanel();
    private ArrayList<JPanel> menuItemPanels;
    private MenuBar menuBar;
    private Vector<FoodDescription> items;
    private JButton addItemButton;



    public ManagerMenuGUI(){
        addItemPanel = new JPanel();
        menuItemPanels = new ArrayList<>();
        addItemButton = new JButton("Add Item to the Menu");

    }

    private void addGUIComponents() {

        managerMenuLabel = new JLabel("Menu");
        managerMenuLabel.setFont(new Font("Arial", Font.PLAIN, 48));
        managerMenuLabel.setPreferredSize(new Dimension(500, 100));

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        menuLabelPanel = new JPanel(flowLayout);
        menuLabelPanel.add(managerMenuLabel);

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        Color green = new Color(21, 71, 52);
        Color gold = new Color(255, 184, 28);
        menuLabelPanel.setBackground(green);
        addItemPanel.setBackground(gold);

        managerMenuPanel.setBorder(new EmptyBorder(0, 10, 0 ,0));
        menuLabelPanel.setBorder(new EmptyBorder(0, 10, 0 ,0));

        addItemPanel.setBorder(new EmptyBorder(0, 10, 0 ,0));
        addItemPanel.add(addItemButton, BorderLayout.CENTER);

        BoxLayout boxLayout = new BoxLayout(managerMenuPanel, BoxLayout.Y_AXIS);
        managerMenuPanel.setLayout(boxLayout);
        managerMenuPanel.setBackground(gold);

        JScrollPane scrollPane = new JScrollPane(managerMenuPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(gold);
        add(menuLabelPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(addItemPanel, BorderLayout.SOUTH);

        menuBar = new MenuBar();
        menuBar.removeCartMenu();
        menuBar.removeHelpMenu();
        menuBar.getBackMenu().addActionListener(this);
        setJMenuBar(menuBar);



        menuBar = new MenuBar();
        menuBar.removeCartMenu();
        menuBar.removeHelpMenu();
        menuBar.getBackMenu().addActionListener(this);
        setJMenuBar(menuBar);

        addItemButton.addActionListener(this);

    }
    public void updatePanel(Vector<FoodDescription> items){
        managerMenuPanel = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        for(int i = 0; i < items.size(); i++){
            MenuItemPanel panel = new MenuItemPanel(items.get(i), this);
            panel.setPreferredSize(new Dimension(550, 175));
            panel.setBorder(border);
            managerMenuPanel.add(panel);
            managerMenuPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        }
    }
    /*
    public void update() {
        managerMenuPanel.repaint();
    }
     */
    public void createAndShowGUI() {
        this.setTitle("Baylor Burgers Manager Menu View");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setResizable(false);

        addGUIComponents();

        //this.pack();
        this.setSize(700, 700);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuBar.getBackMenu()){
            dispose();
            new ManagerMainPageGUI();
        }else if(e.getSource() == addItemButton) {
            dispose();
            AddItemGUI addItemGUI = new AddItemGUI();
        }
    }


}