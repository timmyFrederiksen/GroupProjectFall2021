package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Category;
import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class CategoryGUI extends JFrame implements ActionListener{

    private Category category;
    private MenuBar menuBar;
    
    private int count;

    private JLabel categoryLabel;
    private JPanel categoryPanel, categoryHeader, categoryButtons;

    private ArrayList<JButton> foodItemButtons;
    
    private Vector<FoodDescription> items;

    public CategoryGUI(Category category, Vector<FoodDescription> items){
        foodItemButtons = new ArrayList<>();
        // add Buttons
        this.category = category;
        this.items = items;
        count = 0;
        
        createAndShowGUI();
    }
    private void addGUIComponents() {
        categoryLabel = new JLabel(category.getCategoryName());
        categoryLabel.setFont(new Font("Arial", Font.PLAIN, 48));
        categoryLabel.setPreferredSize(new Dimension(500, 100));

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        categoryHeader = new JPanel(flowLayout);

        Color green = new Color(21, 71, 52);
        Color gold = new Color(255, 184, 28);
        categoryHeader.setBackground(gold);
        this.setBackground(green);
        
        // DELETE THE FOLLOWING FOR EXAMPLES USE ONLY:
        for(int i = 0; i < items.size(); i++){
            JButton button = new JButton(items.get(i).getName());
            
            button.setBackground(Color.WHITE);
            button.setPreferredSize(new Dimension(200, 200));
            foodItemButtons.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ItemGUI itemGUI = new ItemGUI(button.getText(), items);
                    count++;
                }
            });
            
        }

        int size = (category.getNumberOfItems() / 3);
        if(category.getNumberOfItems() % 3 != 0){
            size++;
        }

        GridLayout gridLayout = new GridLayout(size, 3);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);

        categoryButtons = new JPanel(gridLayout);
        categoryButtons.setBackground(green);


        for(JButton button : foodItemButtons){
            categoryButtons.add(button);
        }

        EmptyBorder panelBorder = new EmptyBorder(10, 10 , 0, 0);
        //Border border = BorderFactory.createLineBorder(Color.BLACK);
        //mainMenuLabel.setBorder(border);
        categoryLabel.setBorder(panelBorder);
        categoryButtons.setBorder(panelBorder);


        categoryHeader.add(categoryLabel);

        menuBar = new MenuBar();

        menuBar.getBackMenu().addActionListener(this);
        menuBar.getCartMenu().addActionListener(this);
        menuBar.getHelp().addActionListener(this);
        setJMenuBar(menuBar);

        JScrollPane scrollPane = new JScrollPane(categoryButtons);
        add(categoryHeader, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    private void createAndShowGUI() {
        this.setTitle("Baylor Burgers " + category.getCategoryName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addGUIComponents();

        //this.pack();
        this.setSize(800, 625);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuBar.getBackMenu()){
            new MainMenuGUI();
            dispose();
        }else if(e.getSource() == menuBar.getCartMenu()){
            dispose();
            new CartGUI();
        }
        else if(e.getSource() == menuBar.getHelp()) {
        	JOptionPane.showMessageDialog(new JFrame("Help Request"), "An employee will assist you momentarily", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }
}
