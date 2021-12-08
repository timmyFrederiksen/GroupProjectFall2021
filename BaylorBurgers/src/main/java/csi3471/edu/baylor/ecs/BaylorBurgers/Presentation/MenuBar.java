package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates the menu bar for almost every GUI in the application.
 * <p>
 * This class extends JMenuBar and implements ActionListener
 */
public class MenuBar extends JMenuBar implements ActionListener {
    
	private JMenu menu;
    private JMenuItem backMenu, helpMenu, cartMenu;
    
    /**
     * This class constructs a MenuBar object using JMenu & JMenuItem.
     */
    public MenuBar() {
    	menu = new JMenu("Menu");

    	backMenu = new JMenuItem("Back");
    	helpMenu = new JMenuItem("Help");
    	cartMenu = new JMenuItem("Cart");

    	menu.add(backMenu);
    	menu.add(helpMenu);
    	menu.add(cartMenu);

    	helpMenu.addActionListener(this);

    	add(menu);
    }
    
    /**
     * This function removes the 'back' menu item.
     */
    public void removeBackMenu(){
        menu.remove(backMenu);
    }
    
    /**
     * This function removes the 'remove' menu item.
     */
    public void removeHelpMenu(){
        menu.remove(helpMenu);
    }
    
    /**
     * This function removes the 'cart' menu item.
     */
    public void removeCartMenu(){
        menu.remove(cartMenu);
    }

    /**
     * Getter function for 'helpMenu' menu item.
     * @return Returns the 'helpMenu' attribute.
     */
    public JMenuItem getHelp() {
        return helpMenu;
    }

    /**
     * Setter function for 'helpMenu' menu item.
     * @param helpMenu The JMenuItem to be place into the 'helpMenu' slot.
     */
    public void setHelpMenu(JMenuItem helpMenu) {
        this.helpMenu = helpMenu;
    }

    /**
     * Getter function for 'backMenu' menu item.
     * @return Returns the 'backMenu' attribute.
     */
    public JMenuItem getBackMenu() {
        return backMenu;
    }

    /**
     * Setter function for 'backMenu' menu item.
     * @param backMenu The JMenuItem to be place into the 'backMenu' slot.
     */
    public void setBackMenu(JMenuItem backMenu) {
        this.backMenu = backMenu;
    }

    /**
     * Getter function for 'cartMenu' menu item.
     * @return Returns the 'cartMenu' attribute.
     */
    public JMenuItem getCartMenu() {
        return cartMenu;
    }

    /**
     * Setter function for 'cartMenu' menu item.
     * @param cartMenu The JMenuItem to be place into the 'cartMenu' slot.
     */
    public void setCartMenu(JMenuItem cartMenu) {
        this.cartMenu = cartMenu;
    }

    /**
     * Listens for a button press and performs the indicated operation.
     * @param e The button that was pushed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == helpMenu){
            JOptionPane.showMessageDialog(new JFrame("Help Request"),
                    "An employee will assist you momentarily.", "Warning",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
