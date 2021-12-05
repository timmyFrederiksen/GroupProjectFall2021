package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginGUI extends JPanel{

    private JButton customerViewButton;
    private JButton managerViewButton;
    private JPanel buttonPanel;
    private static JFrame frame;


    public LoginGUI(){
        super();
        customerViewButton = new JButton("Customer View");
        managerViewButton = new JButton("Manager Login");

        customerViewButton.setSize(150, 10);
        managerViewButton.setSize(150, 10);


        buttonPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);

        buttonPanel.setLayout(boxLayout);

        buttonPanel.setBorder(new EmptyBorder(new Insets(75, 100, 75, 100)));
        buttonPanel.add(customerViewButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(managerViewButton);

        add(buttonPanel);

        customerViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainMenuGUI mainMenuGUI = new MainMenuGUI();
            }
        });
        managerViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ManagerLoginGUI managerLoginGUI = new ManagerLoginGUI();
            }
        });

    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Baylor Burgers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //Create and set up the content pane.
        LoginGUI newContentPane = new LoginGUI();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(LoginGUI::createAndShowGUI);
    }
}
