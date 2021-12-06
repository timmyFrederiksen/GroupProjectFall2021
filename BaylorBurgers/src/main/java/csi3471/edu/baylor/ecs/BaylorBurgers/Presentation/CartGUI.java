package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CartGUI extends JDialog implements ActionListener {
    JLabel cartLabel;
    JPanel cartLabelPanel, cartPanel, checkoutPanel;
    ArrayList<JPanel> cartItemPanels;
    MenuBar menuBar;


    public CartGUI(){
        cartPanel = new JPanel();
        checkoutPanel = new JPanel();
        cartPanel.setPreferredSize(new Dimension(700, 500));
        cartItemPanels = new ArrayList<>();
        createAndShowGUI();
    }

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
        for(int i = 0; i < 3; i++){
            CartItemPanel panel = new CartItemPanel();
            panel.setPreferredSize(new Dimension(500, 150));
            panel.setBorder(border);
            cartPanel.add(panel);
        }

        cartPanel.setBorder(new EmptyBorder(0, 10, 0 ,0));
        cartLabelPanel.setBorder(new EmptyBorder(0, 10, 0 ,0));

        JButton checkoutButton = new JButton("Checkout");
        checkoutPanel.setBorder(new EmptyBorder(0, 10, 0 ,0));
        checkoutPanel.add(checkoutButton, BorderLayout.CENTER);

        menuBar = new MenuBar();
        menuBar.removeCartMenu();
        menuBar.getBackMenu().addActionListener(this);
        setJMenuBar(menuBar);


        JScrollPane scrollPane = new JScrollPane(cartPanel);
        add(cartLabelPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(checkoutPanel, BorderLayout.SOUTH);

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentGUI paymentGUI = new PaymentGUI();
            }
        });

    }
    private void createAndShowGUI() {
        this.setTitle("Baylor Burgers Cart");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);

        addGUIComponents();

        //this.pack();
        this.setSize(750, 650);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuBar.getBackMenu()){
            new MainMenuGUI();
            dispose();
        }
    }
}
