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
public class SearchMenu extends JPanel{
    private JButton simpleButton;
    private JButton advancedButton;

    /**
     * Constructor initializes this Panel as grid layout also add components to this JPanel
     * */
    public SearchMenu(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Search Menu"));
        simpleButton = new JButton("Simple");
        simpleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        advancedButton = new JButton("Advanced");
        advancedButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(simpleButton);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(advancedButton);
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
}
