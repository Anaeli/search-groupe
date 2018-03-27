package com.jalasoft.search.View;

import javax.swing.*;
import java.awt.*;

public class SearchMenu extends JPanel{
    private JButton simpleButton;
    private JButton advancedButton;

    public SearchMenu(){
        this.setLayout(new GridLayout(4,1));
        this.setBackground(Color.BLUE);
        this.setBorder(BorderFactory.createTitledBorder("Search Menu"));
        simpleButton = new JButton("Simple");
        advancedButton = new JButton("Advanced");
        this.add(simpleButton);
        this.add(advancedButton);
    }
}
