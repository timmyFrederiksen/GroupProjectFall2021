package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;


import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class AddItemGUI extends JDialog {
    private String[] input = null;
    ArrayList<JTextField> textFields = new ArrayList<>();
    private String[] names = new String[]{"Item Name:", "Item Price:", "Item Description:"};

    public AddItemGUI() {
        super();
        createAndShowGUI();
    }


    private void createAndShowGUI() {
        setPreferredSize(new Dimension(450, 300));
        setTitle(getClass().getSimpleName());

        JPanel listPane = new JPanel();
        //listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Enter Information:");
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setAlignmentY(Component.TOP_ALIGNMENT);

        listPane.add(label);
        listPane.setVisible(true);

        JPanel gridPane = new JPanel();
        gridPane.setLayout(new GridLayout(4,2, 2, 2));

        ArrayList<JLabel> labels = new ArrayList<>();

        for(int i = 0; i < names.length; i++){
            textFields.add(new JTextField(""));
            labels.add(new JLabel(names[i]));
        }

        for(int i = 0; i < names.length; i++){
            gridPane.add(labels.get(i));
            gridPane.add(textFields.get(i));
        }


        JButton saveInfo = new JButton("Save");
        saveInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton cancelInfo = new JButton("Cancel");
        cancelInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        gridPane.add(saveInfo);
        gridPane.add(cancelInfo);


        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.add(label);
        newPanel.add(gridPane);

        add(newPanel);
        setVisible(true);
        pack();
        setLocationRelativeTo(getParent());
    }
}
