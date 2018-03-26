package com.jalasoft.search.View;

import javax.swing.*;
import java.awt.*;

public class SimpleFieldsPanel extends JPanel{
    // Labels
    JLabel filenameLabel;
    JLabel pathLabel;

    // Text Fields
    JTextField filenameTextField;
    JTextField pathTextField;


    public SimpleFieldsPanel(){
        this.setLayout(new GridLayout(2,2));
        this.setBackground(Color.orange);
        this.setBorder(BorderFactory.createTitledBorder("Simple Search"));
        filenameLabel = new JLabel("File Name");
        pathLabel = new JLabel("Path");
        filenameTextField = new JTextField();
        pathTextField = new JTextField();

        this.add(filenameLabel);
        this.add(filenameTextField);
        this.add(pathLabel);
        this.add(pathTextField);
    }
}
