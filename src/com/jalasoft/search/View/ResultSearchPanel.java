package com.jalasoft.search.View;

import javax.swing.*;
import java.awt.*;

public class ResultSearchPanel extends JPanel {
    private JButton searchButton;

    public ResultSearchPanel(){
        this.setLayout(new GridLayout(10,5));
        this.setBorder(BorderFactory.createTitledBorder("Results"));
        searchButton = new JButton("Search");
        this.add(searchButton);
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
