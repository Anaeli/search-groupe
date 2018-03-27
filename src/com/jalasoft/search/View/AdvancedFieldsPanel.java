package com.jalasoft.search.View;

import javax.swing.*;
import java.awt.*;

public class AdvancedFieldsPanel extends JPanel {

    public AdvancedFieldsPanel(){
        this.setLayout(new GridLayout(1,2));
        this.setBackground(Color.pink);
        this.setBorder(BorderFactory.createTitledBorder("Advanced Search"));
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        this.add(f);
    }

}
