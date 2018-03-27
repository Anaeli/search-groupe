package com.jalasoft.search.View;

import javax.swing.*;
import java.awt.*;

public class ResultSearchPanel extends JPanel {

    public ResultSearchPanel(){
        this.setLayout(new GridLayout(10,5));
        this.setBackground(Color.CYAN);
        this.setBorder(BorderFactory.createTitledBorder("Results"));
    }
}
