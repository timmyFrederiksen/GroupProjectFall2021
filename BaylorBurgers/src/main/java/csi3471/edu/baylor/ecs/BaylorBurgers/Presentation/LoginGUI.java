package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * This class creates and manages start menu for the program. 
 * <p>
 * this class extends JPanel and implements ActionListener.
 */
public class LoginGUI extends JPanel implements ActionListener {

    private JButton customerViewButton;
    private JButton managerViewButton;
    private JPanel buttonPanel;
    private static JFrame frame;

    /**
     * This function constructs the LoginGUI and creates the UI for
     * the display.
     */
    public LoginGUI(){
        super();
        customerViewButton = new JButton("Customer View");
        managerViewButton = new JButton("Manager Login");

        customerViewButton.setSize(150, 10);
        managerViewButton.setSize(150, 10);

        buttonPanel = new JPanel();

        BoxLayout boxLayout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);

        buttonPanel.setLayout(boxLayout);
        
        
        Color gold = new Color(255, 184, 28);
        buttonPanel.setBackground(gold);
        
        buttonPanel.setBorder(new EmptyBorder(new Insets(75, 100, 75, 100)));
        buttonPanel.add(customerViewButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(managerViewButton);

        add(buttonPanel);

        customerViewButton.addActionListener(this);
        managerViewButton.addActionListener(this);

    }
    
    /**
     * This function creates the GUI backbone for the LoginGUI object.
     */
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
    
    /** 
     * This function begins the GUI construction process.
     */
    public static void showGUI(){
        createAndShowGUI();
    }
    
    /**
     * This is the entry point of the application.
     * @param args should be empty.
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(LoginGUI::createAndShowGUI);
    }

    /**
     * This function overrides the default behavior from ActionListener.
     * @param e The button that was clicked. This determines which GUI
     * to transition to.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == customerViewButton){
            frame.dispose();
            new MainMenuGUI();
        }else if(e.getSource() == managerViewButton){
            frame.dispose();
            new ManagerLoginGUI();
        }
    }
}