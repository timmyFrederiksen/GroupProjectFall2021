package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Cart;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class creates and manages the GUI associated with the Cart menu.
 * <p>
 * This class extends JDialog and implements ActionListener.
 */
public class CartGUI extends JDialog implements ActionListener {
    private JLabel cartLabel;
    private JPanel cartLabelPanel, cartPanel, checkoutPanel;
    private ArrayList<JPanel> cartItemPanels;
    private MenuBar menuBar;
    private JButton checkoutButton;

    /**
     * This function constructs a CartGUI object.
     */
    public CartGUI(){
        cartPanel = new JPanel();
        checkoutPanel = new JPanel();
        cartItemPanels = new ArrayList<>();
        checkoutButton = new JButton("Checkout");
        createAndShowGUI();
    }

    /**
     * This function adds GUI components to the GUI backbone in a CartGUI 
     * object. 
     */
    private void addGUIComponents() {
    	
        cartLabel = new JLabel("Cart");
        cartLabel.setFont(new Font("Arial", Font.PLAIN, 48));
        cartLabel.setPreferredSize(new Dimension(500, 100));

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        cartLabelPanel = new JPanel(flowLayout);
        cartLabelPanel.add(cartLabel);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        cartPanel.setBorder(new EmptyBorder(10, 10, 10 ,10));

        BoxLayout boxLayout = new BoxLayout(cartPanel, BoxLayout.Y_AXIS);
        cartPanel.setLayout(boxLayout);
        Cart c = new Cart();

        for(int i = 0; i < c.getItems().size(); i++){
            CartItemPanel panel = new CartItemPanel(c.getItems().get(i), this);
            panel.setPreferredSize(new Dimension(500, 175));
            panel.setBorder(border);
            cartPanel.add(panel);
            cartPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        cartLabelPanel.setBorder(new EmptyBorder(0, 10, 0 ,10));
        
        Color green = new Color(21, 71, 52);
        Color gold = new Color(255, 184, 28);
        cartLabelPanel.setBackground(green);
        cartPanel.setBackground(gold);

        checkoutPanel.setBorder(new EmptyBorder(0, 10, 0 ,10));
        checkoutPanel.add(checkoutButton, BorderLayout.CENTER);

        menuBar = new MenuBar();
        menuBar.removeCartMenu();
        menuBar.getBackMenu().addActionListener(this);
        menuBar.getHelp().addActionListener(this);
        setJMenuBar(menuBar);


        JScrollPane scrollPane = new JScrollPane(cartPanel);
        add(cartLabelPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(checkoutPanel, BorderLayout.SOUTH);

        checkoutButton.addActionListener(this);
    }
    
    /**
     * This function creates a GUI backbone for a CartGUI object.
     */
    private void createAndShowGUI() {
        this.setTitle("Baylor Burgers Cart");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        this.setSize(750, 650);
        this.setVisible(true);
    }

    /**
     * This function listens for button presses and executes the given
     * instructions for the pressed button.
     * @param e The button that was pushed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuBar.getBackMenu()){
            new MainMenuGUI();
            dispose();
        } else if(e.getSource() == checkoutButton) {
            new PaymentGUI();
        }
    }
}