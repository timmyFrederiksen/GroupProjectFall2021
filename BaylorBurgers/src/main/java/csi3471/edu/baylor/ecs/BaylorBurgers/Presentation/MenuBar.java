package csi3471.edu.baylor.ecs.BaylorBurgers.Presentation;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    JMenu menu;
    JMenuItem backMenu, helpMenu, cartMenu;
    public MenuBar(){
        menu = new JMenu("Menu");

        backMenu = new JMenuItem("Back");
        helpMenu = new JMenuItem("Help");
        cartMenu = new JMenuItem("Cart");

        menu.add(backMenu);
        menu.add(helpMenu);
        menu.add(cartMenu);

        add(menu);
    }
    public void removeBackMenu(){
        menu.remove(backMenu);
    }
    public void removeHelpMenu(){
        menu.remove(helpMenu);
    }
    public void removeCartMenu(){
        menu.remove(cartMenu);
    }

    public JMenuItem getHelp() {
        return helpMenu;
    }

    public void setHelpMenu(JMenuItem helpMenu) {
        this.helpMenu = helpMenu;
    }

    public JMenuItem getBackMenu() {
        return backMenu;
    }

    public void setBackMenu(JMenuItem backMenu) {
        this.backMenu = backMenu;
    }

    public JMenuItem getCartMenu() {
        return cartMenu;
    }

    public void setCartMenu(JMenuItem cartMenu) {
        this.cartMenu = cartMenu;
    }
}
