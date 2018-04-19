/*
 * Search .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.search.view;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

/**
 *
 This class implements the GUI for Search Menu Panel.
 using components from swing library
 *
 * @version  1.0
 * @author Rodrigo Saul Cespedes Murillo
 */
public class SearchMenu extends BasePanel{
    private JButton simpleButton;
    private JButton advancedButton;
    private JButton searchButton;

    private JPanel formPanels[][];

    /**
     * Constructor initializes this Panel as grid layout also add components to this JPanel
     * */
    public SearchMenu(){
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setLayout(new GridLayout(3,1));

        this.setBorder(BorderFactory.createTitledBorder("Search Menu"));
        simpleButton = new JButton("Simple");
        simpleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        simpleButton.setFocusPainted(false);
        advancedButton = new JButton("Advanced");
        advancedButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        advancedButton.setFocusPainted(false);
        searchButton = new JButton("Search");

        formPanels = addPanelToGrid(3, 1);

        formPanels[0][0].add(simpleButton);
        formPanels[1][0].add(advancedButton);
        formPanels[2][0].setLayout(new BoxLayout(formPanels[2][0], BoxLayout.Y_AXIS));
        formPanels[2][0].add(searchButton);
        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        try {
            Image simple = ImageIO.read(getClass().getResource("../../../../lib/icon/simple.png"));
            Image new_simple = simple.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH ) ;
            simpleButton.setIcon(new ImageIcon(new_simple));
            Image advanced = ImageIO.read(getClass().getResource("../../../../lib/icon/advanced.png"));
            Image new_advanced = advanced.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH ) ;
            advancedButton.setIcon(new ImageIcon(new_advanced));
            Image search = ImageIO.read(getClass().getResource("../../../../lib/icon/search.png"));
            Image new_search = search.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH ) ;
            searchButton.setIcon(new ImageIcon(new_search));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * This method returns simple button component
     * @return JButton to implement its events
     * */
    public JButton getSimpleButton(){
        return simpleButton;
    }

    /**
     * This method returns advanced button component
     * @return JButton to implement its events
     * */
    public JButton getAdvancedButton(){
        return advancedButton;
    }

    /**
     * This method returns Search button
     * @return JButton to implement its event
     * */
    public JButton getSearchButton() {
        return searchButton;
    }
}
