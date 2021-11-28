package csi3471.edu.baylor.ecs.BaylorBurgers;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CategoryGUI extends JFrame{

    private Category category;

    private JLabel categoryLabel;
    private JPanel categoryPanel, categoryHeader, categoryButtons;

    private ArrayList<JButton> foodItemButtons;

    public CategoryGUI(Category category){
        foodItemButtons = new ArrayList<>();
        // add Buttons
        this.category = category;
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


        // DELETE THE FOLLOWING FOR EXAMPLES USE ONLY:
        for(int i = 0; i < 10; i++){
            JButton button = new JButton("Example #" + i);
            button.setBackground(Color.WHITE);
            button.setPreferredSize(new Dimension(200, 200));
            foodItemButtons.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ItemGUI itemGUI = new ItemGUI(new FoodDescription("Item #1"));
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

        for(JButton button : foodItemButtons){
            categoryButtons.add(button);
        }

        EmptyBorder panelBorder = new EmptyBorder(10, 10 , 0, 0);
        //Border border = BorderFactory.createLineBorder(Color.BLACK);
        //mainMenuLabel.setBorder(border);
        categoryLabel.setBorder(panelBorder);
        categoryButtons.setBorder(panelBorder);


        categoryHeader.add(categoryLabel);

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
}
