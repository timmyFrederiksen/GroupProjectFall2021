package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import javax.swing.*;
import java.awt.*;

public class MenuItemPanel extends JPanel {

    JPanel p, centerPanel, rightPanel, leftPanel;
    JButton removeButton = new JButton("Remove Item");
    JButton editButton = new JButton("Edit Item");


    public MenuItemPanel(){
        centerPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel = new JPanel();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        String[] labels = {"Item Name: ", "Item Category: ", "Item Price: ", "Item Description: "};
        int numPairs = labels.length;

        p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(15);
            textField.setEditable(false);
            if(i == numPairs - 1){
                textField.setVisible(false);
            }
            l.setLabelFor(textField);
            p.add(textField);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                numPairs, 2,            //rows, cols
                6, 6,           //initX, initY
                6, 6);             //xPad, yPad

        BoxLayout rightBoxLayout = new BoxLayout(rightPanel, BoxLayout.Y_AXIS);
        rightPanel.setLayout(rightBoxLayout);
        BoxLayout leftBoxLayout = new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
        leftPanel.setLayout(leftBoxLayout);
        JTextArea description = new JTextArea();
        description.setEditable(false);
        description.setLineWrap(true);
        description.setPreferredSize(new Dimension(50, 30));
        JScrollPane scroll = new JScrollPane(description);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        leftPanel.add(p);
        //leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        leftPanel.add(scroll);


        centerPanel.setPreferredSize(new Dimension(75, 125));

        rightPanel.add(editButton);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        rightPanel.add(removeButton);



        //p.setBackground(Color.YELLOW);
        //centerPanel.setBackground(Color.BLUE);
        //rightPanel.setBackground(Color.YELLOW);

        add(leftPanel, BorderLayout.LINE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);
    }
}