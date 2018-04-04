package com.jalasoft.search.view;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel{
    private JLabel errorMessage;
    public HeaderPanel(){
        this.setLayout(new GridLayout(2,1));
        this.add(new JLabel("Search Group E"));
        errorMessage = new JLabel("");
        errorMessage.setForeground(Color.red);
        this.add(errorMessage);
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage.setText(errorMessage);
    }

    public void cleanErrorMessage(){
        this.errorMessage.setText("");
    }
}
